package da.crm;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Industry {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Industry.class);
	public Industry() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.crm.Industry[] getIndustries() throws DAException
	{
		sf.crm.Industry[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mindustri";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.crm.Industry[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.crm.Industry item=new sf.crm.Industry();
				item.setKindustri(v.get(0).toString());
				item.setNindustri(v.get(1).toString());
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
	public sf.crm.Industry getIndustry(String kindustri) throws DAException
	{
		sf.crm.Industry item=new sf.crm.Industry();
		try
		{
			String strSQL="SELECT * FROM mindustri where kindustri=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kindustri);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				item.setKindustri(v.get(0).toString());
				item.setNindustri(v.get(1).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	
	public boolean insertIndustry(sf.crm.Industry ind) throws DAException
	{
		if(ind.checkIsNULL())
		{
			throw new DAException(ind.getErr());
		}
		
		String strSQL="INSERT INTO mindustri values (?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, ind.getKindustri());
			p.setString(2, ind.getNindustri());
			p.setString(3, ind.getRecstatus());
			p.setLong(4, ind.getTglupdate());
			p.setString(5, ind.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateIndustry(sf.crm.Industry ind) throws DAException
	{
		if(ind.checkIsNULL())
		{
			throw new DAException(ind.getErr());
		}
		
		String strSQL="UPDATE mindustri set nindustri=?,recstatus=?,tglupdate=?,userupdate=? where kindustri=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, ind.getNindustri());
			p.setString(2, ind.getRecstatus());
			p.setLong(3, ind.getTglupdate());
			p.setString(4, ind.getUserupdate());
			p.setString(5, ind.getKindustri());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteIndustry(String kindustri) throws DAException
	{
		String strSQL="DELETE FROM mindustry where kindustri=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kindustri);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
