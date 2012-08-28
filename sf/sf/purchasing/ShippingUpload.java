package sf.purchasing;

public class ShippingUpload {
	private String NoShipping;
	private String TglShipping;
	private String kbarang;
	private double jumlah;
	private String kirimvia;
	private String kexpedisi;
	private double kgberat;
	private String tgltiba;
	private String keterangan;
	public void setNoShipping(String noShipping) {
		NoShipping = noShipping;
	}
	public String getNoShipping() {
		return NoShipping;
	}
	public void setTglShipping(String tglShipping) {
		TglShipping = tglShipping;
	}
	public String getTglShipping() {
		return TglShipping;
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
	public void setKirimvia(String kirimvia) {
		this.kirimvia = kirimvia;
	}
	public String getKirimvia() {
		return kirimvia;
	}
	public void setKexpedisi(String kexpedisi) {
		this.kexpedisi = kexpedisi;
	}
	public String getKexpedisi() {
		return kexpedisi;
	}
	public void setKgberat(double kgberat) {
		this.kgberat = kgberat;
	}
	public double getKgberat() {
		return kgberat;
	}
	public void setTgltiba(String tgltiba) {
		this.tgltiba = tgltiba;
	}
	public String getTgltiba() {
		return tgltiba;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getKeterangan() {
		return keterangan;
	}	
}
