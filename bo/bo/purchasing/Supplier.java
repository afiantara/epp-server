package bo.purchasing;

import da.error.DAException;

public class Supplier {
	private da.purchasing.Supplier daSupplier;
	public Supplier() throws DAException
	{
		daSupplier=new da.purchasing.Supplier();
	}
	
	public sf.purchasing.Supplier[] getSupplier() throws DAException
	{
		sf.purchasing.Supplier []items = new sf.purchasing.Supplier[daSupplier.getSupplier().length];
		int idx=0;
		for (sf.purchasing.Supplier supplier : daSupplier.getSupplier()) {
			if(supplier.getKstatus().equals("S"))
				supplier.setKstatusdesc("Supplier");
			else if(supplier.getKstatus().equals("C"))
				supplier.setKstatusdesc("Cabang");
			else
				supplier.setKstatusdesc("Lain-lain");
			
			items[idx]= supplier;
			idx++;
		}
		return items;
	}
	
	public sf.purchasing.Supplier getSupplier(String kvendor) throws DAException
	{
		return daSupplier.getSupplier(kvendor);
	}
	
	public boolean insertSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		return daSupplier.insertSupplier(supplier);
	}
	
	public boolean updateSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		return daSupplier.updateSupplier(supplier);
	}
	
	public boolean deleteSupplier(String kvendor) throws DAException
	{
		return daSupplier.deleteSupplier(kvendor);
	}
	
	public sf.purchasing.Title[] getTitle() throws DAException
	{
		return daSupplier.getTitle();
	}
}
