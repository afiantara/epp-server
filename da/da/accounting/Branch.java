package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;


public class Branch {
	
	private DBEngine db=null;
	static final Category log = Category.getInstance(Branch.class);
	
	public Branch() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public boolean insertBranch(sf.accounting.Branch branch) throws DAException
	{
		if(branch.checkIsNULL())
		{
			throw new DAException(branch.getErr());
		}
		
		log.info("[insertBranch]Kode Cabang: "+branch.getKcabang());
		String strSQL="INSERT INTO mcabang values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, branch.getKcabang());
			p.setString(2, branch.getAlamat1());
			p.setString(3, branch.getAlamat2());
			p.setString(4, branch.getAlamat3());
			p.setString(5, branch.getKota());
			p.setString(6, branch.getKodepos());
			p.setString(7, branch.getNotelp());
			p.setString(8, branch.getNofax());
			p.setString(9, branch.getKacab());
			p.setString(10, branch.getKgudang());
			p.setString(11, branch.getRecstatus());
			p.setLong(12, branch.getTglupdate());
			p.setString(13, branch.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateBranch(sf.accounting.Branch branch) throws DAException
	{
		if(branch.checkIsNULL())
		{
			throw new DAException(branch.getErr());
		}
		
		log.info("[updateBranch]Kode cabang: "+branch.getKcabang());
		String strSQL="UPDATE mcabang set alamat1=?,alamat2=?,alamat3=?,kota=?,kodepos=?,notelp=?,nofax=?,kacab=?,kgudang=?,recstatus=?,tglupdate=?,userupdate=? where kcabang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, branch.getAlamat1());
			p.setString(2, branch.getAlamat2());
			p.setString(3, branch.getAlamat3());
			p.setString(4, branch.getKota());
			p.setString(5, branch.getKodepos());
			p.setString(6, branch.getNotelp());
			p.setString(7, branch.getNofax());
			p.setString(8, branch.getKacab());
			p.setString(9, branch.getKgudang());
			p.setString(10, branch.getRecstatus());
			p.setLong(11, branch.getTglupdate());
			p.setString(12, branch.getUserupdate());
			p.setString(13, branch.getKcabang());

			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteBranch(sf.accounting.Branch branch) throws DAException
	{
		log.info("[deleteBranch]Kode cabang: "+branch.getKcabang());
		String strSQL="UPDATE mcabang set recstatus=?,tglupdate=?,userupdate=? where kcabang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, branch.getRecstatus());
			p.setLong(2, branch.getTglupdate());
			p.setString(3, branch.getUserupdate());
			p.setString(4, branch.getKcabang());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.Branch[] getBranch() throws DAException
	{
		//Vector<sf.accounting.Branch> items=new Vector<sf.accounting.Branch>();
		sf.accounting.Branch[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mcabang where recstatus<>'D'";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.accounting.Branch[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Branch item=new sf.accounting.Branch();
				item.setKcabang(v.get(0).toString());
				item.setAlamat1(v.get(1).toString());
				item.setAlamat2(v.get(2).toString());
				item.setAlamat3(v.get(3).toString());
				item.setKota(v.get(4).toString());
				item.setKodepos(v.get(5).toString());
				item.setNotelp(v.get(6).toString());
				item.setNofax(v.get(7).toString());
				item.setKacab(v.get(8).toString());
				item.setKgudang(v.get(9).toString());
				item.setRecstatus(v.get(10).toString());
				item.setTglupdate(Long.parseLong(v.get(11).toString()));
				item.setUserupdate(v.get(12).toString());
				items[i] = item;
				//items.add(item);
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.accounting.Branch[] getBranch(String kodeCabang) throws DAException
	{
		//Vector<sf.accounting.Branch> items=new Vector<sf.accounting.Branch>();
		sf.accounting.Branch[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mcabang where recstatus<>'D' and kcabang='" + kodeCabang+ "'";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.accounting.Branch[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Branch item=new sf.accounting.Branch();
				item.setKcabang(v.get(0).toString());
				item.setAlamat1(v.get(1).toString());
				item.setAlamat2(v.get(2).toString());
				item.setAlamat3(v.get(3).toString());
				item.setKota(v.get(4).toString());
				item.setKodepos(v.get(5).toString());
				item.setNotelp(v.get(6).toString());
				item.setNofax(v.get(7).toString());
				item.setKacab(v.get(8).toString());
				item.setKgudang(v.get(9).toString());
				item.setRecstatus(v.get(10).toString());
				item.setTglupdate(Long.parseLong(v.get(11).toString()));
				item.setUserupdate(v.get(12).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
}
