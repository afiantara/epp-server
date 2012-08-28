package sf.accounting;

import sf.general.General;

public class KursPajak extends General{
	private String kvaluta;
	private int tvaluta1 =0;
	private int tvaluta2=0;
	private double nvaluta =0;
	
	private KursPajak[] kursPajaks;
	public KursPajak()
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
		
		if(this.getTvaluta1()==0)
		{
			_err="Error,Invalid Tanggal Valuta. Could not empty.";
			return true;
		}
		
		if(this.getTvaluta1() > this.getTvaluta2())
		{
			_err="Error,Invalid Tanggal Valuta Tanggal Valuta#2 > = Tanggal Valuta#1. Could not empty.";
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

	public void setTvaluta1(int tvaluta1) {
		this.tvaluta1 = tvaluta1;
	}

	public int getTvaluta1() {
		return tvaluta1;
	}

	public void setTvaluta2(int tvaluta2) {
		this.tvaluta2 = tvaluta2;
	}

	public int getTvaluta2() {
		return tvaluta2;
	}

	public void setNvaluta(double nvaluta) {
		this.nvaluta = nvaluta;
	}

	public double getNvaluta() {
		return nvaluta;
	}

	public void setKursPajaks(KursPajak[] kursPajaks) {
		this.kursPajaks = kursPajaks;
	}

	public KursPajak[] getKursPajaks() {
		return kursPajaks;
	}
}
