package sf.sales;

import sf.general.General;

public class StockAlokasi extends General{
	
	private String kgudang;
	private String kbarang;
	private double pinjam=0;  
	private double booking =0;  
	private double sorder=0;  
	private double alokasi=0;  
	private double porder=0;  
	private double pshipping=0;
	public void setKgudang(String kgudang) {
		this.kgudang = kgudang;
	}
	public String getKgudang() {
		return kgudang;
	}
	public void setKbarang(String kbarang) {
		this.kbarang = kbarang;
	}
	public String getKbarang() {
		return kbarang;
	}
	public void setPinjam(double pinjam) {
		this.pinjam = pinjam;
	}
	public double getPinjam() {
		return pinjam;
	}
	public void setBooking(double booking) {
		this.booking = booking;
	}
	public double getBooking() {
		return booking;
	}
	public void setSorder(double sorder) {
		this.sorder = sorder;
	}
	public double getSorder() {
		return sorder;
	}
	public void setAlokasi(double alokasi) {
		this.alokasi = alokasi;
	}
	public double getAlokasi() {
		return alokasi;
	}
	public void setPorder(double porder) {
		this.porder = porder;
	}
	public double getPorder() {
		return porder;
	}
	public void setPshipping(double pshipping) {
		this.pshipping = pshipping;
	}
	public double getPshipping() {
		return pshipping;
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
			_err="Error,Kode Gudang Could not empty.";
			return true;
		}
		if(this.getKbarang()==null || "".equals(this.getKbarang()))
		{
			_err="Error,Invalid Kode Barang Could not empty.";
			return true;
		}
		return false;
	}
}
