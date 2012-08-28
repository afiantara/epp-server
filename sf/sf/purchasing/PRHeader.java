package sf.purchasing;

import sf.general.General;

public class PRHeader extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nobukti;	
	private String tglbukti;
	private String kcompany;
	private String keterangan;
	private String approvedby;
	private String approvedtgl;
	private String nopo;
	private String po;
	private PRHeader[] headers;
	
	public void setNobukti(String nobukti) {
		this.nobukti = nobukti;
	}
	public String getNobukti() {
		return nobukti;
	}
	public void setTglbukti(String tglbukti) {
		this.tglbukti = tglbukti;
	}
	public String getTglbukti() {
		return tglbukti;
	}
	
	public void setHeaders(PRHeader[] headers) {
		this.headers = headers;
	}
	public PRHeader[] getHeaders() {
		return headers;
	}
	
	private String _err="";
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
	
		if(this.getTglbukti()==null || "".equals(this.getTglbukti()))
		{
			_err="Error,Tanggal Bukti Could not empty.";
			return true;
		}
		if(this.getNobukti()==null || "".equals(this.getNobukti()))
		{
			_err="Error,Invalid No Bukti Could not empty.";
			return true;
		}
		
		if(this.getKcompany()==null || "".equals(this.getKcompany()))
		{
			_err="Error,Invalid Kcompany. Could not empty.";
			return true;
		}
		return false;
	}
	/**
	 * @param kcompany the kcompany to set
	 */
	public void setKcompany(String kcompany) {
		this.kcompany = kcompany;
	}
	/**
	 * @return the kcompany
	 */
	public String getKcompany() {
		return kcompany;
	}
	/**
	 * @param keterangan the keterangan to set
	 */
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	/**
	 * @return the keterangan
	 */
	public String getKeterangan() {
		return keterangan;
	}
	/**
	 * @param approvedby the approvedby to set
	 */
	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}
	/**
	 * @return the approvedby
	 */
	public String getApprovedby() {
		return approvedby;
	}
	/**
	 * @param approvedtgl the approvedtgl to set
	 */
	public void setApprovedtgl(String approvedtgl) {
		this.approvedtgl = approvedtgl;
	}
	/**
	 * @return the approvedtgl
	 */
	public String getApprovedtgl() {
		return approvedtgl;
	}
	/**
	 * @param nopo the nopo to set
	 */
	public void setNopo(String nopo) {
		this.nopo = nopo;
	}
	/**
	 * @return the nopo
	 */
	public String getNopo() {
		return nopo;
	}
	/**
	 * @param po the po to set
	 */
	public void setPo(String po) {
		this.po = po;
	}
	/**
	 * @return the po
	 */
	public String getPo() {
		return po;
	}

}
