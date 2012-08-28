package sf.sales;

import sf.general.General;

public class SOrderBiaya extends General {
	private String kcabang;
	private String nobukti;
	private String accno;	
	private String accDesc;
	private String kvaluta;
	private double nvaluta=0;
	private double nrealisasi=0;
	private double trealisasi=0;
	private SOrderBiaya[] biayas;
	
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
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getAccno() {
		return accno;
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
	public void setNrealisasi(double nrealisasi) {
		this.nrealisasi = nrealisasi;
	}
	public double getNrealisasi() {
		return nrealisasi;
	}
	public void setTrealisasi(double trealisasi) {
		this.trealisasi = trealisasi;
	}
	public double getTrealisasi() {
		return trealisasi;
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
		if(this.getAccno()==null || "".equals(this.getAccno()))
		{
			_err="Error,Invalid Account No Could not empty.";
			return true;
		}
		if(this.getKvaluta()==null || "".equals(this.getKvaluta()))
		{
			_err="Error,Invalid Kode Valuta Could not empty.";
			return true;
		}
		return false;
	}
	public void setBiayas(SOrderBiaya[] biayas) {
		this.biayas = biayas;
	}
	public SOrderBiaya[] getBiayas() {
		return biayas;
	}
	public void setAccDesc(String accDesc) {
		this.accDesc = accDesc;
	}
	public String getAccDesc() {
		return accDesc;
	}

}
