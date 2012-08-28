package bo.purchasing;

import sf.purchasing.ShippingUpload;
import da.error.DAException;
import da.purchasing.ShippingUploadDA;

public class ShippingUploadBO {
	
	private ShippingUploadDA sda;
	
	public ShippingUploadBO() throws DAException
	{
		sda=new ShippingUploadDA();
	}
	public boolean insertUploadPS(ShippingUpload[] items) throws DAException
	{
	return sda.insertUploadPS(items);	
	}
	public boolean deleteUploadPS()throws DAException
	{
		return sda.deleteUploadPS();
	}
}
