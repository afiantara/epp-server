package bo.inventory;

import da.error.DAException;

public class Gudang {
	private da.inventory.Gudang daGudang;
	public Gudang() throws DAException
	{
		daGudang=new da.inventory.Gudang();
	}
	
	public sf.inventory.Gudang getGudang() throws DAException
	{
		sf.inventory.Gudang gudang=new sf.inventory.Gudang();
		gudang.setGudangs(daGudang.getGudang());
		return gudang;
	}
	
	public sf.inventory.Gudang getGudang(String kgudang) throws DAException
	{
		return daGudang.getGudang(kgudang);
	}
	
	public boolean insertGudang(sf.inventory.Gudang gudang) throws DAException
	{
		return daGudang.insertGudang(gudang);
	}
	
	public boolean updateGrudang(sf.inventory.Gudang gudang) throws DAException
	{
		return daGudang.updateGudang(gudang);
	}
	
	public boolean deleteGudang(String kgudang) throws DAException
	{
		return daGudang.deleteGudang(kgudang);
	}
}
