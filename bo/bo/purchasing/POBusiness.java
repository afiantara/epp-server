package bo.purchasing;

import java.util.Vector;

import sf.purchasing.PODetail;
import sf.purchasing.POHeader;
import da.error.DAException;
import da.purchasing.PODataAccess;

public class POBusiness {
	
	private PODataAccess poda;
	
	public POBusiness() throws DAException
	{
		poda=new PODataAccess();
	}
	public int getNoPO() throws DAException
	{
		return poda.getNoPO();
	}
	
	public String checkPOExist(String noPO) throws DAException
	{
		return poda.checkPOExist(noPO);
	}
	
	public boolean insertPO(POHeader header,PODetail[] details) throws DAException
	{
		return poda.insertPO(header, details);
	}
	
	public boolean updatePO(sf.purchasing.POHeader header,sf.purchasing.PODetail[] details) throws DAException
	{
		return poda.updatePO(header, details);
	}
	
	public boolean deletePO(sf.purchasing.POHeader header) throws DAException
	{
		return poda.deletePO(header);
	}
	public PODetail getPODetail(POHeader header) throws DAException
	{
		PODetail detail=new PODetail();
		detail.setDetails(poda.getPODetail(header));
		return detail;
	}
	
	public POHeader getPOHeader(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		POHeader header = new POHeader();
		POHeader[] headers=poda.getPOHeader(nobukti,startDate, endDate, filter);
		POHeader[] itemHeader=new POHeader[headers.length];
		int idx=0;
		for(POHeader item : headers)
		{
			itemHeader[idx]=item;
			PODetail[] details = poda.getPODetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PODetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setDelivery("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setDelivery("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setDelivery("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public POHeader getPOHeaderByBulan(String bulan) throws DAException
	{
		POHeader header = getPOHeader("","","",0);
		POHeader[] headers=header.getHeaders();
		POHeader[] itemHeader=new POHeader[headers.length];
		int idx=0;
		for(POHeader item : headers)
		{
			String tmpbulan = item.getTglBukti().substring(4, 6); //yyyyMMdd
			
			if(!tmpbulan.equals(bulan))
				continue;
			
			itemHeader[idx]=item;
			PODetail[] details = poda.getPODetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PODetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setDelivery("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setDelivery("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setDelivery("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public POHeader getPOHeaderByTglBukti(String tanggal) throws DAException
	{
		POHeader header = new POHeader();
		POHeader[] headers=poda.getPOHeaderByTglBukti(tanggal);
		POHeader[] itemHeader=new POHeader[headers.length];
		int idx=0;
		for(POHeader item : headers)
		{
			itemHeader[idx]=item;
			PODetail[] details = poda.getPODetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PODetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setDelivery("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setDelivery("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setDelivery("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public POHeader getPOHeaderBelumDelivery(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		POHeader header=getPOHeader(nobukti, startDate,endDate,filter);
		POHeader[] headers=header.getHeaders();
		Vector<POHeader> vheaders=new Vector<POHeader>();
		for(POHeader item : headers)
		{
			if(item.getDelivery()==null || !item.getDelivery().equals("Complete"))
			{
				vheaders.add(item);
			}
		}
		POHeader[] itemHeader=new POHeader[vheaders.size()];
		int idx=0;
		for(POHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public POHeader getPOHeaderSudahDelivery(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		POHeader header=getPOHeader(nobukti,startDate,endDate,filter);
		POHeader[] headers=header.getHeaders();
		Vector<POHeader> vheaders=new Vector<POHeader>();
		for(POHeader item : headers)
		{
			if(item.getDelivery()!=null && !item.getDelivery().equals(""))
			{
				vheaders.add(item);
			}
		}
		POHeader[] itemHeader=new POHeader[vheaders.size()];
		int idx=0;
		for(POHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public POHeader getPOHeaderBelumApproved(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		POHeader header=getPOHeader(nobukti,startDate,endDate,filter);
		POHeader[] headers=header.getHeaders();
		Vector<POHeader> vheaders=new Vector<POHeader>();
		for(POHeader item : headers)
		{
			if(item.getApprovedby()==null || item.getApprovedby().equals(""))
			{
				vheaders.add(item);
			}
		}
		POHeader[] itemHeader=new POHeader[vheaders.size()];
		int idx=0;
		for(POHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public POHeader getPOHeaderSudahApproved(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		POHeader header=getPOHeader(nobukti,startDate,endDate,filter);
		POHeader[] headers=header.getHeaders();
		Vector<POHeader> vheaders=new Vector<POHeader>();
		for(POHeader item : headers)
		{
			if(item.getApprovedby()!=null && !item.getApprovedby().equals(""))
			{
				vheaders.add(item);
			}
		}
		POHeader[] itemHeader=new POHeader[vheaders.size()];
		int idx=0;
		for(POHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
}
