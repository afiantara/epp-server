package bo.file;

import da.error.DAException;

public class Menus {
	private da.file.Menus daMenus;
	public Menus() throws DAException
	{
		daMenus=new da.file.Menus();
	}
	
	public sf.file.Menus getMenus() throws DAException
	{
		sf.file.Menus menus=new sf.file.Menus();
		menus.setMenus(daMenus.getMenus());
		return menus;
	}
	
	public sf.file.Menus getMenus(String kmenus) throws DAException
	{
		sf.file.Menus menus=new sf.file.Menus();
		menus.setMenus(daMenus.getMenus(kmenus));
		return menus;
	}
	
	public boolean insertMenus(sf.file.Menus menus) throws DAException
	{
		return daMenus.insertMenus(menus);
	}
	
	public boolean updateMenus(sf.file.Menus menus) throws DAException
	{
		return daMenus.updateMenus(menus);
	}
	
	public boolean deleteMenus(sf.file.Menus menus) throws DAException
	{
		return daMenus.deleteMenus(menus);
	}
}
