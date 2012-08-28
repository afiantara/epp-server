package sf.sales;

public class InvoiceGroup {
	private String kcabang;
	private String nobukti;
	private String grouping;
	private String ket1;
	private String ket2;
	private String ket3;
	private String ket4;
	private String ket5;
	private String ket6;
	private String ket7;
	private String ket8;
	private String ket9;
	private String ket10;
	private String ket11;
	private String ket12;
	private String ket13;
	private String ket14;
	private String ket15;
	private String ket16;
	private String ket17;
	private String ket18;
	private String ket19;
	private String ket20;
	private String satuan;
	private double jumlah=0;
	
	private InvoiceGroup[] groups;
	
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
	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}
	public String getGrouping() {
		return grouping;
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
	public void setKet6(String ket6) {
		this.ket6 = ket6;
	}
	public String getKet6() {
		return ket6;
	}
	public void setKet7(String ket7) {
		this.ket7 = ket7;
	}
	public String getKet7() {
		return ket7;
	}
	public void setKet8(String ket8) {
		this.ket8 = ket8;
	}
	public String getKet8() {
		return ket8;
	}
	public void setKet9(String ket9) {
		this.ket9 = ket9;
	}
	public String getKet9() {
		return ket9;
	}
	public void setKet10(String ket10) {
		this.ket10 = ket10;
	}
	public String getKet10() {
		return ket10;
	}
	public void setKet11(String ket11) {
		this.ket11 = ket11;
	}
	public String getKet11() {
		return ket11;
	}
	public void setKet12(String ket12) {
		this.ket12 = ket12;
	}
	public String getKet12() {
		return ket12;
	}
	public void setKet13(String ket13) {
		this.ket13 = ket13;
	}
	public String getKet13() {
		return ket13;
	}
	public void setKet14(String ket14) {
		this.ket14 = ket14;
	}
	public String getKet14() {
		return ket14;
	}
	public void setKet15(String ket15) {
		this.ket15 = ket15;
	}
	public String getKet15() {
		return ket15;
	}
	public void setKet16(String ket16) {
		this.ket16 = ket16;
	}
	public String getKet16() {
		return ket16;
	}
	public void setKet17(String ket17) {
		this.ket17 = ket17;
	}
	public String getKet17() {
		return ket17;
	}
	public void setKet18(String ket18) {
		this.ket18 = ket18;
	}
	public String getKet18() {
		return ket18;
	}
	public void setKet19(String ket19) {
		this.ket19 = ket19;
	}
	public String getKet19() {
		return ket19;
	}
	public void setKet20(String ket20) {
		this.ket20 = ket20;
	}
	public String getKet20() {
		return ket20;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}
	public double getJumlah() {
		return jumlah;
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
		if(this.getGrouping()==null || "".equals(this.getGrouping()))
		{
			_err="Error,Invalid Grouping Could not empty.";
			return true;
		}
		return false;
	}
	public void setGroups(InvoiceGroup[] groups) {
		this.groups = groups;
	}
	public InvoiceGroup[] getGroups() {
		return groups;
	}
}
