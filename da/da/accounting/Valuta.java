package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Valuta {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Valuta.class);
	
	public Valuta() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.Valuta[] getValutas() throws DAException
	{
		sf.accounting.Valuta[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mvaluta where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.Valuta[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Valuta item=new sf.accounting.Valuta();
				item.setKvaluta(v.get(0).toString());
				item.setKetvaluta(v.get(1).toString());
				
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
	public sf.accounting.Valuta getValuta(String kValuta) throws DAException
	{
		sf.accounting.Valuta item=new sf.accounting.Valuta();
		try
		{
			String strSQL="SELECT * FROM mvaluta where recstatus<>? and kvaluta=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kValuta);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				
				item.setKvaluta(v.get(0).toString());
				item.setKetvaluta(v.get(1).toString());
				
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
	
	public boolean insertValuta(sf.accounting.Valuta valuta) throws DAException 
	{
		if(valuta.checkIsNULL())
		{
			throw new DAException(valuta.getErr());
		}
		
		String strSQL="INSERT INTO mvaluta values (?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, valuta.getKvaluta());
			p.setString(2, valuta.getKetvaluta());
			p.setString(3, valuta.getRecstatus());
			p.setLong(4, valuta.getTglupdate());
			p.setString(5, valuta.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage(),e.getErrorCode());
		}
	}
	
	public boolean updateValuta(sf.accounting.Valuta valuta) throws DAException 
	{
		if(valuta.checkIsNULL())
		{
			throw new DAException(valuta.getErr());
		}
		
		String strSQL="UPDATE mvaluta set ketvaluta=?,recstatus=?,tglupdate=?,userupdate=? where kvaluta=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, valuta.getKetvaluta());
			p.setString(2, valuta.getRecstatus());
			p.setLong(3, valuta.getTglupdate());
			p.setString(4, valuta.getUserupdate());
			p.setString(5, valuta.getKvaluta());
			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteValuta(String kvaluta) throws DAException 
	{
		String strSQL="DELETE From mvaluta where kvaluta=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kvaluta);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
