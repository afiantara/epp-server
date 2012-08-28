package da.purchasing;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.purchasing.PIHeader;
import sf.purchasing.PReturDetail;
import sf.purchasing.PReturHeader;
import da.error.DAException;
import da.factory.DBEngine;

public class ReturDA {
	private DBEngine db=null;
	static final Category log = Category.getInstance(ReturDA.class);
	
	public ReturDA() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public int getNoPR() throws DAException
	{
		String strSQL="SELECT COUNT(*) from preturn_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public String checkPRExist(String noPR) throws DAException
	{
		
		try {
			String strSQL="SELECT nobukti from preturn_header where nobukti=?";
			log.info(strSQL + "[" + noPR + "]");
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, noPR);
			
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
	
	private boolean removePRDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM preturn_detail where kcabang=? and nobukti=?";
			log.info("removePIDetail->" + strSQL + "[0]" + kcabang + ",[1]" + nobukti);
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			db.execute(p);
			return true;
		} catch (DAException e) {
			// TODO Auto-generated catch block
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return false;
	}
	
	private boolean updatePRHeader(sf.purchasing.PReturHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE preturn_header SET tglbukti=?,kgudang=?,nopi=?,kvendor=?,kvaluta=?," +
				"kenappn=?,disc1=?,noref=?,apposting=? where kcabang=?and nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getTglbukti());
			p.setString(2, header.getKgudang());					
			p.setString(3, header.getNopi());
			p.setString(4, header.getKvendor());
			p.setString(5, header.getKvaluta());
			p.setString(6, header.getKenappn());
			p.setDouble(7, header.getDisc1());
			p.setString(8, header.getNoref());
			p.setString(9, header.getApposting());
			p.setString(10, header.getKcabang());
			p.setString(11, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	private boolean insertPRDetail(sf.purchasing.PReturDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO preturn_detail values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setString(3, detail.getKbarang());
			p.setInt(4, detail.getNourut());
			p.setDouble(5, detail.getJumlah());			
			p.setDouble(6, detail.getNvaluta());
			p.setDouble(7, detail.getDisc2());
			p.setString(8, detail.getKgroup());
			p.setString(9, detail.getKgroup1());
			p.setString(10, detail.getKgroup2());						
			p.setString(11, detail.getRecstatus());
			p.setLong(12, detail.getTglupdate());			
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	public boolean updatePR(sf.purchasing.PReturHeader header,sf.purchasing.PReturDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			//db.getConnection().setAutoCommit(false);
			if(updatePRHeader(header))
			{
				if(removePRDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						PReturDetail dtail = details[i];
						bRet=insertPRDetail(dtail);
						if(!bRet)
							break;
					}
				}
			}
			else
				bRet=false;
			if(!bRet)
				db.getConnection().rollback();
				//db.getConnection().commit();
			return bRet;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public boolean insertPR(PReturHeader header,PReturDetail[] details) throws DAException
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
			String strSQL="INSERT INTO preturn_header values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getNopi());			
			p.setString(6, header.getKvendor());
			p.setString(7, header.getKvaluta());
			p.setString(8, header.getKenappn());
			p.setDouble(9, header.getDisc1());
			p.setString(10, header.getNoref());
			p.setString(11, header.getApposting());					
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				PReturDetail detail = details[i];
				if(detail!=null)
				{
					bTrue=insertPRDetail(detail);
					if(!bTrue)
						break;
				}
			}
			
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
	
	public PReturHeader[] getPRHeader(String kcabang,String startDate,String endDate) throws DAException
	{
		PReturHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL = null;
			strSQL="SELECT * FROM preturn_header";
			if(!kcabang.equals(""))
			{
				strSQL+=" where kcabang=?";
			}
			
			if(!startDate.equals("") && !endDate.equals(""))
			{
				if(strSQL.indexOf("where")>=0)
					strSQL+=" and tglbukti between ? and ?";
				else
					strSQL+=" where tglbukti between ? and ?";
			}
			else
			{
				if(!startDate.equals(""))
				{
					if(strSQL.indexOf("where")>=0)
						strSQL+=" and tglbukti = ?";
					else
						strSQL+=" where tglbukti = ?";
						
				}
				if(!endDate.equals(""))
				{
					if(strSQL.indexOf("where")>=0)
						strSQL+=" and tglbukti = ?";
					else
						strSQL+=" where tglbukti = ?";
				}
			}
			
			log.info("getPRHeader->SQL:" + strSQL + "[1]" + kcabang + ",[2]" + startDate + ",[3]" + endDate);
			
			p=db.getStatement(strSQL);
			
			if(!kcabang.equals(""))
			{
				p.setString(1, kcabang);
			}
			
			if(!startDate.equals("") && !endDate.equals(""))
			{
				p.setString(2, startDate);
				p.setString(3, endDate);
			}
			else
			{
				if(!startDate.equals(""))
				{
					p.setString(2, startDate);
					
				}
				if(!endDate.equals(""))
				{
					p.setString(2, endDate);
				}
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PReturHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PReturHeader header=new PReturHeader();			
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setTglbukti(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setNopi(v.get(4).toString());
				header.setKvendor(v.get(5).toString());
				header.setKvaluta(v.get(6).toString());
				header.setKenappn(v.get(7).toString());	
				header.setDisc1(Double.parseDouble(v.get(8).toString()));
				header.setNoref(v.get(9).toString());
				header.setApposting(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public PReturDetail[] getPRDetail(PReturHeader header) throws DAException
	{
		PReturDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM preturn_detail where kcabang=? and nobukti=?";
			log.info("getPRDetail->strSQL->" + strSQL + "[0]" + header.getKcabang() + ",[1]" + header.getNobukti());
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PReturDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PReturDetail item=new PReturDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setKbarang(v.get(2).toString());
				item.setNourut(Integer.parseInt(v.get(3).toString()));
				item.setJumlah(Double.parseDouble(v.get(4).toString()));				
				item.setNvaluta(Double.parseDouble(v.get(5).toString()));
				item.setDisc2(Double.parseDouble(v.get(6).toString()));
				item.setKgroup(v.get(7).toString());
				item.setKgroup1(v.get(8).toString());
				item.setKgroup2(v.get(9).toString());		
				item.setRecstatus(v.get(10).toString());
				item.setTglupdate(Long.parseLong(v.get(11).toString()));
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	
	public PIHeader[] getPIHeader() throws DAException
	{
		PIHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL = null;
			int idx=1;
			strSQL="SELECT * FROM pinvoice_header order by nobukti asc" ;
			log.info("getPIHeader->SQL:" + strSQL);
			p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PIHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PIHeader header=new PIHeader();			
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setTglbukti(v.get(2).toString());
				header.setTgljtempo(v.get(3).toString());
				header.setKvendor(v.get(4).toString());
				header.setKvaluta(v.get(5).toString());
				header.setKenappn(v.get(6).toString());
				header.setDisc1(Double.parseDouble(v.get(7).toString()));
				header.setNoref(v.get(8).toString());
				header.setKcabang1(v.get(9).toString());
				header.setApposting(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
		

	
	public boolean deletePR(sf.purchasing.PReturHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM preturn_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM preturn_detail where kcabang=? and nobukti=?"; 
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
	
}
