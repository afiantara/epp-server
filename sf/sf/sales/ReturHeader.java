package sf.sales;

public class ReturHeader {
	private String kcabang;
	private String nobukti;
	private String kinvoice;
	private String kgudang;
	private String tglbukti;	
	private String kclient;	
	private String ksales;	
	private String kservice="N";
	private String kvaluta;
	private double discval=0;
	private double disc1=0;
	private double discpl=0;
	private String noscard;
	private String exnoinvoice;
	private String ket;
	
	private ReturHeader[] returHeaders;
	
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
	public void setKinvoice(String kinvoice) {
		this.kinvoice = kinvoice;
	}
	public String getKinvoice() {
		return kinvoice;
	}
	public void setKgudang(String kgudang) {
		this.kgudang = kgudang;
	}
	public String getKgudang() {
		return kgudang;
	}
	public void setTglbukti(String tglbukti) {
		this.tglbukti = tglbukti;
	}
	public String getTglbukti() {
		return tglbukti;
	}
	public void setKclient(String kclient) {
		this.kclient = kclient;
	}
	public String getKclient() {
		return kclient;
	}
	public void setKsales(String ksales) {
		this.ksales = ksales;
	}
	public String getKsales() {
		return ksales;
	}
	public void setKservice(String kservice) {
		this.kservice = kservice;
	}
	public String getKservice() {
		return kservice;
	}
	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}
	public String getKvaluta() {
		return kvaluta;
	}
	public void setDiscval(double discval) {
		this.discval = discval;
	}
	public double getDiscval() {
		return discval;
	}
	public void setDisc1(double disc1) {
		this.disc1 = disc1;
	}
	public double getDisc1() {
		return disc1;
	}
	public void setDiscpl(double discpl) {
		this.discpl = discpl;
	}
	public double getDiscpl() {
		return discpl;
	}
	public void setNoscard(String noscard) {
		this.noscard = noscard;
	}
	public String getNoscard() {
		return noscard;
	}
	public void setExnoinvoice(String exnoinvoice) {
		this.exnoinvoice = exnoinvoice;
	}
	public String getExnoinvoice() {
		return exnoinvoice;
	}
	public void setKet(String ket) {
		this.ket = ket;
	}
	public String getKet() {
		return ket;
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
		if(this.getKinvoice()==null || "".equals(this.getKinvoice()))
		{
			_err="Error,Invalid Kode Invoice Could not empty.";
			return true;
		}
		if(this.getKclient()==null || "".equals(this.getKclient()))
		{
			_err="Error,Invalid Kode Client Could not empty.";
			return true;
		}
		if(this.getKsales()==null || "".equals(this.getKsales()))
		{
			_err="Error,Invalid Kode Sales Could not empty.";
			return true;
		}
		if(this.getKvaluta()==null || "".equals(this.getKvaluta()))
		{
			_err="Error,Invalid Kode Valuta Could not empty.";
			return true;
		}
		return false;
	}
	public void setReturHeaders(ReturHeader[] returHeaders) {
		this.returHeaders = returHeaders;
	}
	public ReturHeader[] getReturHeaders() {
		return returHeaders;
	}
}
