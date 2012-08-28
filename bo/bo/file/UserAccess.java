package bo.file;

import da.error.DAException;

public class UserAccess {
	private da.file.UserAccess daUserAccess;
	public UserAccess() throws DAException
	{
		daUserAccess=new da.file.UserAccess();
	}
	
	public sf.file.UserAccess getUserAccess() throws DAException
	{
		sf.file.UserAccess userAccess=new sf.file.UserAccess();
		userAccess.setUsers(daUserAccess.getUserAccess());
		return userAccess;
	}
	
	public sf.file.UserAccess getUserAccess(String kuserAccess) throws DAException
	{
		sf.file.UserAccess userAccess=new sf.file.UserAccess();
		userAccess.setUsers(daUserAccess.getUserAccess(kuserAccess));
		return userAccess;
	}
	
	public boolean insertUserAccess(sf.file.UserAccess userAccess) throws DAException
	{
		return daUserAccess.insertUserAccess(userAccess);
	}
	
	public boolean updateUserAccess(sf.file.UserAccess userAccess) throws DAException
	{
		return daUserAccess.updateUserAccess(userAccess);
	}
	
	public boolean deleteUserAccess(String kuserAccess) throws DAException
	{
		return daUserAccess.deleteUserAccess(kuserAccess);
	}
	
	public boolean deleteUserAccess(sf.file.UserAccess useraccess) throws DAException
	{
		return daUserAccess.deleteUserAccess(useraccess);
	}
}

