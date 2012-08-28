package sf.crm;

import sf.general.General;


public class Industry extends General {
	private String kindustri;
	private String nindustri;
	private Industry[] industries;
	public Industry()
	{
		
	}
	
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		if(this.getKindustri()==null || "".equals(this.getKindustri()))
		{
			_err="Error,Invalid Kode Industri. Could not empty.";
			return true;
		}
		if(this.getNindustri()==null || "".equals(this.getNindustri()))
		{
			_err="Error,Invalid Nama Industri.Could not empty.";
			return true;
		}
		
		return false;
	}

	public void setKindustri(String kindustri) {
		this.kindustri = kindustri;
	}

	public String getKindustri() {
		return kindustri;
	}

	public void setNindustri(String nindustri) {
		this.nindustri = nindustri;
	}

	public String getNindustri() {
		return nindustri;
	}

	public void setIndustries(Industry[] industries) {
		this.industries = industries;
	}

	public Industry[] getIndustries() {
		return industries;
	}
}
