package bo.sales;

import java.sql.SQLException;

import org.apache.log4j.Category;

import sf.cetak.Cetak;
import sf.inventory.ProdukSet;
import sf.sales.InvoiceDetail;
import sf.sales.InvoiceGroup;
import sf.sales.InvoiceHeader;
import sf.sales.QuotationGroup;
import sf.sales.ReturDetail;
import sf.sales.SDPayment;
import sf.sales.SalesOrderDetail;
import sf.sales.SalesOrderGroup;
import sf.sales.SuratJalanDetail;
import sf.sales.SuratJalanGroup;
import bo.inventory.Produk;
import da.error.DAException;

public class Sales {
	private da.sales.Sales daSales;
	static final Category log = Category.getInstance(Sales.class);
	public Sales() throws DAException
	{
		daSales=new da.sales.Sales();
	}
	public int getNoBukti() throws DAException
	{
		return daSales.getNoBukti();
	}
	public int getNoBuktiSO() throws DAException
	{
		return daSales.getNoBuktiSO();
	}
	public int getNoSO() throws DAException
	{
		return daSales.getNoSO();
	}
	public int getNoSJ() throws DAException
	{
		return daSales.getNoSJ();
	}
	
	public int getNoBuktiRetur() throws DAException
	{
		return daSales.getNoBuktiRetur();
	}
	public int getNoSI() throws DAException
	{
		return daSales.getNoBuktiInvoice();
	}
	public int getNoBuktiSDPayment() throws DAException
	{
		return daSales.getNoBuktiSDPayment();
	}
	public String checkSOExist(String noPO) throws DAException
	{
		return daSales.checkSOExist(noPO);
	}
	public sf.sales.SCardHeader[] getKartuService() throws DAException 
	{
		return daSales.getKartuService();
	}
	
	public QuotationGroup[] getGrouping(String kcabang,String nobukti)throws DAException
	{
		return daSales.getGrouping(kcabang, nobukti);
	}
	
	public SalesOrderGroup[] getSalesGrouping(String kcabang,String nobukti)throws DAException
	{
		return daSales.getSalesGrouping(kcabang, nobukti);
	}
	public boolean insertGrouping(sf.sales.QuotationGroup group) throws DAException
	{
		return daSales.insertGrouping(group);
	}
	public boolean insertQuotation(sf.sales.QuotationHeader header,sf.sales.QuotationDetail[] details) throws DAException
	{
		return daSales.insertQuotation(header, details);
	}
	
	public boolean deleteQuotation(sf.sales.QuotationHeader header) throws DAException
	{
		return daSales.deleteQuotation(header);
	}
	
	public boolean updateQuotation(sf.sales.QuotationHeader header,sf.sales.QuotationDetail[] details) throws DAException
	{
		return daSales.updateQuotation(header, details);
	}
	
	public boolean updateSalesOrder(sf.sales.SalesOrderHeader header,sf.sales.SalesOrderDetail[] details,sf.sales.SOrderBiaya[] biayas) throws DAException
	{
		Stock stock = new Stock(daSales);
		try {
			daSales.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		for(SalesOrderDetail detail : details)
		{
			log.info("updateSalesOrder->" + detail.getKbarang() + ";" + header.getKgudang());
			stock.editStockAlokasi(detail, header.getKgudang());
		}
		
		daSales.updateSalesOrder(header, details,biayas);
		daSales.commit();
		return true;
	}
	
	public sf.sales.SOrderBiaya getSalesOrderBiaya(String kcabang,String nobukti)
	{
		sf.sales.SOrderBiaya biaya = new sf.sales.SOrderBiaya();
		biaya.setBiayas(daSales.getSalesOrderBiaya(kcabang, nobukti));
		return biaya;
	}
	public boolean updateSuratJalan(sf.sales.SuratJalanHeader header,sf.sales.SuratJalanDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(int i=0;i < details.length;i++)
		{
			stock.editStockRekap(details[i], header.getKgudang());
		}
		return daSales.updateSuratJalan(header, details);	
	}
	public boolean updateInvoice(sf.sales.InvoiceHeader header,sf.sales.InvoiceDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(int i=0;i < details.length;i++)
		{
			stock.editStockRekap(details[i], header.getKgudang());
		}
		return daSales.updateInvoice(header, details);	
	}
	public boolean updateRetur(sf.sales.ReturHeader header,sf.sales.ReturDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(int i=0;i < details.length;i++)
		{
			stock.editStockRekap(details[i], header.getKgudang());
		}
		return daSales.updateRetur(header, details);	
	}
	public sf.sales.QuotationDetail[] getQuotationDetail(String kcabang,String noBukti) throws DAException
	{
		return daSales.getQuotationDetail(kcabang, noBukti);
	}
	
	public boolean approved(int nourut,String kbarang,String kcabang,String nobukti,String approvedby,String approvedTgl) throws DAException
	{
		return daSales.approved(nourut,kbarang,kcabang, nobukti, approvedby, approvedTgl);
	}
	public sf.sales.QuotationDetail[] getQuotationDetailSOOut(String kcabang,String noBukti) throws DAException
	{
		return daSales.getQuotationDetailSOOut(kcabang, noBukti);
	}
	
	public sf.sales.SalesOrderHeader[] getSalesOrder(String kcabang,String fromDate,String toDate,int type) throws DAException
	{
		if(type==0)
			return daSales.getSalesOrder(kcabang, fromDate, toDate);
		else if(type==1)
		{
			return daSales.getSalesOrderBySJOut(kcabang, fromDate, toDate);
		}
		else
			return null;
	}
	
	public sf.sales.SuratJalanHeader[] getSuratJalan(String kcabang,String fromDate,String toDate,int type) throws DAException
	{
		if(type==0)
			return daSales.getSuratJalan(kcabang, fromDate, toDate);
		else if(type==1)
		{
			return daSales.getSuratJalanHeaderBySIOut(kcabang, fromDate, toDate);
		}
		else
			return null;
	}
	
	public sf.sales.InvoiceHeader getInvoiceByClient(String kclient) throws DAException
	{
		InvoiceHeader header = new InvoiceHeader();
		header.setInvoiceHeaders(daSales.getInvoice(kclient));
		return header;
	}
	public sf.sales.InvoiceHeader[] getInvoice(String kcabang,String fromDate,String toDate,int type) throws DAException
	{
		if(type==0)
			return daSales.getInvoice(kcabang, fromDate, toDate);
		else if(type==1)
		{
			return daSales.getInvoiceBySIOut(kcabang, fromDate, toDate);
		}
		else
			return null;
	}
	
	public sf.sales.ReturHeader[] getRetur(String kcabang,String fromDate,String toDate) throws DAException
	{
		return daSales.getRetur(kcabang, fromDate, toDate);
	}
	
	public sf.sales.ReturDetail getReturDetail(String kcabang,String nobukti) throws DAException
	{
		ReturDetail detail = new ReturDetail();
		detail.setReturDetails(daSales.getReturDetail(kcabang, nobukti));
		return detail;
	}
	
	public sf.sales.QuotationDetail[] getQuotationDetailNotApproved(String kcabang,String noBukti) throws DAException
	{
		return daSales.getQuotationDetailNoApproved(kcabang, noBukti);
	}
	
	public sf.sales.QuotationHeader[] getQuotationHeader(String kcabang,String fromDate,String toDate,int type) throws DAException
	{
		if(type==0)
			return daSales.getQuotationHeader(kcabang, fromDate, toDate);
		else if(type==1)
		{
			return daSales.getQuotationHeaderBySOOut(kcabang, fromDate, toDate);
		}
		else if(type==2)
		{
			return daSales.getQuotationHeaderByNotApproved(kcabang, fromDate, toDate);
		}
		else
			return null;
	}
	
	public boolean updateQuotationDetail(sf.sales.QuotationDetail detail) throws DAException
	{
		return daSales.updateQuotationDetail(detail);
	}
	
	public boolean updateQuotationGroup(sf.sales.QuotationGroup group) throws DAException
	{
		return daSales.updateQuotationGroup(group);
	}
	public boolean updateQuotationHeader(sf.sales.QuotationHeader header) throws DAException
	{
		return daSales.updateQuotationHeader(header);
	}
	
	public boolean deleteQuotationGroup(sf.sales.QuotationGroup group) throws DAException
	{
		return daSales.deleteQuotationGroup(group);
	}
	
	public double getStockBalance(String kbarang,String kgudang) throws DAException
	{
		//rules..
		Produk boProduk = new Produk();
		sf.inventory.Produk sfProduk = boProduk.getProduk(kbarang, "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
				return daSales.getStockBalance(kbarang, kgudang);
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					ProdukSet ps = boProduk.getProdukSet(kbarang, "EPP");
					if(ps!=null && ps.getProduksets()!=null && ps.getProduksets().length>0)
					{
						double stockbalance=0;
						for(sf.inventory.ProdukSet p : ps.getProduksets())
						{
							sf.inventory.Produk produkChild = boProduk.getProduk(ps.getKbarang1(), "EPP");
							if(produkChild!=null && produkChild.getStockbal().equals("Y"))
							{
								stockbalance+=daSales.getStockBalance(p.getKbarang1(), kgudang);
							}
						}
						return stockbalance;
					}
				}
			}
		}
		return 0;
	}
	
	public boolean insertSalesOrder(sf.sales.SalesOrderHeader header,sf.sales.SalesOrderDetail[] details) throws DAException
	{
		Stock stock  = new Stock(daSales);
		try {
			daSales.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		for(int i=0;i < details.length;i++)
		{
			if(details[i]==null)
				continue;
			
			stock.insertStockAlokasi(details[i], header.getKgudang());
		}
		daSales.insertSalesOrder(header, details);
		daSales.commit();
		return true;
	}
	
	
	
	public boolean insertSuratJalan(sf.sales.SuratJalanHeader header,sf.sales.SuratJalanDetail[] details,sf.sales.SOrderBiaya[] biayas) throws DAException
	{
		Stock stock = new Stock(daSales);
		try {
			daSales.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		for(int i=0;i < details.length;i++)
		{
			stock.editStockRekap(details[i], header.getKgudang());
		}
		daSales.insertSuratJalan(header, details,biayas);
		daSales.commit();
		return true;
	}
	
	public boolean insertInvoice(sf.sales.InvoiceHeader header,sf.sales.InvoiceDetail[] details) throws DAException
	{
		return daSales.insertInvoice(header, details);
	}
	
	public boolean insertRetur(sf.sales.ReturHeader header,sf.sales.ReturDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(int i=0;i < details.length;i++)
		{
			stock.editStockRekap(details[i], header.getKgudang());
		}
		return daSales.insertRetur(header, details);
	}
	
	public sf.sales.SalesOrderDetail[] getSalesOrderDetail(String kcabang,String noBukti) throws DAException
	{
		return daSales.getSalesOrderDetail(kcabang, noBukti);
	}
	public sf.sales.SuratJalanDetail[] getSuratJalanDetail(String kcabang,String noBukti) throws DAException
	{
		return daSales.getSuratJalanDetail(kcabang, noBukti);
	}
	public sf.sales.SalesOrderHeader[] getSalesOrderHeader(String kcabang,String nobukti) throws DAException
	{
		return daSales.getSalesOrderHeader(kcabang, nobukti);
	}
	
	public sf.sales.SuratJalanHeader[] getSuratJalanHeader(String kcabang,String nobukti) throws DAException
	{
		return daSales.getSuratJalanHeader(kcabang, nobukti);
	}
	
	public boolean insertSalesOrderGroup(sf.sales.SalesOrderGroup group) throws DAException
	{
		return daSales.insertSalesOrderGroup(group);
	}
	public boolean insertSuratJalanGroup(sf.sales.SuratJalanGroup group) throws DAException
	{
		return daSales.insertSuratJalanGroup(group);
	}
	public boolean insertInvoiceGroup(sf.sales.InvoiceGroup group) throws DAException
	{
		return daSales.insertInvoiceGroping(group);
	}
	public boolean deleteSalesOrder(sf.sales.SalesOrderHeader header,sf.sales.SalesOrderDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(SalesOrderDetail detail : details)
		{
			stock.deleteStockAlokasi(detail, header.getKgudang());
		}
		
		return daSales.deleteSalesOrder(header);
	}
	
	public boolean deleteSalesOrderDetail(sf.sales.SalesOrderHeader header, sf.sales.SalesOrderDetail detail) throws DAException
	{
		Stock stock = new Stock(daSales);
		stock.deleteStockAlokasi(detail, header.getKgudang());
		return daSales.deleteSalesOrderDetail(detail);
	}
	public boolean deleteSalesOrderGroup(sf.sales.SalesOrderGroup group) throws DAException
	{
		return daSales.deleteSalesOrderGroup(group);
	}
	public boolean updateSalesOrderDetail(sf.sales.SalesOrderDetail detail) throws DAException
	{
		return daSales.updateSalesOrderDetail(detail);
	}
	public boolean updateSuratJalanDetail(sf.sales.SuratJalanDetail detail) throws DAException
	{
		return daSales.updateSuratJalanDetail(detail);
	}
	public boolean updateSalesOrderGroup(sf.sales.SalesOrderGroup group) throws DAException
	{
		return daSales.updateSalesOrderGroup(group);
	}
	public boolean updateSuratJalanGroup(sf.sales.SuratJalanGroup group) throws DAException
	{
		return daSales.updateSuratJalanGroup(group);
	}
	public boolean updateSalesOrderHeader(sf.sales.SalesOrderHeader header) throws DAException
	{
		return daSales.updateSalesOrderHeader(header);
	}
	public boolean updateSuratJalanHeader(sf.sales.SuratJalanHeader header) throws DAException
	{
		return daSales.updateSuratJalanHeader(header);
	}
	public boolean deleteSuratJalan(sf.sales.SuratJalanHeader header,sf.sales.SuratJalanDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(SuratJalanDetail detail : details)
		{
			stock.deleteStockAlokasi(detail, header.getKgudang());
		}
		return daSales.deleteSuratJalan(header);
	}
	
	public boolean deleteInvoice(sf.sales.InvoiceHeader header,sf.sales.InvoiceDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(InvoiceDetail detail : details)
		{
			stock.deleteStockRekap(detail, header.getKgudang());
		}
		return daSales.deleteInvoice(header);
	}
	
	public boolean deleteRetur(sf.sales.ReturHeader header,sf.sales.ReturDetail[] details) throws DAException
	{
		Stock stock = new Stock(daSales);
		for(int i=0;i < details.length;i++)
		{
			stock.deleteStockRekap(details[i], header.getKgudang());
		}
		return daSales.deleteRetur(header);
	}
	
	public SuratJalanGroup[] getSuratJalanGrouping(String kcabang,String nobukti)throws DAException
	{
		return daSales.getSuratJalanGrouping(kcabang, nobukti);
	}
	
	public Cetak cetakQuotation() throws DAException
	{
		log.info("bo->cetakQuotation->enter-");
		return daSales.cetakQuotation();
	}
	
	public boolean updateSorderBiaya(sf.sales.SOrderBiaya sOrderBiaya) throws DAException
	{
		return daSales.updateSorderBiaya(sOrderBiaya);
	}
	
	public boolean deleteSorderBiaya(sf.sales.SOrderBiaya sOrderBiaya) throws DAException
	{
		return daSales.deleteSorderBiaya(sOrderBiaya);
	}
	
	public sf.sales.SDPayment getSDPayment(String kcabang,String fromDate,String toDate) throws DAException
	{
		SDPayment sdPayment = new SDPayment();
		sdPayment.setSdpayments(daSales.getSDPayment(kcabang, fromDate, toDate));
		return sdPayment;
	}
	
	public boolean insertSDPayment(sf.sales.SDPayment detail) throws DAException
	{
		return daSales.insertSDPayment(detail);
	}
	
	public boolean updateSDPayment(sf.sales.SDPayment detail) throws DAException
	{
		return daSales.updateSDPayment(detail);
	}
	
	public boolean deleteSDPayment(sf.sales.SDPayment header) throws DAException
	{
		return daSales.deleteSDPayment(header);
	}
	
	public sf.sales.SDPayment getNoDP(String kclient,String kvaluta) throws DAException
	{
		SDPayment sdPayment = new SDPayment();
		sdPayment.setSdpayments(daSales.getNoDP(kclient, kvaluta));
		return sdPayment;
	}
	
	public sf.sales.SDPayment getNoDPByNoBukti(String nobukti) throws DAException
	{
		SDPayment sdPayment = new SDPayment();
		sdPayment.setSdpayments(daSales.getNoDP(nobukti));
		return sdPayment;
	}
	
	public InvoiceGroup getInvoiceGrouping(String kcabang,String nobukti)throws DAException
	{
		InvoiceGroup invGroup=new InvoiceGroup();
		invGroup.setGroups(daSales.getInvoiceGrouping(kcabang, nobukti));
		return invGroup;
	}
	
	public sf.sales.InvoiceDetail getInvoiceDetail(String kcabang,String noBukti) throws DAException
	{
		InvoiceDetail detail = new InvoiceDetail();
		detail.setInvoiceDetails(daSales.getInvoiceDetail(kcabang, noBukti));
		return detail;
	}
}
