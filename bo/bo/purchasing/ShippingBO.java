package bo.purchasing;

import sf.purchasing.BiayaShipping;
import sf.purchasing.POHeader;
import sf.purchasing.ShippingDetail;
import sf.purchasing.ShippingHeader;
import sf.purchasing.ShippingUpload;
import sf.purchasing.SptBShipping;
import da.error.DAException;
import da.purchasing.ShippingDA;;

public class ShippingBO {
	
	private ShippingDA sda;
	
	public ShippingBO() throws DAException
	{
		sda=new ShippingDA();
	}
	public int getNoShipping() throws DAException
	{
		return sda.getNoShipping();
	}
	
	public String checkShippingExist(String noShipping) throws DAException
	{
		return sda.checkShippingExist(noShipping);
	}
	
	public boolean insertShipping(ShippingHeader header,ShippingDetail[] details,BiayaShipping[] biaya,SptBShipping[] spt) throws DAException
	{
		return sda.insertShipping(header, details,biaya,spt);
	}
	
	public boolean updateShipping(sf.purchasing.ShippingHeader header,sf.purchasing.ShippingDetail[] details,BiayaShipping[] biaya,SptBShipping[] spt) throws DAException
	{
		return sda.updateShipping(header, details,biaya,spt);
	}
	
	public boolean deleteShipping(sf.purchasing.ShippingHeader header) throws DAException
	{
		return sda.deleteShipping(header);
	}
	public ShippingDetail getShippingDetail(ShippingHeader header) throws DAException
	{
		ShippingDetail detail=new ShippingDetail();
		detail.setDetails(sda.getShippingDetail(header));
		return detail;
	}
	
	public ShippingHeader getShippingHeader(String kcabang,String startDate,String endDate,int filter) throws DAException
	{
		ShippingHeader header=new ShippingHeader();
		header.setHeaders(sda.getShippingHeader(kcabang, startDate, endDate, filter));
		return header;
	}
	
	public BiayaShipping getBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		BiayaShipping header=new BiayaShipping();
		header.setBiayas(sda.getBiayaShipping(kcabang, nobukti));
		return header;
	}
	
	public SptBShipping getSPTBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		SptBShipping header=new SptBShipping();
		header.setBiayas(sda.getSPTBiayaShipping(kcabang, nobukti));
		return header;
	}
	
	public boolean insertBiayaShipping(BiayaShipping[] bs) throws DAException
	{
		return sda.insertBiayaShipping(bs);
	}
	
	public boolean deleteBiayaShipping(String kcabang,String nobukti,String accno) throws DAException
	{
		return sda.deleteBiayaShipping(kcabang, nobukti, accno);
	}
	
	public boolean insertSPTBiaya(SptBShipping[] spt) throws DAException
	{
		return sda.insertSPTBiaya(spt);
	}
	
	public boolean updateSPTBiaya(SptBShipping spt) throws DAException
	{
		return sda.updateSPTBiaya(spt);
	}
	
	public boolean deleteSPTBiaya(SptBShipping spt) throws DAException
	{
		return sda.deleteSPTBiaya(spt);
	}
	
	public int getAvailUpload() throws DAException
	{
		return sda.getAvailUpload();
	}
	
	public boolean uploadPS(ShippingUpload[] su)
	{
		return sda.uploadPS(su);
	}
	
	public boolean saveUpload(POHeader header,String user) throws DAException
	{
		return sda.saveUpload(header, user);
	}
}
