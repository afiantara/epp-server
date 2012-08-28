package sf.sales;

import sf.general.General;

public class StockRekap extends General{
	private String kgudang;
	private String kbarang;
	private double onhand=0;
	public StockRekap()
	{
		
	}
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
	public void setOnhand(double onhand) {
		this.onhand = onhand;
	}
	public double getOnhand() {
		return onhand;
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
