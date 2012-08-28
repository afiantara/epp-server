package bo.inventory;

import sf.inventory.ProdukSet;
import da.error.DAException;

public class Produk {
	da.inventory.Produk daProduk;
	da.inventory.ProdukSet daProdukSet;
	da.inventory.HargaJual daHJ;
	da.inventory.HargaPokok daHP;
	public Produk() throws DAException
	{
		daProduk=new da.inventory.Produk();
		daProdukSet=new da.inventory.ProdukSet();
		daHJ=new da.inventory.HargaJual();
		daHP=new da.inventory.HargaPokok();
	}
	
	public sf.inventory.PType getPType() throws DAException
	{
		sf.inventory.PType ptype=new sf.inventory.PType();
		ptype.setPtypes(daProduk.getPType());
		return ptype;
	}
	public sf.inventory.Produk getProdukChild(String cmpType) throws DAException
	{
		sf.inventory.Produk produk=new sf.inventory.Produk();
		produk.setProduks(daProduk.getProdukChild(cmpType));
		return produk;
	}
	public sf.inventory.Produk getProduk(String cmpType) throws DAException
	{
		sf.inventory.Produk produk=new sf.inventory.Produk();
		produk.setProduks(daProduk.getProduk(cmpType));
		return produk;
	}
	
	public sf.inventory.Produk getProduk(String kbarang,String cmpType) throws DAException
	{
		sf.inventory.Produk produk=new sf.inventory.Produk();
		produk.setProduks(daProduk.getProduk(kbarang,cmpType));
		return produk;
	}
	
	public boolean insertProduk(sf.inventory.Produk produk) throws DAException
	{
		return daProduk.insertProduk(produk);
	}
	
	public boolean updateProduk(sf.inventory.Produk produk) throws DAException
	{
		return daProduk.updateProduk(produk);
	}
	
	public boolean deleteProduk(String kbarang,String cmpType) throws DAException
	{
		return daProduk.deleteProduk(kbarang,cmpType);
	}
	
	public sf.inventory.HargaJual getHargaJual() throws DAException
	{
		sf.inventory.HargaJual hj=new sf.inventory.HargaJual();
		hj.setHargaJuals(daHJ.getHargaJual());
		return hj;
	}
	
	public sf.inventory.HargaJual getHargaJual(String kbarang) throws DAException
	{
		sf.inventory.HargaJual hj=new sf.inventory.HargaJual();
		hj.setHargaJuals(daHJ.getHargaJual(kbarang));
		return hj;
	}
	
	public sf.inventory.HargaJual getLatestHargaJualByValuta(String kbarang,String kvaluta,String tglBukti) throws DAException
	{
		return daHJ.getLatestHargaJualByValuta(kbarang, kvaluta, tglBukti);
	}
	public sf.inventory.HargaJual getLatestHargaJual(String kbarang,String tglBukti) throws DAException
	{
		return daHJ.getLatestHargaJual(kbarang,tglBukti);
	}
	
	public sf.inventory.HargaPokok getLatestHargaPokok(String kbarang,String tglBukti) throws DAException
	{
		return daHP.getLatestHargaPokok(kbarang, tglBukti);
	}
	public boolean insertHargaJual(sf.inventory.HargaJual hj) throws DAException
	{
		return daHJ.insertHargaJual(hj);
	}
	
	public boolean updateHargaJual(sf.inventory.HargaJual hj) throws DAException
	{
		return daHJ.updateHargaJual(hj);
	}
	
	public boolean deleteHargaJual(String kbarang) throws DAException
	{
		return daHJ.deleteHargaJual(kbarang);
	}
	
	
	public sf.inventory.ProdukSet getProdukSet(String cmpType) throws DAException
	{
		sf.inventory.ProdukSet[] produk=daProdukSet.getProdukSet(cmpType);
		int idx=0;
		for (ProdukSet item : produk) 
		{
			sf.inventory.Produk[] prods=daProduk.getProduk(item.getKbarang(), cmpType);
			item.setNbarang(prods[0].getNbarang());
			item.setSatuan(prods[0].getSatuan());
			produk[idx]=item;
			idx++;
		}
		ProdukSet produkset = new ProdukSet();
		produkset.setProduksets(produk);
		return produkset;
	}
	
	public sf.inventory.ProdukSet getProdukSet(String kbarang,String cmpType) throws DAException
	{
		sf.inventory.ProdukSet[] produk=daProdukSet.getProdukSet(kbarang,cmpType);
		int idx=0;
		for (ProdukSet item : produk) 
		{
			sf.inventory.Produk[] prods=daProduk.getProduk(item.getKbarang1(), cmpType);
			item.setNbarang1(prods[0].getNbarang());
			item.setSatuan1(prods[0].getSatuan());
			produk[idx]=item;
			idx++;
		}
		ProdukSet produkset = new ProdukSet();
		produkset.setProduksets(produk);
		return produkset;
	}
	
	public boolean insertProdukSet(sf.inventory.ProdukSet produk) throws DAException
	{
		return daProdukSet.insertProdukSet(produk);
	}
	
	public boolean updateProdukSet(sf.inventory.ProdukSet produk) throws DAException
	{
		return daProdukSet.updateProdukSet(produk);
	}
	
	public boolean updateProdukSet(sf.inventory.ProdukSet produk,String compType) throws DAException
	{
		if(daProdukSet.updateProdukSet(produk))
		{
			sf.inventory.Produk prod = new sf.inventory.Produk();
			prod.setKbarang(produk.getKbarang1());
			prod.setNbarang(produk.getNbarang1());
			prod.setSatuan(produk.getSatuan1());
			prod.setCompanyType(compType);
			return daProduk.updateProduk1(prod);	
		}
		return false;
	}
	public boolean deleteProdukSet(String kbarang) throws DAException
	{
		return daProdukSet.deleteProdukSet(kbarang);
	}
	
	public sf.inventory.HargaPokok getHargaPokok() throws DAException
	{
		sf.inventory.HargaPokok hp=new sf.inventory.HargaPokok();
		hp.setHargaPokoks(daHP.getHargaPokok());
		return hp;
	}
	
	public sf.inventory.HargaPokok getHargaPokok(String kbarang) throws DAException
	{
		sf.inventory.HargaPokok hp=new sf.inventory.HargaPokok();
		hp.setHargaPokoks(daHP.getHargaPokok(kbarang));
		return hp;
	}
	
	public boolean insertHargaPokok(sf.inventory.HargaPokok hp) throws DAException
	{
		return daHP.insertHargaPokok(hp);
	}
	
	public boolean updateHargaPokok(sf.inventory.HargaPokok hp) throws DAException
	{
		return daHP.updateHargaPokok(hp);
	}
	
	public boolean deleteHargaPokok(String kbarang) throws DAException
	{
		return daHP.deleteHargaPokok(kbarang);
	}
	
	public sf.inventory.Produk getProdukByGroup(String kgroup,String cmpType) throws DAException
	{
		sf.inventory.Produk produk=new sf.inventory.Produk();
		produk.setProduks(daProduk.getProdukByGroup(kgroup,cmpType));
		return produk;
	}
	
	public sf.inventory.Produk getProduk(String kbarang,String nbarang,String cmpType) throws DAException
	{
		sf.inventory.Produk produk=new sf.inventory.Produk();
		produk.setProduks(daProduk.getProduk(kbarang, nbarang,cmpType));
		return produk;
	}
}
