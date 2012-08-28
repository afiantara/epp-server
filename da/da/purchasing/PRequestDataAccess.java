package da.purchasing;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.purchasing.PRDetail;
import sf.purchasing.PRHeader;
import da.error.DAException;
import da.factory.DBEngine;

public class PRequestDataAccess {
	private DBEngine db=null;
	static final Category log = Category.getInstance(PRequestDataAccess.class);
	
	public PRequestDataAccess() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public int getNoPR() throws DAException
	{
		String strSQL="SELECT COUNT(*) from prequest_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean isNoPRExist(PRHeader header)
	{
		boolean isExist=false;
		
		try {
			String strSQL="SELECT count(*) FROM prequest_header where nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getNobukti());
			Vector rows = db.getData(p);
			Vector v=(Vector)rows.get(0);
			if(Integer.parseInt(v.get(0).toString())>0)
			{
				isExist=true;
			}
		} catch (DAException e) {
			// TODO Auto-generated catch block
			log.info("isNoPRExist->" + e.getLocalizedMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.info("isNoPRExist->" + e.getLocalizedMessage());
		}
		return isExist;
	}
	public boolean insertPR(PRHeader header,PRDetail details) throws DAException
	{
		boolean bTrue=false;
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		if(details.checkIsNULL())
		{
			throw new DAException(details.getErr());
		}
		try
		{
			if(!isNoPRExist(header))
			{
				db.getConnection().setAutoCommit(false);
				String strSQL="INSERT INTO prequest_header values (?,?,?,?,?,?,?,?,?,?,?)";
				log.info("insertPR-> " + strSQL);
				PreparedStatement p=db.getStatement(strSQL);
				p.setString(1, header.getNobukti());
				p.setString(2, header.getTglbukti());
				p.setString(3, header.getKcompany());
				p.setString(4, header.getKeterangan());
				p.setString(5, header.getApprovedby());
				p.setString(6, header.getApprovedtgl());
				p.setString(7, header.getRecstatus());
				p.setString(8, header.getUserinput());
				p.setLong(9, header.getTglinput());
				p.setLong(10, header.getTglupdate());
				p.setString(11, header.getUserupdate());
				db.execute(p);
			}
			insertPRequestDetail(details);
			db.commit();
			bTrue=true;
		}
		catch (Exception ex)
		{
			try {
				db.getConnection().rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DAException(e.getMessage());
			}
			throw new DAException(ex.getMessage());
		}
		return bTrue;
	}
	public boolean insertPR(PRHeader header,PRDetail[] details) throws DAException
	{
		boolean bTrue=false;
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		for(int i=0; i < details.length;i++)
		{
			if(details[i].checkIsNULL())
				throw new DAException(details[i].getErr());
		}
		try
		{
			db.getConnection().setAutoCommit(false);
			if(!isNoPRExist(header))
			{
				String strSQL="INSERT INTO prequest_header values (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement p=db.getStatement(strSQL);
				p.setString(1, header.getNobukti());
				p.setString(2, header.getTglbukti());
				p.setString(3, header.getKcompany());
				p.setString(4, header.getKeterangan());
				p.setString(5, header.getApprovedby());
				p.setString(6, header.getApprovedtgl());
				p.setString(7, header.getRecstatus());
				p.setString(8, header.getUserinput());
				p.setLong(9, header.getTglinput());
				p.setLong(10, header.getTglupdate());
				p.setString(11, header.getUserupdate());
				db.execute(p);
			}
			for(int i=0; i < details.length;i++)
			{
				PRDetail detail = details[i];
				if(detail!=null)
				{
					insertPRequestDetail(detail);
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
				throw new DAException(e.getMessage());
			}
			throw new DAException(ex.getMessage());
		}
		return bTrue;
	}
	
	public boolean updatePR(PRHeader header,PRDetail details) throws DAException
	{
		try
		{
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updatePRHeader(header))
			{
				if(!updatePRequestDetail(details))
				{
					bRet=false;
				}
			}
			else
				bRet=false;
			
			
			if(bRet)
				db.getConnection().commit();
			else
				db.getConnection().rollback();
			return bRet;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	public boolean updatePR(PRHeader header,PRDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updatePRHeader(header))
			{
				if(removePRDetail(header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						PRDetail detail = details[i];
						bRet=insertPRequestDetail(detail);
						if(!bRet)
							break;
					}
				}
			}
			else
				bRet=false;
			if(bRet)
				db.getConnection().commit();
			else
				db.getConnection().rollback();
			return bRet;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	public boolean deletePR(PRHeader  header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="UPDATE prequest_header set recstatus=?,userupdate=?,tglupdate=? where nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, header.getUserupdate());
			p.setLong(3, header.getTglupdate());
			p.setString(4, header.getNobukti());
			db.execute(p);
			strSQL="UPDATE  prequest_detail set recstatus=?,userupdate=?,tglupdate=? where nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, header.getUserupdate());
			p.setLong(3, header.getTglupdate());
			p.setString(4, header.getNobukti());
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
	
	public PRHeader[] getPRequestHeaderByNoBukti(String noBukti) throws DAException
	{
		PRHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM prequest_header where recstatus<>? and nobukti=? order by nobukti asc";
			p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, noBukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PRHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PRHeader header=new PRHeader();
				header.setNobukti(v.get(0).toString());
				header.setTglbukti(v.get(1).toString());
				header.setKcompany(v.get(2).toString());
				header.setKeterangan(v.get(3).toString());
				header.setApprovedby(v.get(4).toString());
				header.setApprovedtgl(v.get(5).toString());
				header.setRecstatus(v.get(6).toString());
				header.setUserinput(v.get(7).toString());
				header.setTglinput(Long.parseLong(v.get(8).toString()));
				header.setTglupdate(Long.parseLong(v.get(9).toString()));
				header.setUserupdate(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public PRHeader[] getPRequestHeaderByTglBukti(String tanggal) throws DAException
	{
		PRHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM prequest_header where recstatus<>? and tglbukti=? order by nobukti asc";
			p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, tanggal);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PRHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PRHeader header=new PRHeader();
				header.setNobukti(v.get(0).toString());
				header.setTglbukti(v.get(1).toString());
				header.setKcompany(v.get(2).toString());
				header.setKeterangan(v.get(3).toString());
				header.setApprovedby(v.get(4).toString());
				header.setApprovedtgl(v.get(5).toString());
				header.setRecstatus(v.get(6).toString());
				header.setUserinput(v.get(7).toString());
				header.setTglinput(Long.parseLong(v.get(8).toString()));
				header.setTglupdate(Long.parseLong(v.get(9).toString()));
				header.setUserupdate(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public PRHeader[] getPRequestHeader(String startDate,String endDate,int filter) throws DAException
	{
		PRHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(filter==0)
			{
				String strSQL="SELECT * FROM prequest_header where recstatus<>? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, "D");
			}
			else
			{
				String strSQL="SELECT * FROM prequest_header where tglbukti between ? and ? and recstatus<> ? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, startDate);
				p.setString(2, endDate);
				p.setString(3, "D");
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PRHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PRHeader header=new PRHeader();
				header.setNobukti(v.get(0).toString());
				header.setTglbukti(v.get(1).toString());
				header.setKcompany(v.get(2).toString());
				header.setKeterangan(v.get(3).toString());
				header.setApprovedby(v.get(4).toString());
				header.setApprovedtgl(v.get(5).toString());
				header.setRecstatus(v.get(6).toString());
				header.setUserinput(v.get(7).toString());
				header.setTglinput(Long.parseLong(v.get(8).toString()));
				header.setTglupdate(Long.parseLong(v.get(9).toString()));
				header.setUserupdate(v.get(10).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public PRDetail[] getPRequestDetail(PRHeader header) throws DAException
	{
		PRDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT a.*,b.nbarang,b.satuan,b.satuan1,b.satuan2,b.hppnval,b.qty1,b.qty2 FROM prequest_detail a,mproduk b where a.kbarang=b.kbarang and a.kcompany=b.kcompany and  a.nobukti=? and a.recstatus<>?";
			log.info("getPRequestDetail->strSQL->" + strSQL + "[0]" +  header.getNobukti());
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getNobukti());
			p.setString(2, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new PRDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				PRDetail item=new PRDetail();
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
				item.setNopo(v.get(11).toString());
				item.setNobukti1(v.get(12).toString());
				item.setKet(v.get(13).toString());
				item.setKcompany(v.get(14).toString());
				item.setRecstatus(v.get(15).toString());
				item.setUserinput(v.get(16).toString());
				item.setTglinput(Long.parseLong(v.get(17).toString()));
				item.setTglupdate(Long.parseLong(v.get(18).toString()));
				item.setUserupdate(v.get(19).toString());
				item.setNbarang(v.get(20).toString());
				String satuan =v.get(21).toString();
				String satuan1 =v.get(22).toString();
				String satuan2 =v.get(23).toString();
				double hargaPokok =Double.parseDouble(v.get(24).toString());
				double qty1=Double.parseDouble(v.get(25).toString());
				double qty2=Double.parseDouble(v.get(26).toString());
				if(item.getSatuan().equals(satuan))
				{
					item.setNvaluta(hargaPokok);
				}
				else if(item.getSatuan().equals(satuan1))
				{
					item.setNvaluta(hargaPokok*qty1);
				}
				else if(item.getSatuan().equals(satuan2))
				{
					item.setNvaluta(hargaPokok*qty2);
				}
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertPRequestDetail(PRDetail detail) throws DAException
	{
		try
		{
			String strSQL="INSERT INTO prequest_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			log.info("insertPRequestDetail->strSQl->" + strSQL);
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
			
			p.setString(12, detail.getNopo());
			p.setString(13, detail.getNobukti1());
			p.setString(14, detail.getKet());
			p.setString(15, detail.getKcompany());
			p.setString(16, detail.getRecstatus());
			p.setString(17, detail.getUserinput());
			p.setLong(18, detail.getTglinput());
			p.setLong(19, detail.getTglupdate());
			p.setString(20, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			log.info(ex.getLocalizedMessage());
		}
		return false;
	}
	
	public boolean updatePRequestDetail(PRDetail detail) throws DAException
	{
		try
		{
			String strSQL="UPDATE prequest_detail set tglbukti=?,kbarang=?,satuan=?,kgroup=?,jumlah=?,jumlah1=?,jumlah2=?,kvaluta=?,nvaluta=?,pdisc=?,nopo=?,nobukti1=?,ket=?,kcompany=?,recstatus=?,tglupdate=?,userupdate=? where nobukti=?";
			log.info("updatePRequestDetail->" + strSQL);
			log.info("updatePRequestDetail-> " +  detail.getNobukti() + ",[0]:" + detail.getKbarang() + ",[1]: " + detail.getSatuan());
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getTglbukti());
			p.setString(2, detail.getKbarang());
			p.setString(3, detail.getSatuan());
			p.setString(4, detail.getKgroup());
			p.setDouble(5, detail.getJumlah());
			p.setDouble(6, detail.getJumlah1());
			p.setDouble(7, detail.getJumlah2());
			p.setString(8, detail.getKvaluta());
			p.setDouble(9, detail.getNvaluta());
			p.setDouble(10, detail.getPdisc());
			
			p.setString(11, detail.getNopo());
			p.setString(12, detail.getNobukti1());
			p.setString(13, detail.getKet());
			p.setString(14, detail.getKcompany());
			p.setString(15, detail.getRecstatus());
			p.setLong(16, detail.getTglupdate());
			p.setString(17, detail.getUserupdate());
			p.setString(18, detail.getNobukti());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			log.info(ex.getLocalizedMessage());
		}
		return false;
	}
	
	public boolean deletePRequestDetail(PRDetail detail) throws DAException
	{
		try
		{
			String strSQL="UPDATE prequest_detail set recstatus=? where nobukti=? and kbarang=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, detail.getNobukti());
			p.setString(3, detail.getKbarang());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	public boolean updatePRHeader(PRHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE prequest_header SET tglbukti=?,kcompany=?,keterangan=?,approvedby=?,approvedtgl=?,recstatus=?,tglupdate=?,userupdate=? where nobukti=?";
		log.info("updatePRHeader->strSQl->" + strSQL);
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getTglbukti());
			p.setString(2, header.getKcompany());
			p.setString(3, header.getKeterangan());
			p.setString(4, header.getApprovedby());
			p.setString(5, header.getApprovedtgl());
			p.setString(6, header.getRecstatus());
			p.setLong(7, header.getTglupdate());
			p.setString(8, header.getUserupdate());
			p.setString(9, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	private boolean removePRDetail(String nobukti)
	{
		try {
			String strSQL="DELETE FROM prequest_detail where nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, nobukti);
			db.execute(p);
			return true;
		} catch (DAException e) {
			// TODO Auto-generated catch block
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return false;
	}
}
