package sf.purchasing;

import sf.general.General;

public class SptBShipping extends General{
	private String kcabang;
	private String nobukti;
	private String nospt;
	private String kclient;
	private double pbiaya;
	private String refno;
	
	private SptBShipping[] biayas;
	
	public void setKcabang(String kcabang) {
		this.kcabang = kcabang;
	}
	public String getKcabang() {
		return kcabang;
	}
	public void setNobukti(String nobukti) {
		this.nobukti = nobukti;
	}
	public String getNobukti() {
		return nobukti;
	}
	public void setNospt(String nospt) {
		this.nospt = nospt;
	}
	public String getNospt() {
		return nospt;
	}
	public void setPbiaya(double pbiaya) {
		this.pbiaya = pbiaya;
	}
	public double getPbiaya() {
		return pbiaya;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getRefno() {
		return refno;
	}
	
	private String _err="";
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		if(this.getKcabang()==null || "".equals(this.getKcabang()))
		{
			_err="Error,Kode Cabang Could not empty.";
			return true;
		}
		if(this.getNobukti()==null || "".equals(this.getNobukti()))
		{
			_err="Error,Invalid No Bukti Could not empty.";
			return true;
		}
		if(this.getNospt()==null || "".equals(this.getNospt()))
		{
			_err="Error,Invalid No SPT Could not empty.";
			return true;
		}
		if(this.getPbiaya()==0)
		{
			_err="Error,Invalid PBiaya Could not empty.";
			return true;
		}
		
		return false;
	}
	public void setBiayas(SptBShipping[] biayas) {
		this.biayas = biayas;
	}
	public SptBShipping[] getBiayas() {
		return biayas;
	}
	public void setKclient(String kclient) {
		this.kclient = kclient;
	}
	public String getKclient() {
		return kclient;
	}
}
