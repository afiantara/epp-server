package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;
import sf.accounting.Account;

public class COA {
	
	private DBEngine db=null;
	static final Category log = Category.getInstance(COA.class);
	
	public COA() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public Account[] getAccounts() throws DAException
	{
		Account[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM maccount where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new Account[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				Account item=new Account();
				item.setAccno(v.get(0).toString());
				item.setAccdesc(v.get(1).toString());
				item.setAcclevel(v.get(2).toString());
				item.setAccgroup(v.get(3).toString());
				item.setAcctype(v.get(4).toString());
				item.setAccbiayas(v.get(5).toString());
				item.setAccbiayab(v.get(6).toString());
				item.setAccbiayap(v.get(7).toString());
				item.setAccbiayak(v.get(8).toString());
				item.setKodein(v.get(9).toString());
				item.setKodeout(v.get(10).toString());
				item.setNoin(Integer.parseInt(v.get(11).toString()));
				item.setNoout(Integer.parseInt(v.get(12).toString()));
				
				item.setRecstatus(v.get(13).toString());
				item.setUserinput(v.get(14).toString());
				item.setTglinput(Long.parseLong(v.get(15).toString()));
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
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
	public Account[] getAccountByGroup(String group) throws DAException
	{
		Account[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM maccount where recstatus<>? and accgroup=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, group);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new Account[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				Account item=new Account();
				item.setAccno(v.get(0).toString());
				item.setAccdesc(v.get(1).toString());
				item.setAcclevel(v.get(2).toString());
				item.setAccgroup(v.get(3).toString());
				item.setAcctype(v.get(4).toString());
				item.setAccbiayas(v.get(5).toString());
				item.setAccbiayab(v.get(6).toString());
				item.setAccbiayap(v.get(7).toString());
				item.setAccbiayak(v.get(8).toString());
				item.setKodein(v.get(9).toString());
				item.setKodeout(v.get(10).toString());
				item.setNoin(Integer.parseInt(v.get(11).toString()));
				item.setNoout(Integer.parseInt(v.get(12).toString()));
				
				item.setRecstatus(v.get(13).toString());
				item.setUserinput(v.get(14).toString());
				item.setTglinput(Long.parseLong(v.get(15).toString()));
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public Account[] getAccountByLevel(String level) throws DAException
	{
		Account[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM maccount where recstatus<>? and acclevel=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, level);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new Account[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				Account item=new Account();
				item.setAccno(v.get(0).toString());
				item.setAccdesc(v.get(1).toString());
				item.setAcclevel(v.get(2).toString());
				item.setAccgroup(v.get(3).toString());
				item.setAcctype(v.get(4).toString());
				item.setAccbiayas(v.get(5).toString());
				item.setAccbiayab(v.get(6).toString());
				item.setAccbiayap(v.get(7).toString());
				item.setAccbiayak(v.get(8).toString());
				item.setKodein(v.get(9).toString());
				item.setKodeout(v.get(10).toString());
				item.setNoin(Integer.parseInt(v.get(11).toString()));
				item.setNoout(Integer.parseInt(v.get(12).toString()));
				
				item.setRecstatus(v.get(13).toString());
				item.setUserinput(v.get(14).toString());
				item.setTglinput(Long.parseLong(v.get(15).toString()));
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public Account getAccountByNo(String accountNo) throws DAException
	{
		Account item=new Account();
		try
		{
			String strSQL="SELECT * FROM maccount where recstatus<>? and accno=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, accountNo);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				item.setAccno(v.get(0).toString());
				item.setAccdesc(v.get(1).toString());
				item.setAcclevel(v.get(2).toString());
				item.setAccgroup(v.get(3).toString());
				item.setAcctype(v.get(4).toString());
				item.setAccbiayas(v.get(5).toString());
				item.setAccbiayab(v.get(6).toString());
				item.setAccbiayap(v.get(7).toString());
				item.setAccbiayak(v.get(8).toString());
				item.setKodein(v.get(9).toString());
				item.setKodeout(v.get(10).toString());
				item.setNoin(Integer.parseInt(v.get(11).toString()));
				item.setNoout(Integer.parseInt(v.get(12).toString()));
				
				item.setRecstatus(v.get(13).toString());
				item.setUserinput(v.get(14).toString());
				item.setTglinput(Long.parseLong(v.get(15).toString()));
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;	
	}
	
	public Account[] getAccountBiaya(String accountNo,String desc) throws DAException
	{
		sf.accounting.Account[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM maccount where recstatus<>? and accbiayas=? and accno like ? and accdesc like ?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, "Y");
			p.setString(3, accountNo + "%");
			p.setString(4, desc + "%");
			
			log.info("getAccountBiaya->" + strSQL + "[0]" + accountNo + "[1]" + desc);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.Account[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Account item=new sf.accounting.Account();
				item.setAccno(v.get(0).toString());
				item.setAccdesc(v.get(1).toString());
				item.setAcclevel(v.get(2).toString());
				item.setAccgroup(v.get(3).toString());
				item.setAcctype(v.get(4).toString());
				item.setAccbiayas(v.get(5).toString());
				item.setAccbiayab(v.get(6).toString());
				item.setAccbiayap(v.get(7).toString());
				item.setAccbiayak(v.get(8).toString());
				item.setKodein(v.get(9).toString());
				item.setKodeout(v.get(10).toString());
				item.setNoin(Integer.parseInt(v.get(11).toString()));
				item.setNoout(Integer.parseInt(v.get(12).toString()));
				
				item.setRecstatus(v.get(13).toString());
				item.setUserinput(v.get(14).toString());
				item.setTglinput(Long.parseLong(v.get(15).toString()));
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
				items[i]= item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;	
	}
	
	public boolean insertCOA(Account acct) throws DAException 
	{
		if(acct.checkIsNULL())
		{
			throw new DAException(acct.getErr());
		}
		
		String strSQL="INSERT INTO maccount values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, acct.getAccno());
			p.setString(2, acct.getAccdesc());
			p.setString(3, acct.getAcclevel());
			p.setString(4, acct.getAccgroup());
			p.setString(5, acct.getAcctype());
			p.setString(6, acct.getAccbiayas());
			p.setString(7, acct.getAccbiayab());
			p.setString(8, acct.getAccbiayap());
			p.setString(9, acct.getAccbiayak());
			p.setString(10, acct.getKodein());
			p.setString(11, acct.getKodeout());
			p.setInt(12, acct.getNoin());
			p.setInt(13, acct.getNoout());
			p.setString(14, acct.getRecstatus());
			p.setString(15, acct.getUserinput());
			p.setLong(16, acct.getTglinput());
			p.setLong(17, acct.getTglupdate());
			p.setString(18, acct.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateCOA(Account acct) throws DAException
	{
		if(acct.checkIsNULL())
		{
			throw new DAException(acct.getErr());
		}
		
		String strSQL="UPDATE maccount set accdesc=?," +
						"acclevel=?," +
						"accgroup=?," +
						"acctype=?," +
						"accbiayab=?,"+
						"accbiayap=?,"+
						"accbiayas=?,"+
						"accbiayak=?,"+
						"kodein=?,"+
						"kodeout=?,"+
						"noin=?,"+
						"noout=?,"+
						"recstatus=?,"+
						"tglupdate=?,"+
						"userupdate=? where accno=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, acct.getAccdesc());
			p.setString(2, acct.getAcclevel());
			p.setString(3, acct.getAccgroup());
			p.setString(4, acct.getAcctype());
			p.setString(5, acct.getAccbiayab());
			p.setString(6, acct.getAccbiayap());
			p.setString(7, acct.getAccbiayas());
			p.setString(8, acct.getAccbiayak());
			p.setString(9, acct.getKodein());
			p.setString(10, acct.getKodeout());
			p.setInt(11, acct.getNoin());
			p.setInt(12, acct.getNoout());
			p.setString(13, acct.getRecstatus());
			p.setLong(14, acct.getTglupdate());
			p.setString(15, acct.getUserupdate());
			p.setString(16, acct.getAccno());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteCOA(String accno) throws DAException
	{
		String strSQL="DELETE FROM maccount WHERE accno=?";
		try
		{
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, accno);
			return db.execute(p);
		}
		catch(SQLException e)
		{
			throw new DAException(e.getMessage());	
		}
	}
}
