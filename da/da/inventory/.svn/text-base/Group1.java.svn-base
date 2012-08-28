package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Group1 {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Group1.class);
	
	public Group1() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.Group1[] getGroup1() throws DAException
	{
		sf.inventory.Group1[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mgroup1 where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Group1[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Group1 item=new sf.inventory.Group1();
				item.setKgroup(v.get(0).toString());
				item.setKgroup1(v.get(1).toString());
				item.setNgroup1(v.get(2).toString());
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
	public sf.inventory.Group1[] getGroup1(String kgroup1) throws DAException
	{
		sf.inventory.Group1[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM mgroup1 where recstatus<>? and kgroup=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kgroup1);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Group1[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Group1 item=new sf.inventory.Group1();
				item.setKgroup(v.get(0).toString());
				item.setKgroup1(v.get(1).toString());
				item.setNgroup1(v.get(2).toString());
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
	
	public boolean insertGroup1(sf.inventory.Group1 group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="INSERT INTO mgroup1 values (?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKgroup());
			p.setString(2, group.getKgroup1());
			p.setString(3, group.getNgroup1());
			p.setString(4, group.getRecstatus());
			p.setLong(5, group.getTglupdate());
			p.setString(6, group.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateGroup1(sf.inventory.Group1 group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE mgroup1 SET ngroup1=?,recstatus=?,tglupdate=?,userupdate=? where kgroup=? and kgroup1=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getNgroup1());
			p.setString(2, group.getRecstatus());
			p.setLong(3, group.getTglupdate());
			p.setString(4, group.getUserupdate());
			p.setString(5, group.getKgroup());
			p.setString(6, group.getKgroup1());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteGroup1(String kgroup) throws DAException
	{
		String strSQL="DELETE FROM mgroup1 where kgroup1=?";
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
