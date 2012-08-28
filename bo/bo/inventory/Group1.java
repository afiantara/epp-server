package bo.inventory;

import da.error.DAException;

public class Group1 {
	private da.inventory.Group1 daGroup;
	public Group1() throws DAException
	{
		daGroup=new da.inventory.Group1();
	}
	
	public sf.inventory.Group1 getGroup() throws DAException
	{
		sf.inventory.Group1 group=new sf.inventory.Group1();
		group.setGroups(daGroup.getGroup1());
		return group;
	}
	
	public sf.inventory.Group1 getGroup(String kgroup) throws DAException
	{
		sf.inventory.Group1 group=new sf.inventory.Group1();
		group.setGroups(daGroup.getGroup1(kgroup));
		return group;
	}
	
	public boolean insertGroup(sf.inventory.Group1 group) throws DAException
	{
		return daGroup.insertGroup1(group);
	}
	
	public boolean updateGroup(sf.inventory.Group1 group) throws DAException
	{
		return daGroup.updateGroup1(group);
	}
	
	public boolean deleteGroup(String kgroup) throws DAException
	{
		return daGroup.deleteGroup1(kgroup);
	}
}
