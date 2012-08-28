package sf.purchasing;

import sf.general.General;

public class Supplier extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kvendor ;
	private String ktitel;
	private String nvendor ;
	private String alamat1;
	private String alamat2;
	private String alamat3 ;
	private String kota;
	private String kodepos;
	private String notelp;
	private String nofax;
	private String website;
	private String email; 
	private String kontak1;
	private String kontak2;
	private String nohp1;
	private String nohp2;
	private String email1;
	private String email2;
	private String kstatus="S";
	private String kcompany;
	private String kstatusdesc="Supplier";
	private int jtempo =0;
	
	private Supplier[] suppliers;
	public Supplier()
	{
		
	}
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		if(this.getKvendor()==null || "".equals(this.getKvendor()))
		{
			_err="Error,Invalid Kode Vendor. Could not empty.";
			return true;
		}
		
		if(this.getNvendor()==null || "".equals(this.getNvendor()))
		{
			_err="Error,Invalid Nama Vendor. Could not empty.";
			return true;
		}
		if(this.getAlamat1()==null || "".equals(this.getAlamat1()))
		{
			_err="Error,Invalid Alamat1. Could not empty.";
			return true;
		}
		if(this.getKota()==null || "".equals(this.getKota()))
		{
			_err="Error,Invalid Kota. Could not empty.";
			return true;
		}
		
		return false;
	}
	
	public void setKvendor(String kvendor) {
		this.kvendor = kvendor;
	}
	public String getKvendor() {
		return kvendor;
	}
	public void setNvendor(String nvendor) {
		this.nvendor = nvendor;
	}
	public String getNvendor() {
		return nvendor;
	}
	public void setAlamat1(String alamat1) {
		this.alamat1 = alamat1;
	}
	public String getAlamat1() {
		return alamat1;
	}
	public void setAlamat2(String alamat2) {
		this.alamat2 = alamat2;
	}
	public String getAlamat2() {
		return alamat2;
	}
	public void setAlamat3(String alamat3) {
		this.alamat3 = alamat3;
	}
	public String getAlamat3() {
		return alamat3;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getKota() {
		return kota;
	}
	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}
	public String getKodepos() {
		return kodepos;
	}
	public void setNotelp(String notelp) {
		this.notelp = notelp;
	}
	public String getNotelp() {
		return notelp;
	}
	public void setNofax(String nofax) {
		this.nofax = nofax;
	}
	public String getNofax() {
		return nofax;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getWebsite() {
		return website;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setKontak1(String kontak1) {
		this.kontak1 = kontak1;
	}
	public String getKontak1() {
		return kontak1;
	}
	public void setKontak2(String kontak2) {
		this.kontak2 = kontak2;
	}
	public String getKontak2() {
		return kontak2;
	}
	public void setNohp1(String nohp1) {
		this.nohp1 = nohp1;
	}
	public String getNohp1() {
		return nohp1;
	}
	public void setNohp2(String nohp2) {
		this.nohp2 = nohp2;
	}
	public String getNohp2() {
		return nohp2;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getEmail2() {
		return email2;
	}
	public void setKstatus(String kstatus) {
		this.kstatus = kstatus;
	}
	public String getKstatus() {
		return kstatus;
	}
	public void setJtempo(int jtempo) {
		this.jtempo = jtempo;
	}
	public int getJtempo() {
		return jtempo;
	}

	public void setSuppliers(Supplier[] suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier[] getSuppliers() {
		return suppliers;
	}

	public void setKstatusdesc(String kstatusdesc) {
		this.kstatusdesc = kstatusdesc;
	}

	public String getKstatusdesc() {
		return kstatusdesc;
	}

	public void setKtitel(String ktitel) {
		this.ktitel = ktitel;
	}

	public String getKtitel() {
		return ktitel;
	}

	public void setKcompany(String kcompany) {
		this.kcompany = kcompany;
	}

	public String getKcompany() {
		return kcompany;
	}
}
