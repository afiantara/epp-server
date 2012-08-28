package bo.inventory;

import da.error.DAException;

public class Rak {
	private da.inventory.Rak daRak;
	public Rak() throws DAException
	{
		daRak=new da.inventory.Rak();
	}
	
	public sf.inventory.Rak getRak() throws DAException
	{
		sf.inventory.Rak rak=new sf.inventory.Rak();
		rak.setRaks(daRak.getRak());
		return rak;
	}
	
	public sf.inventory.Rak getRak(String koderak) throws DAException
	{
		return daRak.getRak(koderak);
	}
	
	public boolean insertRak(sf.inventory.Rak rak) throws DAException
	{
		return daRak.insertRak(rak);
	}
	
	public boolean updateRak(sf.inventory.Rak rak) throws DAException
	{
		return daRak.updateRak(rak);
	}
	
	public boolean deleteRak(String koderak) throws DAException
	{
		return daRak.deleteRak(koderak);
	}
}
