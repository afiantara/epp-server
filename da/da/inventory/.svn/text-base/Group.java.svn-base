package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Group {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Group.class);
	public Group() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.Group[] getGroup() throws DAException
	{
		sf.inventory.Group[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mgroup where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Group[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Group item=new sf.inventory.Group();
				item.setKgroup(v.get(0).toString());
				item.setNgroup(v.get(1).toString());
				item.setMaxdisc(Double.parseDouble(v.get(2).toString()));
				item.setMinstock(Double.parseDouble(v.get(3).toString()));
				item.setMaxstock(Double.parseDouble(v.get(4).toString()));
				item.setRecstatus(v.get(5).toString());
				item.setTglupdate(Long.parseLong(v.get(6).toString()));
				item.setUserupdate(v.get(7).toString());
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
	public sf.inventory.Group getGroup(String kgroup) throws DAException
	{
		sf.inventory.Group item=new sf.inventory.Group();
		try
		{
			String strSQL="SELECT * FROM mgroup where recstatus<>? and kgroup=?";
			System.out.println(strSQL + ":[" + kgroup + "]");
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kgroup);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				item.setKgroup(v.get(0).toString());
				item.setNgroup(v.get(1).toString());
				item.setMaxdisc(Double.parseDouble(v.get(2).toString()));
				item.setMinstock(Double.parseDouble(v.get(3).toString()));
				item.setMaxstock(Double.parseDouble(v.get(4).toString()));
				item.setRecstatus(v.get(5).toString());
				item.setTglupdate(Long.parseLong(v.get(6).toString()));
				item.setUserupdate(v.get(7).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	
	public boolean insertGroup(sf.inventory.Group group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="INSERT INTO mgroup values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKgroup());
			p.setString(2, group.getNgroup());
			p.setDouble(3, group.getMaxdisc());
			p.setDouble(4, group.getMaxstock());
			p.setDouble(5, group.getMinstock());
			p.setString(6, group.getRecstatus());
			p.setLong(7, group.getTglupdate());
			p.setString(8, group.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateGroup(sf.inventory.Group group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE mgroup SET ngroup=?,maxdisc=?,maxstock=?,minstock=?,recstatus=?,tglupdate=?,userupdate=? where kgroup=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getNgroup());
			p.setDouble(2, group.getMaxdisc());
			p.setDouble(3, group.getMaxstock());
			p.setDouble(4, group.getMinstock());
			p.setString(5, group.getRecstatus());
			p.setLong(6, group.getTglupdate());
			p.setString(7, group.getUserupdate());
			p.setString(8, group.getKgroup());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteGroup(String kgroup) throws DAException
	{
		String strSQL="DELETE FROM mgroup where kgroup=?";
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
