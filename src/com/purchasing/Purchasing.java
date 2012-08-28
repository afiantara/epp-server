package com.purchasing;

import sf.purchasing.BiayaShipping;
import sf.purchasing.PDDetail;
import sf.purchasing.PDHeader;
import sf.purchasing.PIDetail;
import sf.purchasing.PIHeader;
import sf.purchasing.PODetail;
import sf.purchasing.POHeader;
import sf.purchasing.PRDetail;
import sf.purchasing.PRHeader;
import sf.purchasing.PReturDetail;
import sf.purchasing.PReturHeader;
import sf.purchasing.ShippingDetail;
import sf.purchasing.ShippingHeader;
import sf.purchasing.ShippingUpload;
import sf.purchasing.SptBShipping;
import sf.purchasing.Title;
import bo.purchasing.PDBusiness;
import bo.purchasing.PIBusiness;
import bo.purchasing.POBusiness;
import bo.purchasing.PRBusiness;
import bo.purchasing.ShippingBO;
import da.error.DAException;

public class Purchasing {
	private bo.purchasing.Supplier boSupplier;
	private bo.purchasing.PRequestBusiness boPurchase;
	private bo.purchasing.POBusiness boPO;
	private bo.purchasing.ShippingBO boShipping;
	private bo.purchasing.PDBusiness boPD;
	private bo.purchasing.PIBusiness boPI;
	private bo.purchasing.PRBusiness boPR;
	public Purchasing() throws DAException
	{
		boSupplier=new bo.purchasing.Supplier();
		boPurchase=new bo.purchasing.PRequestBusiness();
		boPO=new POBusiness();
		boShipping=new ShippingBO();
		boPD=new PDBusiness();
		boPI=new PIBusiness();
		boPR=new PRBusiness();
	}
	
	public sf.purchasing.Supplier getSupplier() throws DAException
	{
		sf.purchasing.Supplier supplier=new sf.purchasing.Supplier();
		supplier.setSuppliers(boSupplier.getSupplier());
		return supplier;
	}

	public sf.purchasing.Supplier getSupplierByCode(String kvendor) throws DAException
	{
		return boSupplier.getSupplier(kvendor);
	}
	
	public boolean insertSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		return boSupplier.insertSupplier(supplier);
	}
	
	public boolean updateSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		supplier.setRecstatus("U");
		return boSupplier.updateSupplier(supplier);
	}
	
	public boolean deleteSupplier(sf.purchasing.Supplier supplier) throws DAException
	{
		supplier.setRecstatus("D");
		return boSupplier.updateSupplier(supplier);
		//return boSupplier.deleteSupplier(kvendor);
	}
	
	public int getNoPR() throws DAException
	{
		return boPurchase.getNoPR();
	}
	
	public int getNoShipping() throws DAException
	{
		return boShipping.getNoShipping();
	}
	
	public int getNOPO() throws DAException
	{
		return boPO.getNoPO();
	}
	
	public int getNOPR() throws DAException
	{
		return boPR.getNoPR();
	}
	
	public int getNOPI() throws DAException
	{
		return boPI.getNoPI();
	}
	
	public String checkPOExist(String noPO) throws DAException
	{
		return boPO.checkPOExist(noPO);
	}
	
	public String checkPIExist(String noPI) throws DAException
	{
		return boPI.checkPIExist(noPI);
	}
	
	public String checkPRExist(String noPR) throws DAException
	{
		return boPR.checkPRExist(noPR);
	}
	
	public String checkShippingExist(String noShipping) throws DAException
	{
		return boShipping.checkShippingExist(noShipping);
	}
	public boolean insertSinglePR(PRHeader header,PRDetail details) throws DAException
	{
		return boPurchase.insertPR(header, details);
	}
	public boolean insertPR(sf.purchasing.PRHeader header,PRDetail[] details) throws DAException
	{
		return boPurchase.insertPR(header, details);
	}
	
	public boolean insertPE(sf.purchasing.PReturHeader header,PReturDetail[] details) throws DAException
	{
		return boPR.insertPR(header, details);
	}
	
	public boolean insertPO(POHeader header,PODetail[] details) throws DAException
	{
		return boPO.insertPO(header, details);
	}
	
	public boolean insertPI(PIHeader header,PIDetail[] details) throws DAException
	{
		return boPI.insertPI(header, details);
	}
	
	public boolean insertShipping(ShippingHeader header,ShippingDetail[] details,BiayaShipping[] biaya,SptBShipping[] spt) throws DAException
	{
		return boShipping.insertShipping(header, details,biaya,spt);
	}
	
	public boolean updatePO(sf.purchasing.POHeader header,sf.purchasing.PODetail[] details) throws DAException
	{
		return boPO.updatePO(header, details);
	}
	
	public boolean updatePI(sf.purchasing.PIHeader header,sf.purchasing.PIDetail[] details) throws DAException
	{
		return boPI.updatePI(header, details);
	}
	
	public boolean updatePE(sf.purchasing.PReturHeader header,sf.purchasing.PReturDetail[] details) throws DAException
	{
		return boPR.updatePR(header, details);
	}
	
	public boolean updateShipping(ShippingHeader header,ShippingDetail[] details,BiayaShipping[] biaya,SptBShipping[] spt) throws DAException
	{
		return boShipping.updateShipping(header, details,biaya,spt);
	}
	
	public boolean deletePO(sf.purchasing.POHeader header) throws DAException
	{
		return boPO.deletePO(header);
	}
	
	public boolean deletePI(sf.purchasing.PIHeader header) throws DAException
	{
		return boPI.deletePI(header);
	}
	
	public boolean deletePE(sf.purchasing.PReturHeader header) throws DAException
	{
		return boPR.deletePR(header);
	}
	
	public boolean deleteShipping(sf.purchasing.ShippingHeader header) throws DAException
	{
		return boShipping.deleteShipping(header);
	}
	
	public boolean updateSinglePR(sf.purchasing.PRHeader header,PRDetail details) throws DAException
	{
		return boPurchase.updatePR(header, details);
	}
	
	public boolean updatePRHeader(PRHeader header) throws DAException
	{
		return boPurchase.updatePRHeader(header);
	}
	
	public boolean updatePR(sf.purchasing.PRHeader header,PRDetail[] details) throws DAException
	{
		return boPurchase.updatePR(header, details);
	}
	
	public boolean deletePR(PRHeader  header) throws DAException
	{
		return boPurchase.deletePR(header);
	}
	
	public PRHeader getPrequisitionHeader(String startDate,String endDate,int filter) throws DAException
	{
		return boPurchase.getPrequisitionHeader( startDate, endDate, filter);
	}
	
	public PIHeader getPIHeader(String kcabang,String startDate,String endDate) throws DAException
	{
		return boPI.getPIHeader(kcabang, startDate, endDate);
	}
	
	public PIHeader getPIHeader() throws DAException
	{
		return boPR.getPIHeader();
	}
	public PReturHeader getPRHeader(String kcabang,String startDate,String endDate) throws DAException
	{
		return boPR.getPRHeader(kcabang, startDate, endDate);
	}
	
	public PRDetail getPrequisitionDetail(PRHeader header) throws DAException
	{
		return boPurchase.getPrequisitionDetail(header);
	}
	
	public PIDetail getPIDetail(PIHeader header) throws DAException
	{
		return boPI.getPIDetail(header);
	}
	
	public PReturDetail getPRDetail(PReturHeader header) throws DAException
	{
		return boPR.getPRDetail(header);
	}
	
	public boolean insertPrequisitionDetail(PRDetail detail) throws DAException
	{
		return boPurchase.insertPrequisitionDetail(detail);
	}
	
	public boolean updatePrequisitionDetail(PRDetail detail) throws DAException
	{
		return boPurchase.updatePrequisitionDetail(detail);
	}
	
	public boolean deletePrequisitionDetail(PRDetail detail) throws DAException
	{
		return boPurchase.deletePrequisitionDetail(detail);
	}
	
	public PODetail getPODetail(POHeader header) throws DAException
	{
		return boPO.getPODetail(header);
	}
	
	public ShippingDetail getShippingDetail(ShippingHeader header) throws DAException
	{
		return boShipping.getShippingDetail(header);
	}
	
	public POHeader getPOHeader(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		return boPO.getPOHeader(nobukti, startDate, endDate, filter);
	}
	
	public POHeader getPOHeaderByBulan(String bulan) throws DAException
	{
		return boPO.getPOHeaderByBulan(bulan);
	}
	
	public POHeader getPOHeaderByTglBukti(String tanggal) throws DAException
	{
		return boPO.getPOHeaderByTglBukti(tanggal);
	}
	public POHeader getPOHeaderBelumDelivery(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		return boPO.getPOHeaderBelumDelivery(nobukti, startDate, endDate, filter);
	}
	public POHeader getPOHeaderSudahDelivery(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		return boPO.getPOHeaderSudahDelivery(nobukti, startDate, endDate, filter);
	}
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPO(String startDate,String endDate,int filter) throws DAException
	{
		return boPurchase.getPrequisitionHeaderSudahApprovedBelumPO(startDate, endDate, filter);
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPOByNoBukti(String nobukti) throws DAException
	{
		return boPurchase.getPrequisitionHeaderSudahApprovedBelumPOByNoBukti(nobukti);
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPOByTglBukti(String tglbukti) throws DAException
	{
		return boPurchase.getPrequisitionHeaderSudahApprovedBelumPOByTglBukti(tglbukti);
	}
	
	public PRHeader getPrequisitionHeaderSudahApprovedBelumPOByBulan(String bulan) throws DAException
	{
		return boPurchase.getPrequisitionHeaderSudahApprovedBelumPOByBulan(bulan);
	}
	
	public POHeader getPOHeaderBelumApproved(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		return boPO.getPOHeaderBelumApproved(nobukti, startDate, endDate, filter);
	}
	
	public POHeader getPOHeaderSudahApproved(String nobukti,String startDate,String endDate,int filter) throws DAException
	{
		return boPO.getPOHeaderSudahApproved(nobukti, startDate, endDate, filter);
	}
	public BiayaShipping getBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		return boShipping.getBiayaShipping(kcabang, nobukti);
	}
	
	public SptBShipping getSPTBiayaShipping(String kcabang,String nobukti) throws DAException
	{
		return boShipping.getSPTBiayaShipping(kcabang, nobukti);
	}
	public ShippingHeader getShippingHeader(String kcabang,String startDate,String endDate,int filter) throws DAException
	{
		return boShipping.getShippingHeader(kcabang, startDate, endDate, filter);
	}
	
	public boolean insertBiayaShipping(BiayaShipping[] bs) throws DAException
	{
		return boShipping.insertBiayaShipping(bs);
	}
	
	public boolean insertSPTBiaya(SptBShipping[] spt) throws DAException
	{
		return boShipping.insertSPTBiaya(spt);
	}
	
	public boolean updateSPTBiaya(SptBShipping spt) throws DAException
	{
		return boShipping.updateSPTBiaya(spt);
	}
	
	public boolean deleteSPTBiaya(SptBShipping spt) throws DAException
	{
		return boShipping.deleteSPTBiaya(spt);
	}
	
	public int getNoPD() throws DAException
	{
		return  boPD.getNoPD();
	}
	
	public String checkPDExist(String noPD) throws DAException
	{
		return boPD.checkPDExist(noPD);
	}
	
	public boolean updatePD(sf.purchasing.PDHeader header,sf.purchasing.PDDetail[] details) throws DAException
	{
		return boPD.updatePD(header, details);
	}
	
	public boolean insertPD(PDHeader header,PDDetail[] details) throws DAException
	{
		return boPD.insertPD(header, details);
	}
	public PDHeader getPDHeader(String kcabang,String startDate,String endDate,int filter) throws DAException
	{
		return boPD.getPDHeader(kcabang, startDate, endDate, filter);
	}
	
	public PDDetail getPDDetail(PDHeader header) throws DAException
	{
		return boPD.getPDDetail(header);
	}
	
	public boolean deletePD(sf.purchasing.PDHeader header) throws DAException
	{
		return boPD.deletePD(header);
	}
	
	public int getAvailUpload() throws DAException
	{
		return boShipping.getAvailUpload();
	}
	
	public boolean uploadPS(ShippingUpload[] su)
	{
		return boShipping.uploadPS(su);
	}
	
	public boolean saveUpload(POHeader header,String user) throws DAException
	{
		return boShipping.saveUpload(header, user);
	}
	
	public Title getTitle() throws DAException
	{
		Title _title = new Title();
		_title.setTitles(boSupplier.getTitle());
		return _title;
	}
	
	public PRHeader getPrequisitionHeaderBelumPO(String startDate,String endDate,int filter) throws DAException
	{
		return boPurchase.getPrequisitionHeaderBelumPO(startDate, endDate, filter);
	}
	public PRHeader getPrequisitionHeaderSudahPO(String startDate,String endDate,int filter) throws DAException
	{
		return boPurchase.getPrequisitionHeaderSudahPO(startDate, endDate, filter);
	}
	
	public PRHeader getPrequisitionHeaderBelumApproved(String startDate,String endDate,int filter) throws DAException
	{
		return boPurchase.getPrequisitionHeaderBelumApproved(startDate, endDate, filter);
	}
	public PRHeader getPrequisitionHeaderSudahApproved(String startDate,String endDate,int filter) throws DAException
	{
		return boPurchase.getPrequisitionHeaderSudahApproved(startDate, endDate, filter);
	}
	
	public PRHeader getPRequestHeaderByNoBukti(String noBukti) throws DAException
	{
		return boPurchase.getPRequestHeaderByNoBukti(noBukti);
	}
	public PRHeader getPRequestHeaderByBulan(String bulan) throws DAException
	{
		return boPurchase.getPRequestHeaderByBulan(bulan);
	}
	public PRHeader getPRequestHeaderByTglBukti(String tanggal) throws DAException
	{
		return boPurchase.getPRequestHeaderByTglBukti(tanggal);
	}
	public PRHeader getPRequestHeaderByRequester(String userid) throws DAException
	{
		return boPurchase.getPRequestHeaderByRequester(userid);
	}
}
