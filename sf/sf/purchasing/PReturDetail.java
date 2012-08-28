package sf.purchasing;

import sf.general.General;

public class PReturDetail extends General  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kcabang;
	private String  nobukti;
	private String  kbarang;
	private int nourut;
	private double  jumlah;
	private double  nvaluta;
	private double disc2;
	private String  kgroup;
	private String  kgroup1;
	private String  kgroup2;
	
	private PReturDetail[] details;
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
	public void setDisc2(Double disc2) {
		this.disc2 = disc2;
	}
	public Double getDisc2() {
		return disc2;
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
	public void setNourut(int nourut) {
		this.nourut = nourut;
	}
	public int getNourut() {
		return nourut;
	}
	public void setDetails(PReturDetail[] details) {
		this.details = details;
	}
	public PReturDetail[] getDetails() {
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
		
		if(this.getKcabang()==null || "".equals(this.getKcabang()))
		{
			_err="Error,Kode Cabang Could not empty.";
			return true;
		}
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
		return false;
	}
}
