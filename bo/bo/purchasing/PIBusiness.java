package bo.purchasing;

import sf.purchasing.PIDetail;
import sf.purchasing.PIHeader;
import da.error.DAException;
import da.purchasing.InvoiceDA;

public class PIBusiness {
	
	private InvoiceDA pida;
	
	public PIBusiness() throws DAException
	{
		pida=new InvoiceDA();
	}
	public int getNoPI() throws DAException
	{
		return pida.getNoPI();
	}
	
	public String checkPIExist(String noPI) throws DAException
	{
		return pida.checkPIExist(noPI);
	}
	
	public boolean insertPI(PIHeader header,PIDetail[] details) throws DAException
	{
		return pida.insertPI(header, details);
	}
	
	public boolean updatePI(sf.purchasing.PIHeader header,sf.purchasing.PIDetail[] details) throws DAException
	{
		return pida.updatePI(header, details);
	}
	
	public boolean deletePI(sf.purchasing.PIHeader header) throws DAException
	{
		return pida.deletePI(header);
	}
	public PIDetail getPIDetail(PIHeader header) throws DAException
	{
		PIDetail detail=new PIDetail();
		detail.setDetails(pida.getPIDetail(header));
		return detail;
	}
	
	public PIHeader getPIHeader(String kcabang,String startDate,String endDate) throws DAException
	{
		PIHeader header=new PIHeader();
		header.setHeaders(pida.getPIHeader(kcabang, startDate, endDate));
		return header;
	}
}
