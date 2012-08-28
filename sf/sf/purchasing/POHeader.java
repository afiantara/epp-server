package sf.purchasing;

import sf.general.General;

public class POHeader extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nobukti;
	private String tglBukti;
	private String kvendor;
	private String kcompany;
	private String kvaluta;
	private String adappn="T";
	private double jtempo=0;
	private double blain_nilai=0;
	private String blain_ket;
	private String keterangan;
	private String approvedby;
	private String approvedtgl;
	private String delivery;
	 private POHeader[] headers;
	
	public void setNobukti(String nobukti) {
		this.nobukti = nobukti;
	}
	public String getNobukti() {
		return nobukti;
	}
	public void setTglBukti(String tglBukti) {
		this.tglBukti = tglBukti;
	}
	public String getTglBukti() {
		return tglBukti;
	}
	public void setKvendor(String kvendor) {
		this.kvendor = kvendor;
	}
	public String getKvendor() {
		return kvendor;
	}
	
	private String _err="";
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		if(this.getNobukti()==null || "".equals(this.getNobukti()))
		{
			_err="Error,Invalid No Bukti Could not empty.";
			return true;
		}
		if(this.getTglBukti()==null || "".equals(this.getTglBukti()))
		{
			_err="Error,Tanggal Bukti Could not empty.";
			return true;
		}
		if(this.getKvendor()==null || "".equals(this.getKvendor()))
		{
			_err="Error,Invalid Kode Vendor Could not empty.";
			return true;
		}
		if(this.getKcompany()==null || "".equals(this.getKcompany()))
		{
			_err="Error,Invalid Kode Company Could not empty.";
			return true;
		}
		return false;
	}
	public void setHeaders(POHeader[] headers) {
		this.headers = headers;
	}
	public POHeader[] getHeaders() {
		return headers;
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
	 * @param jtempo the jtempo to set
	 */
	public void setJtempo(double jtempo) {
		this.jtempo = jtempo;
	}
	/**
	 * @return the jtempo
	 */
	public double getJtempo() {
		return jtempo;
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
	 * @param delivery the delivery to set
	 */
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	/**
	 * @return the delivery
	 */
	public String getDelivery() {
		return delivery;
	}
	/**
	 * @param kvaluta the kvaluta to set
	 */
	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}
	/**
	 * @return the kvaluta
	 */
	public String getKvaluta() {
		return kvaluta;
	}
	/**
	 * @param adappn the adappn to set
	 */
	public void setAdappn(String adappn) {
		this.adappn = adappn;
	}
	/**
	 * @return the adappn
	 */
	public String getAdappn() {
		return adappn;
	}
	/**
	 * @param blain_nilai the blain_nilai to set
	 */
	public void setBlain_nilai(double blain_nilai) {
		this.blain_nilai = blain_nilai;
	}
	/**
	 * @return the blain_nilai
	 */
	public double getBlain_nilai() {
		return blain_nilai;
	}
	/**
	 * @param blain_ket the blain_ket to set
	 */
	public void setBlain_ket(String blain_ket) {
		this.blain_ket = blain_ket;
	}
	/**
	 * @return the blain_ket
	 */
	public String getBlain_ket() {
		return blain_ket;
	}
}
