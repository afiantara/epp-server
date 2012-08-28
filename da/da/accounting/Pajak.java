package da.accounting;

import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Pajak {
	
	private DBEngine db=null;
	static final Category log = Category.getInstance(Pajak.class);
	
	public Pajak() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.Pajak[] getPajak() throws DAException
	{
		sf.accounting.Pajak[] items=null;
		try
		{
			String strSQL="SELECT * FROM mtpajak";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.accounting.Pajak[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Pajak item=new sf.accounting.Pajak();
				
				item.setKode(v.get(0).toString());
				item.setKeterangan(v.get(1).toString());
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
}
