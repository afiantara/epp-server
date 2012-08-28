package bo.accounting;

import da.error.DAException;

public class Valuta {
	private da.accounting.Valuta daValuta;
	
	public Valuta() throws DAException
	{
		daValuta=new da.accounting.Valuta();
	}
	
	public sf.accounting.Valuta[] getValutas() throws DAException
	{
		return daValuta.getValutas();
	}
	
	public sf.accounting.Valuta getValuta(String kValuta) throws DAException
	{
		return daValuta.getValuta(kValuta);
	}
	
	public boolean insertValuta(sf.accounting.Valuta valuta) throws DAException 
	{
		return daValuta.insertValuta(valuta);
	}
	
	public boolean updateValuta(sf.accounting.Valuta valuta) throws DAException 
	{
		return daValuta.updateValuta(valuta);
	}
	
	public boolean deleteValuta(String kvaluta) throws DAException 
	{
		return daValuta.deleteValuta(kvaluta);
	}
}
