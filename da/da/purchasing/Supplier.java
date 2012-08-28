package da.purchasing;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.purchasing.Title;

import da.error.DAException;
import da.factory.DBEngine;

public class Supplier {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Supplier.class);
	public Supplier() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public sf.purchasing.Supplier[] getSupplier() throws DAException
	{
		sf.purchasing.Supplier[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM msupplier where recstatus<>'D'";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.purchasing.Supplier[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.purchasing.Supplier item=new sf.purchasing.Supplier();
				item.setKvendor(v.get(0).toString());
				item.setKtitel(v.get(1).toString());
				item.setNvendor(v.get(2).toString());
				item.setAlamat1(v.get(3).toString());
				item.setAlamat2(v.get(4).toString());
				item.setAlamat3(v.get(5).toString());
				item.setKota(v.get(6).toString());
				item.setKodepos(v.get(7).toString());
				item.setNotelp(v.get(8).toString());
				item.setNofax(v.get(9).toString());
				item.setWebsite(v.get(10).toString());
				item.setEmail(v.get(11).toString());
				item.setKontak1(v.get(12).toString());
				item.setKontak2(v.get(13).toString());
				item.setNohp1(v.get(14).toString());
				item.setNohp2(v.get(15).toString());
				item.setEmail1(v.get(16).toString());
				item.setEmail2(v.get(17).toString());
				item.setKcompany(v.get(18).toString());
				item.setKstatus(v.get(19).toString());
				item.setJtempo(Integer.parseInt(v.get(20).toString()));
				item.setRecstatus(v.get(21).toString());
				item.setUserinput(v.get(22).toString());
				item.setTglinput(Long.parseLong(v.get(23).toString()));
				item.setTglupdate(Long.parseLong(v.get(24).toString()));
				item.setUserupdate(v.get(25).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public sf.purchasing.Supplier getSupplier(String ksupplier) throws DAException
	{
		sf.purchasing.Supplier item=new sf.purchasing.Supplier();
		try
		{
			String strSQL="SELECT * FROM msupplier where recstatus<>? and kvendor=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, ksupplier);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				
				item.setKvendor(v.get(0).toString());
				item.setKtitel(v.get(1).toString());
				item.setNvendor(v.get(2).toString());
				item.setAlamat1(v.get(3).toString());
				item.setAlamat2(v.get(4).toString());
				item.setAlamat3(v.get(5).toString());
				item.setKota(v.get(6).toString());
				item.setKodepos(v.get(7).toString());
				item.setNotelp(v.get(8).toString());
				item.setNofax(v.get(9).toString());
				item.setWebsite(v.get(10).toString());
				item.setEmail(v.get(11).toString());
				item.setKontak1(v.get(12).toString());
				item.setKontak2(v.get(13).toString());
				item.setNohp1(v.get(14).toString());
				item.setNohp2(v.get(15).toString());
				item.setEmail1(v.get(16).toString());
				item.setEmail2(v.get(17).toString());
				item.setKcompany(v.get(18).toString());
				item.setKstatus(v.get(19).toString());
				item.setJtempo(Integer.parseInt(v.get(20).toString()));
				item.setRecstatus(v.get(21).toString());
				item.setUserinput(v.get(22).toString());
				item.setTglinput(Long.parseLong(v.get(23).toString()));
				item.setTglupdate(Long.parseLong(v.get(24).toString()));
				item.setUserupdate(v.get(25).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	
	public boolean insertSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		if(supplier.checkIsNULL())
		{
			throw new DAException(supplier.getErr());
		}
		
		String strSQL="INSERT INTO msupplier values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, supplier.getKvendor());
			p.setString(2, supplier.getKtitel());
			p.setString(3, supplier.getNvendor());
			p.setString(4, supplier.getAlamat1());
			p.setString(5, supplier.getAlamat2());
			p.setString(6, supplier.getAlamat3());
			p.setString(7, supplier.getKota());
			p.setString(8, supplier.getKodepos());
			p.setString(9, supplier.getNotelp());
			p.setString(10, supplier.getNofax());
			p.setString(11, supplier.getWebsite());
			p.setString(12, supplier.getEmail());
			p.setString(13, supplier.getKontak1());
			p.setString(14, supplier.getKontak2());
			p.setString(15, supplier.getNohp1());
			p.setString(16, supplier.getNohp2());
			p.setString(17, supplier.getEmail1());
			p.setString(18, supplier.getEmail2());
			p.setString(19, supplier.getKcompany());
			p.setString(20, supplier.getKstatus());
			p.setInt(21, supplier.getJtempo());
			p.setString(22, supplier.getRecstatus());
			p.setString(23, supplier.getUserinput());
			p.setLong(24, supplier.getTglinput());
			p.setLong(25, supplier.getTglupdate());
			p.setString(26, supplier.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		if(supplier.checkIsNULL())
		{
			throw new DAException(supplier.getErr());
		}
		
		String strSQL="UPDATE msupplier SET nvendor=?,ktitel=?,alamat1=?,alamat2=?,alamat3=?," +
				"kota=?,kodepos=?,notelp=?,nofax=?,website=?,email=?,kontak1=?,kontak2=?,nohp1=?,nohp2=?," +
				"email1=?,email2=?,kcompany=?,kstatus=?,jtempo=?,recstatus=?,tglupdate=?,userupdate=? where kvendor=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, supplier.getNvendor());
			p.setString(2, supplier.getKtitel());
			p.setString(3, supplier.getAlamat1());
			p.setString(4, supplier.getAlamat2());
			p.setString(5, supplier.getAlamat3());
			p.setString(6, supplier.getKota());
			p.setString(7, supplier.getKodepos());
			p.setString(8, supplier.getNotelp());
			p.setString(9, supplier.getNofax());
			p.setString(10, supplier.getWebsite());
			p.setString(11, supplier.getEmail());
			p.setString(12, supplier.getKontak1());
			p.setString(13, supplier.getKontak2());
			p.setString(14, supplier.getNohp1());
			p.setString(15, supplier.getNohp2());
			p.setString(16, supplier.getEmail1());
			p.setString(17, supplier.getEmail2());
			p.setString(18, supplier.getKcompany());
			p.setString(19, supplier.getKstatus());
			p.setInt(20, supplier.getJtempo());
			p.setString(21, supplier.getRecstatus());
			p.setLong(22, supplier.getTglupdate());
			p.setString(23, supplier.getUserupdate());
			p.setString(24, supplier.getKvendor());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteSupplier(String kvendor) throws DAException
	{
		String strSQL="DELETE FROM msupplier where kvendor=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kvendor);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public sf.purchasing.Title[] getTitle() throws DAException
	{
		Title [] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mtitel";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new Title[count];
			for(int i=0; i < count;i++)
			{
				Title title=new Title();
				Vector v=(Vector)rows.get(i);
				title.setKtitel(v.get(0).toString());
				items[i]=title;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
}
