package bo.crm;

import da.error.DAException;

public class Supplier {
	private da.crm.Supplier daSupplier;
	public Supplier() throws DAException
	{
		daSupplier=new da.crm.Supplier();
	}
	
	public sf.crm.Supplier[] getSupplier() throws DAException
	{
		return daSupplier.getSupplier();
	}
	
	public sf.crm.Supplier getSupplier(String kvendor) throws DAException
	{
		return daSupplier.getSupplier(kvendor);
	}
	
	public boolean insertSupplier(sf.crm.Supplier supplier) throws DAException
	{
		return daSupplier.insertSupplier(supplier);
	}
	
	public boolean updateSupplier(sf.crm.Supplier supplier) throws DAException
	{
		return daSupplier.updateSupplier(supplier);
	}
	
	public boolean deleteSupplier(String kvendor) throws DAException
	{
		return daSupplier.deleteSupplier(kvendor);
	}
}
