package sf.inventory;

import sf.general.General;

public class Gudang extends General {
	private String kgudang;
	private String alamat1;
	private String alamat2;
	private String alamat3;
	private String kota;
	private String kodepos;
	private String notelp;
	private String nofax;
	private String kepgudang;
	private Gudang[] gudangs;
	public Gudang()
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
		if(this.getKgudang()==null || "".equals(this.getKgudang()))
		{
			_err="Error,Invalid Kode Gudang. Could not empty.";
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
	
	
	public void setKgudang(String kgudang) {
		this.kgudang = kgudang;
	}

	public String getKgudang() {
		return kgudang;
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

	public void setKepgudang(String kepgudang) {
		this.kepgudang = kepgudang;
	}

	public String getKepgudang() {
		return kepgudang;
	}

	public void setGudangs(Gudang[] gudangs) {
		this.gudangs = gudangs;
	}

	public Gudang[] getGudangs() {
		return gudangs;
	}
}
