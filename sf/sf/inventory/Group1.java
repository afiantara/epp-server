package sf.inventory;

import sf.general.General;

public class Group1 extends General{
	private String kgroup;
	private String kgroup1;
	private String ngroup1;
	
	private Group1[] groups;
	
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		if(this.getKgroup()==null || "".equals(this.getKgroup()))
		{
			_err="Error,Invalid Kode Group. Could not empty.";
			return true;
		}
		
		if(this.getKgroup1()==null || "".equals(this.getKgroup1()))
		{
			_err="Error,Invalid Kode Group1. Could not empty.";
			return true;
		}
		if(this.getNgroup1()==null || "".equals(this.getNgroup1()))
		{
			_err="Error,Invalid Nama Group1. Could not empty.";
			return true;
		}
		return false;
	}
	
	public void setKgroup(String kgroup) {
		this.kgroup = kgroup;
	}
	public String getKgroup() {
		return kgroup;
	}
	public void setKgroup1(String kgroup1) {
		this.kgroup1 = kgroup1;
	}
	public String getKgroup1() {
		return kgroup1;
	}
	public void setNgroup1(String ngroup1) {
		this.ngroup1 = ngroup1;
	}
	public String getNgroup1() {
		return ngroup1;
	}

	public void setGroups(Group1[] groups) {
		this.groups = groups;
	}

	public Group1[] getGroups() {
		return groups;
	}
}
