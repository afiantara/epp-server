package da.inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Gudang {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Gudang.class);
	public Gudang() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.Gudang[] getGudang() throws DAException
	{
		sf.inventory.Gudang[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mgudang where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.inventory.Gudang[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.inventory.Gudang item=new sf.inventory.Gudang();
				item.setKgudang(v.get(0).toString());
				item.setAlamat1(v.get(1).toString());
				item.setAlamat2(v.get(2).toString());
				item.setAlamat3(v.get(3).toString());
				item.setKota(v.get(4).toString());
				item.setKodepos(v.get(5).toString());
				item.setNotelp(v.get(6).toString());
				item.setNofax(v.get(7).toString());
				item.setKepgudang(v.get(8).toString());
				item.setRecstatus(v.get(9).toString());
				item.setTglupdate(Long.parseLong(v.get(10).toString()));
				item.setUserupdate(v.get(11).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	@SuppressWarnings("unchecked")
	public sf.inventory.Gudang getGudang(String kgudang) throws DAException
	{
		sf.inventory.Gudang item=new sf.inventory.Gudang();
		try
		{
			String strSQL="SELECT * FROM mgudang where recstatus<>? and kgudang=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kgudang);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				
				item.setKgudang(v.get(0).toString());
				item.setAlamat1(v.get(1).toString());
				item.setAlamat2(v.get(2).toString());
				item.setAlamat3(v.get(3).toString());
				item.setKota(v.get(4).toString());
				item.setKodepos(v.get(5).toString());
				item.setNotelp(v.get(6).toString());
				item.setNofax(v.get(7).toString());
				item.setKepgudang(v.get(8).toString());
				item.setRecstatus(v.get(9).toString());
				item.setTglupdate(Long.parseLong(v.get(10).toString()));
				item.setUserupdate(v.get(11).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	
	public boolean insertGudang(sf.inventory.Gudang gudang) throws DAException
	{
		if(gudang.checkIsNULL())
		{
			throw new DAException(gudang.getErr());
		}
		
		String strSQL="INSERT INTO mgudang values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, gudang.getKgudang());
			p.setString(2, gudang.getAlamat1());
			p.setString(3, gudang.getAlamat2());
			p.setString(4, gudang.getAlamat3());
			p.setString(5, gudang.getKota());
			p.setString(6, gudang.getKodepos());
			p.setString(7, gudang.getNotelp());
			p.setString(8, gudang.getNofax());
			p.setString(9, gudang.getKepgudang());
			p.setString(10, gudang.getRecstatus());
			p.setLong(11, gudang.getTglupdate());
			p.setString(12, gudang.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateGudang(sf.inventory.Gudang gudang) throws DAException
	{
		if(gudang.checkIsNULL())
		{
			throw new DAException(gudang.getErr());
		}
		
		String strSQL="UPDATE mgudang SET alamat1=?,alamat2=?,alamat3=?,kota=?,kodepos=?," +
				"notelp=?,nofax=?,kepgudang=?,recstatus=?,tglupdate=?,userupdate=? where kgudang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, gudang.getAlamat1());
			p.setString(2, gudang.getAlamat2());
			p.setString(3, gudang.getAlamat3());
			p.setString(4, gudang.getKota());
			p.setString(5, gudang.getKodepos());
			p.setString(6, gudang.getNotelp());
			p.setString(7, gudang.getNofax());
			p.setString(8, gudang.getKepgudang());
			p.setString(9, gudang.getRecstatus());
			p.setLong(10, gudang.getTglupdate());
			p.setString(11, gudang.getUserupdate());
			p.setString(12, gudang.getKgudang());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteGudang(String kgudang) throws DAException
	{
		String strSQL="DELETE FROM mgudang where kgudang=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kgudang);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	
}
