package da.accounting;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Invoice {
	
	private DBEngine db=null;
	static final Category log = Category.getInstance(Invoice.class);
	
	public Invoice() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.accounting.Invoice[] getInvoices() throws DAException
	{
		sf.accounting.Invoice[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM minvoice where recstatus<>?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.accounting.Invoice[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.accounting.Invoice item=new sf.accounting.Invoice();
				item.setKinvoice(v.get(0).toString());
				item.setKeterangan(v.get(1).toString());
				item.setKenappn(v.get(2).toString());
				item.setKonfirmppn(v.get(3).toString());
				item.setAccpiutang(v.get(4).toString());
				item.setAccsales(v.get(5).toString());
				item.setAccdp(v.get(6).toString());
				item.setAccppn(v.get(7).toString());
				item.setDireksi(v.get(8).toString());
				
				item.setRecstatus(v.get(9).toString());
				item.setUserinput(v.get(10).toString());
				item.setTglinput(Long.parseLong(v.get(11).toString()));
				item.setTglupdate(Long.parseLong(v.get(12).toString()));
				item.setUserupdate(v.get(13).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertInvoice(sf.accounting.Invoice inv) throws DAException
	{
		if(inv.checkIsNULL())
		{
			throw new DAException(inv.getErr());
		}
		
		String strSQL="INSERT INTO minvoice values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, inv.getKinvoice());
			p.setString(2, inv.getKeterangan());
			p.setString(3, inv.getKenappn());
			p.setString(4, inv.getKonfirmppn());
			p.setString(5, inv.getAccpiutang());
			p.setString(6, inv.getAccsales());
			p.setString(7, inv.getAccdp());
			p.setString(8, inv.getAccppn());
			p.setString(9, inv.getDireksi());
			p.setString(10, inv.getRecstatus());
			p.setString(11, inv.getUserinput());
			p.setLong(12, inv.getTglinput());
			p.setLong(13, inv.getTglupdate());
			p.setString(14, inv.getUserupdate());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateInvoice(sf.accounting.Invoice inv) throws DAException
	{
		if(inv.checkIsNULL())
		{
			throw new DAException(inv.getErr());
		}
		
		String strSQL="UPDATE minvoice set keterangan=?,kenappn=?,konfirmppn=?,accpiutang=?,accsales=?,accdp=?,accppn=?,direksi=?,recstatus=?,tglupdate=?,userupdate=? where kinvoice=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, inv.getKeterangan());
			p.setString(2, inv.getKenappn());
			p.setString(3, inv.getKonfirmppn());
			p.setString(4, inv.getAccpiutang());
			p.setString(5, inv.getAccsales());
			p.setString(6, inv.getAccdp());
			p.setString(7, inv.getAccppn());
			p.setString(8, inv.getDireksi());
			p.setString(9, inv.getRecstatus());
			p.setLong(10, inv.getTglupdate());
			p.setString(11, inv.getUserupdate());
			p.setString(12, inv.getKinvoice());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteInvoice(String kinvoice) throws DAException
	{
		String strSQL="DELETE FROM minvoice WHERE kinvoice=?";
		try
		{
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kinvoice);
			return db.execute(p);
		}
		catch(SQLException e)
		{
			throw new DAException(e.getMessage());	
		}
	}
}
