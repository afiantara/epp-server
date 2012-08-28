package bo.crm;

import da.error.DAException;

public class Industry {
	private da.crm.Industry daInd;
	public Industry() throws DAException
	{
		daInd=new da.crm.Industry();
	}
	
	public sf.crm.Industry[] getIndustries() throws DAException
	{
		return daInd.getIndustries();
	}
	
	public sf.crm.Industry getIndustry(String kindustri) throws DAException
	{
		return daInd.getIndustry(kindustri);
	}
	
	public boolean insertIndustry(sf.crm.Industry ind) throws DAException
	{
		return daInd.insertIndustry(ind);
	}
	
	public boolean updateIndustry(sf.crm.Industry ind) throws DAException
	{
		return daInd.updateIndustry(ind);
	}
	
	public boolean deleteIndustry(String  kindustri) throws DAException
	{
		return daInd.deleteIndustry(kindustri);
	}
}
