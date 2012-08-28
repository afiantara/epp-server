package sf.inventory;

import sf.general.General;

public class Produk extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kbarang;
	private String nbarang;
	private String satuan;
	private String satuan1;
	private String satuan2;
	private String pstatus="C";
	private String pstatusdesc="Aktif";
	private String stockbal="Y";
	private String stockbaldesc="Ada";
	private String krak ;
	private String kbarang1;
	private String kbarangp;
	private double qty1=0;
	private double qty2=0;
	private String desc1;
	private String desc2;
	private String desc3;
	private String desc4;
	private String desc5;
	private String desc6;
	private String desc7;
	private String desc8;
	private String desc9;
	private String desc10;
	private String kgroup;
	private String kgroup1;
	private String kgroup2;
	private double minstock;
	private double maxstock;
	private double hppnval=0;
	private double hppnval1=0;
	private String hppkval ;
	private String hppkval1;
	private double maxDisc=0.0D;
	private String ptype="MP";
	private String companyType;
	private double nvaluta=0;
	private String kvaluta;
	private Produk[] produks;
	
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		if(this.getKbarang()==null || "".equals(this.getKbarang()))
		{
			_err="Error,Invalid Kode Barang. Could not empty.";
			return true;
		}
		
		if(this.getNbarang()==null || "".equals(this.getNbarang()))
		{
			_err="Error,Invalid Nama Barang. Could not empty.";
			return true;
		}
		return false;
	}
	
	public void setKbarang(String kbarang) {
		this.kbarang = kbarang;
	}
	public String getKbarang() {
		return kbarang;
	}
	public void setNbarang(String nbarang) {
		this.nbarang = nbarang;
	}
	public String getNbarang() {
		return nbarang;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setStockbal(String stockbal) {
		this.stockbal = stockbal;
	}
	public String getStockbal() {
		return stockbal;
	}
	public void setKrak(String krak) {
		this.krak = krak;
	}
	public String getKrak() {
		return krak;
	}
	public void setKbarang1(String kbarang1) {
		this.kbarang1 = kbarang1;
	}
	public String getKbarang1() {
		return kbarang1;
	}
	public void setKbarangp(String kbarangp) {
		this.kbarangp = kbarangp;
	}
	public String getKbarangp() {
		return kbarangp;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}
	public String getDesc2() {
		return desc2;
	}
	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}
	public String getDesc3() {
		return desc3;
	}
	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}
	public String getDesc4() {
		return desc4;
	}
	public void setDesc5(String desc5) {
		this.desc5 = desc5;
	}
	public String getDesc5() {
		return desc5;
	}
	public void setDesc6(String desc6) {
		this.desc6 = desc6;
	}
	public String getDesc6() {
		return desc6;
	}
	public void setDesc7(String desc7) {
		this.desc7 = desc7;
	}
	public String getDesc7() {
		return desc7;
	}
	public void setDesc8(String desc8) {
		this.desc8 = desc8;
	}
	public String getDesc8() {
		return desc8;
	}
	public void setDesc9(String desc9) {
		this.desc9 = desc9;
	}
	public String getDesc9() {
		return desc9;
	}
	public void setDesc10(String desc10) {
		this.desc10 = desc10;
	}
	public String getDesc10() {
		return desc10;
	}
	public void setKgroup(String kgroup) {
		this.kgroup = kgroup;
	}
	public String getKgroup() {
		return kgroup;
	}
	public void setKgroup1(String kgroup1) {
		this.kgroup1 = kgroup1;
	}
	public String getKgroup1() {
		return kgroup1;
	}
	public void setKgroup2(String kgroup2) {
		this.kgroup2 = kgroup2;
	}
	public String getKgroup2() {
		return kgroup2;
	}
	public void setMinstock(double minstock) {
		this.minstock = minstock;
	}
	public double getMinstock() {
		return minstock;
	}
	public void setMaxstock(double maxstock) {
		this.maxstock = maxstock;
	}
	public double getMaxstock() {
		return maxstock;
	}
	public void setHppnval(double hppnval) {
		this.hppnval = hppnval;
	}
	public double getHppnval() {
		return hppnval;
	}
	public void setHppnval1(double hppnval1) {
		this.hppnval1 = hppnval1;
	}
	public double getHppnval1() {
		return hppnval1;
	}
	public void setHppkval(String hppkval) {
		this.hppkval = hppkval;
	}
	public String getHppkval() {
		return hppkval;
	}
	public void setHppkval1(String hppkval1) {
		this.hppkval1 = hppkval1;
	}
	public String getHppkval1() {
		return hppkval1;
	}

	public void setProduks(Produk[] produks) {
		this.produks = produks;
	}

	public Produk[] getProduks() {
		return produks;
	}

	public void setMaxDisc(double maxDisc) {
		this.maxDisc = maxDisc;
	}

	public double getMaxDisc() {
		return maxDisc;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPtype() {
		return ptype;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setSatuan1(String satuan1) {
		this.satuan1 = satuan1;
	}

	public String getSatuan1() {
		return satuan1;
	}

	public void setSatuan2(String satuan2) {
		this.satuan2 = satuan2;
	}

	public String getSatuan2() {
		return satuan2;
	}

	public void setPstatusdesc(String pstatusdesc) {
		this.pstatusdesc = pstatusdesc;
	}

	public String getPstatusdesc() {
		return pstatusdesc;
	}
	
	public void setQty1(double qty1) {
		this.qty1 = qty1;
	}

	public double getQty1() {
		return qty1;
	}

	public void setQty2(double qty2) {
		this.qty2 = qty2;
	}

	public double getQty2() {
		return qty2;
	}

	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}

	public double getNvaluta() {
		return nvaluta;
	}

	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}

	public String getKvaluta() {
		return kvaluta;
	}

	public void setStockbaldesc(String stockbaldesc) {
		this.stockbaldesc = stockbaldesc;
	}

	public String getStockbaldesc() {
		return stockbaldesc;
	}

}
