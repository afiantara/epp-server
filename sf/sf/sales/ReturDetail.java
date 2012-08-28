package sf.sales;

import sf.general.General;

public class ReturDetail extends General {
	private String kcabang;
	private String nobukti;
	private String kbarang;
	private int nourut;
	private double jumlah=1;
	private double nvaluta=0;
	private double discval=0;
	private double disc2=0;
	private double discpl=0;
	private double plist=0;
	private String pvaluta ;
	private String kgroup;
	private double jumlahOld=0;
	private ReturDetail[] returDetails; 
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
	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}
	public double getNvaluta() {
		return nvaluta;
	}
	public void setDiscval(double discval) {
		this.discval = discval;
	}
	public double getDiscval() {
		return discval;
	}
	public void setDisc2(double disc2) {
		this.disc2 = disc2;
	}
	public double getDisc2() {
		return disc2;
	}
	public void setDiscpl(double discpl) {
		this.discpl = discpl;
	}
	public double getDiscpl() {
		return discpl;
	}
	public void setPlist(double plist) {
		this.plist = plist;
	}
	public double getPlist() {
		return plist;
	}
	public void setPvaluta(String pvaluta) {
		this.pvaluta = pvaluta;
	}
	public String getPvaluta() {
		return pvaluta;
	}
	public void setKgroup(String kgroup) {
		this.kgroup = kgroup;
	}
	public String getKgroup() {
		return kgroup;
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
		return false;
	}
	public void setReturDetails(ReturDetail[] returDetails) {
		this.returDetails = returDetails;
	}
	public ReturDetail[] getReturDetails() {
		return returDetails;
	}
	public void setNourut(int nourut) {
		this.nourut = nourut;
	}
	public int getNourut() {
		return nourut;
	}
	public void setJumlahOld(double jumlahOld) {
		this.jumlahOld = jumlahOld;
	}
	public double getJumlahOld() {
		return jumlahOld;
	}
}
