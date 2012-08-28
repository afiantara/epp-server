package sf.sales;

public class QuotationHeader {
	private String kcabang;
	private String nobukti;
	private String kinvoice;
	private String kgudang;
	private String tglbukti;	
	private String kclient;	
	private String ksales;	
	private String kservice="N";
	private String kvaluta;	
	private double kkurs=0;
	private double discval=0;
	private double disc1=0;
	private double discpl=0;
	private String noscard;
	private String noref;			
	private String notracking;			
	private String kontak1;			
	private String kontak2;			
	private String kontak3;			
	private String validity;			
	private String syarat;			
	private String kirim;			
	private String ket1;			
	private String ket2;			
	private String ket3;
	
	private QuotationHeader[] quotationHeaders;
	
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
	/**
	 * @param noref the noref to set
	 */
	public void setNoref(String noref) {
		this.noref = noref;
	}
	/**
	 * @return the noref
	 */
	public String getNoref() {
		return noref;
	}
	/**
	 * @param notracking the notracking to set
	 */
	public void setNotracking(String notracking) {
		this.notracking = notracking;
	}
	/**
	 * @return the notracking
	 */
	public String getNotracking() {
		return notracking;
	}
	/**
	 * @param kontak1 the kontak1 to set
	 */
	public void setKontak1(String kontak1) {
		this.kontak1 = kontak1;
	}
	/**
	 * @return the kontak1
	 */
	public String getKontak1() {
		return kontak1;
	}
	/**
	 * @param kontak2 the kontak2 to set
	 */
	public void setKontak2(String kontak2) {
		this.kontak2 = kontak2;
	}
	/**
	 * @return the kontak2
	 */
	public String getKontak2() {
		return kontak2;
	}
	/**
	 * @param kontak3 the kontak3 to set
	 */
	public void setKontak3(String kontak3) {
		this.kontak3 = kontak3;
	}
	/**
	 * @return the kontak3
	 */
	public String getKontak3() {
		return kontak3;
	}
	/**
	 * @param validity the validity to set
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}
	/**
	 * @return the validity
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * @param syarat the syarat to set
	 */
	public void setSyarat(String syarat) {
		this.syarat = syarat;
	}
	/**
	 * @return the syarat
	 */
	public String getSyarat() {
		return syarat;
	}
	/**
	 * @param kirim the kirim to set
	 */
	public void setKirim(String kirim) {
		this.kirim = kirim;
	}
	/**
	 * @return the kirim
	 */
	public String getKirim() {
		return kirim;
	}
	/**
	 * @param ket1 the ket1 to set
	 */
	public void setKet1(String ket1) {
		this.ket1 = ket1;
	}
	/**
	 * @return the ket1
	 */
	public String getKet1() {
		return ket1;
	}
	/**
	 * @param ket2 the ket2 to set
	 */
	public void setKet2(String ket2) {
		this.ket2 = ket2;
	}
	/**
	 * @return the ket2
	 */
	public String getKet2() {
		return ket2;
	}
	/**
	 * @param ket3 the ket3 to set
	 */
	public void setKet3(String ket3) {
		this.ket3 = ket3;
	}
	/**
	 * @return the ket3
	 */
	public String getKet3() {
		return ket3;
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
	/**
	 * @param quotationHeaders the quotationHeaders to set
	 */
	public void setQuotationHeaders(QuotationHeader[] quotationHeaders) {
		this.quotationHeaders = quotationHeaders;
	}
	/**
	 * @return the quotationHeaders
	 */
	public QuotationHeader[] getQuotationHeaders() {
		return quotationHeaders;
	}
	public void setKgudang(String kgudang) {
		this.kgudang = kgudang;
	}
	public String getKgudang() {
		return kgudang;
	}
	public void setKkurs(double kkurs) {
		this.kkurs = kkurs;
	}
	public double getKkurs() {
		return kkurs;
	}
}
