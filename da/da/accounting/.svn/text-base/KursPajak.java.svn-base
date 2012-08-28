package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class KursPajak {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Valuta.class);
	
	public KursPajak() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");	
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.KursPajak[] getKursPajak() throws DAException
	{
		sf.accounting.KursPajak[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mkpajak where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.KursPajak[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.KursPajak item=new sf.accounting.KursPajak();
				item.setKvaluta(v.get(0).toString());
				item.setTvaluta1(Integer.parseInt(v.get(1).toString()));
				item.setTvaluta2(Integer.parseInt(v.get(2).toString()));
				item.setNvaluta(Double.parseDouble(v.get(3).toString()));
				
				item.setRecstatus(v.get(4).toString());
				item.setTglupdate(Long.parseLong(v.get(5).toString()));
				item.setUserupdate(v.get(6).toString());
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
	public sf.accounting.KursPajak[] getKursPajak(String kValuta) throws DAException
	{
		sf.accounting.KursPajak[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM mkpajak where recstatus<>? and kvaluta=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kValuta);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.KursPajak[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.KursPajak item=new sf.accounting.KursPajak();
				item.setKvaluta(v.get(0).toString());
				item.setTvaluta1(Integer.parseInt(v.get(1).toString()));
				item.setTvaluta2(Integer.parseInt(v.get(2).toString()));
				item.setNvaluta(Double.parseDouble(v.get(3).toString()));
				item.setRecstatus(v.get(4).toString());
				item.setTglupdate(Long.parseLong(v.get(5).toString()));
				item.setUserupdate(v.get(6).toString());
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertKursPajak(sf.accounting.KursPajak kurs) throws DAException 
	{
		if(kurs.checkIsNULL())
		{
			throw new DAException(kurs.getErr());
		}
		
		String strSQL="INSERT INTO mkpajak values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kurs.getKvaluta());
			p.setInt(2, kurs.getTvaluta1());
			p.setInt(3, kurs.getTvaluta2());
			p.setDouble(4, kurs.getNvaluta());
			p.setString(5, kurs.getRecstatus());
			p.setLong(6, kurs.getTglupdate());
			p.setString(7, kurs.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateKursPajak(sf.accounting.KursPajak kurs) throws DAException 
	{
		if(kurs.checkIsNULL())
		{
			throw new DAException(kurs.getErr());
		}
		
		String strSQL="UPDATE mkpajak set tvaluta2=?,nvaluta=?,recstatus=?,tglupdate=?,userupdate=? where kvaluta=? and tvaluta1=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setInt(1, kurs.getTvaluta2());
			p.setDouble(2, kurs.getNvaluta());
			p.setString(3, kurs.getRecstatus());
			p.setLong(4, kurs.getTglupdate());
			p.setString(5, kurs.getUserupdate());
			p.setString(6, kurs.getKvaluta());
			p.setInt(7, kurs.getTvaluta1());	
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteKursPajak(String kvaluta) throws DAException 
	{
		String strSQL="DELETE From mkpajak where kvaluta=?";
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
