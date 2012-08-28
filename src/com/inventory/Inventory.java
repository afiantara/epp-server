package com.inventory;

import bo.inventory.Import;
import da.error.DAException;

public class Inventory {
	private bo.inventory.Gudang boGudang;
	private bo.inventory.Rak boRak;
	private bo.inventory.Group boGroup;
	private bo.inventory.Group1 boGroup1;
	private bo.inventory.Group2 boGroup2;
	private bo.inventory.Produk boProduk;
	private Import boImport;
	public Inventory() throws DAException
	{
		boGudang=new bo.inventory.Gudang();
		boRak=new bo.inventory.Rak();
		boGroup=new bo.inventory.Group();
		boGroup1=new bo.inventory.Group1();
		boGroup2=new bo.inventory.Group2();
		boProduk=new bo.inventory.Produk();
		boImport=new Import();
	}
	
	public boolean importHargaJual(String filePath)
	{
		return boImport.importHargaJual(filePath);
	}
	public sf.inventory.Gudang getGudang() throws DAException
	{
		return boGudang.getGudang();
	}
	
	public sf.inventory.Gudang getGudangByCode(String kgudang) throws DAException
	{
		return boGudang.getGudang(kgudang);
	}
	
	public boolean insertGudang(sf.inventory.Gudang gudang) throws DAException
	{
		return boGudang.insertGudang(gudang);
	}
	
	public boolean updateGudang(sf.inventory.Gudang gudang) throws DAException
	{
		gudang.setRecstatus("U");
		return boGudang.updateGrudang(gudang);
	}
	
	public boolean deleteGudang(sf.inventory.Gudang gudang) throws DAException
	{
		gudang.setRecstatus("D");
		return boGudang.updateGrudang(gudang);
	}
	public sf.inventory.Rak getRak() throws DAException
	{
		return boRak.getRak();
	}
	
	public sf.inventory.Rak getRakByCode(String koderak) throws DAException
	{
		return boRak.getRak(koderak);
	}
	
	public boolean insertRak(sf.inventory.Rak rak) throws DAException
	{
		return boRak.insertRak(rak);
	}
	
	public boolean updateRak(sf.inventory.Rak rak) throws DAException
	{
		rak.setRecstatus("U");
		return boRak.updateRak(rak);
	}
	
	public boolean deleteRak(sf.inventory.Rak rak) throws DAException
	{
		rak.setRecstatus("D");
		return boRak.updateRak(rak);
	}
	
	
	public sf.inventory.Group getGroup() throws DAException
	{
		return boGroup.getGroup();
	}
	
	public sf.inventory.Group getGroupByCode(String kgroup) throws DAException
	{
		return boGroup.getGroup(kgroup);
	}
	
	public boolean insertGroup(sf.inventory.Group group) throws DAException
	{
		return boGroup.insertGroup(group);
	}
	
	public boolean updateGroup(sf.inventory.Group group) throws DAException
	{
		group.setRecstatus("U");
		return boGroup.updateGroup(group);
	}
	
	public boolean deleteGroup(sf.inventory.Group group) throws DAException
	{
		group.setRecstatus("D");
		return boGroup.updateGroup(group);
	}
	
	public sf.inventory.Group1 getGroup1() throws DAException
	{
		return boGroup1.getGroup();
	}
	
	public sf.inventory.Group1 getGroup1ByCode(String kgroup) throws DAException
	{
		return boGroup1.getGroup(kgroup);
	}
	
	public boolean insertGroup1(sf.inventory.Group1 group) throws DAException
	{
		return boGroup1.insertGroup(group);
	}
	
	public boolean updateGroup1(sf.inventory.Group1 group) throws DAException
	{
		group.setRecstatus("U");
		return boGroup1.updateGroup(group);
	}
	
	public boolean deleteGroup1(sf.inventory.Group1 group) throws DAException
	{
		group.setRecstatus("D");
		return boGroup1.updateGroup(group);
	}
	
	public sf.inventory.Group2 getGroup2() throws DAException
	{
		return boGroup2.getGroup();
	}
	
	public sf.inventory.Group2 getGroup2ByCode(String kgroup,String kgroup1) throws DAException
	{
		
		return boGroup2.getGroup(kgroup,kgroup1);
	}
	
	public boolean insertGroup2(sf.inventory.Group2 group) throws DAException
	{
		return boGroup2.insertGroup(group);
	}
	
	public boolean updateGroup2(sf.inventory.Group2 group) throws DAException
	{
		group.setRecstatus("U");
		return boGroup2.updateGroup(group);
	}
	
	public boolean deleteGroup2(sf.inventory.Group2 group) throws DAException
	{
		group.setRecstatus("D");
		return boGroup2.updateGroup(group);
	}
	
	public sf.inventory.Produk getProduk(String cmpType) throws DAException
	{
		return boProduk.getProduk(cmpType);
	}
	
	public sf.inventory.PType getPType() throws DAException
	{
		return boProduk.getPType();
	}
	public sf.inventory.Produk getProdukByCodeAndName(String kbarang,String nbarang,String cmpType) throws DAException
	{
		return boProduk.getProduk(kbarang, nbarang,cmpType);
	}
	
	public sf.inventory.Produk getProdukChild(String cmpType) throws DAException
	{
		return boProduk.getProdukChild(cmpType);
	}
	public sf.inventory.Produk getProdukByGroup(String kgroup,String cmpType) throws DAException
	{
		return boProduk.getProdukByGroup(kgroup,cmpType);
	}
	
	public sf.inventory.Produk getProdukByCode(String kbarang,String cmpType) throws DAException
	{
		return boProduk.getProduk(kbarang,cmpType);
	}
	
	public boolean insertProduk(sf.inventory.Produk produk) throws DAException
	{
		return boProduk.insertProduk(produk);
	}
	
	public boolean updateProduk(sf.inventory.Produk produk) throws DAException
	{
		produk.setRecstatus("U");
		return boProduk.updateProduk(produk);
	}
	
	public boolean deleteProduk(sf.inventory.Produk produk) throws DAException
	{
		produk.setRecstatus("D");
		return boProduk.updateProduk(produk);
	}
	
	public sf.inventory.HargaJual getHargaJual() throws DAException
	{
		return boProduk.getHargaJual();
	}
	
	public sf.inventory.HargaJual getHargaJualByCode(String kbarang) throws DAException
	{
		return boProduk.getHargaJual(kbarang);
	}
	
	public sf.inventory.HargaJual getLatestHargaJualByValuta(String kbarang,String kvaluta,String tglBukti) throws DAException
	{
		return boProduk.getLatestHargaJualByValuta(kbarang, kvaluta, tglBukti);
	}
	
	public sf.inventory.HargaJual getLatestHargaJual(String kbarang,String tglBukti) throws DAException
	{
		return boProduk.getLatestHargaJual(kbarang,tglBukti);
	}
	
	public sf.inventory.HargaPokok getLatestHargaPokok(String kbarang,String tglBukti) throws DAException
	{
		return boProduk.getLatestHargaPokok(kbarang, tglBukti);
	}
	public boolean insertHargaJual(sf.inventory.HargaJual hj) throws DAException
	{
		return boProduk.insertHargaJual(hj);
	}
	
	public boolean updateHargaJual(sf.inventory.HargaJual hj) throws DAException
	{
		hj.setRecstatus("U");
		return boProduk.updateHargaJual(hj);
	}
	
	public boolean deleteHargaJual(sf.inventory.HargaJual hj) throws DAException
	{
		hj.setRecstatus("D");
		return boProduk.updateHargaJual(hj);
	}
	
	public sf.inventory.ProdukSet getProdukSet(String cmpType) throws DAException
	{
		return boProduk.getProdukSet(cmpType);
	}
	
	public sf.inventory.ProdukSet getProdukSetByCode(String kbarang,String cmpType) throws DAException
	{
		return boProduk.getProdukSet(kbarang,cmpType);
	}
	
	public boolean insertProdukSet(sf.inventory.ProdukSet produk) throws DAException
	{
		return boProduk.insertProdukSet(produk);
	}
	
	public boolean updateProdukSetByCompany(sf.inventory.ProdukSet produk,String compType) throws DAException
	{
		produk.setRecstatus("U");
		return boProduk.updateProdukSet(produk,compType);
	}
	
	public boolean updateProdukSet(sf.inventory.ProdukSet produk) throws DAException
	{
		produk.setRecstatus("U");
		return boProduk.updateProdukSet(produk);
	}
	
	public boolean deleteProdukSet(sf.inventory.ProdukSet produk) throws DAException
	{
		produk.setRecstatus("D");
		return boProduk.updateProdukSet(produk);
	}
	
	public sf.inventory.HargaPokok getHargaPokok() throws DAException
	{
		return boProduk.getHargaPokok();
	}
	
	public sf.inventory.HargaPokok getHargaPokokByCode(String kbarang) throws DAException
	{
		return boProduk.getHargaPokok(kbarang);
	}
	
	public boolean insertHargaPokok(sf.inventory.HargaPokok hp) throws DAException
	{
		return boProduk.insertHargaPokok(hp);
	}
	
	public boolean updateHargaPokok(sf.inventory.HargaPokok hp) throws DAException
	{
		hp.setRecstatus("U");
		return boProduk.updateHargaPokok(hp);
	}
	
	public boolean deleteHargaPokok(sf.inventory.HargaPokok hp) throws DAException
	{
		hp.setRecstatus("D");
		return boProduk.updateHargaPokok(hp);
	}
}
