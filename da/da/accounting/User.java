package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import com.encryptor.StringEncrypter;

import da.error.DAException;
import da.factory.DBEngine;


public class User {
	
	private DBEngine db=null;
	static final Category log = Category.getInstance(User.class);
	public User() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public boolean updateUser(sf.accounting.User user) throws DAException
	{
		if(user.checkIsNULL())
		{
			throw new DAException(user.getErr());
		}
		
		log.info("[updateUser]Kode User: "+user.getKstaff());
		String strSQL="UPDATE mstaff set nstaff=?,alamat1=?,alamat2=?,alamat3=?,kota=?,kodepos=?,notelp=?,nofax=?,nohp=?,kotalahir=?,tgllahir=?,tglmasuk=?,tglkeluar=?,kjabatan=?,djabatan=?,kcabang=?,keterangan=?,khpp=?,kprint=?,kconvert=?,recstatus=?,tglupdate=?,userupdate=?,kapprove=?,kalias=?,kcompany=? where kstaff=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, user.getNstaff());
			p.setString(2, user.getAlamat1());
			p.setString(3, user.getAlamat2());
			p.setString(4, user.getAlamat3());
			p.setString(5, user.getKota());
			p.setString(6, user.getKodepos());
			p.setString(7, user.getNotelp());
			p.setString(8, user.getNofax());
			p.setString(9, user.getNohp());
			p.setString(10, user.getKotalahir());
			p.setString(11, user.getTgllahir());
			p.setString(12, user.getTglmasuk());
			p.setString(13, user.getTglkeluar());
			p.setString(14, user.getKjabatan());
			p.setString(15, user.getDjabatan());
			p.setString(16, user.getKcabang());
			p.setString(17, user.getKeterangan());
			p.setString(18, user.getKhpp());
			p.setString(19, user.getKprint());
			p.setString(20, user.getKconvert());
			p.setString(21, user.getRecstatus());
			p.setLong(22, user.getTglupdate());
			p.setString(23, user.getUserupdate());
			p.setString(24, user.getkApprove());
			p.setLong(25, user.getkAlias());
			p.setString(26, user.getKcompany());
			p.setString(27, user.getKstaff());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean insertUser(sf.accounting.User user) throws DAException
	{
		if(user.checkIsNULL())
		{
			throw new DAException(user.getErr());
		}
		
		log.info("[insertUser]userID: "+user.getKstaff() + ",password: "+ user.getKpassword());
		// make default password.
		user.setKpassword("123");
		String strSQL="INSERT INTO mstaff values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,'ekatama'),?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, user.getKstaff());
			p.setString(2, user.getNstaff());
			p.setString(3, user.getAlamat1());
			p.setString(4, user.getAlamat2());
			p.setString(5, user.getAlamat3());
			p.setString(6, user.getKota());
			p.setString(7, user.getKodepos());
			p.setString(8, user.getNotelp());
			p.setString(9, user.getNofax());
			p.setString(10, user.getNohp());
			p.setString(11, user.getKotalahir());
			p.setString(12, user.getTgllahir());
			p.setString(13, user.getTglmasuk());
			p.setString(14, user.getTglkeluar());
			p.setString(15, user.getKjabatan());
			p.setString(16, user.getDjabatan());
			p.setString(17, user.getKcabang());
			p.setString(18, user.getKpassword());
			p.setString(19, user.getKeterangan());
			p.setString(20, user.getKhpp());
			p.setString(21, user.getKprint());
			p.setString(22, user.getKconvert());
			p.setString(23, user.getRecstatus());
			p.setLong(24, user.getTglupdate());
			p.setString(25, user.getUserupdate());
			p.setString(26, user.getkApprove());
			p.setLong(27, user.getkAlias());
			p.setString(28, user.getKcompany());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean changePassword(sf.accounting.User userOld,String newPassword) throws DAException
	{
		if(!validasiPassword(userOld.getKstaff(),userOld.getKpassword()))
		{
			throw new DAException ("Password lama tidak sesuai.");
		}
		String passPhrase   = "ekatamaputraperkasa";
		// Create encrypter/decrypter class
        StringEncrypter desEncrypter = new StringEncrypter(passPhrase);
		String passNow = desEncrypter.decrypt(newPassword);
		
		String strSQL="UPDATE mstaff set kpassword=AES_ENCRYPT(?,'ekatama'),tglupdate=?,userupdate=? where kstaff=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, passNow);
			p.setLong(2, userOld.getTglupdate());
			p.setString(3, userOld.getUserupdate());
			p.setString(4, userOld.getKstaff());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean aliasIsExist(String kstaff, long alias) throws DAException 
	{
		try
		{
			String strSQL="SELECT count(*) from mstaff where kalias=? and kstaff<>?";
			PreparedStatement p = db.getStatement(strSQL);
			p.setLong(1, alias);
			p.setString(2, kstaff);
			Vector rows=db.getData(p);
			if(rows==null || rows.size()==0)
				return false;
			Vector v=(Vector)rows.get(0);
			long count =Long.parseLong(v.get(0).toString());
			if(count>0)
				return true;
			else
				return false;
		}
		catch(Exception ex)
		{
			throw new DAException(ex.getLocalizedMessage());
		}
		
	}
	public boolean login(sf.accounting.User user) throws DAException
	{
		
		if(validasiPassword(user.getKstaff(), user.getKpassword()))
		{
			log.info("[login] user/password is valid");
			return true;
		}
		else{
			//throw new DAException ("Invalid User ID or Password. Please try again.");
			log.info("[login] user/password is not valid!!");
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean validasiPassword(String userID,String password) throws DAException
	{
		try
		{
			
			log.info("[validasiPassword]current userID: "+userID + " and password: "+ password);
			
			String strSQL="SELECT kstaff,AES_DECRYPT(kpassword,'ekatama') as kpassword FROM mstaff where kstaff=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, userID);
			Vector rows=db.getData(p);
			
			if(rows==null || rows.size()==0)
				return false;
			
			Vector v=(Vector)rows.get(0);
			String _userID=v.get(0).toString();
			String _passwrd="";
			if(null!=v.get(1))
				_passwrd=v.get(1).toString();
			System.out.println("userID: " + _userID + ",password:" + _passwrd);
			
			
	        String passPhrase   = "ekatamaputraperkasa";

	        // Create encrypter/decrypter class
	        StringEncrypter desEncrypter = new StringEncrypter(passPhrase);
			String passNow = desEncrypter.decrypt(password);
			System.out.println("password decrypt: " + passNow);
			if(_userID.equals(userID) && _passwrd.equals(passNow))
				return true;
			else
				return false;
		}
		
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.User getUser(String userID) throws DAException
	{
		sf.accounting.User itemUser=new sf.accounting.User();
		try
		{
			String strSQL="SELECT *,AES_DECRYPT(kpassword,'ekatama') as password FROM mstaff where recstatus<>'D' and kstaff=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, userID);
			Vector rows=db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				itemUser.setKstaff(v.get(0).toString());
				itemUser.setNstaff(v.get(1).toString());
				itemUser.setAlamat1(v.get(2).toString());
				itemUser.setAlamat2(v.get(3).toString());
				itemUser.setAlamat3(v.get(4).toString());
				itemUser.setKota(v.get(5).toString());
				itemUser.setKodepos(v.get(6).toString());
				itemUser.setNotelp(v.get(7).toString());
				itemUser.setNofax(v.get(8).toString());
				itemUser.setNohp(v.get(9).toString());
				itemUser.setKotalahir(v.get(10).toString());
				itemUser.setTgllahir(v.get(11).toString());
				itemUser.setTglmasuk(v.get(12).toString());
				itemUser.setTglkeluar(v.get(13).toString());
				itemUser.setKjabatan(v.get(14).toString());
				itemUser.setDjabatan(v.get(15).toString());
				itemUser.setKcabang(v.get(16).toString());
				itemUser.setKpassword(v.get(25).toString());
				itemUser.setKeterangan(v.get(18).toString());
				itemUser.setKhpp(v.get(19).toString());
				itemUser.setKprint(v.get(20).toString());
				itemUser.setKconvert(v.get(21).toString());
				itemUser.setRecstatus(v.get(22).toString());
				itemUser.setTglupdate(Long.parseLong(v.get(23).toString().equals("")?"0":v.get(23).toString()));
				itemUser.setUserupdate(v.get(24).toString());
				itemUser.setkApprove(v.get(25).toString());
				itemUser.setkAlias(Long.parseLong(v.get(26).toString()));
				itemUser.setKcompany(v.get(27).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return itemUser;
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.User[] getUsers() throws DAException
	{
		sf.accounting.User[] items=null;
		try
		{
			String strSQL="SELECT *,AES_DECRYPT(kpassword,'ekatama') as password FROM mstaff where recstatus<>'D'";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.accounting.User[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.User itemUser=new sf.accounting.User();
				
				itemUser.setKstaff(v.get(0).toString());
				itemUser.setNstaff(v.get(1).toString());
				itemUser.setAlamat1(v.get(2).toString());
				itemUser.setAlamat2(v.get(3).toString());
				itemUser.setAlamat3(v.get(4).toString());
				itemUser.setKota(v.get(5).toString());
				itemUser.setKodepos(v.get(6).toString());
				itemUser.setNotelp(v.get(7).toString());
				itemUser.setNofax(v.get(8).toString());
				itemUser.setNohp(v.get(9).toString());
				itemUser.setKotalahir(v.get(10).toString());
				itemUser.setTgllahir(v.get(11).toString());
				itemUser.setTglmasuk(v.get(12).toString());
				itemUser.setTglkeluar(v.get(13).toString());
				itemUser.setKjabatan(v.get(14).toString());
				itemUser.setDjabatan(v.get(15).toString());
				itemUser.setKcabang(v.get(16).toString());
				itemUser.setKpassword(v.get(27).toString());
				itemUser.setKeterangan(v.get(18).toString());
				itemUser.setKhpp(v.get(19).toString());
				itemUser.setKprint(v.get(20).toString());
				itemUser.setKconvert(v.get(21).toString());
				itemUser.setRecstatus(v.get(22).toString());
				itemUser.setTglupdate(Long.parseLong(v.get(23).toString().equals("")?"0":v.get(23).toString()));
				itemUser.setUserupdate(v.get(24).toString());
				itemUser.setkApprove(v.get(25).toString());
				itemUser.setkAlias(Long.parseLong(v.get(26).toString()));
				itemUser.setKcompany(v.get(27).toString());
				items[i]=itemUser;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.User[] getUserByJabatan(String kode) throws DAException
	{
		sf.accounting.User[] items=null;
		try
		{
			String strSQL="SELECT *,AES_DECRYPT(kpassword,'ekatama') as password FROM mstaff where recstatus<>'D' and kjabatan=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kode);
			Vector rows=db.getData(p);
			int count=rows.size();
			items=new sf.accounting.User[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.User itemUser=new sf.accounting.User();
				
				itemUser.setKstaff(v.get(0).toString());
				itemUser.setNstaff(v.get(1).toString());
				itemUser.setAlamat1(v.get(2).toString());
				itemUser.setAlamat2(v.get(3).toString());
				itemUser.setAlamat3(v.get(4).toString());
				itemUser.setKota(v.get(5).toString());
				itemUser.setKodepos(v.get(6).toString());
				itemUser.setNotelp(v.get(7).toString());
				itemUser.setNofax(v.get(8).toString());
				itemUser.setNohp(v.get(9).toString());
				itemUser.setKotalahir(v.get(10).toString());
				itemUser.setTgllahir(v.get(11).toString());
				itemUser.setTglmasuk(v.get(12).toString());
				itemUser.setTglkeluar(v.get(13).toString());
				itemUser.setKjabatan(v.get(14).toString());
				itemUser.setDjabatan(v.get(15).toString());
				itemUser.setKcabang(v.get(16).toString());
				itemUser.setKpassword(v.get(27).toString());
				itemUser.setKeterangan(v.get(18).toString());
				itemUser.setKhpp(v.get(19).toString());
				itemUser.setKprint(v.get(20).toString());
				itemUser.setKconvert(v.get(21).toString());
				itemUser.setRecstatus(v.get(22).toString());
				itemUser.setTglupdate(Long.parseLong(v.get(23).toString().equals("")?"0":v.get(23).toString()));
				itemUser.setUserupdate(v.get(24).toString());
				itemUser.setkApprove(v.get(25).toString());
				itemUser.setkAlias(Long.parseLong(v.get(26).toString()));
				itemUser.setKcompany(v.get(27).toString());
				items[i]=itemUser;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.accounting.User[] getSales(String company) throws DAException
	{
		sf.accounting.User[] items=null;
		try
		{
			String strSQL="SELECT *,AES_DECRYPT(kpassword,'ekatama') as password FROM mstaff where recstatus<>'D' and kjabatan='SL' and kcompany=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, company);
			Vector rows=db.getData(p);
			int count=rows.size();
			items=new sf.accounting.User[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.User itemUser=new sf.accounting.User();
				
				itemUser.setKstaff(v.get(0).toString());
				itemUser.setNstaff(v.get(1).toString());
				itemUser.setAlamat1(v.get(2).toString());
				itemUser.setAlamat2(v.get(3).toString());
				itemUser.setAlamat3(v.get(4).toString());
				itemUser.setKota(v.get(5).toString());
				itemUser.setKodepos(v.get(6).toString());
				itemUser.setNotelp(v.get(7).toString());
				itemUser.setNofax(v.get(8).toString());
				itemUser.setNohp(v.get(9).toString());
				itemUser.setKotalahir(v.get(10).toString());
				itemUser.setTgllahir(v.get(11).toString());
				itemUser.setTglmasuk(v.get(12).toString());
				itemUser.setTglkeluar(v.get(13).toString());
				itemUser.setKjabatan(v.get(14).toString());
				itemUser.setDjabatan(v.get(15).toString());
				itemUser.setKcabang(v.get(16).toString());
				itemUser.setKpassword(v.get(27).toString());
				itemUser.setKeterangan(v.get(18).toString());
				itemUser.setKhpp(v.get(19).toString());
				itemUser.setKprint(v.get(20).toString());
				itemUser.setKconvert(v.get(21).toString());
				itemUser.setRecstatus(v.get(22).toString());
				itemUser.setTglupdate(Long.parseLong(v.get(23).toString().equals("")?"0":v.get(23).toString()));
				itemUser.setUserupdate(v.get(24).toString());
				itemUser.setkApprove(v.get(25).toString());
				itemUser.setkAlias(Long.parseLong(v.get(26).toString()));
				itemUser.setKcompany(v.get(27).toString());
				items[i]=itemUser;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	public boolean deleteUser(sf.accounting.User user) throws DAException
	{
		try
		{
			String strSQL="UPDATE mstaff set recstatus=?,tglupdate=?,userupdate=? where kstaff=?";
			PreparedStatement p = db.getStatement(strSQL);
			p.setString(1, user.getRecstatus());
			p.setLong(2, user.getTglupdate());
			p.setString(3, user.getUserupdate());
			p.setString(4, user.getKstaff());
			
			return db.execute(p);
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
	}
}
