package sf.inventory;

import sf.general.General;

public class Rak extends General{
	private String koderak;
	private String lokasirak;
	
	private Rak[] raks;
	public void setKoderak(String koderak) {
		this.koderak = koderak;
	}
	public String getKoderak() {
		return koderak;
	}
	public void setLokasirak(String lokasirak) {
		this.lokasirak = lokasirak;
	}
	public String getLokasirak() {
		return lokasirak;
	}
	
private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		if(this.getKoderak()==null || "".equals(this.getKoderak()))
		{
			_err="Error,Invalid Kode Rak. Could not empty.";
			return true;
		}
		return false;
	}
	public void setRaks(Rak[] raks) {
		this.raks = raks;
	}
	public Rak[] getRaks() {
		return raks;
	}
}
