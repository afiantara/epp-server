package da.purchasing;

import java.sql.PreparedStatement;

import org.apache.log4j.Category;

import sf.purchasing.ShippingUpload;
import da.error.DAException;
import da.factory.DBEngine;

public class ShippingUploadDA {
	private DBEngine db=null;
	static final Category log = Category.getInstance(ShippingUploadDA.class);
	
	 public ShippingUploadDA() throws DAException
	 {
		 db=new DBEngine();
		 if(!db.connect()) throw new DAException("Could not connect to database");
	 }
	 
	public boolean insertUploadPS(ShippingUpload[] items) throws DAException
	{
		try
		{
			for(int i=0; i < items.length;i++)
			{
				String strSQL="INSERT INTO pshipping_upload values (?,?,?,?,?,?,?,?,?)";
				PreparedStatement p=db.getStatement(strSQL);
				ShippingUpload item = items[i];
				p.setString(1, item.getNoShipping());
				p.setString(2, item.getTglShipping());
				p.setString(3, item.getKbarang());				
				p.setDouble(4, item.getJumlah());
				p.setString(5, item.getKirimvia());
				p.setString(6, item.getKexpedisi());
				p.setDouble(7, item.getKgberat());
				p.setString(8, item.getTgltiba());
				p.setString(9, item.getKeterangan());
				db.execute(p);
			}
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	public boolean deleteUploadPS()throws DAException
	{
		try
		{
			String strSQL="DELETE FROM pshipping_upload";
			PreparedStatement p=db.getStatement(strSQL);
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
}
