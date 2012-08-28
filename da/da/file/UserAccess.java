package da.file;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class UserAccess {
	private DBEngine db=null;
	static final Category log=Category.getInstance(UserAccess.class);
	
	public UserAccess()throws DAException {
		db=new DBEngine ();
		if(!db.connect())throw new DAException("Cloud not connect to database");
	}
	
	public sf.file.UserAccess[] getUserAccess()throws DAException{
		
		sf.file.UserAccess[] items;
		
		try{
			String strSQL="SELECT * FROM user_access";
			PreparedStatement p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.file.UserAccess[count];
			for (int i = 0; i < count; i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.file.UserAccess item=new sf.file.UserAccess();
				item.setUserid(v.get(0).toString());
				item.setMenuname(v.get(1).toString());
				item.setRecstatus(v.get(2).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.file.UserAccess[] getUserAccess(String userID) throws DAException
	{
		sf.file.UserAccess[] items;
		try
		{
			String strSQL="SELECT * FROM user_access";
			if(userID!=null)
				strSQL="SELECT * FROM user_access where userid=?";
			System.out.println(strSQL + ":[" + userID+ "]");
			PreparedStatement p=db.getStatement(strSQL);
			if(userID!=null)
				p.setString(1, userID);
			Vector rows = db.getData(p);
			int count=rows.size();
			items=new sf.file.UserAccess[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.file.UserAccess item = new sf.file.UserAccess();
				item.setUserid(v.get(0).toString());
				item.setMenuname(v.get(1).toString());
				item.setRecstatus(v.get(2).toString());
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertUserAccess(sf.file.UserAccess name) throws DAException
	{
		if(name.checkIsNULL())
		{
			throw new DAException(name.getErr());
		}
		
		String strSQL="INSERT INTO user_access values (?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, name.getUserid());
			p.setString(2, name.getMenuname());
			p.setString(3, name.getRecstatus());
			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}

	public boolean updateUserAccess(sf.file.UserAccess name ) throws DAException
	{
		if(name.checkIsNULL())
		{
			throw new DAException(name.getErr());
		}
		
		String strSQL="UPDATE user_access set recstatus=? where userid=? and menu_name=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, name.getRecstatus());
			p.setString(2, name.getUserid());
			p.setString(3, name.getMenuname());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}

	public boolean deleteUserAccess(String userid) throws DAException
	{
		String strSQL="DELETE FROM user_access where userid=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, userid);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteUserAccess(sf.file.UserAccess useraccess) throws DAException
	{
		String strSQL="DELETE FROM user_access where userid=? and menu_name=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, useraccess.getUserid());
			p.setString(2, useraccess.getMenuname());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}

