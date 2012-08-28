package da.sales;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import org.apache.log4j.Category;

import sf.cetak.Cetak;
import sf.sales.InvoiceDetail;
import sf.sales.InvoiceGroup;
import sf.sales.QuotationDetail;
import sf.sales.QuotationGroup;
import sf.sales.ReturDetail;
import sf.sales.SOrderBiaya;
import sf.sales.SalesOrderDetail;
import sf.sales.SalesOrderGroup;
import sf.sales.StockAlokasi;
import sf.sales.StockRekap;
import sf.sales.SuratJalanDetail;
import sf.sales.SuratJalanGroup;
import da.error.DAException;
import da.factory.DBEngine;

public class Sales {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Sales.class);
	
	public Sales() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public void commit()
	{
		db.commit();
	}
	
	@SuppressWarnings("unchecked")
	public int getNoBukti() throws DAException
	{
		String strSQL="SELECT COUNT(*) from squotation_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public int getNoBuktiSO() throws DAException
	{
		String strSQL="SELECT COUNT(*) from sorder_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public int getNoBuktiRetur() throws DAException
	{
		String strSQL="SELECT COUNT(*) from sretur_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public int getNoBuktiInvoice() throws DAException
	{
		String strSQL="SELECT COUNT(*) from sinvoice_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public int getNoBuktiSDPayment() throws DAException
	{
		String strSQL="SELECT COUNT(*) from sdpayment";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public int getNoSO() throws DAException
	{
		String strSQL="SELECT COUNT(*) from sorder_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public int getNoSJ() throws DAException
	{
		String strSQL="SELECT COUNT(*) from sjalan_header";
		try {
			Vector rows = db.getData(strSQL);
			Vector v=(Vector)rows.get(0);
			return Integer.parseInt(v.get(0).toString());
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public sf.sales.SCardHeader[] getKartuService() throws DAException
	{
		sf.sales.SCardHeader[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM scard_header";
			Vector rows = db.getData(strSQL);
			int count=rows.size();
			items = new sf.sales.SCardHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SCardHeader item=new sf.sales.SCardHeader();
				item.setNoscard(v.get(0).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean updateQuotationHeader(sf.sales.QuotationHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE squotation_header SET kinvoice=?,kgudang=?,tglbukti=?,kclient=?,ksales=?," +
				"kservice=?,kvaluta=?,kkurs=?,discval=?,disc1=?,discpl=?,noscard=?,noref=?,notracking=?,kontak1=?,kontak2=?," +
				"kontak3=?,validity=?,syarat=?,kirim=?,ket1=?,ket2=?,ket3=? where kcabang=? and nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKinvoice());
			p.setString(2, header.getKgudang());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKclient());
			p.setString(5, header.getKsales());
			p.setString(6, header.getKservice());
			p.setString(7, header.getKvaluta());
			p.setDouble(8, header.getKkurs());
			p.setDouble(9, header.getDiscval());
			p.setDouble(10, header.getDisc1());
			p.setDouble(11, header.getDiscpl());
			p.setString(12, header.getNoscard());
			p.setString(13, header.getNoref());
			p.setString(14, header.getNotracking());
			p.setString(15, header.getKontak1());
			p.setString(16, header.getKontak2());
			p.setString(17, header.getKontak3());
			p.setString(18, header.getValidity());
			p.setString(19, header.getSyarat());
			p.setString(20, header.getKirim());
			p.setString(21, header.getKet1());
			p.setString(22, header.getKet2());
			p.setString(23, header.getKet3());
			p.setString(24, header.getKcabang());
			p.setString(25, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSalesOrderHeader(sf.sales.SalesOrderHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE sorder_header SET kinvoice=?,kgudang=?,tglbukti=?,kclient=?,ksales=?," +
				"kservice=?,kvaluta=?,kkurs=?,discval=?,disc1=?,discpl=?,noscard=?,notracking=?,nopocust=? where kcabang=? and nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKinvoice());
			p.setString(2, header.getKgudang());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKclient());
			p.setString(5, header.getKsales());
			p.setString(6, header.getKservice());
			p.setString(7, header.getKvaluta());
			p.setDouble(8, header.getKkurs());
			p.setDouble(9, header.getDiscval());
			p.setDouble(10, header.getDisc1());
			p.setDouble(11, header.getDiscpl());
			p.setString(12, header.getNoscard());
			p.setString(13, header.getNotracking());
			p.setString(14, header.getNopocust());
			p.setString(15, header.getKcabang());
			p.setString(16, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSuratJalanHeader(sf.sales.SuratJalanHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE sjalan_header SET kinvoice=?,kgudang=?,tglbukti=?,kclient=?,ksales=?," +
				"kservice=?,kvaluta=?,kkurs=?,discval=?,disc1=?,discpl=?,noscard=?,notracking=?,nopocust=? where kcabang=? and nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKinvoice());
			p.setString(2, header.getKgudang());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKclient());
			p.setString(5, header.getKsales());
			p.setString(6, header.getKservice());
			p.setString(7, header.getKvaluta());
			p.setDouble(8, header.getKkurs());
			p.setDouble(9, header.getDiscval());
			p.setDouble(10, header.getDisc1());
			p.setDouble(11, header.getDiscpl());
			p.setString(12, header.getNoscard());
			p.setString(13, header.getNotracking());
			p.setString(14, header.getNopocust());
			p.setString(15, header.getKcabang());
			p.setString(16, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateInvoiceHeader(sf.sales.InvoiceHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE sinvoice_header SET kinvoice=?,kgudang=?,tglbukti=?,kclient=?,ksales=?," +
				"kservice=?,kvaluta=?,kkurs=?,discval=?,disc1=?,discpl=?,noscard=?,noref=?,nopocust=?,nodpayment=? where kcabang=? and nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKinvoice());
			p.setString(2, header.getKgudang());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKclient());
			p.setString(5, header.getKsales());
			p.setString(6, header.getKservice());
			p.setString(7, header.getKvaluta());
			p.setDouble(8, header.getKkurs());
			p.setDouble(9, header.getDiscval());
			p.setDouble(10, header.getDisc1());
			p.setDouble(11, header.getDiscpl());
			p.setString(12, header.getNoscard());
			p.setString(13, header.getNoref());
			p.setString(14, header.getNopocust());
			p.setString(15, header.getNodpayment());
			p.setString(16, header.getKcabang());
			p.setString(17, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateReturHeader(sf.sales.ReturHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		String strSQL="UPDATE sretur_header SET kinvoice=?,kgudang=?,tglbukti=?,kclient=?,ksales=?," +
				"kservice=?,kvaluta=?,discval=?,disc1=?,discpl=?,noscard=?,exnoinvoice=?,ket=? where kcabang=? and nobukti=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKinvoice());
			p.setString(2, header.getKgudang());
			p.setString(3, header.getTglbukti());
			p.setString(4, header.getKclient());
			p.setString(5, header.getKsales());
			p.setString(6, header.getKservice());
			p.setString(7, header.getKvaluta());
			p.setDouble(8, header.getDiscval());
			p.setDouble(9, header.getDisc1());
			p.setDouble(10, header.getDiscpl());
			p.setString(11, header.getNoscard());
			p.setString(12, header.getExnoinvoice());
			p.setString(13, header.getKet());
			p.setString(14, header.getKcabang());
			p.setString(15, header.getNobukti());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean approved(int nourut,String kbarang,String kcabang,String nobukti,String approvedby,String approvedTgl) throws DAException
	{
		String strSQL="UPDATE squotation_detail set approvedby=?,approvedtgl=? where kcabang=? and nobukti=? and kbarang=? and nourut=?";
		log.info("approved->" + strSQL + "[1]" + approvedby + "[2]" + approvedTgl + "[3]" + kcabang + "[4]" + nobukti + "[5]" + nourut);
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, approvedby);
			p.setString(2, approvedTgl);
			p.setString(3, kcabang);
			p.setString(4, nobukti);
			p.setString(5, kbarang);
			p.setInt(6, nourut);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	public boolean updateQuotationGroup(sf.sales.QuotationGroup group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE squotation_group SET ket1=?,ket2=?,ket3=?,ket4=?," +
				"ket5=?,ket6=?,ket7=?,ket8=?,ket9=?,ket10=?,ket11=?,ket12=?,ket13=?," +
				"ket14=?,ket15=?,ket16=?,ket17=?,ket18=?,ket19=?,ket20=?,satuan=?,jumlah=? where kcabang=? and nobukti=? and grouping=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKet1());
			p.setString(2, group.getKet2());
			p.setString(3, group.getKet3());
			p.setString(4, group.getKet4());
			p.setString(5, group.getKet5());
			p.setString(6, group.getKet6());
			p.setString(7, group.getKet7());
			p.setString(8, group.getKet8());
			p.setString(9, group.getKet9());
			p.setString(10, group.getKet10());
			p.setString(11, group.getKet11());
			p.setString(12, group.getKet12());
			p.setString(13, group.getKet13());
			p.setString(14, group.getKet14());
			p.setString(15, group.getKet15());
			p.setString(16, group.getKet16());
			p.setString(17, group.getKet17());
			p.setString(18, group.getKet18());
			p.setString(19, group.getKet19());
			p.setString(20, group.getKet20());
			p.setString(21, group.getSatuan());
			p.setDouble(22, group.getJumlah());
			p.setString(23, group.getKcabang());
			p.setString(24, group.getNobukti());
			p.setString(25, group.getGrouping());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSalesOrderGroup(sf.sales.SalesOrderGroup group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE sorder_group SET ket1=?,ket2=?,ket3=?,ket4=?," +
				"ket5=?,ket6=?,ket7=?,ket8=?,ket9=?,ket10=?,ket11=?,ket12=?,ket13=?," +
				"ket14=?,ket15=?,ket16=?,ket17=?,ket18=?,ket19=?,ket20=?,satuan=?,jumlah=? where kcabang=? and nobukti=? and grouping=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKet1());
			p.setString(2, group.getKet2());
			p.setString(3, group.getKet3());
			p.setString(4, group.getKet4());
			p.setString(5, group.getKet5());
			p.setString(6, group.getKet6());
			p.setString(7, group.getKet7());
			p.setString(8, group.getKet8());
			p.setString(9, group.getKet9());
			p.setString(10, group.getKet10());
			p.setString(11, group.getKet11());
			p.setString(12, group.getKet12());
			p.setString(13, group.getKet13());
			p.setString(14, group.getKet14());
			p.setString(15, group.getKet15());
			p.setString(16, group.getKet16());
			p.setString(17, group.getKet17());
			p.setString(18, group.getKet18());
			p.setString(19, group.getKet19());
			p.setString(20, group.getKet20());
			p.setString(21, group.getSatuan());
			p.setDouble(22, group.getJumlah());
			p.setString(23, group.getKcabang());
			p.setString(24, group.getNobukti());
			p.setString(25, group.getGrouping());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSuratJalanGroup(sf.sales.SuratJalanGroup group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE sjalan_group SET ket1=?,ket2=?,ket3=?,ket4=?," +
				"ket5=?,ket6=?,ket7=?,ket8=?,ket9=?,ket10=?,ket11=?,ket12=?,ket13=?," +
				"ket14=?,ket15=?,ket16=?,ket17=?,ket18=?,ket19=?,ket20=?,satuan=?,jumlah=? where kcabang=? and nobukti=? and grouping=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKet1());
			p.setString(2, group.getKet2());
			p.setString(3, group.getKet3());
			p.setString(4, group.getKet4());
			p.setString(5, group.getKet5());
			p.setString(6, group.getKet6());
			p.setString(7, group.getKet7());
			p.setString(8, group.getKet8());
			p.setString(9, group.getKet9());
			p.setString(10, group.getKet10());
			p.setString(11, group.getKet11());
			p.setString(12, group.getKet12());
			p.setString(13, group.getKet13());
			p.setString(14, group.getKet14());
			p.setString(15, group.getKet15());
			p.setString(16, group.getKet16());
			p.setString(17, group.getKet17());
			p.setString(18, group.getKet18());
			p.setString(19, group.getKet19());
			p.setString(20, group.getKet20());
			p.setString(21, group.getSatuan());
			p.setDouble(22, group.getJumlah());
			p.setString(23, group.getKcabang());
			p.setString(24, group.getNobukti());
			p.setString(25, group.getGrouping());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateInvoiceGroup(sf.sales.InvoiceGroup group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="UPDATE sinvoice_group SET ket1=?,ket2=?,ket3=?,ket4=?," +
				"ket5=?,ket6=?,ket7=?,ket8=?,ket9=?,ket10=?,ket11=?,ket12=?,ket13=?," +
				"ket14=?,ket15=?,ket16=?,ket17=?,ket18=?,ket19=?,ket20=?,satuan=?,jumlah=? where kcabang=? and nobukti=? and grouping=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKet1());
			p.setString(2, group.getKet2());
			p.setString(3, group.getKet3());
			p.setString(4, group.getKet4());
			p.setString(5, group.getKet5());
			p.setString(6, group.getKet6());
			p.setString(7, group.getKet7());
			p.setString(8, group.getKet8());
			p.setString(9, group.getKet9());
			p.setString(10, group.getKet10());
			p.setString(11, group.getKet11());
			p.setString(12, group.getKet12());
			p.setString(13, group.getKet13());
			p.setString(14, group.getKet14());
			p.setString(15, group.getKet15());
			p.setString(16, group.getKet16());
			p.setString(17, group.getKet17());
			p.setString(18, group.getKet18());
			p.setString(19, group.getKet19());
			p.setString(20, group.getKet20());
			p.setString(21, group.getSatuan());
			p.setDouble(22, group.getJumlah());
			p.setString(23, group.getKcabang());
			p.setString(24, group.getNobukti());
			p.setString(25, group.getGrouping());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteQuotationGroup(sf.sales.QuotationGroup group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="DELETE from squotation_group where kcabang=? and nobukti=? and grouping=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKcabang());
			p.setString(2, group.getNobukti());
			p.setString(3, group.getGrouping());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteSalesOrderGroup(sf.sales.SalesOrderGroup group) throws DAException
	{
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		String strSQL="DELETE from sorder_group where kcabang=? and nobukti=? and grouping=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKcabang());
			p.setString(2, group.getNobukti());
			p.setString(3, group.getGrouping());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	
	public double getStockBalance(String kbarang,String kgudang) throws DAException
	{
		double stockBalance=0;
		String strSQL="SELECT (a.onhand-b.pinjam-b.booking-b.sorder-b.alokasi+b.pshipping) as stockbalance from stock_rekap a,stock_alokasi b where  a.kbarang = b.kbarang and a.kgudang=b.kgudang and a.kbarang=? and a.kgudang=?";
		System.out.println(strSQL + "[kbarang:" + kbarang + ",kgudang:" + kgudang + "]" );
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kbarang);
			p.setString(2, kgudang);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				stockBalance= Double.parseDouble(v.get(0).toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
		return stockBalance;
	}
	
	public boolean updateQuotationDetail(sf.sales.QuotationDetail detail) throws DAException
	{
		if(detail.checkIsNULL())
		{
			throw new DAException(detail.getErr());
		}
		
		String strSQL="UPDATE squotation_detail SET grouping=?,kbarang=?,jumlah=?,jumlah1=?," +
				"jumlah2=?,stockbal=?,nvaluta=?,discval=?,disc2=?,discpl=?,plist=?,pvaluta=?,kgroup=?,noso=?," +
				"ket=?,recstatus=?,tglupdate=?,userupdate=?,approvedby=?,approvedtgl=? where kcabang=? and nobukti=? and nourut=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getGrouping());
			p.setString(2, detail.getKbarang());
			p.setDouble(3, detail.getJumlah());
			p.setDouble(4, detail.getJumlah1());
			p.setDouble(5, detail.getJumlah2());
			p.setDouble(6, detail.getStockbal());
			p.setDouble(7, detail.getNvaluta());
			p.setDouble(8, detail.getDiscval());
			p.setDouble(9, detail.getDisc2());
			p.setDouble(10, detail.getDiscpl());
			p.setDouble(11, detail.getPlist());
			p.setString(12, detail.getPvaluta());
			p.setString(13, detail.getKgroup());
			p.setString(14, detail.getNoso());
			p.setString(15, detail.getKet());
			p.setString(16, detail.getRecstatus());
			p.setLong(17, detail.getTglupdate());
			p.setString(18, detail.getUserupdate());
			p.setString(19, detail.getApprovedBy());
			p.setString(20, detail.getApprovedDate());
			p.setString(21, detail.getKcabang());
			p.setString(22, detail.getNobukti());
			p.setInt(23, detail.getNourut());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSalesOrderDetail(sf.sales.SalesOrderDetail detail) throws DAException
	{
		if(detail.checkIsNULL())
		{
			throw new DAException(detail.getErr());
		}
		
		String strSQL="UPDATE sorder_detail SET grouping=?,kbarang=?,jumlah=?,jumlah1=?," +
				"jumlah2=?,stockbal=?,nvaluta=?,discval=?,disc2=?,discpl=?,plist=?,pvaluta=?,kgroup=?," +
				"ket=?,nosq=?,nosj=?,nopo=?,recstatus=?,tglupdate=?,userupdate=? where kcabang=? and nobukti=? and nourut=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getGrouping());
			p.setString(2, detail.getKbarang());
			p.setDouble(3, detail.getJumlah());
			p.setDouble(4, detail.getJumlah1());
			p.setDouble(5, detail.getJumlah2());
			p.setDouble(6, detail.getStockbal());
			p.setDouble(7, detail.getNvaluta());
			p.setDouble(8, detail.getDiscval());
			p.setDouble(9, detail.getDisc2());
			p.setDouble(10, detail.getDiscpl());
			p.setDouble(11, detail.getPlist());
			p.setString(12, detail.getPvaluta());
			p.setString(13, detail.getKgroup());
			p.setString(14, detail.getKet());
			p.setString(15, detail.getNosq());
			p.setString(16, detail.getNosj());
			p.setString(17, detail.getNopo());
			p.setString(18, detail.getRecstatus());
			p.setLong(19, detail.getTglupdate());
			p.setString(20, detail.getUserupdate());
			p.setString(21, detail.getKcabang());
			p.setString(22, detail.getNobukti());
			p.setInt(23, detail.getNourut());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateSuratJalanDetail(sf.sales.SuratJalanDetail detail) throws DAException
	{
		if(detail.checkIsNULL())
		{
			throw new DAException(detail.getErr());
		}
		
		String strSQL="UPDATE sjalan_detail SET grouping=?,kbarang=?,jumlah=?,jumlah1=?," +
				"jumlah2=?,stockbal=?,nvaluta=?,discval=?,disc2=?,discpl=?,plist=?,pvaluta=?,kgroup=?," +
				"ket=?,nosq=?,noso=?,noinvoice=?,nopo=?,recstatus=?,tglupdate=?,userupdate=? where kcabang=? and nobukti=? and nourut=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getGrouping());
			p.setString(2, detail.getKbarang());
			p.setDouble(3, detail.getJumlah());
			p.setDouble(4, detail.getJumlah1());
			p.setDouble(5, detail.getJumlah2());
			p.setDouble(6, detail.getStockbal());
			p.setDouble(7, detail.getNvaluta());
			p.setDouble(8, detail.getDiscval());
			p.setDouble(9, detail.getDisc2());
			p.setDouble(10, detail.getDiscpl());
			p.setDouble(11, detail.getPlist());
			p.setString(12, detail.getPvaluta());
			p.setString(13, detail.getKgroup());
			p.setString(14, detail.getKet());
			p.setString(15, detail.getNosq());
			p.setString(16, detail.getNoso());
			p.setString(17, detail.getNoinvoice());
			p.setString(18, detail.getNopo());
			p.setString(19, detail.getRecstatus());
			p.setLong(20, detail.getTglupdate());
			p.setString(21, detail.getUserupdate());
			p.setString(22, detail.getKcabang());
			p.setString(23, detail.getNobukti());
			p.setInt(24, detail.getNourut());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateInvoiceDetail(sf.sales.InvoiceDetail detail) throws DAException
	{
		if(detail.checkIsNULL())
		{
			throw new DAException(detail.getErr());
		}
		
		String strSQL="UPDATE sinvoice_detail SET grouping=?,kbarang=?,jumlah=?,jumlah1=?," +
				"jumlah2=?,stockbal=?,nvaluta=?,discval=?,disc2=?,discpl=?,plist=?,pvaluta=?,kgroup=?," +
				"ket=?,nosq=?,noso=?,nosj=?,nopo=?,recstatus=?,tglupdate=?,userupdate=? where kcabang=? and nobukti=? and nourut=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getGrouping());
			p.setString(2, detail.getKbarang());
			p.setDouble(3, detail.getJumlah());
			p.setDouble(4, detail.getJumlah1());
			p.setDouble(5, detail.getJumlah2());
			p.setDouble(6, detail.getStockbal());
			p.setDouble(7, detail.getNvaluta());
			p.setDouble(8, detail.getDiscval());
			p.setDouble(9, detail.getDisc2());
			p.setDouble(10, detail.getDiscpl());
			p.setDouble(11, detail.getPlist());
			p.setString(12, detail.getPvaluta());
			p.setString(13, detail.getKgroup());
			p.setString(14, detail.getKet());
			p.setString(15, detail.getNosq());
			p.setString(16, detail.getNoso());
			p.setString(17, detail.getNosj());
			p.setString(18, detail.getNopo());
			p.setString(19, detail.getRecstatus());
			p.setLong(20, detail.getTglupdate());
			p.setString(21, detail.getUserupdate());
			p.setString(22, detail.getKcabang());
			p.setString(23, detail.getNobukti());
			p.setInt(24, detail.getNourut());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	public sf.sales.QuotationDetail[] getQuotationDetail(String kcabang,String noBukti) throws DAException
	{
		sf.sales.QuotationDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM squotation_detail where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, noBukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.QuotationDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationDetail item=new sf.sales.QuotationDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setGrouping(v.get(3).toString());
				item.setKbarang(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setJumlah1(Double.parseDouble(v.get(6).toString()));
				item.setJumlah2(Double.parseDouble(v.get(7).toString()));
				item.setStockbal(Double.parseDouble(v.get(8).toString()));
				item.setNvaluta(Double.parseDouble(v.get(9).toString()));
				item.setDiscval(Double.parseDouble(v.get(10).toString()));
				item.setDisc2(Double.parseDouble(v.get(11).toString()));
				item.setDiscpl(Double.parseDouble(v.get(12).toString()));
				item.setPlist(Double.parseDouble(v.get(13).toString()));
				item.setPvaluta(v.get(14).toString());
				item.setKgroup(v.get(15).toString());
				item.setNoso(v.get(16).toString());
				item.setKet(v.get(17).toString());
				item.setRecstatus(v.get(18).toString());
				item.setTglupdate(Long.parseLong(v.get(19).toString()));
				item.setUserupdate(v.get(20).toString());
				item.setApprovedBy(v.get(21).toString());
				item.setApprovedDate(v.get(22).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SalesOrderDetail[] getSalesOrderDetail(String kcabang,String noBukti) throws DAException
	{
		sf.sales.SalesOrderDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM sorder_detail where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, noBukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SalesOrderDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SalesOrderDetail item=new sf.sales.SalesOrderDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setGrouping(v.get(3).toString());
				item.setKbarang(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setJumlah1(Double.parseDouble(v.get(6).toString()));
				item.setJumlah2(Double.parseDouble(v.get(7).toString()));
				item.setStockbal(Double.parseDouble(v.get(8).toString()));
				item.setNvaluta(Double.parseDouble(v.get(9).toString()));
				item.setDiscval(Double.parseDouble(v.get(10).toString()));
				item.setDisc2(Double.parseDouble(v.get(11).toString()));
				item.setDiscpl(Double.parseDouble(v.get(12).toString()));
				item.setPlist(Double.parseDouble(v.get(13).toString()));
				item.setPvaluta(v.get(14).toString());
				item.setKgroup(v.get(15).toString());
				item.setKet(v.get(16).toString());
				item.setNosq(v.get(17).toString());
				item.setNosj(v.get(18).toString());
				item.setNopo(v.get(19).toString());
				item.setRecstatus(v.get(20).toString());
				item.setTglupdate(Long.parseLong(v.get(21).toString()));
				item.setUserupdate(v.get(22).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SuratJalanDetail[] getSuratJalanDetail(String kcabang,String noBukti) throws DAException
	{
		sf.sales.SuratJalanDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM sjalan_detail where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, noBukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SuratJalanDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SuratJalanDetail item=new sf.sales.SuratJalanDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setGrouping(v.get(3).toString());
				item.setKbarang(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setJumlah1(Double.parseDouble(v.get(6).toString()));
				item.setJumlah2(Double.parseDouble(v.get(7).toString()));
				item.setStockbal(Double.parseDouble(v.get(8).toString()));
				item.setNvaluta(Double.parseDouble(v.get(9).toString()));
				item.setDiscval(Double.parseDouble(v.get(10).toString()));
				item.setDisc2(Double.parseDouble(v.get(11).toString()));
				item.setDiscpl(Double.parseDouble(v.get(12).toString()));
				item.setPlist(Double.parseDouble(v.get(13).toString()));
				item.setPvaluta(v.get(14).toString());
				item.setKgroup(v.get(15).toString());
				item.setKet(v.get(16).toString());
				item.setNosq(v.get(17).toString());
				item.setNoso(v.get(18).toString());
				item.setNoinvoice(v.get(19).toString());
				item.setNopo(v.get(20).toString());
				item.setRecstatus(v.get(21).toString());
				item.setTglupdate(Long.parseLong(v.get(22).toString()));
				item.setUserupdate(v.get(23).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.InvoiceDetail[] getInvoiceDetail(String kcabang,String noBukti) throws DAException
	{
		sf.sales.InvoiceDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM sinvoice_detail where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, noBukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.InvoiceDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.InvoiceDetail item=new sf.sales.InvoiceDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setGrouping(v.get(3).toString());
				item.setKbarang(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setNvaluta(Double.parseDouble(v.get(6).toString()));
				item.setDiscval(Double.parseDouble(v.get(7).toString()));
				item.setDisc2(Double.parseDouble(v.get(8).toString()));
				item.setDiscpl(Double.parseDouble(v.get(9).toString()));
				item.setPlist(Double.parseDouble(v.get(10).toString()));
				item.setPvaluta(v.get(11).toString());
				item.setKgroup(v.get(12).toString());
				item.setNosq(v.get(13).toString());
				item.setNoso(v.get(14).toString());
				item.setNosj(v.get(15).toString());
				item.setNopo(v.get(16).toString());
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
	
	public sf.sales.QuotationDetail[] getQuotationDetailSOOut(String kcabang,String noBukti) throws DAException
	{
		sf.sales.QuotationDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM squotation_detail where kcabang=? and nobukti=? and (jumlah>jumlah1)";
			System.out.println(strSQL);
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, noBukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			System.out.println("count row: " + count);
			items = new sf.sales.QuotationDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationDetail item=new sf.sales.QuotationDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setGrouping(v.get(3).toString());
				item.setKbarang(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setJumlah1(Double.parseDouble(v.get(6).toString()));
				item.setJumlah2(Double.parseDouble(v.get(7).toString()));
				item.setStockbal(Double.parseDouble(v.get(8).toString()));
				item.setNvaluta(Double.parseDouble(v.get(9).toString()));
				item.setDiscval(Double.parseDouble(v.get(10).toString()));
				item.setDisc2(Double.parseDouble(v.get(11).toString()));
				item.setDiscpl(Double.parseDouble(v.get(12).toString()));
				item.setPlist(Double.parseDouble(v.get(13).toString()));
				item.setPvaluta(v.get(14).toString());
				item.setKgroup(v.get(15).toString());
				item.setNoso(v.get(16).toString());
				item.setKet(v.get(17).toString());
				item.setRecstatus(v.get(18).toString());
				item.setTglupdate(Long.parseLong(v.get(19).toString()));
				item.setUserupdate(v.get(20).toString());
				item.setApprovedBy(v.get(21).toString());
				item.setApprovedDate(v.get(22).toString());
				System.out.println("data[" + item.getKcabang() + "," + item.getKbarang() + "," + item.getNobukti());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.QuotationDetail[] getQuotationDetailNoApproved(String kcabang,String noBukti) throws DAException
	{
		sf.sales.QuotationDetail[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT a.* FROM squotation_detail a,mgroup b where a.kcabang=? and a.nobukti=? and ISNULL(a.approvedby) and a.discpl > b.maxdisc and a.kgroup=b.kgroup";
			System.out.println(strSQL);
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, noBukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.QuotationDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationDetail item=new sf.sales.QuotationDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setGrouping(v.get(3).toString());
				item.setKbarang(v.get(4).toString());
				item.setJumlah(Double.parseDouble(v.get(5).toString()));
				item.setJumlah1(Double.parseDouble(v.get(6).toString()));
				item.setJumlah2(Double.parseDouble(v.get(7).toString()));
				item.setStockbal(Double.parseDouble(v.get(8).toString()));
				item.setNvaluta(Double.parseDouble(v.get(9).toString()));
				item.setDiscval(Double.parseDouble(v.get(10).toString()));
				item.setDisc2(Double.parseDouble(v.get(11).toString()));
				item.setDiscpl(Double.parseDouble(v.get(12).toString()));
				item.setPlist(Double.parseDouble(v.get(13).toString()));
				item.setPvaluta(v.get(14).toString());
				item.setKgroup(v.get(15).toString());
				item.setNoso(v.get(16).toString());
				item.setKet(v.get(17).toString());
				item.setRecstatus(v.get(18).toString());
				item.setTglupdate(Long.parseLong(v.get(19).toString()));
				item.setUserupdate(v.get(20).toString());
				item.setApprovedBy(v.get(21).toString());
				item.setApprovedDate(v.get(22).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SalesOrderHeader[] getSalesOrder(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.SalesOrderHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT * FROM sorder_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="";
				if(fromDate.equals("") || toDate.equals(""))
					strSQL="SELECT * FROM sorder_header where kcabang=? order by nobukti asc";
				else
					strSQL="SELECT * FROM sorder_header where kcabang=? and tglbukti between ? and ? order by nobukti asc";
				
				log.info("getSalesOrder->" + strSQL + "[0]" + kcabang + "[1]" + fromDate + "[2]" + toDate);
				p=db.getStatement(strSQL);
				if(fromDate.equals("") || toDate.equals(""))
				{
					p.setString(1, kcabang);
				}
				else
				{
					p.setString(1, kcabang);
					p.setString(2, fromDate);
					p.setString(3, toDate);
				}
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SalesOrderHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SalesOrderHeader header=new sf.sales.SalesOrderHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.SuratJalanHeader[] getSuratJalan(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.SuratJalanHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT * FROM sjalan_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT * FROM sjalan_header where kcabang=? and tglbukti between ? and ? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SuratJalanHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SuratJalanHeader header=new sf.sales.SuratJalanHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.InvoiceHeader[] getInvoice(String kclient) throws DAException
	{
		sf.sales.InvoiceHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM sinvoice_header where kclient=? order by nobukti asc";
			p=db.getStatement(strSQL);
			p.setString(1, kclient);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.InvoiceHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.InvoiceHeader header=new sf.sales.InvoiceHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNopocust(v.get(15).toString());
				header.setNodpayment(v.get(16).toString());
				
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	public sf.sales.InvoiceHeader[] getInvoice(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.InvoiceHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT * FROM sinvoice_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT * FROM sinvoice_header where kcabang=? and tglbukti between ? and ? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.InvoiceHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.InvoiceHeader header=new sf.sales.InvoiceHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNopocust(v.get(15).toString());
				header.setNodpayment(v.get(16).toString());
				
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.ReturHeader[] getRetur(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.ReturHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT * FROM sretur_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT * FROM sretur_header where kcabang=? and tglbukti between ? and ? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.ReturHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.ReturHeader header=new sf.sales.ReturHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setDiscval(Double.parseDouble(v.get(9).toString()));
				header.setDisc1(Double.parseDouble(v.get(10).toString()));
				header.setDiscpl(Double.parseDouble(v.get(11).toString()));
				header.setNoscard(v.get(12).toString());
				header.setExnoinvoice(v.get(13).toString());
				header.setKet(v.get(14).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.ReturDetail[] getReturDetail(String kcabang,String nobukti) throws DAException
	{
		sf.sales.ReturDetail[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM sretur_detail where kcabang=? and nobukti=? order by nobukti asc";
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.ReturDetail[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.ReturDetail item=new sf.sales.ReturDetail();
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setNourut(Integer.parseInt(v.get(2).toString()));
				item.setKbarang(v.get(3).toString());
				item.setJumlah(Double.parseDouble(v.get(4).toString()));
				item.setNvaluta(Double.parseDouble(v.get(5).toString()));
				item.setDiscval(Double.parseDouble(v.get(6).toString()));
				item.setDisc2(Double.parseDouble(v.get(7).toString()));
				item.setDiscpl(Double.parseDouble(v.get(8).toString()));
				item.setPlist(Double.parseDouble(v.get(9).toString()));
				item.setPvaluta(v.get(10).toString());
				item.setKgroup(v.get(11).toString());
				item.setRecstatus(v.get(12).toString());
				item.setTglupdate(Long.parseLong(v.get(13).toString()));
				item.setUserupdate(v.get(14).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.SalesOrderHeader[] getSalesOrderBySJOut(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.SalesOrderHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT a.* FROM sorder_header a,sorder_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 group by a.nobukti";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT a.* FROM sorder_header a,sorder_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 and a.kcabang=? and a.tglbukti between ? and ? group by a.nobukti";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SalesOrderHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SalesOrderHeader header=new sf.sales.SalesOrderHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	public sf.sales.InvoiceHeader[] getInvoiceBySIOut(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.InvoiceHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT a.* FROM sinvoice_header a,sinvoice_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 group by a.nobukti";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT a.* FROM sinvoice_header a,sinvoice_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 and a.kcabang=? and a.tglbukti between ? and ? group by a.nobukti";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.InvoiceHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.InvoiceHeader header=new sf.sales.InvoiceHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNopocust(v.get(15).toString());
				header.setNodpayment(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	public sf.sales.QuotationHeader[] getQuotationHeaderBySOOut(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.QuotationHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT a.* FROM squotation_header a,squotation_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 group by a.nobukti";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT a.* FROM squotation_header a,squotation_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 and a.kcabang=? and a.tglbukti between ? and ? group by a.nobukti";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.QuotationHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationHeader header=new sf.sales.QuotationHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setKontak1(v.get(16).toString());
				header.setKontak2(v.get(17).toString());
				header.setKontak3(v.get(18).toString());
				header.setValidity(v.get(19).toString());
				header.setSyarat(v.get(20).toString());
				header.setKirim(v.get(21).toString());
				header.setKet1(v.get(22).toString());
				header.setKet2(v.get(23).toString());
				header.setKet3(v.get(24).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.QuotationHeader[] getQuotationHeaderByNotApproved(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.QuotationHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT a.* FROM squotation_header a,squotation_detail b,mgroup c where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.kgroup=c.kgroup and ISNULL(b.approvedby) and b.discpl > c.maxdisc group by a.nobukti";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT a.* FROM squotation_header a,squotation_detail b,mgroup c where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.kgroup=c.kgroup and ISNULL(b.approvedby) and b.discpl > c.maxdisc and a.kcabang=? and a.tglbukti between ? and ? group by a.nobukti";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.QuotationHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationHeader header=new sf.sales.QuotationHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setKontak1(v.get(16).toString());
				header.setKontak2(v.get(17).toString());
				header.setKontak3(v.get(18).toString());
				header.setValidity(v.get(19).toString());
				header.setSyarat(v.get(20).toString());
				header.setKirim(v.get(21).toString());
				header.setKet1(v.get(22).toString());
				header.setKet2(v.get(23).toString());
				header.setKet3(v.get(24).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	
	public sf.sales.QuotationHeader[] getQuotationHeader(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.QuotationHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT * FROM squotation_header order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT * FROM squotation_header where kcabang=? and tglbukti between ? and ? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.QuotationHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationHeader header=new sf.sales.QuotationHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setKontak1(v.get(16).toString());
				header.setKontak2(v.get(17).toString());
				header.setKontak3(v.get(18).toString());
				header.setValidity(v.get(19).toString());
				header.setSyarat(v.get(20).toString());
				header.setKirim(v.get(21).toString());
				header.setKet1(v.get(22).toString());
				header.setKet2(v.get(23).toString());
				header.setKet3(v.get(24).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SOrderBiaya[] getSalesOrderBiaya(String kcabang,String nobukti)
	{
		sf.sales.SOrderBiaya[] items = null;
		String strSQL="SELECT a.*,b.accdesc FROM sorder_biaya a,maccount b where a.accno=b.accno and a.kcabang=? and a.nobukti=?";
		PreparedStatement p=null;
		
		try {
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SOrderBiaya[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SOrderBiaya header=new sf.sales.SOrderBiaya();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setAccno(v.get(2).toString());
				header.setKvaluta(v.get(3).toString());
				header.setNvaluta(Double.parseDouble(v.get(4).toString()));
				header.setTrealisasi(Double.parseDouble(v.get(5).toString()));
				header.setNrealisasi(Double.parseDouble(v.get(6).toString()));
				header.setAccDesc(v.get(10).toString());
				items[i] = header;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		} catch (DAException e) {
			// TODO Auto-generated catch block
			
		}
		
		return items;
	}
	
	public sf.sales.SalesOrderHeader[] getSalesOrderHeaderBySOOut(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.SalesOrderHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT a.* FROM sorder_header a,sorder_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 group by a.nobukti";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT a.* FROM sorder_header a,sorder_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 and a.kcabang=? and a.tglbukti between ? and ? group by a.nobukti";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SalesOrderHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SalesOrderHeader header=new sf.sales.SalesOrderHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.SuratJalanHeader[] getSuratJalanHeaderBySIOut(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.SuratJalanHeader[] items = null;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT a.* FROM sjalan_header a,sjalan_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 group by a.nobukti";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT a.* FROM sjalan_header a,sjalan_detail b where a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.jumlah > b.jumlah1 and a.kcabang=? and a.tglbukti between ? and ? group by a.nobukti";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SuratJalanHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SuratJalanHeader header=new sf.sales.SuratJalanHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		return items;
	}
	
	public sf.sales.SalesOrderHeader[] getSalesOrderHeader(String kcabang,String nobukti) throws DAException
	{
		sf.sales.SalesOrderHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			
			String strSQL="SELECT * FROM sorder_header where kcabang=? and nobukti=?";
			log.info("getSalesOrderHeader->" + strSQL + "[0]" + kcabang + "[1]" + nobukti);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SalesOrderHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SalesOrderHeader header=new sf.sales.SalesOrderHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SuratJalanHeader[] getSuratJalanHeader(String kcabang,String nobukti) throws DAException
	{
		sf.sales.SuratJalanHeader[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			
			String strSQL="SELECT * FROM sjalan_header where kcabang=? and nobukti=?";
			log.info("getSuratJalanHeader->" + strSQL + "[0]" + kcabang + "[1]" + nobukti);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SuratJalanHeader[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SuratJalanHeader header=new sf.sales.SuratJalanHeader();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setKgudang(v.get(3).toString());
				header.setTglbukti(v.get(4).toString());
				header.setKclient(v.get(5).toString());
				header.setKsales(v.get(6).toString());
				header.setKservice(v.get(7).toString());
				header.setKvaluta(v.get(8).toString());
				header.setKkurs(Double.parseDouble(v.get(9).toString()));
				header.setDiscval(Double.parseDouble(v.get(10).toString()));
				header.setDisc1(Double.parseDouble(v.get(11).toString()));
				header.setDiscpl(Double.parseDouble(v.get(12).toString()));
				header.setNoscard(v.get(13).toString());
				header.setNoref(v.get(14).toString());
				header.setNotracking(v.get(15).toString());
				header.setNopocust(v.get(16).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public QuotationGroup[] getGrouping(String kcabang,String nobukti)throws DAException
	{
		sf.sales.QuotationGroup[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM squotation_group where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.QuotationGroup[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.QuotationGroup item=new sf.sales.QuotationGroup();
				
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setGrouping(v.get(2).toString());
				item.setKet1(v.get(3).toString());
				item.setKet2(v.get(4).toString());
				item.setKet3(v.get(5).toString());
				item.setKet4(v.get(6).toString());
				item.setKet5(v.get(7).toString());
				item.setKet6(v.get(8).toString());
				item.setKet7(v.get(9).toString());
				item.setKet8(v.get(10).toString());
				item.setKet9(v.get(11).toString());
				item.setKet10(v.get(12).toString());
				item.setKet11(v.get(13).toString());
				item.setKet12(v.get(14).toString());
				item.setKet13(v.get(15).toString());
				item.setKet14(v.get(16).toString());
				item.setKet15(v.get(17).toString());
				item.setKet16(v.get(18).toString());
				item.setKet17(v.get(19).toString());
				item.setKet18(v.get(20).toString());
				item.setKet19(v.get(21).toString());
				item.setKet20(v.get(22).toString());
				item.setSatuan(v.get(23).toString());
				item.setJumlah(Double.parseDouble(v.get(24).toString()));
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	public SalesOrderGroup[] getSalesGrouping(String kcabang,String nobukti)throws DAException
	{
		sf.sales.SalesOrderGroup[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM sorder_group where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SalesOrderGroup[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SalesOrderGroup item=new sf.sales.SalesOrderGroup();
				
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setGrouping(v.get(2).toString());
				item.setKet1(v.get(3).toString());
				item.setKet2(v.get(4).toString());
				item.setKet3(v.get(5).toString());
				item.setKet4(v.get(6).toString());
				item.setKet5(v.get(7).toString());
				item.setKet6(v.get(8).toString());
				item.setKet7(v.get(9).toString());
				item.setKet8(v.get(10).toString());
				item.setKet9(v.get(11).toString());
				item.setKet10(v.get(12).toString());
				item.setKet11(v.get(13).toString());
				item.setKet12(v.get(14).toString());
				item.setKet13(v.get(15).toString());
				item.setKet14(v.get(16).toString());
				item.setKet15(v.get(17).toString());
				item.setKet16(v.get(18).toString());
				item.setKet17(v.get(19).toString());
				item.setKet18(v.get(20).toString());
				item.setKet19(v.get(21).toString());
				item.setKet20(v.get(22).toString());
				item.setSatuan(v.get(23).toString());
				item.setJumlah(Double.parseDouble(v.get(24).toString()));
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	public InvoiceGroup[] getInvoiceGrouping(String kcabang,String nobukti)throws DAException
	{
		sf.sales.InvoiceGroup[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM sinvoice_group where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.InvoiceGroup[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.InvoiceGroup item=new sf.sales.InvoiceGroup();
				
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setGrouping(v.get(2).toString());
				item.setKet1(v.get(3).toString());
				item.setKet2(v.get(4).toString());
				item.setKet3(v.get(5).toString());
				item.setKet4(v.get(6).toString());
				item.setKet5(v.get(7).toString());
				item.setKet6(v.get(8).toString());
				item.setKet7(v.get(9).toString());
				item.setKet8(v.get(10).toString());
				item.setKet9(v.get(11).toString());
				item.setKet10(v.get(12).toString());
				item.setKet11(v.get(13).toString());
				item.setKet12(v.get(14).toString());
				item.setKet13(v.get(15).toString());
				item.setKet14(v.get(16).toString());
				item.setKet15(v.get(17).toString());
				item.setKet16(v.get(18).toString());
				item.setKet17(v.get(19).toString());
				item.setKet18(v.get(20).toString());
				item.setKet19(v.get(21).toString());
				item.setKet20(v.get(22).toString());
				item.setSatuan(v.get(23).toString());
				item.setJumlah(Double.parseDouble(v.get(24).toString()));
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public SuratJalanGroup[] getSuratJalanGrouping(String kcabang,String nobukti)throws DAException
	{
		sf.sales.SuratJalanGroup[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM sjalan_group where kcabang=? and nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kcabang);
			p.setString(2, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SuratJalanGroup[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SuratJalanGroup item=new sf.sales.SuratJalanGroup();
				
				item.setKcabang(v.get(0).toString());
				item.setNobukti(v.get(1).toString());
				item.setGrouping(v.get(2).toString());
				item.setKet1(v.get(3).toString());
				item.setKet2(v.get(4).toString());
				item.setKet3(v.get(5).toString());
				item.setKet4(v.get(6).toString());
				item.setKet5(v.get(7).toString());
				item.setKet6(v.get(8).toString());
				item.setKet7(v.get(9).toString());
				item.setKet8(v.get(10).toString());
				item.setKet9(v.get(11).toString());
				item.setKet10(v.get(12).toString());
				item.setKet11(v.get(13).toString());
				item.setKet12(v.get(14).toString());
				item.setKet13(v.get(15).toString());
				item.setKet14(v.get(16).toString());
				item.setKet15(v.get(17).toString());
				item.setKet16(v.get(18).toString());
				item.setKet17(v.get(19).toString());
				item.setKet18(v.get(20).toString());
				item.setKet19(v.get(21).toString());
				item.setKet20(v.get(22).toString());
				item.setSatuan(v.get(23).toString());
				item.setJumlah(Double.parseDouble(v.get(24).toString()));
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertGrouping(sf.sales.QuotationGroup group) throws DAException
	{
		boolean bTrue=false;
		
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		try
		{
			String strSQL="INSERT INTO squotation_group values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKcabang());
			p.setString(2, group.getNobukti());
			p.setString(3, group.getGrouping());
			p.setString(4, group.getKet1());
			p.setString(5, group.getKet2());
			p.setString(6, group.getKet3());
			p.setString(7, group.getKet4());
			p.setString(8, group.getKet5());
			p.setString(9, group.getKet6());
			p.setString(10, group.getKet7());
			p.setString(11, group.getKet8());
			p.setString(12, group.getKet9());
			p.setString(13, group.getKet10());
			p.setString(14, group.getKet11());
			p.setString(15, group.getKet12());
			p.setString(16, group.getKet13());
			p.setString(17, group.getKet14());
			p.setString(18, group.getKet15());
			p.setString(19, group.getKet16());
			p.setString(20, group.getKet17());
			p.setString(21, group.getKet18());
			p.setString(22, group.getKet19());
			p.setString(23, group.getKet20());
			p.setString(24, group.getSatuan());
			p.setDouble(25, group.getJumlah());
			db.execute(p);
			bTrue=true;
		}
		catch(Exception e)
		{
			throw new DAException(e.getMessage());
		}
		return bTrue;
	}
	public boolean insertInvoiceGroping(sf.sales.InvoiceGroup group) throws DAException
	{
		boolean bTrue=false;
		
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		try
		{
			String strSQL="INSERT INTO sinvoice_group values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKcabang());
			p.setString(2, group.getNobukti());
			p.setString(3, group.getGrouping());
			p.setString(4, group.getKet1());
			p.setString(5, group.getKet2());
			p.setString(6, group.getKet3());
			p.setString(7, group.getKet4());
			p.setString(8, group.getKet5());
			p.setString(9, group.getKet6());
			p.setString(10, group.getKet7());
			p.setString(11, group.getKet8());
			p.setString(12, group.getKet9());
			p.setString(13, group.getKet10());
			p.setString(14, group.getKet11());
			p.setString(15, group.getKet12());
			p.setString(16, group.getKet13());
			p.setString(17, group.getKet14());
			p.setString(18, group.getKet15());
			p.setString(19, group.getKet16());
			p.setString(20, group.getKet17());
			p.setString(21, group.getKet18());
			p.setString(22, group.getKet19());
			p.setString(23, group.getKet20());
			p.setString(24, group.getSatuan());
			p.setDouble(25, group.getJumlah());
			db.execute(p);
			bTrue=true;
		}
		catch(Exception e)
		{
			throw new DAException(e.getMessage());
		}
		return bTrue;
	}
	public boolean insertSalesOrderGroup(sf.sales.SalesOrderGroup group) throws DAException
	{
		boolean bTrue=false;
		
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		try
		{
			String strSQL="INSERT INTO sorder_group values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKcabang());
			p.setString(2, group.getNobukti());
			p.setString(3, group.getGrouping());
			p.setString(4, group.getKet1());
			p.setString(5, group.getKet2());
			p.setString(6, group.getKet3());
			p.setString(7, group.getKet4());
			p.setString(8, group.getKet5());
			p.setString(9, group.getKet6());
			p.setString(10, group.getKet7());
			p.setString(11, group.getKet8());
			p.setString(12, group.getKet9());
			p.setString(13, group.getKet10());
			p.setString(14, group.getKet11());
			p.setString(15, group.getKet12());
			p.setString(16, group.getKet13());
			p.setString(17, group.getKet14());
			p.setString(18, group.getKet15());
			p.setString(19, group.getKet16());
			p.setString(20, group.getKet17());
			p.setString(21, group.getKet18());
			p.setString(22, group.getKet19());
			p.setString(23, group.getKet20());
			p.setString(24, group.getSatuan());
			p.setDouble(25, group.getJumlah());
			db.execute(p);
			bTrue=true;
		}
		catch(Exception e)
		{
			throw new DAException(e.getMessage());
		}
		return bTrue;
	}
	
	public boolean insertSuratJalanGroup(sf.sales.SuratJalanGroup group) throws DAException
	{
		boolean bTrue=false;
		
		if(group.checkIsNULL())
		{
			throw new DAException(group.getErr());
		}
		
		try
		{
			String strSQL="INSERT INTO sjalan_group values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, group.getKcabang());
			p.setString(2, group.getNobukti());
			p.setString(3, group.getGrouping());
			p.setString(4, group.getKet1());
			p.setString(5, group.getKet2());
			p.setString(6, group.getKet3());
			p.setString(7, group.getKet4());
			p.setString(8, group.getKet5());
			p.setString(9, group.getKet6());
			p.setString(10, group.getKet7());
			p.setString(11, group.getKet8());
			p.setString(12, group.getKet9());
			p.setString(13, group.getKet10());
			p.setString(14, group.getKet11());
			p.setString(15, group.getKet12());
			p.setString(16, group.getKet13());
			p.setString(17, group.getKet14());
			p.setString(18, group.getKet15());
			p.setString(19, group.getKet16());
			p.setString(20, group.getKet17());
			p.setString(21, group.getKet18());
			p.setString(22, group.getKet19());
			p.setString(23, group.getKet20());
			p.setString(24, group.getSatuan());
			p.setDouble(25, group.getJumlah());
			db.execute(p);
			bTrue=true;
		}
		catch(Exception e)
		{
			throw new DAException(e.getMessage());
		}
		return bTrue;
	}
	
	
	public boolean updateQuotation(sf.sales.QuotationHeader header,sf.sales.QuotationDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updateQuotationHeader(header))
			{
				if(removeQuotationDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						QuotationDetail dtail = details[i];
						bRet=insertQuotationDetail(dtail);
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
	
	public boolean deleteSorderBiaya(sf.sales.SOrderBiaya sOrderBiaya) throws DAException
	{
		if(sOrderBiaya.checkIsNULL())
		{
			throw new DAException(sOrderBiaya.getErr());
		}
		
		String strSQL="DELETE FROM sorder_biaya where kcabang=? and nobukti=? and accno=?";
		
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, sOrderBiaya.getKcabang());
			p.setString(2, sOrderBiaya.getNobukti());
			p.setString(3, sOrderBiaya.getAccno());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//throw new DAException(e.getMessage());
		}
		
		return false;
	}
	public boolean updateSorderBiaya(sf.sales.SOrderBiaya sOrderBiaya) throws DAException
	{
		if(sOrderBiaya.checkIsNULL())
		{
			throw new DAException(sOrderBiaya.getErr());
		}
		
		String strSQL="UPDATE sorder_biaya SET kvaluta=?,nvaluta=?,nrealisasi=?,trealisasi=?," +
				"recstatus=?,tglupdate=?,userupdate=? where kcabang=? and nobukti=? and accno=?";
		
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, sOrderBiaya.getKvaluta());
			p.setDouble(2, sOrderBiaya.getNvaluta());
			p.setDouble(3, sOrderBiaya.getNrealisasi());
			p.setDouble(4, sOrderBiaya.getTrealisasi());
			p.setString(5, sOrderBiaya.getRecstatus());
			p.setLong(6, sOrderBiaya.getTglupdate());
			p.setString(7, sOrderBiaya.getUserupdate());
			p.setString(8, sOrderBiaya.getKcabang());
			p.setString(9, sOrderBiaya.getNobukti());
			p.setString(10, sOrderBiaya.getAccno());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//throw new DAException(e.getMessage());
		}
		
		return false;
	}
	
	public boolean updateSuratJalan(sf.sales.SuratJalanHeader header,sf.sales.SuratJalanDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updateSuratJalanHeader(header))
			{
				if(removeSuratJalanDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						SuratJalanDetail dtail = details[i];
						bRet=insertSuratJalanDetail(dtail);
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
	public boolean updateInvoice(sf.sales.InvoiceHeader header,sf.sales.InvoiceDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updateInvoiceHeader(header))
			{
				if(removeInvoiceDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						InvoiceDetail dtail = details[i];
						bRet=insertInvoiceDetail(dtail);
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
	
	public boolean updateRetur(sf.sales.ReturHeader header,sf.sales.ReturDetail[] details) throws DAException
	{
		try
		{
			boolean bRet=true;
			db.getConnection().setAutoCommit(false);
			if(updateReturHeader(header))
			{
				if(removeReturDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						ReturDetail dtail = details[i];
						bRet=insertReturDetail(dtail);
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
	public boolean updateSalesOrder(sf.sales.SalesOrderHeader header,sf.sales.SalesOrderDetail[] details,sf.sales.SOrderBiaya[] biayas) throws DAException
	{
		try
		{
			boolean bRet=true;
			//db.getConnection().setAutoCommit(false);
			if(updateSalesOrderHeader(header))
			{
				if(removeSalesOrderDetail(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < details.length;i++)
					{
						SalesOrderDetail dtail = details[i];
						bRet=insertSalesOrderDetail(dtail);
						if(!bRet)
							break;
					}
				}
				
				if(removeSalesOrderBiaya(header.getKcabang(),header.getNobukti()))
				{
					for(int i=0; i < biayas.length;i++)
					{
						SOrderBiaya biaya = biayas[i];
						bRet=insertSalesOrderBiaya(biaya);
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
	
	private boolean removeQuotationDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM squotation_detail where kcabang=? and nobukti=?";
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
	
	private boolean removeSalesOrderBiaya(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM sorder_biaya where kcabang=? and nobukti=?";
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
	
	private boolean removeSuratJalanDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM sjalan_detail where kcabang=? and nobukti=?";
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
	
	private boolean removeInvoiceDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM sinvoice_detail where kcabang=? and nobukti=?";
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
	
	private boolean removeReturDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM sretur_detail where kcabang=? and nobukti=?";
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
	
	private boolean removeSalesOrderDetail(String kcabang, String nobukti)
	{
		try {
			String strSQL="DELETE FROM sorder_detail where kcabang=? and nobukti=?";
			log.info("removeSalesOrderDetail->" + strSQL + "[0]" + kcabang + ",[1]" + nobukti);
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
	public boolean deleteQuotation(sf.sales.QuotationHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM squotation_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM squotation_detail where kcabang=? and nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM squotation_group where kcabang=? and nobukti=?"; 
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
	
	public boolean deleteSalesOrder(sf.sales.SalesOrderHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM sorder_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM sorder_detail where kcabang=? and nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM sorder_biaya where kcabang=? and nobukti=?"; 
			p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM sorder_group where kcabang=? and nobukti=?"; 
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
	
	public boolean deleteSalesOrderDetail(sf.sales.SalesOrderDetail detail) throws DAException
	{
		try
		{
			String strSQL="DELETE FROM sorder_detail where kcabang=? and nobukti=? and nourut=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setInt(3, detail.getNourut());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
		
	}
	
	public boolean deleteSuratJalan(sf.sales.SuratJalanHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM sjalan_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM sjalan_detail where kcabang=? and nobukti=?"; 
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
	
	public void setAutoCommit(boolean state) throws SQLException
	{
		db.getConnection().setAutoCommit(state);
	}
	
	public boolean deleteInvoice(sf.sales.InvoiceHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM sinvoice_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM sinvoice_detail where kcabang=? and nobukti=?"; 
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
	
	public boolean updateStockAlokasi(StockAlokasi alokasi) throws DAException
	{
		try
		{
			String strSQL="UPDATE stock_alokasi set pinjam=?,booking=?,sorder=?,alokasi=?,porder=?,pshipping=?,tglupdate=?,userupdate=? where kgudang=? and kbarang=?" ;
			PreparedStatement p=db.getStatement(strSQL);
			p.setDouble(1, alokasi.getPinjam());
			p.setDouble(2, alokasi.getBooking());
			p.setDouble(3, alokasi.getSorder());
			p.setDouble(4, alokasi.getAlokasi());
			p.setDouble(5, alokasi.getPorder());
			p.setDouble(6, alokasi.getPshipping());
			p.setLong(7, alokasi.getTglupdate());
			p.setString(8, alokasi.getUserupdate());
			p.setString(9, alokasi.getKgudang());
			p.setString(10, alokasi.getKbarang());
			db.execute(p);
			return true;
		}
		catch(SQLException e)
		{
			try {
				try {
					db.getConnection().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new DAException(e1.getLocalizedMessage());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new DAException(e1.getLocalizedMessage());
			}
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getLocalizedMessage());
		}
		return false;
	}
	
	public boolean updateStockRekap(StockRekap rekap) throws DAException
	{
		try
		{
			String strSQL="UPDATE stock_rekap set onhand=?,tglupdate=?,userupdate=? where kgudang=? and kbarang=?" ;
			PreparedStatement p=db.getStatement(strSQL);
			p.setDouble(1, rekap.getOnhand());
			p.setLong(2, rekap.getTglupdate());
			p.setString(3, rekap.getUserupdate());
			p.setString(4, rekap.getKgudang());
			p.setString(5, rekap.getKbarang());
			db.execute(p);
			return true;
		}
		catch(SQLException e)
		{
			try {
				try {
					db.getConnection().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new DAException(e1.getLocalizedMessage());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new DAException(e1.getLocalizedMessage());
			}
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getLocalizedMessage());
		}
		return false;
	}
	
	public boolean insertStockAlokasi(StockAlokasi alokasi) throws DAException
	{
		try
		{
			String strSQL="INSERT INTO stock_alokasi values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, alokasi.getKgudang());
			p.setString(2, alokasi.getKbarang());
			p.setDouble(3, alokasi.getPinjam());
			p.setDouble(4, alokasi.getBooking());
			p.setDouble(5, alokasi.getSorder());
			p.setDouble(6, alokasi.getAlokasi());
			p.setDouble(7, alokasi.getPorder());
			p.setDouble(8, alokasi.getPshipping());
			p.setLong(9, alokasi.getTglupdate());
			p.setString(10, alokasi.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(SQLException e)
		{
			try {
				try {
					db.getConnection().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new DAException(e1.getLocalizedMessage());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new DAException(e1.getLocalizedMessage());
			}
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getLocalizedMessage());
		}
		return false;
	}
	
	public boolean insertStockRekap(StockRekap rekap) throws DAException
	{
		try
		{
			String strSQL="INSERT INTO stock_rekap values (?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, rekap.getKgudang());
			p.setString(2, rekap.getKbarang());
			p.setDouble(3, rekap.getOnhand());
			p.setLong(4, rekap.getTglupdate());
			p.setString(5, rekap.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(SQLException e)
		{
			try {
				try {
					db.getConnection().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					throw new DAException(e1.getLocalizedMessage());
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new DAException(e1.getLocalizedMessage());
			}
		} catch (DAException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getLocalizedMessage());
		}
		return false;
	}
	
	public StockAlokasi[] getStockAlokasi(String kbarang,String kgudang)
	{
		sf.sales.StockAlokasi[] items=null;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM stock_alokasi where kbarang=? and kgudang=?";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kbarang);
			p.setString(2, kgudang);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.StockAlokasi[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.StockAlokasi item=new sf.sales.StockAlokasi();
				
				item.setKgudang(v.get(0).toString());
				item.setKbarang(v.get(1).toString());
				item.setPinjam(Double.parseDouble(v.get(2).toString()));
				item.setBooking(Double.parseDouble(v.get(3).toString()));
				item.setSorder(Double.parseDouble(v.get(4).toString()));
				item.setAlokasi(Double.parseDouble(v.get(5).toString()));
				item.setPorder(Double.parseDouble(v.get(6).toString()));
				item.setPshipping(Double.parseDouble(v.get(7).toString()));
				item.setTglupdate(Long.parseLong(v.get(8).toString()));
				item.setRecstatus(v.get(9).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
		}
		return items;
	}
	
	public HashMap<String, StockAlokasi> getStockAlokasi()
	{
		HashMap<String, StockAlokasi> items=new HashMap<String, StockAlokasi>();// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM stock_alokasi";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.StockAlokasi item=new sf.sales.StockAlokasi();
				
				item.setKgudang(v.get(0).toString());
				item.setKbarang(v.get(1).toString());
				item.setPinjam(Double.parseDouble(v.get(2).toString()));
				item.setBooking(Double.parseDouble(v.get(3).toString()));
				item.setSorder(Double.parseDouble(v.get(4).toString()));
				item.setAlokasi(Double.parseDouble(v.get(5).toString()));
				item.setPorder(Double.parseDouble(v.get(6).toString()));
				item.setPshipping(Double.parseDouble(v.get(7).toString()));
				item.setTglupdate(Long.parseLong(v.get(8).toString()));
				item.setRecstatus(v.get(9).toString());
				String key = item.getKgudang()+ "~" + item.getKbarang();
				log.info("key:" + key + ",sorder:" + item.getSorder());
				items.put(key, item);
			}
		}
		catch(Exception ex)
		{
		}
		return items;
	}
	
	
	
	public StockRekap[] getStockRekap(String kbarang,String kgudang)
	{
		sf.sales.StockRekap[] items=null;// new Branch[count];
		try
		{
			String strSQL="SELECT * FROM stock_rekap where kbarang=? and kgudang=?";
			PreparedStatement p=db.getStatement(strSQL);
			p=db.getStatement(strSQL);
			p.setString(1, kbarang);
			p.setString(2, kgudang);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.StockRekap[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.StockRekap item=new sf.sales.StockRekap();
				
				item.setKgudang(v.get(0).toString());
				item.setKbarang(v.get(1).toString());
				item.setOnhand(Double.parseDouble(v.get(2).toString()));
				item.setTglupdate(Long.parseLong(v.get(3).toString()));
				item.setRecstatus(v.get(4).toString());
				items[i] = item;
			}
		}
		catch(Exception ex)
		{
		}
		return items;
	}
	
	public boolean deleteRetur(sf.sales.ReturHeader header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM sretur_header where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			strSQL="DELETE FROM sretur_detail where kcabang=? and nobukti=?"; 
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
	
	private boolean insertQuotationDetail(sf.sales.QuotationDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO squotation_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setInt(3, detail.getNourut());
			p.setString(4, detail.getGrouping());
			p.setString(5, detail.getKbarang());
			p.setDouble(6, detail.getJumlah());
			p.setDouble(7, detail.getJumlah1());
			p.setDouble(8, detail.getJumlah2());
			p.setDouble(9, detail.getStockbal());
			p.setDouble(10, detail.getNvaluta());
			p.setDouble(11, detail.getDiscval());
			p.setDouble(12, detail.getDisc2());
			p.setDouble(13, detail.getDiscpl());
			p.setDouble(14, detail.getPlist());
			p.setString(15, detail.getPvaluta());
			p.setString(16, detail.getKgroup());
			p.setString(17, detail.getNoso());
			p.setString(18, detail.getKet());
			p.setString(19, detail.getRecstatus());
			p.setLong(20, detail.getTglupdate());
			p.setString(21, detail.getUserupdate());
			p.setString(22, detail.getApprovedBy());
			p.setString(23, detail.getApprovedDate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	private boolean insertSalesOrderBiaya(sf.sales.SOrderBiaya biaya)
	{
		try
		{
			String strSQL="INSERT INTO sorder_biaya values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, biaya.getKcabang());
			p.setString(2, biaya.getNobukti());
			p.setString(3, biaya.getAccno());
			p.setString(4, biaya.getKvaluta());
			p.setDouble(5, biaya.getNvaluta());
			p.setDouble(6, biaya.getTrealisasi());
			p.setDouble(7, biaya.getNrealisasi());
			p.setString(8, biaya.getRecstatus());
			p.setLong(9, biaya.getTglupdate());
			p.setString(10, biaya.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	private boolean insertSalesOrderDetail(sf.sales.SalesOrderDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO sorder_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setInt(3, detail.getNourut());
			p.setString(4, detail.getGrouping());
			p.setString(5, detail.getKbarang());
			p.setDouble(6, detail.getJumlah());
			p.setDouble(7, detail.getJumlah1());
			p.setDouble(8, detail.getJumlah2());
			p.setDouble(9, detail.getStockbal());
			p.setDouble(10, detail.getNvaluta());
			p.setDouble(11, detail.getDiscval());
			p.setDouble(12, detail.getDisc2());
			p.setDouble(13, detail.getDiscpl());
			p.setDouble(14, detail.getPlist());
			p.setString(15, detail.getPvaluta());
			p.setString(16, detail.getKgroup());
			p.setString(17, detail.getKet());
			p.setString(18, detail.getNosq());
			p.setString(19, detail.getNosj());
			p.setString(20, detail.getNopo());
			p.setString(21, detail.getRecstatus());
			p.setLong(22, detail.getTglupdate());
			p.setString(23, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	private boolean insertSuratJalanDetail(sf.sales.SuratJalanDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO sjalan_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setInt(3, detail.getNourut());
			p.setString(4, detail.getGrouping());
			p.setString(5, detail.getKbarang());
			p.setDouble(6, detail.getJumlah());
			p.setDouble(7, detail.getJumlah1());
			p.setDouble(8, detail.getJumlah2());
			p.setDouble(9, detail.getStockbal());
			p.setDouble(10, detail.getNvaluta());
			p.setDouble(11, detail.getDiscval());
			p.setDouble(12, detail.getDisc2());
			p.setDouble(13, detail.getDiscpl());
			p.setDouble(14, detail.getPlist());
			p.setString(15, detail.getPvaluta());
			p.setString(16, detail.getKgroup());
			p.setString(17, detail.getKet());
			p.setString(18, detail.getNosq());
			p.setString(19, detail.getNoso());
			p.setString(20, detail.getNoinvoice());
			p.setString(21, detail.getNopo());
			p.setString(22, detail.getRecstatus());
			p.setLong(23, detail.getTglupdate());
			p.setString(24, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	private boolean insertInvoiceDetail(sf.sales.InvoiceDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO sinvoice_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setInt(3, detail.getNourut());
			p.setString(4, detail.getGrouping());
			p.setString(5, detail.getKbarang());
			p.setDouble(6, detail.getJumlah());
			p.setDouble(7, detail.getNvaluta());
			p.setDouble(8, detail.getDiscval());
			p.setDouble(9, detail.getDisc2());
			p.setDouble(10, detail.getDiscpl());
			p.setDouble(11, detail.getPlist());
			p.setString(12, detail.getPvaluta());
			p.setString(13, detail.getKgroup());
			p.setString(14, detail.getNosq());
			p.setString(15, detail.getNoso());
			p.setString(16, detail.getNosj());
			p.setString(17, detail.getNopo());
			p.setString(18, detail.getRecstatus());
			p.setLong(19, detail.getTglupdate());
			p.setString(20, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	private boolean insertReturDetail(sf.sales.ReturDetail detail)
	{
		try
		{
			String strSQL="INSERT INTO sretur_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setInt(3, detail.getNourut());
			p.setString(4, detail.getKbarang());
			p.setDouble(5, detail.getJumlah());
			p.setDouble(6, detail.getNvaluta());
			p.setDouble(7, detail.getDiscval());
			p.setDouble(8, detail.getDisc2());
			p.setDouble(9, detail.getDiscpl());
			p.setDouble(10, detail.getPlist());
			p.setString(11, detail.getPvaluta());
			p.setString(12, detail.getKgroup());
			p.setString(13, detail.getRecstatus());
			p.setLong(14, detail.getTglupdate());
			p.setString(15, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	public boolean insertSalesOrder(sf.sales.SalesOrderHeader header,sf.sales.SalesOrderDetail[] details) throws DAException
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
			//db.getConnection().setAutoCommit(false);
			String strSQL="INSERT INTO sorder_header values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getKinvoice());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getTglbukti());
			p.setString(6, header.getKclient());
			p.setString(7, header.getKsales());
			p.setString(8, header.getKservice());
			p.setString(9, header.getKvaluta());
			p.setDouble(10, header.getKkurs());
			p.setDouble(11, header.getDiscval());
			p.setDouble(12, header.getDisc1());
			p.setDouble(13, header.getDiscpl());
			p.setString(14, header.getNoscard());
			p.setString(15, header.getNoref());
			p.setString(16, header.getNotracking());
			p.setString(17, header.getNopocust());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				SalesOrderDetail detail = details[i];
				if(detail!=null)
				{
					strSQL="INSERT INTO sorder_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					p=db.getStatement(strSQL);
					p.setString(1, detail.getKcabang());
					p.setString(2, detail.getNobukti());
					p.setInt(3, detail.getNourut());
					p.setString(4, detail.getGrouping());
					p.setString(5, detail.getKbarang());
					p.setDouble(6, detail.getJumlah());
					p.setDouble(7, detail.getJumlah1());
					p.setDouble(8, detail.getJumlah2());
					p.setDouble(9, detail.getStockbal());
					p.setDouble(10, detail.getNvaluta());
					p.setDouble(11, detail.getDiscval());
					p.setDouble(12, detail.getDisc2());
					p.setDouble(13, detail.getDiscpl());
					p.setDouble(14, detail.getPlist());
					p.setString(15, detail.getPvaluta());
					p.setString(16, detail.getKgroup());
					p.setString(17, detail.getKet());
					p.setString(18, detail.getNosq());
					p.setString(19, detail.getNosj());
					p.setString(20, detail.getNopo());
					p.setString(21, detail.getRecstatus());
					p.setLong(22, detail.getTglupdate());
					p.setString(23, detail.getUserupdate());
					db.execute(p);
				}
			}
			//db.commit();
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
	
	public boolean insertSuratJalan(sf.sales.SuratJalanHeader header,sf.sales.SuratJalanDetail[] details,sf.sales.SOrderBiaya[] biaya) throws DAException
	{
		boolean bTrue=false;
		//saving header
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
			String strSQL="INSERT INTO sjalan_header values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getKinvoice());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getTglbukti());
			p.setString(6, header.getKclient());
			p.setString(7, header.getKsales());
			p.setString(8, header.getKservice());
			p.setString(9, header.getKvaluta());
			p.setDouble(10, header.getKkurs());
			p.setDouble(11, header.getDiscval());
			p.setDouble(12, header.getDisc1());
			p.setDouble(13, header.getDiscpl());
			p.setString(14, header.getNoscard());
			p.setString(15, header.getNoref());
			p.setString(16, header.getNotracking());
			p.setString(17, header.getNopocust());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				SuratJalanDetail detail = details[i];
				if(detail!=null)
				{
					strSQL="INSERT INTO sjalan_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					p=db.getStatement(strSQL);
					p.setString(1, detail.getKcabang());
					p.setString(2, detail.getNobukti());
					p.setInt(3, detail.getNourut());
					p.setString(4, detail.getGrouping());
					p.setString(5, detail.getKbarang());
					p.setDouble(6, detail.getJumlah());
					p.setDouble(7, detail.getJumlah1());
					p.setDouble(8, detail.getJumlah2());
					p.setDouble(9, detail.getStockbal());
					p.setDouble(10, detail.getNvaluta());
					p.setDouble(11, detail.getDiscval());
					p.setDouble(12, detail.getDisc2());
					p.setDouble(13, detail.getDiscpl());
					p.setDouble(14, detail.getPlist());
					p.setString(15, detail.getPvaluta());
					p.setString(16, detail.getKgroup());
					p.setString(17, detail.getKet());
					p.setString(18, detail.getNosq());
					p.setString(19, detail.getNoso());
					p.setString(20, detail.getNoinvoice());
					p.setString(21, detail.getNopo());
					p.setString(22, detail.getRecstatus());
					p.setLong(23, detail.getTglupdate());
					p.setString(24, detail.getUserupdate());
					db.execute(p);
				}
			}
			
			for(int i=0;i <biaya.length;i++)
			{
				SOrderBiaya ordBiaya = biaya[i];
				if(ordBiaya!=null)
				{
					strSQL="INSERT INTO sorder_biaya values (?,?,?,?,?,?,?,?,?,?)";
					
					p.setString(1, ordBiaya.getKcabang());
					p.setString(2, ordBiaya.getNobukti());
					p.setString(3, ordBiaya.getAccno());
					p.setString(4, ordBiaya.getKvaluta());
					p.setDouble(5, ordBiaya.getNvaluta());
					p.setDouble(6, ordBiaya.getTrealisasi());
					p.setDouble(7, ordBiaya.getNrealisasi());
					p.setString(8, ordBiaya.getRecstatus());
					p.setLong(9, ordBiaya.getTglupdate());
					p.setString(10, ordBiaya.getUserupdate());
					db.execute(p);
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
	
	public boolean insertInvoice(sf.sales.InvoiceHeader header,sf.sales.InvoiceDetail[] details) throws DAException
	{
		boolean bTrue=false;
		//saving header
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
			String strSQL="INSERT INTO sinvoice_header values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getKinvoice());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getTglbukti());
			p.setString(6, header.getKclient());
			p.setString(7, header.getKsales());
			p.setString(8, header.getKservice());
			p.setString(9, header.getKvaluta());
			p.setDouble(10, header.getKkurs());
			p.setDouble(11, header.getDiscval());
			p.setDouble(12, header.getDisc1());
			p.setDouble(13, header.getDiscpl());
			p.setString(14, header.getNoscard());
			p.setString(15, header.getNoref());
			p.setString(16, header.getNopocust());
			p.setString(17, header.getNodpayment());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				InvoiceDetail detail = details[i];
				if(detail!=null)
				{
					strSQL="INSERT INTO sinvoice_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					p=db.getStatement(strSQL);
					p.setString(1, detail.getKcabang());
					p.setString(2, detail.getNobukti());
					p.setInt(3, detail.getNourut());
					p.setString(4, detail.getGrouping());
					p.setString(5, detail.getKbarang());
					p.setDouble(6, detail.getJumlah());
					p.setDouble(7, detail.getNvaluta());
					p.setDouble(8, detail.getDiscval());
					p.setDouble(9, detail.getDisc2());
					p.setDouble(10, detail.getDiscpl());
					p.setDouble(11, detail.getPlist());
					p.setString(12, detail.getPvaluta());
					p.setString(13, detail.getKgroup());
					p.setString(14, detail.getNosq());
					p.setString(15, detail.getNoso());
					p.setString(16, detail.getNosj());
					p.setString(17, detail.getNopo());
					p.setString(18, detail.getRecstatus());
					p.setLong(19, detail.getTglupdate());
					p.setString(20, detail.getUserupdate());
					db.execute(p);
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
	
	public boolean insertRetur(sf.sales.ReturHeader header,sf.sales.ReturDetail[] details) throws DAException
	{
		boolean bTrue=false;
		//saving header
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
			String strSQL="INSERT INTO sretur_header values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getKinvoice());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getTglbukti());
			p.setString(6, header.getKclient());
			p.setString(7, header.getKsales());
			p.setString(8, header.getKservice());
			p.setString(9, header.getKvaluta());
			p.setDouble(10, header.getDiscval());
			p.setDouble(11, header.getDisc1());
			p.setDouble(12, header.getDiscpl());
			p.setString(13, header.getNoscard());
			p.setString(14, header.getExnoinvoice());
			p.setString(15, header.getKet());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				ReturDetail detail = details[i];
				if(detail!=null)
				{
					strSQL="INSERT INTO sretur_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					p=db.getStatement(strSQL);
					p.setString(1, detail.getKcabang());
					p.setString(2, detail.getNobukti());
					p.setInt(3, detail.getNourut());
					p.setString(4, detail.getKbarang());
					p.setDouble(5, detail.getJumlah());
					p.setDouble(6, detail.getNvaluta());
					p.setDouble(7, detail.getDiscval());
					p.setDouble(8, detail.getDisc2());
					p.setDouble(9, detail.getDiscpl());
					p.setDouble(10, detail.getPlist());
					p.setString(11, detail.getPvaluta());
					p.setString(12, detail.getKgroup());
					p.setString(13, detail.getRecstatus());
					p.setLong(14, detail.getTglupdate());
					p.setString(15, detail.getUserupdate());
					db.execute(p);
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
	
	public String checkSOExist(String noPO) throws DAException
	{
		
		try {
			String strSQL="SELECT nobukti from sorder_header where nopocust=?";
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
	public boolean insertQuotation(sf.sales.QuotationHeader header,sf.sales.QuotationDetail[] details) throws DAException
	{
		boolean bTrue=false;
		//saving header
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
			String strSQL="INSERT INTO squotation_header values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			p.setString(3, header.getKinvoice());
			p.setString(4, header.getKgudang());
			p.setString(5, header.getTglbukti());
			p.setString(6, header.getKclient());
			p.setString(7, header.getKsales());
			p.setString(8, header.getKservice());
			p.setString(9, header.getKvaluta());
			p.setDouble(10, header.getKkurs());
			p.setDouble(11, header.getDiscval());
			p.setDouble(12, header.getDisc1());
			p.setDouble(13, header.getDiscpl());
			p.setString(14, header.getNoscard());
			p.setString(15, header.getNoref());
			p.setString(16, header.getNotracking());
			p.setString(17, header.getKontak1());
			p.setString(18, header.getKontak2());
			p.setString(19, header.getKontak3());
			p.setString(20, header.getValidity());
			p.setString(21, header.getSyarat());
			p.setString(22, header.getKirim());
			p.setString(23, header.getKet1());
			p.setString(24, header.getKet2());
			p.setString(25, header.getKet3());
			db.execute(p);
			for(int i=0; i < details.length;i++)
			{
				QuotationDetail detail = details[i];
				if(detail!=null)
				{
					strSQL="INSERT INTO squotation_detail values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					p=db.getStatement(strSQL);
					p.setString(1, detail.getKcabang());
					p.setString(2, detail.getNobukti());
					p.setInt(3, detail.getNourut());
					p.setString(4, detail.getGrouping());
					p.setString(5, detail.getKbarang());
					p.setDouble(6, detail.getJumlah());
					p.setDouble(7, detail.getJumlah1());
					p.setDouble(8, detail.getJumlah2());
					p.setDouble(9, detail.getStockbal());
					p.setDouble(10, detail.getNvaluta());
					p.setDouble(11, detail.getDiscval());
					p.setDouble(12, detail.getDisc2());
					p.setDouble(13, detail.getDiscpl());
					p.setDouble(14, detail.getPlist());
					p.setString(15, detail.getPvaluta());
					p.setString(16, detail.getKgroup());
					p.setString(17, detail.getNoso());
					p.setString(18, detail.getKet());
					p.setString(19, detail.getRecstatus());
					p.setLong(20, detail.getTglupdate());
					p.setString(21, detail.getUserupdate());
					p.setString(22, detail.getApprovedBy());
					p.setString(23, detail.getApprovedDate());
					db.execute(p);
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
	
	public Cetak cetakQuotation() throws DAException
	{
		Cetak obj = new Cetak();
		String strSQL="select a.kcabang,a.nobukti,a.kvaluta,a.disc1,a.ksales,a.noref,a.notracking,a.kontak1,a.kontak2,a.kontak3,a.validity,a.syarat,a.kirim,a.ket1,a.ket2,a.ket3,b.nourut,b.grouping,b.kbarang,b.jumlah,b.jumlah1,b.jumlah2,b.stockbal,b.nvaluta,b.discval,b.disc2,b.discpl,b.plist,b.pvaluta,b.kgroup,b.noso,b.ket,b.recstatus,b.tglupdate,b.userupdate,b.approvedby,b.approvedtgl,case when (b.grouping='' or e.jumlah=0) then c.nbarang else '' end as namabarang,case when (b.grouping='' or e.jumlah=0) then b.kbarang else e.keterangan end as keterangan,case when (b.grouping='' or e.jumlah=0) then (b.nvaluta- b.disc2*b.nvaluta/100) else (e.jumlah- b.disc2*e.jumlah/100) end as netto,case when d.kdtrs='01' then 10 else 0 end as ppn,c.satuan,case when b.grouping='' then f.satuan else e.satuan end as satuanGroup,case when (b.grouping='' or e.jumlah=0) then b.jumlah else e.jumlah end as jumlahGroup,case when (b.grouping<>'' and e.jumlah=0) then e.keterangan else'' end as keterangan1 from squotation_header a join squotation_detail b join mproduk c join mcustomer d join mproduk f on (a.kcabang=b.kcabang and a.nobukti=b.nobukti and b.kbarang=c.kbarang and a.kclient=d.kclient and b.kbarang=f.kbarang) left join squotation_group e on (b.kcabang=e.kcabang and b.nobukti=e.nobukti and b.grouping=e.grouping) group by namabarang,a.nobukti,a.kcabang";
		log.info("cetakQuotation->" + strSQL);
		Vector rows = db.getData(strSQL);
		if(rows==null)
		{
			log.info("cetakQuotation->rows is null");
			return null;
		}
		log.info("cetakQuotation->getcolumn-" + db.getCurrentColumnCount());
		int count=rows.size();
		String[] items=new String[count];
		obj.setRowCount( count);
		obj.setColCount(db.getCurrentColumnCount());
		
		StringBuffer sb =new StringBuffer();
		
		for(int i=0;i < db.getCurrentColumnCount();i++ )
		{
			sb.append(db.getColumnName(i));
			if(i < db.getCurrentColumnCount()-1)
				sb.append("#");
		}
		String cols = sb.toString();
		log.info("cetakQuotation->getcolumn-" + cols);
		obj.setColumns(cols);
		for(int i=0;i < count;i++)
		{
			Vector item= (Vector)rows.get(i);
			StringBuffer sbRow=new StringBuffer();
			for(int j=0;j <db.getCurrentColumnCount();j++)
			{
				sbRow.append(item.get(j).toString().equals("")? " ":item.get(j).toString());
				if(j< db.getCurrentColumnCount()-1)
					sbRow.append("#");
				
			}
			items[i] = sbRow.toString();
		}
		obj.setValues(items);
		return obj;
	}
	
	public sf.sales.SDPayment[] getSDPayment(String kcabang,String fromDate,String toDate) throws DAException
	{
		sf.sales.SDPayment[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			if(kcabang.equals("") && fromDate.equals("") && toDate.equals(""))
			{
				String strSQL="SELECT * FROM sdpayment order by nobukti asc";
				p=db.getStatement(strSQL);
			}
			else
			{
				String strSQL="SELECT * FROM sdpayment where kcabang=? and tglbukti between ? and ? order by nobukti asc";
				p=db.getStatement(strSQL);
				p.setString(1, kcabang);
				p.setString(2, fromDate);
				p.setString(3, toDate);
			}
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SDPayment[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SDPayment header=new sf.sales.SDPayment();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setTglbukti(v.get(3).toString());
				header.setKclient(v.get(4).toString());
				header.setKsales(v.get(5).toString());
				header.setKvaluta(v.get(6).toString());
				header.setNvaluta(Double.parseDouble(v.get(7).toString()));
				header.setDisc1(Double.parseDouble(v.get(8).toString()));
				header.setPpn(Double.parseDouble(v.get(9).toString()));
				header.setKet1(v.get(10).toString());
				header.setKet2(v.get(11).toString());
				header.setKet3(v.get(12).toString());
				header.setKet4(v.get(13).toString());
				header.setKet5(v.get(14).toString());
				header.setRecstatus(v.get(15).toString());
				header.setTglupdate(Long.parseLong(v.get(16).toString()));
				header.setUserupdate(v.get(17).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SDPayment[] getNoDP(String kclient,String kvaluta) throws DAException
	{
		sf.sales.SDPayment[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM sdpayment where kclient=? and kvaluta=? order by nobukti asc";
			p=db.getStatement(strSQL);
			p.setString(1, kclient);
			p.setString(2, kvaluta);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SDPayment[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SDPayment header=new sf.sales.SDPayment();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setTglbukti(v.get(3).toString());
				header.setKclient(v.get(4).toString());
				header.setKsales(v.get(5).toString());
				header.setKvaluta(v.get(6).toString());
				header.setNvaluta(Double.parseDouble(v.get(7).toString()));
				header.setDisc1(Double.parseDouble(v.get(8).toString()));
				header.setPpn(Double.parseDouble(v.get(9).toString()));
				header.setKet1(v.get(10).toString());
				header.setKet2(v.get(11).toString());
				header.setKet3(v.get(12).toString());
				header.setKet4(v.get(13).toString());
				header.setKet5(v.get(14).toString());
				header.setRecstatus(v.get(15).toString());
				header.setTglupdate(Long.parseLong(v.get(16).toString()));
				header.setUserupdate(v.get(17).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public sf.sales.SDPayment[] getNoDP(String nobukti) throws DAException
	{
		sf.sales.SDPayment[] items;// new Branch[count];
		try
		{
			PreparedStatement p=null;
			String strSQL="SELECT * FROM sdpayment where nobukti=?";
			p=db.getStatement(strSQL);
			p.setString(1, nobukti);
			
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.sales.SDPayment[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.sales.SDPayment header=new sf.sales.SDPayment();
				
				header.setKcabang(v.get(0).toString());
				header.setNobukti(v.get(1).toString());
				header.setKinvoice(v.get(2).toString());
				header.setTglbukti(v.get(3).toString());
				header.setKclient(v.get(4).toString());
				header.setKsales(v.get(5).toString());
				header.setKvaluta(v.get(6).toString());
				header.setNvaluta(Double.parseDouble(v.get(7).toString()));
				header.setDisc1(Double.parseDouble(v.get(8).toString()));
				header.setPpn(Double.parseDouble(v.get(9).toString()));
				header.setKet1(v.get(10).toString());
				header.setKet2(v.get(11).toString());
				header.setKet3(v.get(12).toString());
				header.setKet4(v.get(13).toString());
				header.setKet5(v.get(14).toString());
				header.setRecstatus(v.get(15).toString());
				header.setTglupdate(Long.parseLong(v.get(16).toString()));
				header.setUserupdate(v.get(17).toString());
				items[i] = header;
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return items;
	}
	
	public boolean insertSDPayment(sf.sales.SDPayment detail) throws DAException
	{
		try
		{
			String strSQL="INSERT INTO sdpayment values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getNobukti());
			p.setString(3, detail.getKinvoice());
			p.setString(4, detail.getTglbukti());
			p.setString(5, detail.getKclient());
			p.setString(6, detail.getKsales());
			p.setString(7, detail.getKvaluta());
			p.setDouble(8, detail.getNvaluta());
			p.setDouble(9, detail.getDisc1());
			p.setDouble(10, detail.getPpn());
			p.setString(11, detail.getKet1());
			p.setString(12, detail.getKet2());
			p.setString(13, detail.getKet3());
			p.setString(14, detail.getKet4());
			p.setString(15, detail.getKet5());
			p.setString(16, detail.getRecstatus());
			p.setLong(17, detail.getTglupdate());
			p.setString(18, detail.getUserupdate());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	public boolean updateSDPayment(sf.sales.SDPayment detail) throws DAException
	{
		try
		{
			String strSQL="UPDATE sdpayment set kcabang=?,kinvoice=?,tglbukti=?,kclient=?,ksales=?,kvaluta=?,nvaluta=?,disc1=?,ppn=?,ket1=?,ket2=?,ket3=?,ket4=?,ket5=?,recstatus=?,tglupdate=?,userupdate=? where nobukti=?";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, detail.getKcabang());
			p.setString(2, detail.getKinvoice());
			p.setString(3, detail.getTglbukti());
			p.setString(4, detail.getKclient());
			p.setString(5, detail.getKsales());
			p.setString(6, detail.getKvaluta());
			p.setDouble(7, detail.getNvaluta());
			p.setDouble(8, detail.getDisc1());
			p.setDouble(9, detail.getPpn());
			p.setString(10, detail.getKet1());
			p.setString(11, detail.getKet2());
			p.setString(12, detail.getKet3());
			p.setString(13, detail.getKet4());
			p.setString(14, detail.getKet5());
			p.setString(15, detail.getRecstatus());
			p.setLong(16, detail.getTglupdate());
			p.setString(17, detail.getUserupdate());
			p.setString(18, detail.getNobukti());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
	
	public boolean deleteSDPayment(sf.sales.SDPayment header) throws DAException
	{
		if(header.checkIsNULL())
		{
			throw new DAException(header.getErr());
		}
		
		try
		{
			db.getConnection().setAutoCommit(false);
			String strSQL="DELETE FROM sdpayment where kcabang=? and nobukti=?"; 
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, header.getKcabang());
			p.setString(2, header.getNobukti());
			db.execute(p);
			return true;
		}
		catch(Exception ex)
		{
			
		}
		return false;
	}
}
