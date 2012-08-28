package sf.sales;

import sf.general.General;

public class SDPayment extends General{
	private String kcabang;
	private String nobukti;
	private String kinvoice;
	private String tglbukti;
	private String kclient;
	private String ksales;
	private String kvaluta;
	private double nvaluta=0;
	private double disc1=0;
	private double ppn=0;
	private String ket1;	
	private String ket2;
	private String ket3;
	private String ket4;
	private String ket5;
	
	
	private SDPayment[] sdpayments;
	
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
	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}
	public String getKvaluta() {
		return kvaluta;
	}
	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}
	public double getNvaluta() {
		return nvaluta;
	}
	public void setDisc1(double disc1) {
		this.disc1 = disc1;
	}
	public double getDisc1() {
		return disc1;
	}
	public void setPpn(double ppn) {
		this.ppn = ppn;
	}
	public double getPpn() {
		return ppn;
	}
	public void setKet1(String ket1) {
		this.ket1 = ket1;
	}
	public String getKet1() {
		return ket1;
	}
	public void setKet2(String ket2) {
		this.ket2 = ket2;
	}
	public String getKet2() {
		return ket2;
	}
	public void setKet3(String ket3) {
		this.ket3 = ket3;
	}
	public String getKet3() {
		return ket3;
	}
	public void setKet4(String ket4) {
		this.ket4 = ket4;
	}
	public String getKet4() {
		return ket4;
	}
	public void setKet5(String ket5) {
		this.ket5 = ket5;
	}
	public String getKet5() {
		return ket5;
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
		if(this.getKet1()==null || "".equals(this.getKet1()))
		{
			_err="Error,Invalid Keterangan 1 Could not empty.";
			return true;
		}
		return false;
	}
	public void setSdpayments(SDPayment[] sdpayments) {
		this.sdpayments = sdpayments;
	}
	public SDPayment[] getSdpayments() {
		return sdpayments;
	}
}
