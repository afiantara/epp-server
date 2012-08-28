package bo.accounting;

import da.error.DAException;


public class Branch
{
	private da.accounting.Branch daBranch;
	
	public Branch() throws DAException
	{
		daBranch=new da.accounting.Branch();
	}
	
	public boolean insertBranch(sf.accounting.Branch branch) throws DAException
	{
		return daBranch.insertBranch(branch);
	}
	
	public boolean updateBranch(sf.accounting.Branch branch) throws DAException
	{
		return daBranch.updateBranch(branch);
	}
	
	public boolean deleteBranch(sf.accounting.Branch branch) throws DAException
	{
		return daBranch.deleteBranch(branch);
	}
	
	public sf.accounting.Branch[] getBranch() throws DAException
	{
		return daBranch.getBranch();
	}
	
	public sf.accounting.Branch[] getBranch(String kodeCabang) throws DAException
	{
		return daBranch.getBranch(kodeCabang);
	}
}
