package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class HargaPokok {
	private DBEngine db=null;
	static final Category log = Category.getInstance(HargaPokok.class);
	public HargaPokok() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.HargaPokok[] getHargaPokok() throws DAException
	{
		sf.inventory.HargaPokok[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT a.*,b.nbarang,b.satuan FROM mhpokok a,mproduk b where a.recstatus<>? and a.kbarang=b.kbarang";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.HargaPokok[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.HargaPokok item=new sf.inventory.HargaPokok();
				item.setKbarang(v.get(0).toString());
				item.setKtanggal(v.get(1).toString());
				item.setKvaluta(v.get(2).toString());
				item.setNvaluta(Double.parseDouble(v.get(3).toString()));
				item.setPotongan(Double.parseDouble(v.get(4).toString()));
				
				item.setRecstatus(v.get(5).toString());
				item.setTglupdate(Long.parseLong(v.get(6).toString()));
				item.setUserupdate(v.get(7).toString());
				item.setNbarang(v.get(8).toString());
				item.setSatuan(v.get(9).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.inventory.HargaPokok getLatestHargaPokok(String kbarang,String tglBukti) throws DAException
	{
		try
		{
			String strSQL="SELECT a.*,b.nbarang,b.satuan FROM mhpokok a,mproduk b where a.recstatus<>? and a.kbarang=b.kbarang and a.kbarang=? and a.ktanggal <=? order by a.ktanggal desc LIMIT 0,1";
			log.info(strSQL + "[0]" + kbarang + ",[1]" + tglBukti );
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kbarang);
			p.setString(3, tglBukti);
			Vector rows = db.getData(p);
			Vector v=(Vector)rows.get(0);
			sf.inventory.HargaPokok item=new sf.inventory.HargaPokok();
			item.setKbarang(v.get(0).toString());
			item.setKtanggal(v.get(1).toString());
			item.setKvaluta(v.get(2).toString());
			item.setNvaluta(Double.parseDouble(v.get(3).toString()));
			item.setPotongan(Double.parseDouble(v.get(4).toString()));
			
			item.setRecstatus(v.get(5).toString());
			item.setTglupdate(Long.parseLong(v.get(6).toString()));
			item.setUserupdate(v.get(7).toString());
			item.setNbarang(v.get(8).toString());
			item.setSatuan(v.get(9).toString());
			return item;
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.HargaPokok[] getHargaPokok(String kbarang) throws DAException
	{
		sf.inventory.HargaPokok[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT a.*,b.nbarang,b.satuan FROM mhpokok a,mproduk b where a.recstatus<>? and a.kbarang=? and a.kbarang=b.kbarang";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kbarang);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.HargaPokok[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.HargaPokok item=new sf.inventory.HargaPokok();
				item.setKbarang(v.get(0).toString());
				item.setKtanggal(v.get(1).toString());
				item.setKvaluta(v.get(2).toString());
				item.setNvaluta(Double.parseDouble(v.get(3).toString()));
				item.setPotongan(Double.parseDouble(v.get(4).toString()));
				
				item.setRecstatus(v.get(5).toString());
				item.setTglupdate(Long.parseLong(v.get(6).toString()));
				item.setUserupdate(v.get(7).toString());
				item.setNbarang(v.get(8).toString());
				item.setSatuan(v.get(9).toString());
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertHargaPokok(sf.inventory.HargaPokok hj) throws DAException
	{
		if(hj.checkIsNULL())
		{
			throw new DAException(hj.getErr());
		}
		
		String strSQL="INSERT INTO mhpokok values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, hj.getKbarang());
			p.setString(2, hj.getKtanggal());
			p.setString(3, hj.getKvaluta());
			p.setDouble(4, hj.getNvaluta());
			p.setDouble(5, hj.getPotongan());
			p.setString(6, hj.getRecstatus());
			p.setString(7, hj.getUserinput());
			p.setLong(8, hj.getTglinput());
			p.setLong(9, hj.getTglupdate());
			p.setString(10, hj.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateHargaPokok(sf.inventory.HargaPokok hj) throws DAException
	{
		if(hj.checkIsNULL())
		{
			throw new DAException(hj.getErr());
		}
		
		String strSQL="UPDATE mhpokok SET ktanggal=?,kvaluta=?,nvaluta=?,potongan=?,recstatus=?,tglupdate=?,userupdate=? where kbarang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			
			p.setString(1, hj.getKtanggal());
			p.setString(2, hj.getKvaluta());
			p.setDouble(3, hj.getNvaluta());
			p.setDouble(4, hj.getPotongan());
			p.setString(5, hj.getRecstatus());
			p.setLong(6, hj.getTglupdate());
			p.setString(7, hj.getUserupdate());
			p.setString(8, hj.getKbarang());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteHargaPokok(String kbarang) throws DAException
	{
		String strSQL="DELETE FROM mhpokok where kbarang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kbarang);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
