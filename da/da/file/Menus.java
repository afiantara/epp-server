package da.file;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Menus{
	private DBEngine db=null;
	static final Category log=Category.getInstance(Menus.class);
	
	public Menus()throws DAException {
		db=new DBEngine ();
		if(!db.connect())throw new DAException("Cloud not connect to database");
	}
	
	public sf.file.Menus[] getMenus()throws DAException{
		
		sf.file.Menus[] items;
		
		try{
			String strSQL="SELECT * FROM menu_name";
			PreparedStatement p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.file.Menus[count];
			for (int i = 0; i < count; i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.file.Menus item=new sf.file.Menus();
				item.setMenuname(v.get(0).toString());
				item.setRecstatus(v.get(1).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.file.Menus[] getMenus(String name) throws DAException
	{
		sf.file.Menus[] items;
		try
		{
			String strSQL="SELECT * FROM menu_name where name=?";
			System.out.println(strSQL + ":[" + name+ "]");
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, name);
			Vector rows = db.getData(p);
			int count=rows.size();
			items=new sf.file.Menus[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.file.Menus item=new sf.file.Menus();
				item.setMenuname(v.get(0).toString());
				item.setRecstatus(v.get(1).toString());
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public boolean insertMenus(sf.file.Menus name) throws DAException
	{
		if(name.checkIsNULL())
		{
			throw new DAException(name.getErr());
		}
		
		String strSQL="INSERT INTO menu_name values (?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, name.getMenuname());
			p.setString(2, name.getRecstatus());
			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}

	public boolean updateMenus(sf.file.Menus name ) throws DAException
	{
		if(name.checkIsNULL())
		{
			throw new DAException(name.getErr());
		}
		
		String strSQL="UPDATE menu_name SET recstatus=? where name=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, name.getRecstatus());
			p.setString(2, name.getMenuname());			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}

	public boolean deleteMenus(sf.file.Menus menu) throws DAException
	{
		String strSQL="DELETE FROM menu_name where name=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, menu.getMenuname());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}

