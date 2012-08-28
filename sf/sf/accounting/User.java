package sf.accounting;

import sf.general.General;

public class User extends General {
	
	private String kstaff	;
	private String nstaff;
	private String alamat1;
	private String alamat2	     ;
	private String alamat3	     ;
	private String kota	     ;
	private String kodepos	     ;
	private String notelp	     ;
	private String nofax	     ;
	private String nohp         ;
	private String kotalahir    ;
	private String tgllahir     ;
	private String tglmasuk     ;
	private String tglkeluar    ;
	private String kjabatan     ;
	private String djabatan     ;
	private String kcabang	     ;
	private String kpassword    ;
	private String keterangan   ;
	private String khpp         ="N";
	private String kprint       ="N";
	private String kconvert     ="N";
	private String kApprove		="N";
	private User[] users;
	private long kAlias;
	private String kcompany;
	
	private String[] headers=new String[]{
		"kstaff",
		"nstaff",
		"alamat1",
		"alamat2",
		"alamat3",
		"kota",
		"kodepos",
		"notelp",
		"nofax",
		"nohp",
		"kotalahir",
		"tgllahir",
		"tglmasuk",
		"tglkeluar",
		"kjabatan",
		"djabatan",
		"kcabang",
		"kpassword",
		"keterangan",
		"khpp",
		"kprint",
		"kconvert",
		"kapprove",
		"kalias"
	};
	
	public String[] getHeader()
	{
		return headers;
	}
	
	public String[] getContent()
	{
		String[] contents=new String[]{
				this.getKstaff(),
				this.getNstaff(),
				this.getAlamat1(),
				this.getAlamat2(),
				this.getAlamat3(),
				this.getKota(),
				this.getKodepos(),
				this.getNotelp(),
				this.getNofax(),
				this.getNohp(),
				this.getKotalahir(),
				this.getTgllahir(),
				this.getTglmasuk(),
				this.getTglkeluar(),
				this.getKjabatan(),
				this.getDjabatan(),
				this.getKcabang(),
				this.getKpassword(),
				this.getKeterangan(),
				this.getKhpp(),
				this.getKprint(),
				this.getKconvert(),this.getkApprove(),String.valueOf(this.getkAlias())};
		return contents;
	}
	public void setKstaff(String kstaff) {
		this.kstaff = kstaff;
	}
	public String getKstaff() {
		return kstaff;
	}
	public void setNstaff(String nstaff) {
		this.nstaff = nstaff;
	}
	public String getNstaff() {
		return nstaff;
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
	public void setNohp(String nohp) {
		this.nohp = nohp;
	}
	public String getNohp() {
		return nohp;
	}
	public void setKotalahir(String kotalahir) {
		this.kotalahir = kotalahir;
	}
	public String getKotalahir() {
		return kotalahir;
	}
	public void setTgllahir(String tgllahir) {
		this.tgllahir = tgllahir;
	}
	public String getTgllahir() {
		return tgllahir;
	}
	public void setTglmasuk(String tglmasuk) {
		this.tglmasuk = tglmasuk;
	}
	public String getTglmasuk() {
		return tglmasuk;
	}
	public void setTglkeluar(String tglkeluar) {
		this.tglkeluar = tglkeluar;
	}
	public String getTglkeluar() {
		return tglkeluar;
	}
	public void setKjabatan(String kjabatan) {
		this.kjabatan = kjabatan;
	}
	public String getKjabatan() {
		return kjabatan;
	}
	public void setDjabatan(String djabatan) {
		this.djabatan = djabatan;
	}
	public String getDjabatan() {
		return djabatan;
	}
	public void setKcabang(String kcabang) {
		this.kcabang = kcabang;
	}
	public String getKcabang() {
		return kcabang;
	}
	public void setKpassword(String kpassword) {
		this.kpassword = kpassword;
	}
	public String getKpassword() {
		return kpassword;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKhpp(String khpp) {
		this.khpp = khpp;
	}
	public String getKhpp() {
		return khpp;
	}
	public void setKprint(String kprint) {
		this.kprint = kprint;
	}
	public String getKprint() {
		return kprint;
	}
	public void setKconvert(String kconvert) {
		this.kconvert = kconvert;
	}
	public String getKconvert() {
		return kconvert;
	}
	
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		if(this.getKstaff()==null || "".equals(this.getKstaff()))
		{
			_err="Error,Invalid Kode staff.Could not empty.";
			return true;
		}
		if(this.getNstaff()==null || "".equals(this.getNstaff()))
		{
			_err="Error,Invalid Nama staff.Could not empty.";
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
		
		if(this.getKjabatan()==null || "".equals(this.getKjabatan()))
		{
			_err="Error,Invalid Jabatan.Could not empty.";
			return true;
		}
		if(this.getKcabang()==null || "".equals(this.getKcabang()))
		{
			_err="Error,Invalid Kantor Cabang.Could not empty.";
			return true;
		}
		
		if(0==this.getkAlias()){
			_err="Error,Invalid Alias.Could not empty.";
			return true;
		}
		return false;
	}
	public void setUsers(User[] users) {
		this.users = users;
	}
	public User[] getUsers() {
		return users;
	}

	public void setkApprove(String kApprove) {
		this.kApprove = kApprove;
	}

	public String getkApprove() {
		return kApprove;
	}

	public void setkAlias(long kAlias) {
		this.kAlias = kAlias;
	}

	public long getkAlias() {
		return kAlias;
	}

	public void setKcompany(String kcompany) {
		this.kcompany = kcompany;
	}

	public String getKcompany() {
		return kcompany;
	}
}
