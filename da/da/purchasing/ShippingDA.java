package da.purchasing;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.accounting.Account;
import sf.purchasing.BiayaShipping;
import sf.purchasing.POHeader;
import sf.purchasing.ShippingDetail;
import sf.purchasing.ShippingHeader;
import sf.purchasing.ShippingUpload;
import sf.purchasing.SptBShipping;
import tools.Tools;
import da.accounting.COA;
import da.error.DAException;
import da.factory.DBEngine;

public class ShippingDA {
	private DBEngine db=null;
	static final Category log = Category.getInstance(ShippingDA.class);
	
	public ShippingDA() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public int getNoShipping() throws DAException
	{
		String strSQL="SELECT COUNT(*) from pshipping_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	private boolean isBiayaShippingExist(String nobukti)
	{
		String strSQL="SELECT COUNT(*) from biaya_shipping where nobukti=?";
		try {
			PreparedStatement p;
			try {
				p = db.getStatement(strSQL);
				p=db.getStatement(strSQL);
				p.setString(1, nobukti);
				Vector rows = db.getData(strSQL);
				Vector v=(Vector)rows.get(0);
				return Integer.parseInt(v.get(0).toString())>0 ? true : false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
		} catch (DAException e) {
			// TODO Auto-generated catch block
			
		}
		return false;
	}
	
	private int getNoUrutMax()
	{
		try {
			String strSQL="SELECT max(nourut) from pshipping_detail";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return 0;
	}
	public String checkShippingExist(String noShipping) throws DAException
	{
		
		try {
			String strSQL="SELECT nobukti from pshipping_header where nobukti=?";
			log.info(strSQL + "[" + noShipping + "]");
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, noShipping);
			
			Vector rows = db.getData(p);
			Vector v=(Vector)rows.get(0);
			return v.get(0).toString();
		} catch (DAException e) {
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return "";
	}
	
	private boolean removeShippingDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM pshipping_detail where kcabang=? and nobukti=?";
			log.info("removeShippingDetail->" + strSQL + "[0]" + kcabang + ",[1]" + nobukti);
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			db.execute(p);
			return true;
		} catch (DAException e) {
			// TODO Auto-generated catch block
			log.error("-ERR-removeShippingDetail->" + e.getLocalizedMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("-ERR-removeShippingDetail->" + e.getLocalizedMessage());
		}
		return false;
	}
	
	private boolean updateShippingHeader(sf.purchasing.ShippingHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE pshipping_header SET kvendor=?,kvaluta=?,kenappn=?,disc1=?,kgberat=?," +
				"kirimvia=?,kexpedisi=?,noref=? where kcabang=? and nobukti=? and tglbukti=?";
		
		log.info("-updateShippingHeader->SQL: " + strSQL);
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKvendor());
			p.setString(2, header.getKvaluta());
			p.setString(3, header.getKenappn());
			p.setDouble(4, header.getDisc1());
			p.setDouble(5, header.getKgberat());
			p.setString(6, header.getKirimvia());
			p.setString(7, header.getKexpedisi());
			p.setString(8, header.getNoref());
			p.setString(9, header.getKcabang());
			p.setString(10, header.getNobukti());
			p.setString(11, header.getTglbukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("-ERR-updateShippingHeader->" + e.getLocalizedMessage());
			throw new DAException(e.getMessage());
		}
	}
	
	private boolean insertShippingDetail(sf.purchasing.ShippingDetail detail)
	{
		String strSQL="INSERT INTO pshipping_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		log.info("-insertShippingDetail->SQL: " + strSQL);
		try
		{
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setString(3, detail.getKbarang());
			p.setInt(4, detail.getNourut());
			p.setDouble(5, detail.getJumlah());
			p.setDouble(6, detail.getJumlah1());
			p.setDouble(7, detail.getJumlah2());
			p.setDouble(8, detail.getNvaluta());
			p.setDouble(9, detail.getDisc2());
			p.setString(10, detail.getKgroup());
			p.setString(11, detail.getKgroup1());
			p.setString(12, detail.getKgroup2());
			p.setString(13, detail.getNoso());
			p.setString(14, detail.getNopo());
			p.setString(15, detail.getNopd());
			p.setString(16, detail.getTgltiba());
			p.setString(17, detail.getKeterangan());
			p.setString(18, detail.getRecstatus());
			p.setLong(19, detail.getTglupdate());
			p.setString(20, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			log.error("-ERR-insertShippingDetail->SQL: " + strSQL);
		}
		return false;
	}
	public boolean updateShipping(sf.purchasing.ShippingHeader header,sf.purchasing.ShippingDetail[] details,BiayaShipping[] biaya,SptBShipping[] spt) throws DAException
	{
		try
		{
			log.info("-start updateShipping");
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updateShippingHeader(header))
			{
				if(removeShippingDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						ShippingDetail dtail = details[i];
						bRet=insertShippingDetail(dtail);
						if(!bRet)
							break;
					}
				}
				if(bRet)
				{
					if(deleteBiayaShipping(header.getKcabang(), header.getNobukti()))
					{
						bRet=insertBiayaShipping(biaya);
					}
				}
				
				if(bRet)
				{
					if(deleteSPTBiaya(header.getKcabang(), header.getNobukti()))
					{
						bRet=insertSPTBiaya(spt);
					}
				}
			}
			else
				bRet=false;
			if(!bRet)
				db.getConnection().rollback();
			else
				db.getConnection().commit();
			
			log.info("-end updateShipping");
			return bRet;
		}
		catch(Exception ex)
		{
			log.error("-ERR- updateShipping->" + ex.getLocalizedMessage());
			return false;
		}
	}
	
	public boolean insertShipping(ShippingHeader header,ShippingDetail[] details,BiayaShipping[] biaya,SptBShipping[] spt) throws DAException
	{
		boolean bTrue=false;
		//saving header
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		for(int i=0; i < details.length;i++)
		{
			if(details[i]==null)
				continue;
			
			if(details[i].checkIsNULL())
				throw new DAException(details[i].getErr());
		}
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="INSERT INTO pshipping_header values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKvendor());
			p.setString(5, header.getKvaluta());
			p.setString(6, header.getKenappn());
			p.setDouble(7, header.getDisc1());
			p.setDouble(8, header.getKgberat());
			p.setString(9, header.getKirimvia());
			p.setString(10, header.getKexpedisi());
			p.setString(11, header.getNoref());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				ShippingDetail detail = details[i];
				if(detail!=null)
				{
					bTrue=insertShippingDetail(detail);
				}
			}
			if(bTrue)
				bTrue=insertBiayaShipping(biaya);
			if(bTrue)
				bTrue=insertSPTBiaya(spt);
			
			if(bTrue)
				db.getConnection().commit();
			else
				db.getConnection().rollback();
			
		}
		catch (Exception ex)
		{
			try {
				db.getConnection().rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
				throw new DAException(e.getMessage());
			}
			log.error(ex.getMessage());
			throw new DAException(ex.getMessage());
		}
		return bTrue;
	}
	
	public ShippingHeader[] getShippingHeader(String kcabang,String startDate,String endDate,int filter) throws DAException
	{
		ShippingHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL = null;
			int idx=1;
			if(filter==0)
			{
				strSQL="SELECT * FROM pshipping_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				strSQL="SELECT a.* FROM pshipping_header a,pshipping_detail b where a.nobukti=b.nobukti" ;
				if(!kcabang.equals(""))
				{
					strSQL+=" and a.kcabang=?";
				}
				
				if(!startDate.equals("") && !endDate.equals(""))
				{
					strSQL+=" and a.tglbukti between ? and ?";
					p.setString(idx, startDate);
					idx++;
					p.setString(idx, endDate);
					idx++;
				}
				else
				{
					if(!startDate.equals(""))
					{
						strSQL+=" and a.tglbukti = ?";
						p.setString(idx, startDate);
						idx++;
						
					}
					if(!endDate.equals(""))
					{
						strSQL+=" and a.tglbukti = ?";
						p.setString(idx, endDate);
						idx++;
					}
				}
				
				if(filter==1)
				{
					strSQL+=" and b.jumlah1=0";
				}
			}
			log.info("getShippingHeader->SQL:" + strSQL);
			p=db.getStatement(strSQL);
			if(!kcabang.equals(""))
			{
				p.setString(idx, kcabang);
				idx++;
			}
			
			if(!startDate.equals("") && !endDate.equals(""))
			{
				p.setString(idx, startDate);
				idx++;
				p.setString(idx, endDate);
				idx++;
			}
			else
			{
				if(!startDate.equals(""))
				{
					p.setString(idx, startDate);
					idx++;
					
				}
				if(!endDate.equals(""))
				{
					p.setString(idx, endDate);
					idx++;
				}
			}
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new ShippingHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				ShippingHeader header=new ShippingHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setTglbukti(v.get(2).toString());
				header.setKvendor(v.get(3).toString());
				header.setKvaluta(v.get(4).toString());
				header.setKenappn(v.get(5).toString());
				header.setDisc1(Double.parseDouble(v.get(6).toString()));
				header.setKgberat(Double.parseDouble(v.get(7).toString()));
				header.setKirimvia(v.get(8).toString());
				header.setKexpedisi(v.get(9).toString());
				header.setNoref(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public ShippingDetail[] getShippingDetail(ShippingHeader header) throws DAException
	{
		ShippingDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM pshipping_detail where kcabang=? and nobukti=?";
			log.info("getShippingDetail->strSQL->" + strSQL + "[0]" + header.getKcabang() + ",[1]" + header.getNobukti());
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new ShippingDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				ShippingDetail item=new ShippingDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setKbarang(v.get(2).toString());
				item.setNourut(Integer.parseInt(v.get(3).toString()));
				item.setJumlah(Double.parseDouble(v.get(4).toString()));
				item.setJumlah1(Double.parseDouble(v.get(5).toString()));
				item.setJumlah2(Double.parseDouble(v.get(6).toString()));
				item.setNvaluta(Double.parseDouble(v.get(7).toString()));
				item.setDisc2(Double.parseDouble(v.get(8).toString()));
				item.setKgroup(v.get(9).toString());
				item.setKgroup1(v.get(10).toString());
				item.setKgroup2(v.get(11).toString());
				item.setNoso(v.get(12).toString());
				item.setNopo(v.get(13).toString());
				item.setNopd(v.get(14).toString());
				item.setTgltiba(v.get(15).toString());
				item.setKeterangan(v.get(16).toString());
				item.setRecstatus(v.get(17).toString());
				item.setTglupdate(Long.parseLong(v.get(18).toString()));
				item.setUserupdate(v.get(19).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public BiayaShipping[] getBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		BiayaShipping[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT a.*,b.accdesc FROM biaya_shipping a,maccount b where a.accno=b.accno and a.kcabang=? and a.nobukti=?";
			log.info("getBiayaShipping->SQL:" + strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new BiayaShipping[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				BiayaShipping header=new BiayaShipping();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setAccno(v.get(2).toString());
				header.setAcclevel(v.get(3).toString());
				header.setAccbudget(Double.parseDouble(v.get(4).toString()));
				header.setAccrealisasi(Double.parseDouble(v.get(5).toString()));
				header.setRefno(v.get(6).toString());
				header.setNopo(v.get(7).toString());
				header.setUserupdate(v.get(8).toString());
				header.setTglupdate(Long.parseLong(v.get(9).toString()));
				header.setAccdesc(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			//throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public SptBShipping[] getSPTBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		SptBShipping[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM spt_bshipping where kcabang=? and nobukti=?";
			log.info("getSPTBiayaShipping->SQL:" + strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new SptBShipping[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				SptBShipping header=new SptBShipping();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setNospt(v.get(2).toString());
				header.setPbiaya(Double.parseDouble(v.get(3).toString()));
				header.setUserupdate(v.get(5).toString());
				header.setTglupdate(Long.parseLong(v.get(6).toString()));
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			//throw new DAException (ex.getLocalizedMessage());
			log.error("-ERR-getSPTBiayaShipping->" + ex.getLocalizedMessage());
		}
		
		return items;
	}
	public boolean deleteShipping(sf.purchasing.ShippingHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM pshipping_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM pshipping_detail where kcabang=? and nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM biaya_shipping where kcabang=? and nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM spt_bshipping where kcabang=? and nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			db.getConnection().commit();
			return true;
		}
		catch(Exception ex)
		{
			try
			{
				db.getConnection().rollback();
			}
			catch(Exception e)
			{
				
			}
		}
		return false;
	}
	
	public boolean insertBiayaShipping(BiayaShipping[] bs) throws DAException
	{
		boolean bTrue=true;
				
		for(int i=0; i < bs.length;i++)
		{
			if(bs[i]==null)
				continue;
			try
			{
				//db.getConnection().setAutoCommit(false);
				BiayaShipping item = bs[i];
				String strSQL="INSERT INTO biaya_shipping values (?,?,?,?,?,?,?,?,?,?)";
				log.info("-insertBiayaShipping->SQL: " + strSQL);
				PreparedStatement p=db.getStatement(strSQL);
				p.setString(1, item.getKcabang());
				p.setString(2, item.getNobukti());
				p.setString(3, item.getAccno());
				p.setString(4, item.getAcclevel());
				p.setDouble(5, item.getAccbudget());
				p.setDouble(6, item.getAccrealisasi());
				p.setString(7, item.getRefno());
				p.setString(8, item.getNopo());
				p.setString(9, item.getUserupdate());
				p.setLong(10, item.getTglupdate());
				db.execute(p);
			}
			catch (Exception ex)
			{
				bTrue=false;
				try {
					db.getConnection().rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					log.error(e.getMessage());
					throw new DAException(e.getMessage());
				}
				log.error(ex.getMessage());
				throw new DAException(ex.getMessage());
			}
		}
		return bTrue;
	}
	
	public boolean deleteBiayaShipping(String kcabang,String nobukti,String accno) throws DAException
	{
		try
		{
			String strSQL="DELETE FROM biaya_shipping where kcabang=? and nobukti=? and accno=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			p.setString(3, accno);
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
		}
		return false;
	}
	
	public  boolean deleteBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		String strSQL="DELETE FROM biaya_shipping where kcabang=? and nobukti=?";
		log.info("-deleteBiayaShipping->SQL: " + strSQL);
		try
		{
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			log.error("-ERR-deleteBiayaShipping->SQL: " + strSQL);
		}
		return false;
	}
	
	
	public boolean insertSPTBiaya(SptBShipping[] spt) throws DAException
	{
		try
		{
			for(int i=0; i < spt.length;i++)
			{
				String strSQL="INSERT INTO spt_bshipping values (?,?,?,?,?,?,?)";
				log.info("-insertSPTBiaya->SQL: " + strSQL);
				PreparedStatement p=db.getStatement(strSQL);
				p.setString(1, spt[i].getKcabang());
				p.setString(2, spt[i].getNobukti());
				p.setString(3, spt[i].getNospt());
				p.setDouble(4, spt[i].getPbiaya());
				p.setString(5, spt[i].getRefno());
				p.setString(6, spt[i].getUserupdate());
				p.setString(7, String.valueOf(spt[i].getTglupdate()));
				db.execute(p);
			}
			return true;
		}
		catch(Exception ex)
		{
			log.info("-ERR-insertSPTBiaya-> " + ex.getLocalizedMessage());
		}
		return false;
	}
	
	public boolean updateSPTBiaya(SptBShipping spt) throws DAException
	{
		try
		{
			String strSQL="UPDATE spt_bshipping set pbiaya=?,refno=?,userid=?,userupdate=? where kbarang=? and nobukti=? and nospt=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setDouble(1, spt.getPbiaya());
			p.setString(2, spt.getRefno());
			p.setString(3, spt.getUserupdate());
			p.setLong(4, spt.getTglupdate());
			p.setString(5, spt.getKcabang());
			p.setString(6, spt.getNobukti());
			p.setString(7, spt.getNospt());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	public boolean deleteSPTBiaya(SptBShipping spt) throws DAException
	{
		try
		{
			String strSQL="DELETE FROM spt_bshipping where kcabang=? and nobukti=? and nospt=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, spt.getKcabang());
			p.setString(2, spt.getNobukti());
			p.setString(3, spt.getNospt());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	private boolean deleteSPTBiaya(String kcabang, String nobukti) throws DAException
	{
		String strSQL="DELETE FROM spt_bshipping where kcabang=? and nobukti=?";
		log.info("-deleteSPTBiaya->SQL: " + strSQL);
		try
		{
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			log.error("-ERR-deleteSPTBiaya->SQL: " + strSQL);
		}
		return false;
	}
	
	private boolean removeShippingUpload()
	{
		String strSQL="DELETE from pshipping_upload";
		try {
			db.execute(strSQL);
			return true;
		} catch (DAException e) {
			// TODO Auto-generated catch block
		}
		return false;
	}
	public int getAvailUpload() throws DAException
	{
		String strSQL="SELECT COUNT(*) from pshipping_upload";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
		}
		return 0;
	}
	
	public boolean uploadPS(ShippingUpload[] su)
	{
		try
		{
			for(int i=0; i < su.length;i++)
			{
				String strSQL="INSERT INTO pshipping_upload values (?,?,?,?,?,?,?,?,?)";
				log.info("-uploadPS->SQL: " + strSQL);
				PreparedStatement p=db.getStatement(strSQL);
				p.setString(1, su[i].getNoShipping());
				p.setString(2, su[i].getTglShipping());
				p.setString(3, su[i].getKbarang());
				p.setDouble(4, su[i].getJumlah());
				p.setString(5, su[i].getKirimvia());
				p.setString(6, su[i].getKexpedisi());
				p.setDouble(7, su[i].getKgberat());
				p.setString(8, su[i].getTgltiba());
				p.setString(9, su[i].getKeterangan());
				db.execute(p);
			}
			return true;
		}
		catch(Exception ex)
		{
			log.info("-ERR-uploadPS-> " + ex.getLocalizedMessage());
		}
		return false;
	}
	
	
	public boolean saveUpload(POHeader header,String user) throws DAException
	{
		Vector<ShippingUpload> shippingno=new Vector<ShippingUpload>();
		try {
			String strSQL="SELECT * from pshipping_upload";
			PreparedStatement p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				ShippingUpload su=new ShippingUpload();
				Vector v=(Vector)rows.get(i);
				su.setNoShipping( v.get(0).toString());
				su.setTglShipping(v.get(1).toString());
				su.setKbarang(v.get(2).toString());
				su.setJumlah(Double.parseDouble(v.get(3).toString()));
				su.setKirimvia(v.get(4).toString());
				su.setKexpedisi(v.get(5).toString());
				su.setKgberat(Double.parseDouble(v.get(6).toString()));
				su.setTgltiba(v.get(7).toString());
				su.setKeterangan(v.get(8).toString());
				shippingno.add(su);
			}
			
			int maxNoUrut=getNoUrutMax();
			Vector<BiayaShipping> vbiaya=new Vector<BiayaShipping>();
			for(ShippingUpload su : shippingno)
			{
				if(checkShippingExist(su.getNoShipping()).equals(""))
				{
					//insert ke pshipping_header
					/*
					ShippingHeader psHeader=new ShippingHeader();
					psHeader.setKcabang(header.getKcabang());
					psHeader.setNobukti(su.getNoShipping());
					psHeader.setTglbukti(su.getTglShipping());
					psHeader.setKvendor(header.getKvendor());
					psHeader.setKvaluta(header.getKvaluta());
					psHeader.setKenappn(header.getKenappn());
					psHeader.setDisc1(header.getDisc1());
					psHeader.setKgberat(su.getKgberat());
					psHeader.setKirimvia(su.getKirimvia());
					psHeader.setKexpedisi(su.getKexpedisi());
					psHeader.setNoref(header.getNoref());
					insertShippingHeader(psHeader);
					*/
				}
				//insert ke pshipping_detail
				ShippingDetail detail=new ShippingDetail();
				/*
				detail.setKcabang(header.getKcabang());
				detail.setNobukti(su.getNoShipping());
				detail.setKbarang(su.getKbarang());
				detail.setNourut(maxNoUrut++);
				detail.setJumlah(su.getJumlah());
				detail.setJumlah1(0);
				detail.setJumlah2(su.getJumlah());
				detail.setNvaluta(0);
				detail.setDisc2(0);
				detail.setKgroup("");
				detail.setKgroup1("");
				detail.setKgroup2("");
				detail.setNoso("");
				detail.setNopo(header.getNobukti());
				detail.setNopd("");
				detail.setTgltiba(su.getTgltiba());
				detail.setKeterangan(su.getKeterangan());
				detail.setRecstatus("U");
				detail.setTglupdate(Long.parseLong(Tools.convertDate(new Date(), "yyyyMMdd")));
				detail.setUserupdate(user);
				insertShippingDetail(detail);
				*/
				if(!isBiayaShippingExist(su.getNoShipping()))
				{
					
					Account[] accts = getAccounts();
					if(accts!=null)
					{
						BiayaShipping[] bs = new BiayaShipping[accts.length];
						for (int i=0; i < accts.length;i++)
						{
							/*
							bs[i]=new BiayaShipping();
							bs[i].setKcabang(header.getKcabang());
							bs[i].setNobukti(su.getNoShipping());
							bs[i].setNopo(header.getNobukti());
							bs[i].setRefno(header.getNoref());
							bs[i].setRecstatus("U");
							bs[i].setTglupdate(Long.parseLong(Tools.convertDate(new Date(), "yyyyMMdd")));
							bs[i].setUserupdate(user);
							bs[i].setAccno(accts[i].getAccno());
							bs[i].setAccdesc(accts[i].getAccdesc());
							bs[i].setAcclevel(accts[i].getAcclevel());
							bs[i].setAccrealisasi(0);
							bs[i].setAccbudget(0);
							*/
						}
						insertBiayaShipping(bs);
					}
				}
			}
			removeShippingUpload();
			
		} catch (DAException e) {
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return false;
	}
	
	private Account[] getAccounts() throws DAException
	{
		da.accounting.COA coa= new COA();
		Account[] accts=coa.getAccountByLevel("D");
		return accts;
	}
	private boolean insertShippingHeader(ShippingHeader header)
	{
		if(header.checkIsNULL())
		{
			return false;
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="INSERT INTO pshipping_header values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKvendor());
			p.setString(5, header.getKvaluta());
			p.setString(6, header.getKenappn());
			p.setDouble(7, header.getDisc1());
			p.setDouble(8, header.getKgberat());
			p.setString(9, header.getKirimvia());
			p.setString(10, header.getKexpedisi());
			p.setString(11, header.getNoref());
			db.execute(p);
			return true;
		}
		catch (Exception ex){
			
		}
		return false;
	}
}
