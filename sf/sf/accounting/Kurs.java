package sf.accounting;

import sf.general.General;

public class Kurs extends General{
	private String kvaluta;
	private int tvaluta ;
	private double nvaluta=0;
	private Kurs[] kurs;
	public Kurs()
	{
		
	}
	
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		if(this.getKvaluta()==null || "".equals(this.getKvaluta()))
		{
			_err="Error,Invalid Kode Valuta. Could not empty.";
			return true;
		}
		if(this.getTvaluta()==0)
		{
			_err="Error,Invalid Tanggal Valuta. Could not empty.";
			return true;
		}
		return false;
	}

	public void setKvaluta(String kvaluta) {
		this.kvaluta = kvaluta;
	}

	public String getKvaluta() {
		return kvaluta;
	}

	public void setTvaluta(int tvaluta) {
		this.tvaluta = tvaluta;
	}

	public int getTvaluta() {
		return tvaluta;
	}

	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}

	public double getNvaluta() {
		return nvaluta;
	}

	public void setKurs(Kurs[] kurs) {
		this.kurs = kurs;
	}

	public Kurs[] getKurs() {
		return kurs;
	}
	
	
}
