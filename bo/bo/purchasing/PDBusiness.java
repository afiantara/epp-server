package bo.purchasing;

import sf.purchasing.PDDetail;
import sf.purchasing.PDHeader;
import da.error.DAException;
import da.purchasing.PDDataAccess;

public class PDBusiness {
	
	private PDDataAccess pdda;
	
	public PDBusiness() throws DAException
	{
		pdda=new PDDataAccess();
	}
	public int getNoPD() throws DAException
	{
		return pdda.getNoPD();
	}
	
	public String checkPDExist(String noPD) throws DAException
	{
		return pdda.checkPDExist(noPD);
	}
	
	public boolean insertPD(PDHeader header,PDDetail[] details) throws DAException
	{
		return pdda.insertPD(header, details);
	}
	
	public boolean updatePD(sf.purchasing.PDHeader header,sf.purchasing.PDDetail[] details) throws DAException
	{
		return pdda.updatePD(header, details);
	}
	
	public boolean deletePD(sf.purchasing.PDHeader header) throws DAException
	{
		return pdda.deletePD(header);
	}
	public PDDetail getPDDetail(PDHeader header) throws DAException
	{
		PDDetail detail=new PDDetail();
		detail.setDetails(pdda.getPDDetail(header));
		return detail;
	}
	
	public PDHeader getPDHeader(String kcabang,String startDate,String endDate,int filter) throws DAException
	{
		PDHeader header=new PDHeader();
		header.setHeaders(pdda.getPDHeader(kcabang, startDate, endDate, filter));
		return header;
	}
}
