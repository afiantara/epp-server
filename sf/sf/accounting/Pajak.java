package sf.accounting;

public class Pajak {
	private String kode;
	private String keterangan;
	
	private Pajak[] pajaks;
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getKode() {
		return kode;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setPajaks(Pajak[] pajaks) {
		this.pajaks = pajaks;
	}
	public Pajak[] getPajaks() {
		return pajaks;
	}
}
