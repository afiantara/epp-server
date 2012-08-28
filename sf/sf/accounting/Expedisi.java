package sf.accounting;

import sf.general.General;

public class Expedisi extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kexpedisi; 
	private String nexpedisi;
	private String alamat1;
	private String alamat2;
	private String alamat3;
	private String kota;
	private String kodepos;
	private String kodevia="L"; //laut.
	private String kodeviadesc="Laut";
	private String email;
	private String notelp;
	private String nofax;
	private String kontak1;
	private String kontak2;
	private String nohp1;
	private String nohp2;
	
	private Expedisi[] expedisies;
	public Expedisi()
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
		if(this.getKexpedisi()==null || "".equals(this.getKexpedisi()))
		{
			_err="Error,Invalid Kode Expedisi. Could not empty.";
			return true;
		}
		
		if(this.getNexpedisi()==null || "".equals(this.getNexpedisi()))
		{
			_err="Error,Invalid Nama Expedisi. Could not empty.";
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
	
	public void setKexpedisi(String kexpedisi) {
		this.kexpedisi = kexpedisi;
	}

	public String getKexpedisi() {
		return kexpedisi;
	}

	public void setNexpedisi(String nexpedisi) {
		this.nexpedisi = nexpedisi;
	}

	public String getNexpedisi() {
		return nexpedisi;
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

	public void setKodevia(String kodevia) {
		this.kodevia = kodevia;
	}

	public String getKodevia() {
		return kodevia;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
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

	public void setExpedisies(Expedisi[] expedisies) {
		this.expedisies = expedisies;
	}

	public Expedisi[] getExpedisies() {
		return expedisies;
	}

	public void setKodeviadesc(String kodeviadesc) {
		this.kodeviadesc = kodeviadesc;
	}

	public String getKodeviadesc() {
		return kodeviadesc;
	}
}
