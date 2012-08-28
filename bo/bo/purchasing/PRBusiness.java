package bo.purchasing;

import sf.purchasing.PIHeader;
import sf.purchasing.PReturDetail;
import sf.purchasing.PReturHeader;
import da.error.DAException;
import da.purchasing.ReturDA;

public class PRBusiness {
	private ReturDA returDA;
	
	public PRBusiness() throws DAException
	{
		returDA=new ReturDA();
	}
	
	public int getNoPR() throws DAException
	{
		return returDA.getNoPR();
	}
	
	public String checkPRExist(String noPR) throws DAException
	{
		return returDA.checkPRExist(noPR);
	}
	
	public boolean insertPR(PReturHeader header,PReturDetail[] details) throws DAException
	{
		return returDA.insertPR(header, details);
	}
	
	public boolean updatePR(sf.purchasing.PReturHeader header,sf.purchasing.PReturDetail[] details) throws DAException
	{
		return returDA.updatePR(header, details);
	}
	
	
	public boolean deletePR(sf.purchasing.PReturHeader header) throws DAException
	{
		return returDA.deletePR(header);
	}
	public PReturDetail getPRDetail(PReturHeader header) throws DAException
	{
		PReturDetail detail=new PReturDetail();
		detail.setDetails(returDA.getPRDetail(header));
		return detail;
	}
	
	public PReturHeader getPRHeader(String kcabang,String startDate,String endDate) throws DAException
	{
		PReturHeader header=new PReturHeader();
		header.setHeaders(returDA.getPRHeader(kcabang, startDate, endDate));
		return header;
	}
	
	public PIHeader getPIHeader() throws DAException
	{
		PIHeader header=new PIHeader();
		header.setHeaders(returDA.getPIHeader());
		return header;
	}
}
