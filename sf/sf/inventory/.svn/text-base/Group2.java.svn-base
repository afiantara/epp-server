package sf.inventory;

import sf.general.General;

public class Group2 extends General{
	private String kgroup;
	private String kgroup1;
	private String kgroup2;
	private String ngroup2;
	private Group2[] groups;
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
		if(this.getKgroup2()==null || "".equals(this.getKgroup2()))
		{
			_err="Error,Invalid Kode Group2. Could not empty.";
			return true;
		}
		if(this.getNgroup2()==null || "".equals(this.getNgroup2()))
		{
			_err="Error,Invalid Nama Group2. Could not empty.";
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
	public void setKgroup2(String kgroup2) {
		this.kgroup2 = kgroup2;
	}
	public String getKgroup2() {
		return kgroup2;
	}
	public void setNgroup2(String ngroup2) {
		this.ngroup2 = ngroup2;
	}
	public String getNgroup2() {
		return ngroup2;
	}

	public void setGroups(Group2[] groups) {
		this.groups = groups;
	}

	public Group2[] getGroups() {
		return groups;
	}
}
