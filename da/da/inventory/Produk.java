package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Produk {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Produk.class);
	
	public Produk() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public sf.inventory.Produk[] getProduk(String cmpType) throws DAException
	{
		sf.inventory.Produk[] items;// new Branch[count];
		try
		{
			
			String strSQL="SELECT * FROM mproduk where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Produk[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Produk item=new sf.inventory.Produk();
				
				item.setKbarang(v.get(0).toString());
				item.setNbarang(v.get(1).toString());
				item.setSatuan(v.get(2).toString());
				item.setSatuan1(v.get(3).toString());
				item.setSatuan2( v.get(4).toString());
				item.setKgroup(v.get(5).toString());
				item.setKgroup1(v.get(6).toString());
				item.setKgroup2(v.get(7).toString());
				item.setCompanyType(v.get(8).toString());
				item.setPstatus(v.get(9).toString());
				item.setStockbal(v.get(10).toString());
				item.setPtype(v.get(11).toString());
				item.setKbarang1(v.get(12).toString());
				item.setKbarangp(v.get(13).toString());
				item.setQty1(Double.parseDouble(v.get(14).toString()));
				item.setQty2(Double.parseDouble(v.get(15).toString()));
				item.setMinstock(Double.parseDouble(v.get(16).toString()));
				item.setMaxstock(Double.parseDouble(v.get(17).toString()));
				item.setMaxDisc(Double.parseDouble(v.get(18).toString()));
				item.setHppnval(Double.parseDouble(v.get(19).toString()));
				item.setHppnval1(Double.parseDouble(v.get(20).toString()));
				item.setNvaluta(Double.parseDouble(v.get(21).toString()));
				item.setKvaluta(v.get(22).toString());
				item.setHppkval(v.get(23).toString());
				item.setHppkval1(v.get(24).toString());
				item.setDesc1(v.get(25).toString());
				item.setDesc2(v.get(26).toString());
				item.setDesc3(v.get(27).toString());
				item.setDesc4(v.get(28).toString());
				item.setDesc5(v.get(29).toString());
				item.setDesc6(v.get(30).toString());
				item.setDesc7(v.get(31).toString());
				item.setDesc8(v.get(32).toString());
				item.setDesc9(v.get(33).toString());
				item.setDesc10(v.get(34).toString());
				item.setRecstatus(v.get(35).toString());
				item.setUserinput(v.get(36).toString());
				item.setTglinput(Long.parseLong(v.get(37).toString()));
				item.setTglupdate(Long.parseLong(v.get(38).toString()));
				item.setUserupdate(v.get(39).toString());
				if(item.getPstatus().equals("C"))
					item.setPstatusdesc("Aktif");
				else
					item.setPstatusdesc("Discontinue");
				
				if(item.getStockbal().equals("Y"))
					item.setStockbaldesc("Ada");
				else 
					item.setStockbaldesc("Tidak");
				
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.inventory.PType[] getPType() throws DAException
	{
		sf.inventory.PType[] items;// new Branch[count];
		try
		{
			
			String strSQL="SELECT * FROM mtype";
			PreparedStatement p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.PType[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.PType item=new sf.inventory.PType();
				item.setKtype(v.get(0).toString());
				item.setNtype(v.get(1).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.inventory.Produk[] getProdukChild(String cmpType) throws DAException
	{
		sf.inventory.Produk[] items;
		try
		{
			String strSQL="SELECT * FROM " +  (cmpType.equals("EPP") ? "mproduk" : "wproduk") + " where pstatus=? and recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "C");
			p.setString(2, "D");
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Produk[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Produk item =new sf.inventory.Produk();
				item.setKbarang(v.get(0).toString());
				item.setNbarang(v.get(1).toString());
				item.setSatuan(v.get(2).toString());
				item.setSatuan1(v.get(3).toString());
				item.setSatuan2( v.get(4).toString());
				item.setKgroup(v.get(5).toString());
				item.setKgroup1(v.get(6).toString());
				item.setKgroup2(v.get(7).toString());
				item.setCompanyType(v.get(8).toString());
				item.setPstatus(v.get(9).toString());
				item.setStockbal(v.get(10).toString());
				item.setPtype(v.get(11).toString());
				item.setKbarang1(v.get(12).toString());
				item.setKbarangp(v.get(13).toString());
				item.setQty1(Double.parseDouble(v.get(14).toString()));
				item.setQty2(Double.parseDouble(v.get(15).toString()));
				item.setMinstock(Double.parseDouble(v.get(16).toString()));
				item.setMaxstock(Double.parseDouble(v.get(17).toString()));
				item.setMaxDisc(Double.parseDouble(v.get(18).toString()));
				item.setHppnval(Double.parseDouble(v.get(19).toString()));
				item.setHppnval1(Double.parseDouble(v.get(20).toString()));
				item.setNvaluta(Double.parseDouble(v.get(21).toString()));
				item.setKvaluta(v.get(22).toString());
				item.setHppkval(v.get(23).toString());
				item.setHppkval1(v.get(24).toString());
				item.setDesc1(v.get(25).toString());
				item.setDesc2(v.get(26).toString());
				item.setDesc3(v.get(27).toString());
				item.setDesc4(v.get(28).toString());
				item.setDesc5(v.get(29).toString());
				item.setDesc6(v.get(30).toString());
				item.setDesc7(v.get(31).toString());
				item.setDesc8(v.get(32).toString());
				item.setDesc9(v.get(33).toString());
				item.setDesc10(v.get(34).toString());
				item.setRecstatus(v.get(35).toString());
				item.setUserinput(v.get(36).toString());
				item.setTglinput(Long.parseLong(v.get(37).toString()));
				item.setTglupdate(Long.parseLong(v.get(38).toString()));
				item.setUserupdate(v.get(39).toString());
				if(item.getPstatus().equals("C"))
					item.setPstatusdesc("Aktif");
				else
					item.setPstatusdesc("Discontinue");
				
				if(item.getStockbal().equals("Y"))
					item.setStockbaldesc("Ada");
				else 
					item.setStockbaldesc("Tidak");
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.inventory.Produk[] getProduk(String kbarang,String cmpType) throws DAException
	{
		sf.inventory.Produk[] items;
		try
		{
			String strSQL="SELECT * FROM " +  (cmpType.equals("EPP") ? "mproduk" : "wproduk") + " where recstatus<>? and kbarang=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kbarang);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Produk[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Produk item =new sf.inventory.Produk();
				item.setKbarang(v.get(0).toString());
				item.setNbarang(v.get(1).toString());
				item.setSatuan(v.get(2).toString());
				item.setSatuan1(v.get(3).toString());
				item.setSatuan2( v.get(4).toString());
				item.setKgroup(v.get(5).toString());
				item.setKgroup1(v.get(6).toString());
				item.setKgroup2(v.get(7).toString());
				item.setCompanyType(v.get(8).toString());
				item.setPstatus(v.get(9).toString());
				item.setStockbal(v.get(10).toString());
				item.setPtype(v.get(11).toString());
				item.setKbarang1(v.get(12).toString());
				item.setKbarangp(v.get(13).toString());
				item.setQty1(Double.parseDouble(v.get(14).toString()));
				item.setQty2(Double.parseDouble(v.get(15).toString()));
				item.setMinstock(Double.parseDouble(v.get(16).toString()));
				item.setMaxstock(Double.parseDouble(v.get(17).toString()));
				item.setMaxDisc(Double.parseDouble(v.get(18).toString()));
				item.setHppnval(Double.parseDouble(v.get(19).toString()));
				item.setHppnval1(Double.parseDouble(v.get(20).toString()));
				item.setNvaluta(Double.parseDouble(v.get(21).toString()));
				item.setKvaluta(v.get(22).toString());
				item.setHppkval(v.get(23).toString());
				item.setHppkval1(v.get(24).toString());
				item.setDesc1(v.get(25).toString());
				item.setDesc2(v.get(26).toString());
				item.setDesc3(v.get(27).toString());
				item.setDesc4(v.get(28).toString());
				item.setDesc5(v.get(29).toString());
				item.setDesc6(v.get(30).toString());
				item.setDesc7(v.get(31).toString());
				item.setDesc8(v.get(32).toString());
				item.setDesc9(v.get(33).toString());
				item.setDesc10(v.get(34).toString());
				item.setRecstatus(v.get(35).toString());
				item.setUserinput(v.get(36).toString());
				item.setTglinput(Long.parseLong(v.get(37).toString()));
				item.setTglupdate(Long.parseLong(v.get(38).toString()));
				item.setUserupdate(v.get(39).toString());
				if(item.getPstatus().equals("C"))
					item.setPstatusdesc("Aktif");
				else
					item.setPstatusdesc("Discontinue");
				
				if(item.getStockbal().equals("Y"))
					item.setStockbaldesc("Ada");
				else 
					item.setStockbaldesc("Tidak");
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.inventory.Produk[] getProduk(String kbarang,String nbarang,String cmpType) throws DAException
	{
		sf.inventory.Produk[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM " +  (cmpType.equals("EPP") ? "mproduk" : "wproduk") + " where recstatus<>?";
			if(kbarang.equals("") || nbarang.equals(""))
			{
				strSQL+=" and kbarang like ? or nbarang like ?";
			}
			else
				strSQL+=" and kbarang like ? and nbarang like ?";
			
			log.info("getProduk->" + strSQL + "[0]" + kbarang + ",[1]" + nbarang + ",[3]" + cmpType);
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kbarang + "%");
			p.setString(3, nbarang + "%");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Produk[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Produk item=new sf.inventory.Produk();
				item.setKbarang(v.get(0).toString());
				item.setNbarang(v.get(1).toString());
				item.setSatuan(v.get(2).toString());
				item.setSatuan1(v.get(3).toString());
				item.setSatuan2( v.get(4).toString());
				item.setKgroup(v.get(5).toString());
				item.setKgroup1(v.get(6).toString());
				item.setKgroup2(v.get(7).toString());
				item.setCompanyType(v.get(8).toString());
				item.setPstatus(v.get(9).toString());
				item.setStockbal(v.get(10).toString());
				item.setPtype(v.get(11).toString());
				item.setKbarang1(v.get(12).toString());
				item.setKbarangp(v.get(13).toString());
				item.setQty1(Double.parseDouble(v.get(14).toString()));
				item.setQty2(Double.parseDouble(v.get(15).toString()));
				item.setMinstock(Double.parseDouble(v.get(16).toString()));
				item.setMaxstock(Double.parseDouble(v.get(17).toString()));
				item.setMaxDisc(Double.parseDouble(v.get(18).toString()));
				item.setHppnval(Double.parseDouble(v.get(19).toString()));
				item.setHppnval1(Double.parseDouble(v.get(20).toString()));
				item.setNvaluta(Double.parseDouble(v.get(21).toString()));
				item.setKvaluta(v.get(22).toString());
				item.setHppkval(v.get(23).toString());
				item.setHppkval1(v.get(24).toString());
				item.setDesc1(v.get(25).toString());
				item.setDesc2(v.get(26).toString());
				item.setDesc3(v.get(27).toString());
				item.setDesc4(v.get(28).toString());
				item.setDesc5(v.get(29).toString());
				item.setDesc6(v.get(30).toString());
				item.setDesc7(v.get(31).toString());
				item.setDesc8(v.get(32).toString());
				item.setDesc9(v.get(33).toString());
				item.setDesc10(v.get(34).toString());
				item.setRecstatus(v.get(35).toString());
				item.setUserinput(v.get(36).toString());
				item.setTglinput(Long.parseLong(v.get(37).toString()));
				item.setTglupdate(Long.parseLong(v.get(38).toString()));
				item.setUserupdate(v.get(39).toString());
				if(item.getPstatus().equals("C"))
					item.setPstatusdesc("Aktif");
				else
					item.setPstatusdesc("Discontinue");
				
				if(item.getStockbal().equals("Y"))
					item.setStockbaldesc("Ada");
				else 
					item.setStockbaldesc("Tidak");
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.inventory.Produk[] getProdukByGroup(String kgroup,String cmpType) throws DAException
	{
		sf.inventory.Produk[] items;// new Branch[count];
		
		try
		{
			String strSQL="SELECT * FROM " +  (cmpType.equals("EPP") ? "mproduk" : "wproduk") + " where recstatus<>? and kgroup=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kgroup);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Produk[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Produk item=new sf.inventory.Produk();
				item.setKbarang(v.get(0).toString());
				item.setNbarang(v.get(1).toString());
				item.setSatuan(v.get(2).toString());
				item.setSatuan1(v.get(3).toString());
				item.setSatuan2( v.get(4).toString());
				item.setKgroup(v.get(5).toString());
				item.setKgroup1(v.get(6).toString());
				item.setKgroup2(v.get(7).toString());
				item.setCompanyType(v.get(8).toString());
				item.setPstatus(v.get(9).toString());
				item.setStockbal(v.get(10).toString());
				item.setPtype(v.get(11).toString());
				item.setKbarang1(v.get(12).toString());
				item.setKbarangp(v.get(13).toString());
				item.setQty1(Double.parseDouble(v.get(14).toString()));
				item.setQty2(Double.parseDouble(v.get(15).toString()));
				item.setMinstock(Double.parseDouble(v.get(16).toString()));
				item.setMaxstock(Double.parseDouble(v.get(17).toString()));
				item.setMaxDisc(Double.parseDouble(v.get(18).toString()));
				item.setHppnval(Double.parseDouble(v.get(19).toString()));
				item.setHppnval1(Double.parseDouble(v.get(20).toString()));
				item.setNvaluta(Double.parseDouble(v.get(21).toString()));
				item.setKvaluta(v.get(22).toString());
				item.setHppkval(v.get(23).toString());
				item.setHppkval1(v.get(24).toString());
				item.setDesc1(v.get(25).toString());
				item.setDesc2(v.get(26).toString());
				item.setDesc3(v.get(27).toString());
				item.setDesc4(v.get(28).toString());
				item.setDesc5(v.get(29).toString());
				item.setDesc6(v.get(30).toString());
				item.setDesc7(v.get(31).toString());
				item.setDesc8(v.get(32).toString());
				item.setDesc9(v.get(33).toString());
				item.setDesc10(v.get(34).toString());
				item.setRecstatus(v.get(35).toString());
				item.setUserinput(v.get(36).toString());
				item.setTglinput(Long.parseLong(v.get(37).toString()));
				item.setTglupdate(Long.parseLong(v.get(38).toString()));
				item.setUserupdate(v.get(39).toString());
				if(item.getPstatus().equals("C"))
					item.setPstatusdesc("Aktif");
				else
					item.setPstatusdesc("Discontinue");
				
				if(item.getStockbal().equals("Y"))
					item.setStockbaldesc("Ada");
				else 
					item.setStockbaldesc("Tidak");
				
				items[i]=item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertProduk(sf.inventory.Produk produk) throws DAException
	{
		if(produk.checkIsNULL())
		{
			throw new DAException(produk.getErr());
		}
		
		String strSQL="INSERT INTO mproduk values (?,?,?,?,?,?,?,?,?,?," +
												  "?,?,?,?,?,?,?,?,?,?," +
												  "?,?,?,?,?,?,?,?,?,?," +
												  "?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, produk.getKbarang());
			p.setString(2, produk.getNbarang());
			p.setString(3, produk.getSatuan());
			p.setString(4, produk.getSatuan1());
			p.setString(5, produk.getSatuan2());
			p.setString(6, produk.getKgroup());
			p.setString(7, produk.getKgroup1());
			p.setString(8, produk.getKgroup2());
			p.setString(9, produk.getCompanyType());
			p.setString(10, produk.getPstatus());
			p.setString(11, produk.getStockbal());
			p.setString(12, produk.getPtype());
			p.setString(13, produk.getKbarang1());
			p.setString(14, produk.getKbarangp());
			p.setDouble(15, produk.getQty1());
			p.setDouble(16, produk.getQty2());
			p.setDouble(17, produk.getMinstock());
			p.setDouble(18, produk.getMaxstock());
			p.setDouble(19, produk.getMaxDisc());
			p.setDouble(20, produk.getHppnval());
			p.setDouble(21, produk.getHppnval1());
			p.setDouble(22, produk.getNvaluta());
			p.setString(23, produk.getKvaluta());
			p.setString(24, produk.getHppkval());
			p.setString(25, produk.getHppkval1());
			p.setString(26, produk.getDesc1());
			p.setString(27, produk.getDesc2());
			p.setString(28, produk.getDesc3());
			p.setString(29, produk.getDesc4());
			p.setString(30, produk.getDesc5());
			p.setString(31, produk.getDesc6());
			p.setString(32, produk.getDesc7());
			p.setString(33, produk.getDesc8());
			p.setString(34, produk.getDesc9());
			p.setString(35, produk.getDesc10());
			p.setString(36, produk.getRecstatus());
			p.setString(37, produk.getUserinput());
			p.setLong(38, produk.getTglinput());
			p.setLong(39, produk.getTglupdate());
			p.setString(40, produk.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateProduk1(sf.inventory.Produk produk) throws DAException
	{
		if(produk.checkIsNULL())
		{
			throw new DAException(produk.getErr());
		}
		String strSQL="UPDATE " +   (produk.getCompanyType().equals("EPP") ? "mproduk" : "wproduk") + " SET nbarang=?,satuan=? where kbarang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, produk.getNbarang());
			p.setString(2, produk.getSatuan());
			p.setString(3, produk.getKbarang());
			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateProduk(sf.inventory.Produk produk) throws DAException
	{
		if(produk.checkIsNULL())
		{
			throw new DAException(produk.getErr());
		}
		
		String strSQL="UPDATE mproduk SET nbarang=?,satuan=?,satuan1=?,satuan2=?,kgroup=?,kgroup1=?,kgroup2=?,kcompany=?,pstatus=?,stockbal=?," +
				"ptype=?,kbarang1=?,kbarangp=?,qty1=?,qty2=?,minstock=?,maxstock=?,maxdisc=?," +
				"hppnval=?,hppnval1=?,nvaluta=?,kvaluta=?,hppkval=?,hppkval1=?," +
				"desc1=?,desc2=?,desc3=?,desc4=?,desc5=?,desc6=?,desc7=?," +
				"desc8=?,desc9=?,desc10=?,recstatus=?,tglupdate=?,userupdate=? where kbarang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, produk.getNbarang());
			p.setString(2, produk.getSatuan());
			p.setString(3, produk.getSatuan1());
			p.setString(4, produk.getSatuan2());
			p.setString(5, produk.getKgroup());
			p.setString(6, produk.getKgroup1());
			p.setString(7, produk.getKgroup2());
			p.setString(8, produk.getCompanyType());
			p.setString(9, produk.getPstatus());
			p.setString(10, produk.getStockbal());
			p.setString(11, produk.getPtype());
			p.setString(12, produk.getKbarang1());
			p.setString(13, produk.getKbarangp());
			p.setDouble(14, produk.getQty1());
			p.setDouble(15, produk.getQty2());
			p.setDouble(16, produk.getMinstock());
			p.setDouble(17, produk.getMaxstock());
			p.setDouble(18, produk.getMaxDisc());
			p.setDouble(19, produk.getHppnval());
			p.setDouble(20, produk.getHppnval1());
			p.setDouble(21, produk.getNvaluta());
			p.setString(22, produk.getKvaluta());
			p.setString(23, produk.getHppkval());
			p.setString(24, produk.getHppkval1());
			p.setString(25, produk.getDesc1());
			p.setString(26, produk.getDesc2());
			p.setString(27, produk.getDesc3());
			p.setString(28, produk.getDesc4());
			p.setString(29, produk.getDesc5());
			p.setString(30, produk.getDesc6());
			p.setString(31, produk.getDesc7());
			p.setString(32, produk.getDesc8());
			p.setString(33, produk.getDesc9());
			p.setString(34, produk.getDesc10());
			p.setString(35, produk.getRecstatus());
			p.setLong(36, produk.getTglupdate());
			p.setString(37, produk.getUserupdate());
			p.setString(38, produk.getKbarang());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteProduk(String kproduk,String cmpType) throws DAException
	{
		String strSQL="DELETE FROM " +  (cmpType.equals("EPP") ? "mproduk" : "wproduk") + " where kbarang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kproduk);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
}
