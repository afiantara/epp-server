package sf.purchasing;

public class ShippingHeader {
    private String kcabang ;
    private String nobukti ;
    private String tglbukti ;
    private String kvendor ;
    private String kvaluta ;
    private String kenappn ;
    private double disc1  ;
    private double kgberat;
    private String kirimvia;
    private String kexpedisi;
    private String noref  ;
    
    private ShippingHeader[] headers;
    
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
	public void setTglbukti(String tglbukti) {
		this.tglbukti = tglbukti;
	}
	public String getTglbukti() {
		return tglbukti;
	}
	public void setKvendor(String kvendor) {
		this.kvendor = kvendor;
	}
	public String getKvendor() {
		return kvendor;
	}
	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}
	public String getKvaluta() {
		return kvaluta;
	}
	public void setKenappn(String kenappn) {
		this.kenappn = kenappn;
	}
	public String getKenappn() {
		return kenappn;
	}
	public void setDisc1(double disc1) {
		this.disc1 = disc1;
	}
	public double getDisc1() {
		return disc1;
	}
	public void setKgberat(double kgberat) {
		this.kgberat = kgberat;
	}
	public double getKgberat() {
		return kgberat;
	}
	public void setKirimvia(String kirimvia) {
		this.kirimvia = kirimvia;
	}
	public String getKirimvia() {
		return kirimvia;
	}
	public void setKexpedisi(String kexpedisi) {
		this.kexpedisi = kexpedisi;
	}
	public String getKexpedisi() {
		return kexpedisi;
	}
	public void setNoref(String noref) {
		this.noref = noref;
	}
	public String getNoref() {
		return noref;
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
		if(this.getKvendor()==null || "".equals(this.getKvendor()))
		{
			_err="Error,Invalid Kode Vendor Could not empty.";
			return true;
		}
		return false;
	}
	public void setHeaders(ShippingHeader[] headers) {
		this.headers = headers;
	}
	public ShippingHeader[] getHeaders() {
		return headers;
	}
}
