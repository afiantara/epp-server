package tester;


import com.account.Accounting;

import da.error.DAException;

public class Test {
	
	public static void main(String[] args) throws DAException
	{
		/*
		sf.accounting.Branch branch=new sf.accounting.Branch();
		com.account.Accounting acct = new Accounting();
		Object obj=acct.getBranch();
		Branch[] items = (Branch[])obj;
		Branch item = items[0];
		System.out.println(item.getKcabang() + "  " + item.getKota());
		*/
		
		sf.accounting.User user=new sf.accounting.User();
		user.setKstaff("999");
		
		//user.setKpassword(enc.encryptPassword("afiantara"));
		
		com.account.Accounting acct = new Accounting();
		if(acct.login(user))
			System.out.println("LoginOK");
		/*
		com.account.Accounting acct = new Accounting();
		User user = acct.getUsers();
		User[] userts=user.getUsers();
		User usr=new User();
		usr = userts
		System.out.println(userts[0].getKstaff());
		//User user=acct.getUser("1000");
		//System.out.println(user.getKstaff());
		 * 
		 */
	}
}
