package bo.inventory;

import da.error.DAException;

public class Group2 {
	private da.inventory.Group2 daGroup;
	public Group2() throws DAException
	{
		daGroup=new da.inventory.Group2();
	}
	
	public sf.inventory.Group2 getGroup() throws DAException
	{
		sf.inventory.Group2 group=new sf.inventory.Group2();
		group.setGroups(daGroup.getGroup2());
		return group;
	}
	
	public sf.inventory.Group2 getGroup(String kgroup,String kgroup1) throws DAException
	{
		sf.inventory.Group2 group=new sf.inventory.Group2();
		group.setGroups(daGroup.getGroup2(kgroup,kgroup1));
		return group;
	}
	
	public boolean insertGroup(sf.inventory.Group2 group) throws DAException
	{
		return daGroup.insertGroup2(group);
	}
	
	public boolean updateGroup(sf.inventory.Group2 group) throws DAException
	{
		return daGroup.updateGroup2(group);
	}
	
	public boolean deleteGroup(String kgroup) throws DAException
	{
		return daGroup.deleteGroup2(kgroup);
	}
}
