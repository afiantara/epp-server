package bo.accounting;

import da.error.DAException;

public class KursPajak {
	
	da.accounting.KursPajak daKurs;
	public KursPajak() throws DAException
	{
		daKurs=new da.accounting.KursPajak(); 
	}
	
	public sf.accounting.KursPajak[] getKursPajak() throws DAException
	{
		return daKurs.getKursPajak();
	}
	
	public sf.accounting.KursPajak[] getKursPajak(String kValuta) throws DAException
	{
		return daKurs.getKursPajak(kValuta);
	}
	
	public boolean insertKursPajak(sf.accounting.KursPajak kurs) throws DAException 
	{
		return daKurs.insertKursPajak(kurs);
	}
	
	public boolean updateKursPajak(sf.accounting.KursPajak kurs) throws DAException 
	{
		return daKurs.updateKursPajak(kurs);
	}
	
	public boolean deleteKursPajak(String kvaluta) throws DAException 
	{
		return daKurs.deleteKursPajak(kvaluta);
	}
}
