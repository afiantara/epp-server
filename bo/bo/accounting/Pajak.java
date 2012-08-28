package bo.accounting;

import da.error.DAException;

public class Pajak {
	private da.accounting.Pajak daPajak;
	public Pajak() throws DAException
	{
		daPajak=new da.accounting.Pajak();
	}
	public sf.accounting.Pajak[] getPajak() throws DAException
	{
		return daPajak.getPajak();
	}
}
