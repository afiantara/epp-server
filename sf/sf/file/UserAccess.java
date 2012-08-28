package sf.file;

import sf.general.General;

public class UserAccess extends General {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String userid;
private String menuname;
private String recstatus="Y";
private String _err;
private UserAccess[] users;


public String getErr()
{
	return _err;
}

public boolean checkIsNULL() {
	_err="";
	if(this.getUserid()==null || "".equals(this.getUserid()))
	{
		_err="Error,Invalid UseriD. Could not empty.";
		return true;
	}
	
	if(this.getMenuname()==null || "".equals(this.getMenuname()))
	{
		_err="Error,Invalid Menu Name. Could not empty.";
		return true;
	}
	return false;
}

/**
 * @param userid the userid to set
 */
public void setUserid(String userid) {
	this.userid = userid;
}
/**
 * @return the userid
 */
public String getUserid() {
	return userid;
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
/**
 * @param users the users to set
 */
public void setUsers(UserAccess[] users) {
	this.users = users;
}
/**
 * @return the users
 */
public UserAccess[] getUsers() {
	return users;
}
}
