package com.crm;

import da.error.DAException;

public class CRM {
	private bo.crm.Industry boInd;
	private bo.crm.Customer boCust;
	public CRM() throws DAException
	{
		boInd=new bo.crm.Industry();
		boCust=new bo.crm.Customer();
	}
	
	
	
	public sf.crm.Industry getIndustries() throws DAException
	{
		sf.crm.Industry ind=new sf.crm.Industry();
		ind.setIndustries(boInd.getIndustries());
		return ind;
	}
	
	public sf.crm.Industry getIndustry(String kindustri) throws DAException
	{
		return boInd.getIndustry(kindustri);
	}
	
	public boolean insertIndustry(sf.crm.Industry ind) throws DAException
	{
		return boInd.insertIndustry(ind);
	}
	
	public boolean updateIndustry(sf.crm.Industry ind) throws DAException
	{
		ind.setRecstatus("U");
		return boInd.updateIndustry(ind);
	}
	
	public boolean deleteIndustry(sf.crm.Industry ind) throws DAException
	{
		ind.setRecstatus("D");
		return boInd.updateIndustry(ind);
		//return boInd.deleteIndustry(kindustri);
	}
	
	public sf.crm.Customer getCustomers(String cmpType) throws DAException
	{
		sf.crm.Customer cust=new sf.crm.Customer();
		cust.setCustomers(boCust.getCustomers(cmpType));
		return cust;
	}
	
	public sf.crm.Customer getCustomersByCabang(String kcabang,String cmpType) throws DAException
	{
		sf.crm.Customer cust=new sf.crm.Customer();
		cust.setCustomers(boCust.getCustomersByCabang(kcabang,cmpType));
		return cust;
	}
	
	public sf.crm.Customer getCustomer(String kclient,String cmpType) throws DAException
	{
		return boCust.getCustomer(kclient,cmpType);
	}
	
	public boolean insertCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		return boCust.insertCustomer(cust,cmpType);
	}
	
	public boolean updateCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		cust.setRecstatus("U");
		return boCust.updateCustomer(cust,cmpType);
	}
	
	public boolean deleteCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		cust.setRecstatus("D");
		return boCust.updateCustomer(cust,cmpType);
		//return boCust.deleteCustomer(kclient);
	}
	
}
