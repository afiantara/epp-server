package sf.purchasing;

public class PIHeader {
	private String kcabang;
	private String nobukti;
	private String tglbukti;
	private String tgljtempo;
	private String kvendor;
	private String kvaluta;		
	private String kenappn;		
	private Double disc1;		
	private String noref;
	private String kcabang1;
	private String apposting="N";
	
	private PIHeader[] headers;
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
	public void setTgljtempo(String tgljtempo) {
		this.tgljtempo = tgljtempo;
	}
	public String getTgljtempo() {
		return tgljtempo;
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
	public void setDisc1(Double disc1) {
		this.disc1 = disc1;
	}
	public Double getDisc1() {
		return disc1;
	}
	public void setNoref(String noref) {
		this.noref = noref;
	}
	public String getNoref() {
		return noref;
	}
	public void setKcabang1(String kcabang1) {
		this.kcabang1 = kcabang1;
	}
	public String getKcabang1() {
		return kcabang1;
	}
	public void setApposting(String apposting) {
		this.apposting = apposting;
	}
	public String getApposting() {
		return apposting;
	}
	public void setHeaders(PIHeader[] headers) {
		this.headers = headers;
	}
	public PIHeader[] getHeaders() {
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

}
