package da.purchasing;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.purchasing.PDDetail;
import sf.purchasing.PDHeader;
import da.error.DAException;
import da.factory.DBEngine;

public class PDDataAccess {
	private DBEngine db=null;
	static final Category log = Category.getInstance(PDDataAccess.class);
	
	public PDDataAccess() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public int getNoPD() throws DAException
	{
		String strSQL="SELECT COUNT(*) from pdelivery_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public String checkPDExist(String noPD) throws DAException
	{
		
		try {
			String strSQL="SELECT nobukti from pdelivery_header where nobukti=?";
			log.info(strSQL + "[" + noPD + "]");
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, noPD);
			
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
	
	private boolean removePDDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM pdelivery_detail where kcabang=? and nobukti=?";
			log.info("removeShippingDetail->" + strSQL + "[0]" + kcabang + ",[1]" + nobukti);
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
	
	private boolean updatePDHeader(sf.purchasing.PDHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE pdelivery_header SET tglbukti=?,kgudang=?,kvendor=?,kvaluta=?," +
				"kenappn=?,disc1=?,noref=? where kcabang=? and nobukti=?";
		
		log.info("updatePDHeader->strSQL:" + strSQL);
		
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getTglbukti());
			p.setString(2, header.getKgudang());
			p.setString(3, header.getKvendor());
			p.setString(4, header.getKvaluta());
			p.setString(5, header.getKenappn());
			p.setDouble(6, header.getDisc1());
			p.setString(7, header.getNoref());
			p.setString(8, header.getKcabang());
			p.setString(9, header.getNobukti());						
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info("updatePDHeader->ERR:" + e.getLocalizedMessage());
			throw new DAException(e.getMessage());
		}
	}
	
	private boolean insertPDDetail(sf.purchasing.PDDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO pdelivery_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			log.info("insertPDDetail->strSQL" + strSQL);
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
			p.setString(14, detail.getNops());
			p.setString(15, detail.getNopi());			
			p.setString(16, detail.getKeterangan());
			p.setString(17, detail.getRecstatus());
			p.setLong(18, detail.getTglupdate());
			p.setString(19, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	public boolean updatePD(sf.purchasing.PDHeader header,sf.purchasing.PDDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			//db.getConnection().setAutoCommit(false);
			if(updatePDHeader(header))
			{
				if(removePDDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						PDDetail dtail = details[i];
						bRet=insertPDDetail(dtail);
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
	
	public boolean insertPD(PDHeader header,PDDetail[] details) throws DAException
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
			String strSQL="INSERT INTO pdelivery_header values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getKvendor());
			p.setString(6, header.getKvaluta());
			p.setString(7, header.getKenappn());
			p.setDouble(8, header.getDisc1());			
			p.setString(9, header.getNoref());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				PDDetail detail = details[i];
				if(detail!=null)
				{
					bTrue=insertPDDetail(detail);
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
	
	public PDHeader[] getPDHeader(String kcabang,String startDate,String endDate,int filter) throws DAException
	{
		PDHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL = null;
			int idx=1;
			if(filter==0)
			{
				strSQL="SELECT * FROM pdelivery_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				strSQL="SELECT a.* FROM pdelivery_header a,pdelivery_detail b where a.nobukti=b.nobukti" ;
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
			log.info("getPDHeader->SQL:" + strSQL);
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
			items = new PDHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PDHeader header=new PDHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setTglbukti(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setKvendor(v.get(4).toString());
				header.setKvaluta(v.get(5).toString());
				header.setKenappn(v.get(6).toString());
				header.setDisc1(Double.parseDouble(v.get(7).toString()));
				header.setNoref(v.get(8).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public PDDetail[] getPDDetail(PDHeader header) throws DAException
	{
		PDDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM pdelivery_detail where kcabang=? and nobukti=?";
			log.info("getPDDetail->strSQL->" + strSQL + "[0]" + header.getKcabang() + ",[1]" + header.getNobukti());
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PDDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PDDetail item=new PDDetail();
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
				item.setNops(v.get(13).toString());
				item.setNopi(v.get(14).toString());
				item.setKeterangan(v.get(15).toString());
				item.setRecstatus(v.get(16).toString());
				item.setTglupdate(Long.parseLong(v.get(17).toString()));
				item.setUserupdate(v.get(18).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean deletePD(sf.purchasing.PDHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM pdelivery_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM pdelivery_detail where kcabang=? and nobukti=?"; 
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
