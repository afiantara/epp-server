package sf.purchasing;
import sf.general.General;

public class PIDetail extends General {
	private String kcabang;
	private String nobukti;
	private String kbarang;
	private int nourut;
	private Double jumlah;
	private Double nvaluta;
	private Double disc2;
	private String kgroup;
	private String kgroup1;
	private String kgroup2;
	private String noso;
	private String nopd;
	private String kstatus;	
	private String userid;
	
	private PIDetail[] details;
	
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
	public void setJumlah(Double jumlah) {
		this.jumlah = jumlah;
	}
	public Double getJumlah() {
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
	public void setNoso(String noso) {
		this.noso = noso;
	}
	public String getNoso() {
		return noso;
	}
	public void setNopd(String nopd) {
		this.nopd = nopd;
	}
	public String getNopd() {
		return nopd;
	}
	public void setKstatus(String kstatus) {
		this.kstatus = kstatus;
	}
	public String getKstatus() {
		return kstatus;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserid() {
		return userid;
	}
	public void setNourut(int nourut) {
		this.nourut = nourut;
	}
	public int getNourut() {
		return nourut;
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
	public void setDetails(PIDetail[] details) {
		this.details = details;
	}
	public PIDetail[] getDetails() {
		return details;
	}
	
}
