package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Kurs {
	
	private DBEngine db=null;
	static final Category log = Category.getInstance(Valuta.class);
	
	public Kurs() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");	
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.Kurs[] getKurs() throws DAException
	{
		sf.accounting.Kurs[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mkurs where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.Kurs[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Kurs item=new sf.accounting.Kurs();
				item.setKvaluta(v.get(0).toString());
				item.setTvaluta(Integer.parseInt(v.get(1).toString()));
				item.setNvaluta(Double.parseDouble(v.get(2).toString()));
				
				item.setRecstatus(v.get(3).toString());
				item.setTglupdate(Long.parseLong(v.get(4).toString()));
				item.setUserupdate(v.get(5).toString());
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
	public sf.accounting.Kurs[] getKurs(String kValuta) throws DAException
	{
		sf.accounting.Kurs[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM mkurs where recstatus<>? and kvaluta=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kValuta);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.Kurs[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Kurs item=new sf.accounting.Kurs();
				item.setKvaluta(v.get(0).toString());
				item.setTvaluta(Integer.parseInt(v.get(1).toString()));
				item.setNvaluta(Double.parseDouble(v.get(2).toString()));
				item.setRecstatus(v.get(3).toString());
				item.setTglupdate(Long.parseLong(v.get(4).toString()));
				item.setUserupdate(v.get(5).toString());
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
	public sf.accounting.Kurs[] getLatestKurs(String kValuta,String tglValuta) throws DAException
	{
		sf.accounting.Kurs[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM mkurs where recstatus<>? and kvaluta=? and tvaluta<=? order by tvaluta desc";
			System.out.println(strSQL + "[" + kValuta + "," + tglValuta + "]");
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kValuta);
			p.setString(3, tglValuta);
			Vector rows = db.getData(p);
			if(rows==null)
			{
				System.out.println("Empty latest kurs");
				items = new sf.accounting.Kurs[1];
				sf.accounting.Kurs item=new sf.accounting.Kurs();
				items[0]=item;
				return items;
			}
			int count=rows.size();
			items = new sf.accounting.Kurs[count];
			for(int i=0; i < count; i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Kurs item=new sf.accounting.Kurs();
				item.setKvaluta(v.get(0).toString());
				item.setTvaluta(Integer.parseInt(v.get(1).toString()));
				item.setNvaluta(Double.parseDouble(v.get(2).toString()));
				item.setRecstatus(v.get(3).toString());
				item.setTglupdate(Long.parseLong(v.get(4).toString()));
				item.setUserupdate(v.get(5).toString());
				System.out.println("Tvaluta:" + item.getTvaluta() + ",Nvaluta:" + item.getNvaluta());
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertKurs(sf.accounting.Kurs kurs) throws DAException 
	{
		if(kurs.checkIsNULL())
		{
			throw new DAException(kurs.getErr());
		}
		
		String strSQL="INSERT INTO mkurs values (?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kurs.getKvaluta());
			p.setInt(2, kurs.getTvaluta());
			p.setDouble(3, kurs.getNvaluta());
			p.setString(4, kurs.getRecstatus());
			p.setLong(5, kurs.getTglupdate());
			p.setString(6, kurs.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateKurs(sf.accounting.Kurs kurs) throws DAException 
	{
		if(kurs.checkIsNULL())
		{
			throw new DAException(kurs.getErr());
		}
		
		String strSQL="UPDATE mkurs set nvaluta=?,recstatus=?,tglupdate=?,userupdate=? where kvaluta=? and tvaluta=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setDouble(1, kurs.getNvaluta());
			p.setString(2, kurs.getRecstatus());
			p.setLong(3, kurs.getTglupdate());
			p.setString(4, kurs.getUserupdate());
			p.setString(5, kurs.getKvaluta());
			p.setInt(6, kurs.getTvaluta());
			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteKurs(String kvaluta) throws DAException 
	{
		String strSQL="DELETE From mkurs where kvaluta=?";
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
