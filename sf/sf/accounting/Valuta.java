package sf.accounting;

import sf.general.General;

public class Valuta extends General {
	private String kvaluta;
	private String ketvaluta;
	
	private Valuta[] valutas;
	
	public Valuta()
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
			_err="Error,Invalid Kode Valuta.Could not empty.";
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
	public void setKetvaluta(String ketvaluta) {
		this.ketvaluta = ketvaluta;
	}
	public String getKetvaluta() {
		return ketvaluta;
	}
	public void setValutas(Valuta[] valutas) {
		this.valutas = valutas;
	}
	public Valuta[] getValutas() {
		return valutas;
	}
}
