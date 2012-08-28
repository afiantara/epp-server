package bo.accounting;

import sf.accounting.Expedisi;
import da.error.DAException;


public class Ekspedisi {
	private da.accounting.Ekspedisi daEkspedisi;
	
	public Ekspedisi() throws DAException
	{
		daEkspedisi=new da.accounting.Ekspedisi();
	}
	
	public Expedisi[] getEkspedisi() throws DAException
	{
		Expedisi[] arrExpredisi = new Expedisi[daEkspedisi.getEkspedisi().length];
		int idx=0;
		for (Expedisi expedisi : daEkspedisi.getEkspedisi()) {
			if(expedisi.getKodevia().equals("L"))
				expedisi.setKodeviadesc("Laut");
			else if(expedisi.getKodevia().equals("D"))
				expedisi.setKodeviadesc("Darat");
			else
				expedisi.setKodeviadesc("Udara");
			arrExpredisi[idx]= expedisi;
			idx++;
		}
		return daEkspedisi.getEkspedisi();
	}
	
	public Expedisi getEkspedisi(String kode) throws DAException
	{
		return daEkspedisi.getEkspedisi(kode);
	}
	
	public boolean insertEkspedisi(Expedisi eks) throws DAException
	{
		return daEkspedisi.insertEkspedisi(eks);
	}
	
	public boolean updateEkspedisi(Expedisi eks) throws DAException
	{
		return daEkspedisi.updateEkspedisi(eks);
	}
	
	public boolean deleteEkspedisi(String kexpedisi) throws DAException
	{
		return daEkspedisi.deleteEkspedisi(kexpedisi);
	}
}
