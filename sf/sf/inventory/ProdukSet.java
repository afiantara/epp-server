package sf.inventory;

import sf.general.General;


public class ProdukSet extends General {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kbarang;
	private String kbarang1;
	private String nbarang;
	private String nbarang1;
	private String satuan;
	private String satuan1;
	private double kqty;
	
	private ProdukSet[] produksets;
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
		
		if(this.getKbarang1()==null || "".equals(this.getKbarang1()))
		{
			_err="Error,Invalid Kode Barang1. Could not empty.";
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
	public void setKbarang1(String kbarang1) {
		this.kbarang1 = kbarang1;
	}
	public String getKbarang1() {
		return kbarang1;
	}
	public void setKqty(double kqty) {
		this.kqty = kqty;
	}
	public double getKqty() {
		return kqty;
	}

	public void setProduksets(ProdukSet[] produksets) {
		this.produksets = produksets;
	}

	public ProdukSet[] getProduksets() {
		return produksets;
	}

	public void setNbarang1(String nbarang1) {
		this.nbarang1 = nbarang1;
	}

	public String getNbarang1() {
		return nbarang1;
	}

	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	public String getSatuan() {
		return satuan;
	}

	public void setNbarang(String nbarang) {
		this.nbarang = nbarang;
	}

	public String getNbarang() {
		return nbarang;
	}

	public void setSatuan1(String satuan1) {
		this.satuan1 = satuan1;
	}

	public String getSatuan1() {
		return satuan1;
	}
}
