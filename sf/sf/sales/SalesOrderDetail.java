package sf.sales;

import sf.general.General;

public class SalesOrderDetail extends General{
	private String kcabang;
	private String nobukti;
	private int nourut;
	private String grouping;	
	private String kbarang;
	private double jumlah;
	private double jumlah1=0;
	private double jumlah2;
	private double stockbal;
	private double nvaluta=0;
	private double discval=0;
	private double disc2=0;
	private double discpl=0;
	private double plist=0;
	private String pvaluta ;
	private String kgroup;	
	private String ket ;
	private String nosq ;
	private String nosj	;
	private String nopo  ;
	private double jumlahOld;
	private  SalesOrderDetail[] salesOrderDetails;
	
	public SalesOrderDetail()
	{
		this.setUserupdate("U");//default status.
	}

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

	public void setNourut(int nourut) {
		this.nourut = nourut;
	}

	public int getNourut() {
		return nourut;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}

	public String getGrouping() {
		return grouping;
	}

	public void setKbarang(String kbarang) {
		this.kbarang = kbarang;
	}

	public String getKbarang() {
		return kbarang;
	}

	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}

	public double getJumlah() {
		return jumlah;
	}

	public void setJumlah1(double jumlah1) {
		this.jumlah1 = jumlah1;
	}

	public double getJumlah1() {
		return jumlah1;
	}

	public void setJumlah2(double jumlah2) {
		this.jumlah2 = jumlah2;
	}

	public double getJumlah2() {
		return jumlah2;
	}

	public void setStockbal(double stockbal) {
		this.stockbal = stockbal;
	}

	public double getStockbal() {
		return stockbal;
	}

	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}

	public double getNvaluta() {
		return nvaluta;
	}

	public void setDiscval(double discval) {
		this.discval = discval;
	}

	public double getDiscval() {
		return discval;
	}

	public void setDisc2(double disc2) {
		this.disc2 = disc2;
	}

	public double getDisc2() {
		return disc2;
	}

	public void setDiscpl(double discpl) {
		this.discpl = discpl;
	}

	public double getDiscpl() {
		return discpl;
	}

	public void setPlist(double plist) {
		this.plist = plist;
	}

	public double getPlist() {
		return plist;
	}

	public void setPvaluta(String pvaluta) {
		this.pvaluta = pvaluta;
	}

	public String getPvaluta() {
		return pvaluta;
	}

	public void setKgroup(String kgroup) {
		this.kgroup = kgroup;
	}

	public String getKgroup() {
		return kgroup;
	}

	public void setKet(String ket) {
		this.ket = ket;
	}

	public String getKet() {
		return ket;
	}

	public void setNosq(String nosq) {
		this.nosq = nosq;
	}

	public String getNosq() {
		return nosq;
	}

	public void setNosj(String nosj) {
		this.nosj = nosj;
	}

	public String getNosj() {
		return nosj;
	}

	public void setNopo(String nopo) {
		this.nopo = nopo;
	}

	public String getNopo() {
		return nopo;
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
		return false;
	}

	/**
	 * @param salesOrderDetails the salesOrderDetails to set
	 */
	public void setSalesOrderDetails(SalesOrderDetail[] salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	/**
	 * @return the salesOrderDetails
	 */
	public SalesOrderDetail[] getSalesOrderDetails() {
		return salesOrderDetails;
	}

	public void setJumlahOld(double jumlahOld) {
		this.jumlahOld = jumlahOld;
	}

	public double getJumlahOld() {
		return jumlahOld;
	}
}
