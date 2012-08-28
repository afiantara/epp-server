package bo.purchasing;

import org.apache.log4j.Category;

import sf.inventory.ProdukSet;
import sf.sales.InvoiceDetail;
import sf.sales.ReturDetail;
import sf.sales.SalesOrderDetail;
import sf.sales.StockAlokasi;
import sf.sales.StockRekap;
import sf.sales.SuratJalanDetail;
import bo.inventory.Produk;
import da.error.DAException;

public class Stock {
	private da.sales.Sales daSales;
	private bo.inventory.Produk boProduk;
	static final Category log = Category.getInstance(Stock.class);
	public Stock(da.sales.Sales daSales) throws DAException
	{
		this.daSales=daSales;
		boProduk = new Produk();
	}
	
	public boolean insertStockAlokasi(SalesOrderDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(!isExistStockAlokasi(gudang,detail.getKbarang()))
				{
					StockAlokasi alokasi=new StockAlokasi();
					alokasi.setKbarang(detail.getKbarang());
					alokasi.setKgudang(gudang);
					alokasi.setRecstatus("U");
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					alokasi.setSorder(detail.getJumlah());
					daSales.insertStockAlokasi(alokasi);
				}
				else
				{
					StockAlokasi alokasi=daSales.getStockAlokasi(detail.getKbarang(), gudang)[0];
					alokasi.setRecstatus("U");
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					double dblAlok = alokasi.getSorder() + detail.getJumlah();
					alokasi.setSorder(dblAlok);
					daSales.updateStockAlokasi(alokasi);
				}
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(!isExistStockAlokasi(gudang,ps.getKbarang1()))
								{
									StockAlokasi alokasi=new StockAlokasi();
									alokasi.setRecstatus("U");
									alokasi.setKbarang(ps.getKbarang1());
									alokasi.setKgudang(gudang);
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									alokasi.setSorder(detail.getJumlah()*ps.getKqty());
									daSales.insertStockAlokasi(alokasi);
								}
								else
								{
									StockAlokasi alokasi=daSales.getStockAlokasi(ps.getKbarang1(), gudang)[0];
									alokasi.setRecstatus("U");
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									double dblAlok = alokasi.getSorder() + detail.getJumlah()*ps.getKqty();
									alokasi.setSorder(dblAlok);
									daSales.updateStockAlokasi(alokasi);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean editStockAlokasi(SalesOrderDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockAlokasi(gudang,detail.getKbarang()))
				{
					StockAlokasi alokasi=daSales.getStockAlokasi(detail.getKbarang(), gudang)[0];
					alokasi.setRecstatus("U");
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					double dblAlok = alokasi.getSorder() - detail.getJumlahOld() + detail.getJumlah();
					alokasi.setSorder(dblAlok);
					daSales.updateStockAlokasi(alokasi);
					log.info("editStockAlokasi->updateStockAlokasi->" + detail.getKbarang() + ";" + gudang);
				}
				else
				{
					StockAlokasi alokasi=new StockAlokasi();
					alokasi.setRecstatus("U");
					alokasi.setKbarang(detail.getKbarang());
					alokasi.setKgudang(gudang);
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					alokasi.setSorder(detail.getJumlah());
					daSales.insertStockAlokasi(alokasi);
					log.info("editStockAlokasi->insertStockAlokasi->" + detail.getKbarang() + ";" + gudang);
				}
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockAlokasi(gudang,ps.getKbarang1()))
								{
									StockAlokasi alokasi=daSales.getStockAlokasi(ps.getKbarang1(), gudang)[0];
									alokasi.setRecstatus("U");
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									double dblAlok = alokasi.getSorder() - (detail.getJumlahOld()-detail.getJumlah())*ps.getKqty();
									alokasi.setSorder(dblAlok);
									daSales.updateStockAlokasi(alokasi);
								}
								else
								{
									StockAlokasi alokasi=new StockAlokasi();
									alokasi.setRecstatus("U");
									alokasi.setKbarang(ps.getKbarang1());
									alokasi.setKgudang(gudang);
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									alokasi.setSorder(detail.getJumlah()*ps.getKqty());
									daSales.insertStockAlokasi(alokasi);
								}
							}
						}
					}
				}
			}
		}
		return true;	
	}
	
	
	public boolean deleteStockAlokasi(SalesOrderDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockAlokasi(gudang,detail.getKbarang()))
				{
					StockAlokasi alokasi=daSales.getStockAlokasi(detail.getKbarang(), gudang)[0];
					alokasi.setRecstatus("U");
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					double dblAlok = alokasi.getSorder() - detail.getJumlah();
					alokasi.setSorder(dblAlok);
					daSales.updateStockAlokasi(alokasi);
				}
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockAlokasi(gudang,ps.getKbarang1()))
								{
									StockAlokasi alokasi=daSales.getStockAlokasi(ps.getKbarang1(), gudang)[0];
									alokasi.setRecstatus("U");
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									double dblAlok = alokasi.getSorder() - detail.getJumlah()*ps.getKqty();
									alokasi.setSorder(dblAlok);
									daSales.updateStockAlokasi(alokasi);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean deleteStockAlokasi(SuratJalanDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockAlokasi(gudang,detail.getKbarang()))
				{
					StockAlokasi alokasi=daSales.getStockAlokasi(detail.getKbarang(), gudang)[0];
					alokasi.setRecstatus("U");
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					double dblAlok = alokasi.getSorder() - detail.getJumlah();
					alokasi.setSorder(dblAlok);
					daSales.updateStockAlokasi(alokasi);
				}
				
				if(isExistStockRekap(gudang,detail.getKbarang()))
				{
					StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
					rekap.setRecstatus("U");
					rekap.setUserupdate(detail.getUserupdate());
					rekap.setTglupdate(detail.getTglupdate());
					double dblRekap = rekap.getOnhand() + detail.getJumlah();
					rekap.setOnhand(dblRekap);
					daSales.updateStockRekap(rekap);
				}
				else
				{
					log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
				}
				
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockAlokasi(gudang,ps.getKbarang1()))
								{
									StockAlokasi alokasi=daSales.getStockAlokasi(ps.getKbarang1(), gudang)[0];
									alokasi.setRecstatus("U");
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									double dblAlok = alokasi.getSorder() - detail.getJumlah()*ps.getKqty();
									alokasi.setSorder(dblAlok);
									daSales.updateStockAlokasi(alokasi);
								}
								if(isExistStockRekap(gudang,detail.getKbarang()))
								{
									StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
									rekap.setRecstatus("U");
									rekap.setUserupdate(detail.getUserupdate());
									rekap.setTglupdate(detail.getTglupdate());
									double dblRekap = rekap.getOnhand() + detail.getJumlah()* ps.getKqty();
									rekap.setOnhand(dblRekap);
									daSales.updateStockRekap(rekap);
								}
								else
								{
									log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	public boolean editStockRekap(SuratJalanDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockAlokasi(gudang,detail.getKbarang()))
				{
					StockAlokasi alokasi=daSales.getStockAlokasi(detail.getKbarang(), gudang)[0];
					alokasi.setRecstatus("U");
					alokasi.setUserupdate(detail.getUserupdate());
					alokasi.setTglupdate(detail.getTglupdate());
					double dblAlok = alokasi.getSorder() + detail.getJumlahOld() -  detail.getJumlah();
					if(dblAlok>=0)
					{
						alokasi.setSorder(dblAlok);
						daSales.updateStockAlokasi(alokasi);
					}
					else
					{
						log.warn("Stock Alokasi SOrder Barang minus: " + detail.getKbarang() + ";" + gudang);
					}
					if(isExistStockRekap(gudang,detail.getKbarang()))
					{
						StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
						rekap.setRecstatus("U");
						rekap.setUserupdate(detail.getUserupdate());
						rekap.setTglupdate(detail.getTglupdate());
						double dblRekap = rekap.getOnhand() + detail.getJumlahOld() - detail.getJumlah();
						rekap.setOnhand(dblRekap);
						daSales.updateStockRekap(rekap);
					}
					else
					{
						log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
					}
				}
				else
				{
					log.warn("Stock Alokasi Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
				}
				
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockAlokasi(gudang,ps.getKbarang1()))
								{
									StockAlokasi alokasi=daSales.getStockAlokasi(ps.getKbarang1(), gudang)[0];
									alokasi.setRecstatus("U");
									alokasi.setUserupdate(detail.getUserupdate());
									alokasi.setTglupdate(detail.getTglupdate());
									double dblAlok = alokasi.getSorder() - detail.getJumlah()*ps.getKqty();
									alokasi.setSorder(dblAlok);
									daSales.updateStockAlokasi(alokasi);
									if(isExistStockRekap(gudang,detail.getKbarang()))
									{
										StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
										rekap.setRecstatus("U");
										rekap.setUserupdate(detail.getUserupdate());
										rekap.setTglupdate(detail.getTglupdate());
										double dblRekap = rekap.getOnhand() + (detail.getJumlahOld()- detail.getJumlah())* ps.getKqty();
										rekap.setOnhand(dblRekap);
										daSales.updateStockRekap(rekap);
									}
									else
									{
										log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
									}
								}
								else
								{
									log.warn("Stock Alokasi Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
								}
							}
						}
					}
				}
			}
		}
		return true;		
	}
		
	public boolean editStockRekap(InvoiceDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockRekap(gudang,detail.getKbarang()))
				{
					StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
					rekap.setRecstatus("U");
					rekap.setUserupdate(detail.getUserupdate());
					rekap.setTglupdate(detail.getTglupdate());
					double dblRekap = rekap.getOnhand() + detail.getJumlahOld() - detail.getJumlah();
					rekap.setOnhand(dblRekap);
					daSales.updateStockRekap(rekap);
				}
				else
				{
					log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
				}
				
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockRekap(gudang,detail.getKbarang()))
								{
									StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
									rekap.setRecstatus("U");
									rekap.setUserupdate(detail.getUserupdate());
									rekap.setTglupdate(detail.getTglupdate());
									double dblRekap = rekap.getOnhand() + (detail.getJumlahOld()- detail.getJumlah())* ps.getKqty();
									rekap.setOnhand(dblRekap);
									daSales.updateStockRekap(rekap);
								}
								else
								{
									log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
								}
							}
						}
					}
				}
			}
		}
		return true;		
	}
	
	public boolean editStockRekap(ReturDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockRekap(gudang,detail.getKbarang()))
				{
					StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
					rekap.setRecstatus("U");
					rekap.setUserupdate(detail.getUserupdate());
					rekap.setTglupdate(detail.getTglupdate());
					double dblRekap = rekap.getOnhand() - detail.getJumlahOld() + detail.getJumlah();
					rekap.setOnhand(dblRekap);
					daSales.updateStockRekap(rekap);
				}
				else
				{
					log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
				}
				
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockRekap(gudang,detail.getKbarang()))
								{
									StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
									rekap.setRecstatus("U");
									rekap.setUserupdate(detail.getUserupdate());
									rekap.setTglupdate(detail.getTglupdate());
									double dblRekap = rekap.getOnhand() - (detail.getJumlahOld()- detail.getJumlah())* ps.getKqty();
									rekap.setOnhand(dblRekap);
									daSales.updateStockRekap(rekap);
								}
								else
								{
									log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
								}
							}
						}
					}
				}
			}
		}
		return true;		
	}
	
	public boolean deleteStockRekap(InvoiceDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockRekap(gudang,detail.getKbarang()))
				{
					StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
					rekap.setRecstatus("U");
					rekap.setUserupdate(detail.getUserupdate());
					rekap.setTglupdate(detail.getTglupdate());
					double dblRekap = rekap.getOnhand() +  detail.getJumlah();
					rekap.setOnhand(dblRekap);
					daSales.updateStockRekap(rekap);
				}
				else
				{
					log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
				}
				
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockRekap(gudang,detail.getKbarang()))
								{
									StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
									rekap.setRecstatus("U");
									rekap.setUserupdate(detail.getUserupdate());
									rekap.setTglupdate(detail.getTglupdate());
									double dblRekap = rekap.getOnhand() + detail.getJumlah()* ps.getKqty();
									rekap.setOnhand(dblRekap);
									daSales.updateStockRekap(rekap);
								}
								else
								{
									log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
								}
							}
						}
					}
				}
			}
		}
		return true;		
	}
	
	public boolean deleteStockRekap(ReturDetail detail,String gudang) throws DAException
	{
		sf.inventory.Produk sfProduk = boProduk.getProduk(detail.getKbarang(), "EPP");
		if(sfProduk!=null)
		{
			if(sfProduk.getStockbal().equals("Y"))
			{
				if(isExistStockRekap(gudang,detail.getKbarang()))
				{
					StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
					rekap.setRecstatus("U");
					rekap.setUserupdate(detail.getUserupdate());
					rekap.setTglupdate(detail.getTglupdate());
					double dblRekap = rekap.getOnhand() -  detail.getJumlah();
					rekap.setOnhand(dblRekap);
					daSales.updateStockRekap(rekap);
				}
				else
				{
					log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
				}
				
			}
			else
			{
				if(sfProduk.getPstatus().equals("P"))
				{
					//lookup child.
					ProdukSet produkSet= boProduk.getProdukSet(detail.getKbarang(), "EPP");
					if(produkSet!=null && produkSet.getProduksets()!=null && produkSet.getProduksets().length>0)
					{
						for (ProdukSet ps : produkSet.getProduksets()) 
						{
							if(ps!=null)
							{
								if(isExistStockRekap(gudang,detail.getKbarang()))
								{
									StockRekap rekap=daSales.getStockRekap(detail.getKbarang(), gudang)[0];
									rekap.setRecstatus("U");
									rekap.setUserupdate(detail.getUserupdate());
									rekap.setTglupdate(detail.getTglupdate());
									double dblRekap = rekap.getOnhand()- detail.getJumlah()* ps.getKqty();
									rekap.setOnhand(dblRekap);
									daSales.updateStockRekap(rekap);
								}
								else
								{
									log.warn("Stock Rekap Barang tidak ada: " + detail.getKbarang() + ";" + gudang);
								}
							}
						}
					}
				}
			}
		}
		return true;		
	}
	
	public boolean isExistStockAlokasi(String kgudang,String kbarang)
	{
		sf.sales.StockAlokasi [] alok = daSales.getStockAlokasi(kbarang, kgudang);
		if(alok==null)
			return false;
		if(alok.length==0)
			return false;
		return true;
	}
	
	public boolean isExistStockRekap(String kgudang,String kbarang)
	{
		sf.sales.StockRekap [] alok = daSales.getStockRekap(kbarang, kgudang);
		if(alok==null)
			return false;
		if(alok.length==0)
			return false;
		
		return true;
	}
	
	
}
