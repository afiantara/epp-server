package sf.purchasing;

import sf.general.General;

public class PRDetail extends General  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  nobukti;
	private String tglbukti;
	private String  kbarang;
	private String nbarang;
	private String satuan;
	private String  kgroup;
	private int nourut;
	private double  jumlah;
	private double  jumlah1=0;
	private double  jumlah2=0;
	private String kvaluta;
	private double  nvaluta=0;
	private double pdisc=0;
	private String nopo;
	private String nobukti1;
	private String ket;
	private String kcompany;
	
	private PRDetail[] details;
	public void setNobukti(String nobukti) {
		this.nobukti = nobukti;
	}
	public String getNobukti() {
		return nobukti;
	}
	public void setKbarang(String kbarang) {
		this.kbarang = kbarang;
	}
	public String getKbarang() {
		return kbarang;
	}
	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}
	public double getJumlah() {
		return jumlah;
	}
	public void setNvaluta(Double nvaluta) {
		this.nvaluta = nvaluta;
	}
	public Double getNvaluta() {
		return nvaluta;
	}
	
	public void setKgroup(String kgroup) {
		this.kgroup = kgroup;
	}
	public String getKgroup() {
		return kgroup;
	}
	
	public void setNourut(int nourut) {
		this.nourut = nourut;
	}
	public int getNourut() {
		return nourut;
	}
	public void setDetails(PRDetail[] details) {
		this.details = details;
	}
	public PRDetail[] getDetails() {
		return details;
	}
	
	private String _err="";
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		
		if(this.getKbarang()==null || "".equals(this.getKbarang()))
		{
			_err="Error,Kode Barang Could not empty.";
			return true;
		}
		if(this.getNobukti()==null || "".equals(this.getNobukti()))
		{
			_err="Error,Invalid No Bukti Could not empty.";
			return true;
		}
		if(this.getTglbukti()==null || "".equals(this.getTglbukti()))
		{
			_err="Error,Invalid Tgl Bukti Could not empty.";
			return true;
		}
		if(this.getSatuan()==null || "".equals(this.getSatuan()))
		{
			_err="Error,Invalid Satuan Could not empty.";
			return true;
		}
		if(this.getKgroup()==null || "".equals(this.getKgroup()))
		{
			_err="Error,Invalid Kgroup Could not empty.";
			return true;
		}
		if(this.getJumlah()==0)
		{
			_err="Error,Invalid Jumlah Could not 0.";
			return true;
		}
		if(this.getKcompany()==null || "".equals(this.getKcompany()))
		{
			_err="Error,Invalid Kcompany Could not empty.";
			return true;
		}
		return false;
	}
	/**
	 * @param tglbukti the tglbukti to set
	 */
	public void setTglbukti(String tglbukti) {
		this.tglbukti = tglbukti;
	}
	/**
	 * @return the tglbukti
	 */
	public String getTglbukti() {
		return tglbukti;
	}
	/**
	 * @param satuan the satuan to set
	 */
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	/**
	 * @return the satuan
	 */
	public String getSatuan() {
		return satuan;
	}
	/**
	 * @param jumlah1 the jumlah1 to set
	 */
	public void setJumlah1(double jumlah1) {
		this.jumlah1 = jumlah1;
	}
	/**
	 * @return the jumlah1
	 */
	public double getJumlah1() {
		return jumlah1;
	}
	/**
	 * @param jumlah2 the jumlah2 to set
	 */
	public void setJumlah2(double jumlah2) {
		this.jumlah2 = jumlah2;
	}
	/**
	 * @return the jumlah2
	 */
	public double getJumlah2() {
		return jumlah2;
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
	 * @param pdisc the pdisc to set
	 */
	public void setPdisc(double pdisc) {
		this.pdisc = pdisc;
	}
	/**
	 * @return the pdisc
	 */
	public double getPdisc() {
		return pdisc;
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
	 * @param nobukti1 the nobukti1 to set
	 */
	public void setNobukti1(String nobukti1) {
		this.nobukti1 = nobukti1;
	}
	/**
	 * @return the nobukti1
	 */
	public String getNobukti1() {
		return nobukti1;
	}
	/**
	 * @param ket the ket to set
	 */
	public void setKet(String ket) {
		this.ket = ket;
	}
	/**
	 * @return the ket
	 */
	public String getKet() {
		return ket;
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
	 * @param nbarang the nbarang to set
	 */
	public void setNbarang(String nbarang) {
		this.nbarang = nbarang;
	}
	/**
	 * @return the nbarang
	 */
	public String getNbarang() {
		return nbarang;
	}
}
