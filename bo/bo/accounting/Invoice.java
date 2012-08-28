package bo.accounting;

import sf.accounting.Account;
import da.error.DAException;

public class Invoice {
	
	private da.accounting.Invoice daInv;
	private COA coa;
	public Invoice() throws DAException
	{
		daInv=new da.accounting.Invoice();
		coa = new COA();
	}
	
	public sf.accounting.Invoice[] getInvoices() throws DAException
	{
		sf.accounting.Invoice[] invoices = new sf.accounting.Invoice[daInv.getInvoices().length];
		int idx=0;
		for (sf.accounting.Invoice item : daInv.getInvoices()) {
			Account account= coa.getAccountByNo(item.getAccsales());
			item.setAccsalesdesc(account.getAccno() + "-" + account.getAccdesc());
			
			account= coa.getAccountByNo(item.getAccpiutang());
			item.setAccpiutangdesc(account.getAccno() + "-" + account.getAccdesc());
			
			account= coa.getAccountByNo(item.getAccdp());
			item.setAccdpdesc(account.getAccno() + "-" + account.getAccdesc());
			
			account= coa.getAccountByNo(item.getAccppn());
			item.setAccppndesc(account.getAccno() + "-" + account.getAccdesc());
			if(item.getKenappn().equals("Y"))
				item.setKenappndesc("Ya");
			else
				item.setKenappndesc("Tidak");
			if(item.getKonfirmppn().equals("Y"))
				item.setKonfirmppndesc("Ya");
			else
				item.setKonfirmppndesc("Tidak");
			
			invoices[idx]=item;
			idx++;
		}
		return invoices;
	}
	
	public boolean insertInvoice(sf.accounting.Invoice inv) throws DAException
	{
		return daInv.insertInvoice(inv);
	}
	
	public boolean updateInvoice(sf.accounting.Invoice inv) throws DAException
	{
		return daInv.updateInvoice(inv);
	}
	
	public boolean deleteInvoice(String kinvoice) throws DAException
	{
		return daInv.deleteInvoice(kinvoice);
	}
}
