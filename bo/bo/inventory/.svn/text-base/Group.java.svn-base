package bo.inventory;

import da.error.DAException;

public class Group {
	private da.inventory.Group daGroup;
	public Group() throws DAException
	{
		daGroup=new da.inventory.Group();
	}
	
	public sf.inventory.Group getGroup() throws DAException
	{
		sf.inventory.Group group=new sf.inventory.Group();
		group.setGroups(daGroup.getGroup());
		return group;
	}
	
	public sf.inventory.Group getGroup(String kgroup) throws DAException
	{
		return daGroup.getGroup(kgroup);
	}
	
	public boolean insertGroup(sf.inventory.Group group) throws DAException
	{
		return daGroup.insertGroup(group);
	}
	
	public boolean updateGroup(sf.inventory.Group group) throws DAException
	{
		return daGroup.updateGroup(group);
	}
	
	public boolean deleteGroup(String kgroup) throws DAException
	{
		return daGroup.deleteGroup(kgroup);
	}
}
