package sf.inventory;

import sf.general.General;

public class Group extends General{
	private String kgroup;
	private String ngroup;
	private double maxdisc;
	private double minstock;
	private double maxstock;
	
	private Group[] groups;
	
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
		
		if(this.getNgroup()==null || "".equals(this.getNgroup()))
		{
			_err="Error,Invalid Nama Group. Could not empty.";
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
	public void setNgroup(String ngroup) {
		this.ngroup = ngroup;
	}
	public String getNgroup() {
		return ngroup;
	}
	public void setMaxdisc(double maxdisc) {
		this.maxdisc = maxdisc;
	}
	public double getMaxdisc() {
		return maxdisc;
	}
	public void setMinstock(double minstock) {
		this.minstock = minstock;
	}
	public double getMinstock() {
		return minstock;
	}
	public void setMaxstock(double maxstock) {
		this.maxstock = maxstock;
	}
	public double getMaxstock() {
		return maxstock;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public Group[] getGroups() {
		return groups;
	}
}
