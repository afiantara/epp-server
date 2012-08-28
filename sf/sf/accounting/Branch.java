package sf.accounting;

import sf.general.General;


public class Branch extends General {
	private String kcabang;
	private String alamat1;
	private String alamat2;
	private String alamat3;
	private String kota;
	private String kodepos;
	private String notelp;
	private String nofax;
	private String kacab;
	private String kgudang;
	private Branch[] branches;
	
	public void setKcabang(String kcabang) {
		this.kcabang = kcabang;
	}
	public String getKcabang() {
		return kcabang;
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
	public void setKacab(String kacab) {
		this.kacab = kacab;
	}
	public String getKacab() {
		return kacab;
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
			_err="Error,Invalid Kode Cabang.Could not empty.";
			return true;
		}
		if(this.getAlamat1()==null || "".equals(this.getAlamat1()))
		{
			_err="Error,Invalid Alamat1.Could not empty.";
			return true;
		}
		
		if(this.getKota()==null || "".equals(this.getKota()))
		{
			_err="Error,Invalid Kota.Could not empty.";
			return true;
		}
		if(this.getKacab()==null || "".equals(this.getKacab()))
		{
			_err="Error,Invalid Kepala Cabang.Could not empty.";
			return true;
		}
		
		if (this.getKgudang()==null || "".equals(this.getKgudang()))
		{
			_err="Error,Invalid Kode Gudang.Could not empty.";
			return true;
		}
		return false;
	}
	
	public void setBranches(Branch[] branches) {
		this.branches = branches;
	}
	public Branch[] getBranches() {
		return branches;
	}
	public void setKgudang(String kgudang) {
		this.kgudang = kgudang;
	}
	public String getKgudang() {
		return kgudang;
	}
	
	
}
