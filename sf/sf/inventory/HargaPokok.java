package sf.inventory;

import sf.general.General;

public class HargaPokok extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kbarang;
	private String nbarang;
	private String satuan;
	private String ktanggal ;
	private String kvaluta ;
	private double nvaluta=0 ;
	private double potongan=0;
	
	private HargaPokok[] hargaPokoks;
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
		
		if(this.getKtanggal()==null || "".equals(this.getKtanggal()))
		{
			_err="Error,Invalid Tanggal. Could not empty.";
			return true;
		}
		
		if(this.getKvaluta()==null || "".equals(this.getKvaluta()))
		{
			_err="Error,Invalid Valuta. Could not empty.";
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
	public void setKtanggal(String ktanggal) {
		this.ktanggal = ktanggal;
	}
	public String getKtanggal() {
		return ktanggal;
	}
	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}
	public String getKvaluta() {
		return kvaluta;
	}
	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}
	public double getNvaluta() {
		return nvaluta;
	}
	public void setPotongan(double potongan) {
		this.potongan = potongan;
	}
	public double getPotongan() {
		return potongan;
	}

	public void setHargaPokoks(HargaPokok[] hargaPokoks) {
		this.hargaPokoks = hargaPokoks;
	}

	public HargaPokok[] getHargaPokoks() {
		return hargaPokoks;
	}

	/**
	 * @param nbarang the nbarang to set
	 */
	public void setNbarang(String nbarang) {
		this.nbarang = nbarang;
	}

	/**
	 * @return the nbarang
	 */
	public String getNbarang() {
		return nbarang;
	}

	/**
	 * @param satuan the satuan to set
	 */
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}

	/**
	 * @return the satuan
	 */
	public String getSatuan() {
		return satuan;
	}
}
