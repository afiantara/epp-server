package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Rak {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Rak.class);
	public Rak() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.Rak[] getRak() throws DAException
	{
		sf.inventory.Rak[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mrak where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Rak[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Rak item=new sf.inventory.Rak();
				item.setKoderak(v.get(0).toString());
				item.setLokasirak(v.get(1).toString());
				item.setRecstatus(v.get(2).toString());
				item.setTglupdate(Long.parseLong(v.get(3).toString()));
				item.setUserupdate(v.get(4).toString());
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
	public sf.inventory.Rak getRak(String koderak) throws DAException
	{
		sf.inventory.Rak item=new sf.inventory.Rak();
		try
		{
			String strSQL="SELECT * FROM mrak where recstatus<>? and koderak=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, koderak);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				
				item.setKoderak(v.get(0).toString());
				item.setLokasirak(v.get(1).toString());
				item.setRecstatus(v.get(2).toString());
				item.setTglupdate(Long.parseLong(v.get(3).toString()));
				item.setUserupdate(v.get(4).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	
	public boolean insertRak(sf.inventory.Rak rak) throws DAException
	{
		if(rak.checkIsNULL())
		{
			throw new DAException(rak.getErr());
		}
		
		String strSQL="INSERT INTO mrak values (?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, rak.getKoderak());
			p.setString(2, rak.getLokasirak());
			p.setString(3, rak.getRecstatus());
			p.setLong(4, rak.getTglupdate());
			p.setString(5, rak.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateRak(sf.inventory.Rak rak) throws DAException
	{
		if(rak.checkIsNULL())
		{
			throw new DAException(rak.getErr());
		}
		
		String strSQL="UPDATE mrak SET lokasirak=?,recstatus=?,tglupdate=?,userupdate=? where koderak=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, rak.getLokasirak());
			p.setString(2, rak.getRecstatus());
			p.setLong(3, rak.getTglupdate());
			p.setString(4, rak.getUserupdate());
			p.setString(5, rak.getKoderak());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteRak(String koderak) throws DAException
	{
		String strSQL="DELETE FROM mrak where koderak=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, koderak);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
