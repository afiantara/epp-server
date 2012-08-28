package bo.purchasing;

import java.util.Vector;

import da.error.DAException;
import sf.purchasing.PRDetail;
import sf.purchasing.PRHeader;

public class PRequestBusiness {
	private da.purchasing.PRequestDataAccess daPurchase;
	
	public PRequestBusiness() throws DAException 
	{
		daPurchase=new da.purchasing.PRequestDataAccess();
	}
	
	public int getNoPR() throws DAException
	{
		return daPurchase.getNoPR();
	}
	
	public boolean insertPR(PRHeader header,PRDetail details) throws DAException
	{
		return daPurchase.insertPR(header, details);
	}
	public boolean insertPR(sf.purchasing.PRHeader header,PRDetail[] details) throws DAException
	{
		return daPurchase.insertPR(header, details);
	}
	
	public boolean updatePRHeader(PRHeader header) throws DAException
	{
		return daPurchase.updatePRHeader(header); 
	}
	public boolean updatePR(PRHeader header,PRDetail details) throws DAException
	{
		return daPurchase.updatePR(header, details);
	}
	public boolean updatePR(sf.purchasing.PRHeader header,PRDetail[] details) throws DAException
	{
		return daPurchase.updatePR(header, details);
	}
	
	public boolean deletePR(PRHeader  header) throws DAException
	{
		return daPurchase.deletePR(header);
	}
	
	public PRHeader getPRequestHeaderByNoBukti(String noBukti) throws DAException
	{
		PRHeader header = new PRHeader();
		PRHeader[] headers=daPurchase.getPRequestHeaderByNoBukti(noBukti);
		PRHeader[] itemHeader=new PRHeader[headers.length];
		int idx=0;
		for(PRHeader item : headers)
		{
			itemHeader[idx]=item;
			PRDetail[] details = daPurchase.getPRequestDetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PRDetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setPo("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPRequestHeaderByBulan(String bulan) throws DAException
	{
		PRHeader header = getPrequisitionHeader("","",0);
		PRHeader[] headers=header.getHeaders();
		PRHeader[] itemHeader=new PRHeader[headers.length];
		int idx=0;
		for(PRHeader item : headers)
		{
			String tmpbulan = item.getTglbukti().substring(4, 6); //yyyyMMdd
			
			if(!tmpbulan.equals(bulan))
				continue;
			
			itemHeader[idx]=item;
			PRDetail[] details = daPurchase.getPRequestDetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PRDetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setPo("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPRequestHeaderByTglBukti(String tanggal) throws DAException
	{
		PRHeader header = new PRHeader();
		PRHeader[] headers=daPurchase.getPRequestHeaderByTglBukti(tanggal);
		PRHeader[] itemHeader=new PRHeader[headers.length];
		int idx=0;
		for(PRHeader item : headers)
		{
			itemHeader[idx]=item;
			PRDetail[] details = daPurchase.getPRequestDetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PRDetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setPo("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPRequestHeaderByRequester(String userid) throws DAException
	{
		PRHeader header=getPrequisitionHeader("","",0);
		PRHeader[] headers=header.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : headers)
		{
			if(item.getUserinput().equals(userid))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPrequisitionHeaderBelumPO(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader header=getPrequisitionHeader(startDate,endDate,filter);
		PRHeader[] headers=header.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : headers)
		{
			if(item.getPo()==null || !item.getPo().equals("Complete"))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPrequisitionHeaderSudahPO(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader header=getPrequisitionHeader(startDate,endDate,filter);
		PRHeader[] headers=header.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : headers)
		{
			if(item.getPo()!=null && !item.getPo().equals(""))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPrequisitionHeaderBelumApproved(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader header=getPrequisitionHeader(startDate,endDate,filter);
		PRHeader[] headers=header.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : headers)
		{
			if(item.getApprovedby()==null || item.getApprovedby().equals(""))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPrequisitionHeaderSudahApproved(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader header=getPrequisitionHeader(startDate,endDate,filter);
		PRHeader[] headers=header.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : headers)
		{
			if(item.getApprovedby()!=null && !item.getApprovedby().equals(""))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPO(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader pheader=getPrequisitionHeaderSudahApproved(startDate,endDate,0);
		PRHeader[] pheaders = pheader.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : pheaders)
		{
			if(item.getPo()==null || !item.getPo().equals("Complete"))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		pheader.setHeaders(itemHeader);
		return pheader;
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPOByNoBukti(String nobukti) throws DAException
	{
		PRHeader pheader=getPrequisitionHeaderSudahApprovedBelumPO("","",0);
		PRHeader[] pheaders = pheader.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : pheaders)
		{
			if(item.getNobukti().equals(nobukti))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		pheader.setHeaders(itemHeader);
		return pheader;
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPOByTglBukti(String tglbukti) throws DAException
	{
		PRHeader pheader=getPrequisitionHeaderSudahApprovedBelumPO("","",0);
		PRHeader[] pheaders = pheader.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : pheaders)
		{
			if(item.getTglbukti().equals(tglbukti))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		pheader.setHeaders(itemHeader);
		return pheader;
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPOByBulan(String bulan) throws DAException
	{
		PRHeader pheader=getPrequisitionHeaderSudahApprovedBelumPO("","",0);
		PRHeader[] pheaders = pheader.getHeaders();
		Vector<PRHeader> vheaders=new Vector<PRHeader>();
		for(PRHeader item : pheaders)
		{
			String tmpbulan = item.getTglbukti().substring(4, 6); //yyyyMMdd
			if(tmpbulan.equals(bulan))
			{
				vheaders.add(item);
			}
		}
		PRHeader[] itemHeader=new PRHeader[vheaders.size()];
		int idx=0;
		for(PRHeader item : vheaders)
		{
			itemHeader[idx]=item;
			idx++;
		}
		pheader.setHeaders(itemHeader);
		return pheader;
	}
	public PRHeader getPrequisitionHeader(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader header = new PRHeader();
		PRHeader[] headers=daPurchase.getPRequestHeader(startDate, endDate, filter);
		PRHeader[] itemHeader=new PRHeader[headers.length];
		int idx=0;
		for(PRHeader item : headers)
		{
			itemHeader[idx]=item;
			PRDetail[] details = daPurchase.getPRequestDetail(item);
			double jumlah=0;
			double jumlah1=0;
			for(PRDetail detail :details)
			{
				jumlah+=detail.getJumlah();
				jumlah1+=detail.getJumlah1();
			}
			if(jumlah==jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Complete");
			}
			if(jumlah>jumlah1 && jumlah1>0)
			{
				itemHeader[idx].setPo("Partial");
			}
			if(jumlah1==0)
			{
				itemHeader[idx].setPo("");
			}
			idx++;
		}
		header.setHeaders(itemHeader);
		return header;
	}
	
	public PRDetail getPrequisitionDetail(PRHeader header) throws DAException
	{
		PRDetail detail = new PRDetail();
		detail.setDetails(daPurchase.getPRequestDetail(header));
		return detail;
	}
	
	public boolean insertPrequisitionDetail(PRDetail detail) throws DAException
	{
		return daPurchase.insertPRequestDetail(detail);
	}
	
	public boolean updatePrequisitionDetail(PRDetail detail) throws DAException
	{
		return daPurchase.updatePRequestDetail(detail);
	}
	
	public boolean deletePrequisitionDetail(PRDetail detail) throws DAException
	{
		return daPurchase.deletePRequestDetail(detail);
	}
}
