package da.purchasing;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.purchasing.PODetail;
import sf.purchasing.POHeader;
import da.error.DAException;
import da.factory.DBEngine;

public class PODataAccess {
	private DBEngine db=null;
	static final Category log = Category.getInstance(PODataAccess.class);
	
	public PODataAccess() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public int getNoPO() throws DAException
	{
		String strSQL="SELECT COUNT(*) from porder_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public String checkPOExist(String noPO) throws DAException
	{
		
		try {
			String strSQL="SELECT nobukti from porder_header where nobukti=?";
			log.info(strSQL + "[" + noPO + "]");
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, noPO);
			
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
	
	private boolean removePODetail(String nobukti)
	{
		try {
			String strSQL="UPDATE porder_header SET recstatus=? where nobukti=?";
			log.info("removePODetail->" + strSQL + "[0]" + nobukti);
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "U");
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
	
	private boolean updatePOHeader(sf.purchasing.POHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE porder_header SET tglbukti=?,kvendor=?,kcompany=?,jtempo=?,keterangan=?," +
				"approvedby=?,approvatedtgl=?,recstatus=?,tglupdate=?,userupdate=?, where nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getTglBukti());
			p.setString(2, header.getKvendor());
			p.setString(3, header.getKcompany());
			p.setDouble(4, header.getJtempo());
			p.setString(5, header.getKeterangan());
			p.setString(6, header.getApprovedby());
			p.setString(7, header.getApprovedtgl());
			p.setString(8, header.getRecstatus());
			p.setLong(9, header.getTglupdate());
			p.setString(10, header.getUserupdate());
			p.setString(10, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	private boolean insertPODetail(sf.purchasing.PODetail detail)
	{
		try
		{
			String strSQL="INSERT INTO porder_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getNobukti());
			p.setString(2, detail.getTglbukti());
			p.setString(3, detail.getKbarang());
			p.setString(4, detail.getSatuan());
			p.setString(5, detail.getKgroup());
			p.setDouble(6, detail.getJumlah());
			p.setDouble(7, detail.getJumlah1());
			p.setDouble(8, detail.getJumlah2());
			p.setString(9, detail.getKvaluta());
			p.setDouble(10, detail.getNvaluta());
			p.setDouble(11, detail.getPdisc());
			p.setString(12, detail.getNodelivery());
			p.setString(13, detail.getNopr());
			p.setString(14, detail.getNobukti1());
			p.setString(15, detail.getKet());
			p.setString(16, detail.getKcompany());
			p.setString(17, detail.getRecstatus());
			p.setString(18, detail.getUserinput());
			p.setLong(19, detail.getTglinput());
			p.setLong(20, detail.getTglupdate());
			p.setString(21, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	public boolean updatePO(sf.purchasing.POHeader header,sf.purchasing.PODetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			//db.getConnection().setAutoCommit(false);
			if(updatePOHeader(header))
			{
				if(removePODetail(header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						PODetail dtail = details[i];
						bRet=insertPODetail(dtail);
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
	
	public boolean insertPO(POHeader header,PODetail[] details) throws DAException
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
			String strSQL="INSERT INTO porder_header values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getNobukti());
			p.setString(2, header.getTglBukti());
			p.setString(3, header.getKvendor());
			p.setString(4, header.getKcompany());
			p.setDouble(5, header.getJtempo());
			p.setString(6, header.getKeterangan());
			p.setString(7, header.getApprovedby());
			p.setString(8, header.getApprovedtgl());
			p.setString(9, header.getRecstatus());
			p.setString(10, header.getUserinput());
			p.setLong(11, header.getTglinput());
			p.setLong(12, header.getTglupdate());
			p.setString(13, header.getUserupdate());
			
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				PODetail detail = details[i];
				if(detail!=null)
				{
					if(!(bTrue=insertPODetail(detail)))
					{
						db.getConnection().rollback();
					}
				}
			}
			db.commit();
			bTrue=true;
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
	
	public POHeader[] getPOHeader(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		POHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL = null;
			int idx=1;
			if(filter==0)
			{
				strSQL="SELECT * FROM porder_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				strSQL="SELECT a.* FROM porder_header a,porder_detail b where a.nobukti=b.nobukti" ;
				if(!nobukti.equals(""))
				{
					strSQL+=" and a.nobukti=?";
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
				else
				{
					strSQL+=" and (b.noso='' or b.noso is null)";
				}
			}
			log.error("getPOHeader->SQL:" + strSQL);
			p=db.getStatement(strSQL);
			if(!nobukti.equals(""))
			{
				p.setString(idx, nobukti);
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
			items = new POHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				POHeader header=new POHeader();
				
				header.setNobukti(v.get(0).toString());
				header.setTglBukti(v.get(1).toString());
				header.setKvendor(v.get(2).toString());
				header.setKcompany(v.get(3).toString());
				header.setJtempo(Double.parseDouble(v.get(4).toString()));
				header.setKeterangan(v.get(5).toString());
				header.setApprovedby(v.get(6).toString());
				header.setApprovedtgl(v.get(7).toString());
				header.setRecstatus(v.get(8).toString());
				header.setUserinput(v.get(9).toString());
				header.setTglinput(Long.parseLong(v.get(10).toString()));
				header.setTglupdate(Long.parseLong(v.get(11).toString()));
				header.setUserupdate(v.get(12).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public POHeader[] getPOHeaderByTglBukti(String tglBukti) throws DAException
	{
		POHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL = null;
			
			strSQL="SELECT * FROM porder_header where tglbukti=? order by nobukti asc";
			p=db.getStatement(strSQL);
			log.info("getPOHeader->SQL:" + strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, tglBukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new POHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				POHeader header=new POHeader();
				
				header.setNobukti(v.get(0).toString());
				header.setTglBukti(v.get(1).toString());
				header.setKvendor(v.get(2).toString());
				header.setKcompany(v.get(3).toString());
				header.setJtempo(Double.parseDouble(v.get(4).toString()));
				header.setKeterangan(v.get(5).toString());
				header.setApprovedby(v.get(6).toString());
				header.setApprovedtgl(v.get(7).toString());
				header.setRecstatus(v.get(8).toString());
				header.setUserinput(v.get(9).toString());
				header.setTglinput(Long.parseLong(v.get(10).toString()));
				header.setTglupdate(Long.parseLong(v.get(11).toString()));
				header.setUserupdate(v.get(12).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public PODetail[] getPODetail(POHeader header) throws DAException
	{
		PODetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM porder_detail where nobukti=?";
			log.info("getPODetail->strSQL->" + strSQL + "[0]" + header.getNobukti());
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getNobukti());
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PODetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PODetail item=new PODetail();
				item.setNobukti(v.get(0).toString());
				item.setTglbukti(v.get(1).toString());
				item.setKbarang(v.get(2).toString());
				item.setSatuan(v.get(3).toString());
				item.setKgroup(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setJumlah1(Double.parseDouble(v.get(6).toString()));
				item.setJumlah2(Double.parseDouble(v.get(7).toString()));
				item.setKvaluta(v.get(8).toString());
				item.setNvaluta(Double.parseDouble(v.get(9).toString()));
				item.setPdisc(Double.parseDouble(v.get(10).toString()));
				item.setNodelivery(v.get(11).toString());
				item.setNopr(v.get(12).toString());
				item.setNobukti1(v.get(13).toString());
				item.setKet(v.get(14).toString());
				item.setKcompany(v.get(15).toString());
				item.setRecstatus(v.get(16).toString());
				item.setUserinput(v.get(17).toString());
				item.setTglinput(Long.parseLong(v.get(18).toString()));
				item.setTglupdate(Long.parseLong(v.get(19).toString()));
				item.setUserupdate(v.get(20).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean deletePO(sf.purchasing.POHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="UPDATE porder_header set recstatus=? where nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "U");
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="UPDATE porder_detail set recstatus=? where nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, "U");
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
