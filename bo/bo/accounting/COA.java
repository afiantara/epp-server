package bo.accounting;

import sf.accounting.Account;
import da.error.DAException;


public class COA {
	
	private da.accounting.COA daCOA;
	
	public COA() throws DAException
	{
		daCOA=new da.accounting.COA();
	}
	
	public Account[] getAccounts() throws DAException
	{
		return convert(daCOA.getAccounts());
	}
	
	private Account[] convert(Account[] accts)
	{
		Account[] accs = new Account[accts.length];
		int idx=0;
		for (Account account : accts) {
			if(account.getAccbiayab().equals("N"))
				account.setBoolaccbiayab(false);
			else
				account.setBoolaccbiayab(true);
			
			if(account.getAccbiayas().equals("N"))
				account.setBoolaccbiayas(false);
			else
				account.setBoolaccbiayas(true);
			
			if(account.getAccbiayap().equals("N"))
				account.setBoolaccbiayap(false);
			else
				account.setBoolaccbiayap(true);
			
			if(account.getAccbiayak().equals("N"))
				account.setBoolaccbiayak(false);
			else
				account.setBoolaccbiayak(true);
			
			if(account.getAccgroup().equals("A"))
				account.setAccgroupdesc("Aktiva");
			else if(account.getAccgroup().equals("K"))
				account.setAccgroupdesc("Kewajiban");
			else if(account.getAccgroup().equals("M"))
				account.setAccgroupdesc("Modal");
			else if(account.getAccgroup().equals("B"))
				account.setAccgroupdesc("Biaya");
			else if(account.getAccgroup().equals("P"))
				account.setAccgroupdesc("Pendapatan");
			if(account.getAcctype().equals("K"))
				account.setAcctypedesc("Kas");
			else if(account.getAcctype().equals("B"))
				account.setAcctypedesc("Bank");
			else
				account.setAcctypedesc("Non K/B");
			if(account.getAcclevel().equals("H"))
				account.setAccleveldesc("Header");
			else
				account.setAccleveldesc("Detail (Journal Account)");
			
			accs[idx]=account;
			idx++;
		}
		return accs;
	}
	
	
	public Account[] getAccountByGroup(String group) throws DAException
	{
		return convert(daCOA.getAccountByGroup(group));
	}
	
	public Account[] getAccountByLevel(String level) throws DAException
	{
		return convert(daCOA.getAccountByLevel(level));
	}
	
	public Account getAccountByNo(String accountNo) throws DAException
	{
		Account tmpAccount = daCOA.getAccountByNo(accountNo);
		if(tmpAccount.getAccbiayab().equals("N"))
			tmpAccount.setBoolaccbiayab(false);
		else
			tmpAccount.setBoolaccbiayab(true);
		
		if(tmpAccount.getAccbiayas().equals("N"))
			tmpAccount.setBoolaccbiayas(false);
		else
			tmpAccount.setBoolaccbiayas(true);
		
		if(tmpAccount.getAccbiayap().equals("N"))
			tmpAccount.setBoolaccbiayap(false);
		else
			tmpAccount.setBoolaccbiayap(true);
		
		if(tmpAccount.getAccbiayak().equals("N"))
			tmpAccount.setBoolaccbiayak(false);
		else
			tmpAccount.setBoolaccbiayak(true);
		
		if(tmpAccount.getAccgroup().equals("A"))
			tmpAccount.setAccgroupdesc("Aktiva");
		else if(tmpAccount.getAccgroup().equals("K"))
			tmpAccount.setAccgroupdesc("Kewajiban");
		else if(tmpAccount.getAccgroup().equals("M"))
			tmpAccount.setAccgroupdesc("Modal");
		else if(tmpAccount.getAccgroup().equals("B"))
			tmpAccount.setAccgroupdesc("Biaya");
		else if(tmpAccount.getAccgroup().equals("P"))
			tmpAccount.setAccgroupdesc("Pendapatan");
		if(tmpAccount.getAcctype().equals("K"))
			tmpAccount.setAcctypedesc("Kas");
		else if(tmpAccount.getAcctype().equals("B"))
			tmpAccount.setAcctypedesc("Bank");
		else
			tmpAccount.setAcctypedesc("Non K/B");
		if(tmpAccount.getAcclevel().equals("H"))
			tmpAccount.setAccleveldesc("Header");
		else
			tmpAccount.setAccleveldesc("Detail (Journal Account)");
		return tmpAccount;
	}
	
	public Account getAccountBiaya(String accountNo,String desc) throws DAException
	{
		sf.accounting.Account acc=new sf.accounting.Account();
		acc.setAccounts(daCOA.getAccountBiaya(accountNo, desc));
		return acc;
	}
	public boolean insertCOA(Account acct) throws DAException 
	{
		return daCOA.insertCOA(acct);
	}
	
	public boolean updateCOA(Account acct) throws DAException
	{
		return daCOA.updateCOA(acct);
	}
	
	public boolean deleteCOA(String accno) throws DAException
	{
		return daCOA.deleteCOA(accno);
	}
}
