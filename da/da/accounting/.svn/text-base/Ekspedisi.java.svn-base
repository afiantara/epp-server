package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.accounting.Expedisi;
import da.error.DAException;
import da.factory.DBEngine;

public class Ekspedisi {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Ekspedisi.class);
	
	public Ekspedisi() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public Expedisi[] getEkspedisi() throws DAException
	{
		sf.accounting.Expedisi[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM mexpedisi where recstatus<>'D'";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.accounting.Expedisi[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Expedisi item=new sf.accounting.Expedisi();
				item.setKexpedisi(v.get(0).toString());
				item.setNexpedisi(v.get(1).toString());
				item.setAlamat1(v.get(2).toString());
				item.setAlamat2(v.get(3).toString());
				item.setAlamat3(v.get(4).toString());
				item.setKota(v.get(5).toString());
				item.setKodepos(v.get(6).toString());
				item.setKodevia(v.get(7).toString());
				item.setEmail(v.get(8).toString());
				item.setNotelp(v.get(9).toString());
				item.setNofax(v.get(10).toString());
				item.setKontak1(v.get(11).toString());
				item.setKontak2(v.get(12).toString());
				item.setNohp1(v.get(13).toString());
				item.setNohp2(v.get(14).toString());
				item.setRecstatus(v.get(15).toString());
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
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
	public Expedisi getEkspedisi(String kode) throws DAException
	{
		sf.accounting.Expedisi item=new sf.accounting.Expedisi();
		try
		{
			String strSQL="SELECT * FROM mexpedisi where recstatus<>? and kexpedisi=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kode);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				
				item.setKexpedisi(v.get(0).toString());
				item.setNexpedisi(v.get(1).toString());
				item.setAlamat1(v.get(2).toString());
				item.setAlamat2(v.get(3).toString());
				item.setAlamat3(v.get(4).toString());
				item.setKota(v.get(5).toString());
				item.setKodepos(v.get(6).toString());
				item.setKodevia(v.get(7).toString());
				item.setEmail(v.get(8).toString());
				item.setNotelp(v.get(9).toString());
				item.setNofax(v.get(10).toString());
				item.setKontak1(v.get(11).toString());
				item.setKontak2(v.get(12).toString());
				item.setNohp1(v.get(13).toString());
				item.setNohp2(v.get(14).toString());
				item.setRecstatus(v.get(15).toString());
				item.setTglupdate(Long.parseLong(v.get(16).toString()));
				item.setUserupdate(v.get(17).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	public boolean insertEkspedisi(Expedisi eks) throws DAException
	{
		if(eks.checkIsNULL())
		{
			throw new DAException(eks.getErr());
		}
		
		String strSQL="INSERT INTO mexpedisi values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, eks.getKexpedisi());
			p.setString(2, eks.getNexpedisi());
			p.setString(3, eks.getAlamat1());
			p.setString(4, eks.getAlamat2());
			p.setString(5, eks.getAlamat3());
			p.setString(6, eks.getKota());
			p.setString(7, eks.getKodepos());
			p.setString(8, eks.getKodevia());
			p.setString(9, eks.getEmail());
			p.setString(10, eks.getNotelp());
			p.setString(11, eks.getNofax());
			p.setString(12, eks.getKontak1());
			p.setString(13, eks.getKontak2());
			p.setString(14, eks.getNohp1());
			p.setString(15, eks.getNohp2());
			p.setString(16, eks.getRecstatus());
			p.setLong(17, eks.getTglupdate());
			p.setString(18, eks.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateEkspedisi(Expedisi eks) throws DAException
	{
		if(eks.checkIsNULL())
		{
			throw new DAException(eks.getErr());
		}
		
		String strSQL="UPDATE mexpedisi set nexpedisi=?,alamat1=?," +
				"alamat2=?,alamat3=?,kota=?,kodepos=?,kodevia=?,email=?,notelp=?," +
				"nofax=?,kontak1=?,kontak2=?,nohp1=?,nohp2=?,recstatus=?,tglupdate=?,userupdate=? where kexpedisi=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, eks.getNexpedisi());
			p.setString(2, eks.getAlamat1());
			p.setString(3, eks.getAlamat2());
			p.setString(4, eks.getAlamat3());
			p.setString(5, eks.getKota());
			p.setString(6, eks.getKodepos());
			p.setString(7, eks.getKodevia());
			p.setString(8, eks.getEmail());
			p.setString(9, eks.getNotelp());
			p.setString(10, eks.getNofax());
			p.setString(11, eks.getKontak1());
			p.setString(12, eks.getKontak2());
			p.setString(13, eks.getNohp1());
			p.setString(14, eks.getNohp2());
			p.setString(15, eks.getRecstatus());
			p.setLong(16, eks.getTglupdate());
			p.setString(17, eks.getUserupdate());
			p.setString(18, eks.getKexpedisi());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteEkspedisi(String kexpedisi) throws DAException
	{
		String strSQL="DELETE FROM mexpedisi where kexpedisi=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kexpedisi);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
