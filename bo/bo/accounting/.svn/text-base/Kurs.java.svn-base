package bo.accounting;

import da.error.DAException;

public class Kurs {
	private da.accounting.Kurs daKurs;
	public Kurs() throws DAException
	{
		daKurs=new da.accounting.Kurs(); 
	}
	
	public sf.accounting.Kurs[] getKurs() throws DAException
	{
		return daKurs.getKurs();
	}
	
	public sf.accounting.Kurs[] getLatestKurs(String kValuta,String tglValuta) throws DAException
	{
		return daKurs.getLatestKurs(kValuta, tglValuta);
	}
	public sf.accounting.Kurs[] getKurs(String kValuta) throws DAException
	{
		return daKurs.getKurs(kValuta);
	}
	
	public boolean insertKurs(sf.accounting.Kurs kurs) throws DAException 
	{
		return daKurs.insertKurs(kurs);
	}
	
	public boolean updateKurs(sf.accounting.Kurs kurs) throws DAException 
	{
		return daKurs.updateKurs(kurs);
	}
	
	public boolean deleteKurs(String kvaluta) throws DAException 
	{
		return daKurs.deleteKurs(kvaluta);
	}
}
