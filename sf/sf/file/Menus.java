package sf.file;

import sf.general.General;

public class Menus extends General{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String menuname;
private String recstatus="Y";
private String _err;

private Menus[] menus;

public String getErr()
{
	return _err;
}

public boolean checkIsNULL()
{
	_err="";
	if(this.getMenuname()==null || "".equals(this.getMenuname()))
	{
		_err="Error,Invalid Menu Name. Could not empty.";
		return true;
	}
	
	return false;
}

public void setMenus(Menus[] menus) {
	this.menus = menus;
}

public Menus[] getMenus() {
	return menus;
}

/**
 * @param menuname the menuname to set
 */
public void setMenuname(String menuname) {
	this.menuname = menuname;
}

/**
 * @return the menuname
 */
public String getMenuname() {
	return menuname;
}

/**
 * @param recstatus the recstatus to set
 */
public void setRecstatus(String recstatus) {
	this.recstatus = recstatus;
}

/**
 * @return the recstatus
 */
public String getRecstatus() {
	return recstatus;
}


}
