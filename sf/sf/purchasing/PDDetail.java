package sf.purchasing;
import sf.general.General;

public class PDDetail extends General {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kcabang;
	private String nobukti;
	private String kbarang;
	private int nourut;
	private double jumlah;
	private double jumlah1;
	private double jumlah2;
	private double nvaluta;
	private double disc2;
	private String kgroup;
	private String kgroup1;
	private String kgroup2;
	private String noso;
	private String nops;
	private String nopi;
	private String keterangan;
	
	private PDDetail[] details;
	
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
	public void setJumlah1(double jumlah1) {
		this.jumlah1 = jumlah1;
	}
	public double getJumlah1() {
		return jumlah1;
	}
	public void setJumlah2(double jumlah2) {
		this.jumlah2 = jumlah2;
	}
	public double getJumlah2() {
		return jumlah2;
	}
	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}
	public double getNvaluta() {
		return nvaluta;
	}
	public void setDisc2(double disc2) {
		this.disc2 = disc2;
	}
	public double getDisc2() {
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
	public void setNops(String nops) {
		this.nops = nops;
	}
	public String getNops() {
		return nops;
	}
	public void setNopi(String nopi) {
		this.nopi = nopi;
	}
	public String getNopi() {
		return nopi;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	
	public void setNourut(int nourut) {
		this.nourut = nourut;
	}
	public int getNourut() {
		return nourut;
	}
	public void setDetails(PDDetail[] details) {
		this.details = details;
	}
	public PDDetail[] getDetails() {
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
