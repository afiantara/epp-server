package bo.crm;

import da.error.DAException;

public class Customer {
	private da.crm.Customer daCust;
	public Customer() throws DAException
	{
		daCust=new da.crm.Customer();
	}
	
	public sf.crm.Customer[] getCustomers(String cmpType) throws DAException
	{
		sf.crm.Customer[] custs =daCust.getCustomers(cmpType);
		int idx=0;
		for(sf.crm.Customer cust : custs)
		{
			if(cust.getKstatus().equals("C"))
				cust.setKstatusdesc("Customer");
			else if(cust.getKstatus().equals("B"))
				cust.setKstatusdesc("Cabang");
			else if(cust.getKstatus().equals("T"))
				cust.setKstatusdesc("Tender/Supplier");
			else
				cust.setKstatusdesc("Lain-lain");
			
			if(cust.getTfaktur1().equals("N"))
				cust.setBtfaktur1(false);
			else
				cust.setBtfaktur1(true);
			
			if(cust.getTfaktur2().equals("N"))
				cust.setBtfaktur2(false);
			else
				cust.setBtfaktur2(true);
			
			if(cust.getTfaktur3().equals("N"))
				cust.setBtfaktur3(false);
			else
				cust.setBtfaktur3(true);
			
			if(cust.getTfaktur4().equals("N"))
				cust.setBtfaktur4(false);
			else
				cust.setBtfaktur4(true);
			
			if(cust.getTfaktur5().equals("N"))
				cust.setBtfaktur5(false);
			else
				cust.setBtfaktur5(true);
			
			if(cust.getTfaktur6().equals("N"))
				cust.setBtfaktur6(false);
			else
				cust.setBtfaktur6(true);
			
			custs[idx]=cust;
			idx++;
		}
		return custs;
	}
	
	public sf.crm.Customer getCustomer(String kclient,String cmpType) throws DAException
	{
		return daCust.getCustomer(kclient,cmpType);
	}
	
	public sf.crm.Customer[] getCustomersByCabang(String kcabang,String cmpType) throws DAException
	{
		sf.crm.Customer[] custs =daCust.getCustomersByCabang(kcabang,cmpType);
		int idx=0;
		for(sf.crm.Customer cust : custs)
		{
			if(cust.getKstatus().equals("C"))
				cust.setKstatusdesc("Customer");
			else if(cust.getKstatus().equals("B"))
				cust.setKstatusdesc("Cabang");
			else if(cust.getKstatus().equals("T"))
				cust.setKstatusdesc("Tender/Supplier");
			else
				cust.setKstatusdesc("Lain-lain");
			
			if(cust.getTfaktur1().equals("N"))
				cust.setBtfaktur1(false);
			else
				cust.setBtfaktur1(true);
			
			if(cust.getTfaktur2().equals("N"))
				cust.setBtfaktur2(false);
			else
				cust.setBtfaktur2(true);
			
			if(cust.getTfaktur3().equals("N"))
				cust.setBtfaktur3(false);
			else
				cust.setBtfaktur3(true);
			
			if(cust.getTfaktur4().equals("N"))
				cust.setBtfaktur4(false);
			else
				cust.setBtfaktur4(true);
			
			if(cust.getTfaktur5().equals("N"))
				cust.setBtfaktur5(false);
			else
				cust.setBtfaktur5(true);
			
			if(cust.getTfaktur6().equals("N"))
				cust.setBtfaktur6(false);
			else
				cust.setBtfaktur6(true);
			custs[idx]=cust;
			idx++;
		}
		return custs;
	}
	public boolean insertCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		return daCust.insertCustomer(cust,cmpType);
	}
	
	public boolean updateCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		return daCust.updateCustomer(cust,cmpType);
	}
	
	public boolean deleteCustomer(String kclient,String cmpType) throws DAException
	{
		return daCust.deleteCustomer(kclient,cmpType);
	}
}
