package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Group2 {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Group2.class);
	public Group2() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.Group2[] getGroup2() throws DAException
	{
		sf.inventory.Group2[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mgroup2 where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Group2[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Group2 item=new sf.inventory.Group2();
				item.setKgroup(v.get(0).toString());
				item.setKgroup1(v.get(1).toString());
				item.setKgroup2(v.get(2).toString());
				item.setNgroup2(v.get(3).toString());
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
	public sf.inventory.Group2[] getGroup2(String kgroup,String kgroup1) throws DAException
	{
		sf.inventory.Group2[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM mgroup2 where recstatus<>? and kgroup=? and kgroup1=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kgroup);
			p.setString(3, kgroup1);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Group2[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Group2 item=new sf.inventory.Group2();
				item.setKgroup(v.get(0).toString());
				item.setKgroup1(v.get(1).toString());
				item.setKgroup2(v.get(2).toString());
				item.setNgroup2(v.get(3).toString());
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
	
	public boolean insertGroup2(sf.inventory.Group2 group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="INSERT INTO mgroup2 values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKgroup());
			p.setString(2, group.getKgroup1());
			p.setString(3, group.getKgroup2());
			p.setString(4, group.getNgroup2());
			p.setString(5, group.getRecstatus());
			p.setLong(6, group.getTglupdate());
			p.setString(7, group.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateGroup2(sf.inventory.Group2 group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE mgroup2 SET ngroup2=?,recstatus=?,tglupdate=?,userupdate=? where kgroup=? and kgroup1=? and kgroup2=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getNgroup2());
			p.setString(2, group.getRecstatus());
			p.setLong(3, group.getTglupdate());
			p.setString(4, group.getUserupdate());
			p.setString(5, group.getKgroup());
			p.setString(6, group.getKgroup1());
			p.setString(7, group.getKgroup2());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteGroup2(String kgroup) throws DAException
	{
		String strSQL="DELETE FROM mgroup2 where kgroup2=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kgroup);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
