package sf.purchasing;

import sf.general.General;

public class BiayaShipping extends General{
	private String kcabang;	
	private String nobukti; 	
	private String accno;	
	private String accdesc;
	private String acclevel;	
	private double accbudget;	
	private double accrealisasi;	
	private String refno;	
	private String nopo;
	
	private BiayaShipping [] biayas;
	
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
	public void setAcclevel(String acclevel) {
		this.acclevel = acclevel;
	}
	public String getAcclevel() {
		return acclevel;
	}
	public void setAccbudget(double accbudget) {
		this.accbudget = accbudget;
	}
	public double getAccbudget() {
		return accbudget;
	}
	public void setAccrealisasi(double accrealisasi) {
		this.accrealisasi = accrealisasi;
	}
	public double getAccrealisasi() {
		return accrealisasi;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getRefno() {
		return refno;
	}
	public void setNopo(String nopo) {
		this.nopo = nopo;
	}
	public String getNopo() {
		return nopo;
	}
	public void setBiayas(BiayaShipping [] biayas) {
		this.biayas = biayas;
	}
	public BiayaShipping [] getBiayas() {
		return biayas;
	}
	public void setAccdesc(String accdesc) {
		this.accdesc = accdesc;
	}
	public String getAccdesc() {
		return accdesc;
	}	
}
