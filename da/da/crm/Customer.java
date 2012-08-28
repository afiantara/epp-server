package da.crm;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Category;

import da.error.DAException;
import da.factory.DBEngine;

public class Customer {
	private DBEngine db=null;
	static final Category log = Category.getInstance(Customer.class);
	public Customer() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	@SuppressWarnings("unchecked")
	public sf.crm.Customer[] getCustomers(String cmpType) throws DAException
	{
		sf.crm.Customer[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT a.*,b.nindustri,c.descr FROM mcustomer a,mindustri b,mtpajak c where a.recstatus<>? and a.kindustri=b.kindustri and a.kdtrs=c.codes";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.crm.Customer[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.crm.Customer item=new sf.crm.Customer();
				item.setKclient(v.get(0).toString());
				item.setKtitel(v.get(1).toString());
				item.setNclient(v.get(2).toString());
				item.setKindustri(v.get(3).toString());
				item.setKclass(v.get(4).toString());
				item.setKstatus(v.get(5).toString());
				item.setKsales(v.get(6).toString());
				item.setKcabang(v.get(7).toString());
				item.setKcompany(v.get(8).toString());
				item.setKclient1(v.get(9).toString());
				item.setNpwp(v.get(10).toString());
				item.setKdtrs(v.get(11).toString());
				item.setPlafond(Double.parseDouble(v.get(12).toString()));
				item.setJtempo(Integer.parseInt(v.get(13).toString()));
				item.setTfaktur1(v.get(14).toString());
				item.setTfaktur2(v.get(15).toString());
				item.setTfaktur3(v.get(16).toString());
				item.setTfaktur4(v.get(17).toString());
				item.setTfaktur5(v.get(18).toString());
				item.setTfaktur6(v.get(19).toString());
				
				item.setKpdir1(v.get(20).toString());
				item.setEmdir1(v.get(21).toString());
				item.setHpdir1(v.get(22).toString());
				
				item.setKpdir2(v.get(23).toString());
				item.setEmdir2(v.get(24).toString());
				item.setHpdir2(v.get(25).toString());
				
				item.setKpgm1(v.get(26).toString());
				item.setEmgm1(v.get(27).toString());
				item.setHpgm1(v.get(28).toString());
				
				item.setKpgm2(v.get(29).toString());
				item.setEmgm2(v.get(30).toString());
				item.setHpgm2(v.get(31).toString());
				
				item.setKpbeli1(v.get(32).toString());
				item.setEmbeli1(v.get(33).toString());
				item.setHpbeli1(v.get(34).toString());
				
				item.setKpbeli2(v.get(35).toString());
				item.setEmbeli2(v.get(36).toString());
				item.setHpbeli2(v.get(37).toString());
				
				item.setKpuser1(v.get(38).toString());
				item.setEmuser1(v.get(39).toString());
				item.setHpuser1(v.get(40).toString());
				
				item.setKpuser2(v.get(41).toString());
				item.setEmuser2(v.get(42).toString());
				item.setHpuser2(v.get(43).toString());
				
				
				item.setIalamat1(v.get(44).toString());
				item.setIalamat2(v.get(45).toString());
				item.setIalamat3(v.get(46).toString());
				item.setIkota(v.get(47).toString());
				item.setIkodepos(v.get(48).toString());
				item.setInotelp(v.get(49).toString());
				item.setInofax(v.get(50).toString());
				item.setIemail(v.get(51).toString());
				item.setIkontak1(v.get(52).toString());
				item.setIkontak2(v.get(53).toString());
				item.setInohp1(v.get(54).toString());
				item.setInohp2(v.get(55).toString());
				item.setIemail1(v.get(56).toString());
				item.setIemail2(v.get(57).toString());
				
				item.setTalamat1(v.get(58).toString());
				item.setTalamat2(v.get(59).toString());
				item.setTalamat3(v.get(60).toString());
				item.setTkota(v.get(61).toString());
				item.setTkodepos(v.get(62).toString());
				item.setTnotelp(v.get(63).toString());
				item.setTnofax(v.get(64).toString());	
				item.setTemail(v.get(65).toString());
				item.setTkontak1(v.get(66).toString());
				item.setTkontak2(v.get(67).toString());
				item.setTnohp1(v.get(68).toString());
				item.setTnohp2(v.get(69).toString());
				item.setTemail1(v.get(70).toString());
				item.setTemail2(v.get(71).toString());
				
				item.setKalamat1(v.get(72).toString());
				item.setKalamat2(v.get(73).toString());
				item.setKalamat3(v.get(74).toString());
				item.setKkota(v.get(75).toString());
				item.setKkodepos(v.get(76).toString());
				item.setKnotelp(v.get(77).toString());
				item.setKnofax(v.get(78).toString());
				item.setKemail(v.get(79).toString());
				item.setKkontak1(v.get(80).toString());
				item.setKkontak2(v.get(81).toString());
				item.setKnohp1(v.get(82).toString());
				item.setKnohp2(v.get(83).toString());
				item.setKemail1(v.get(84).toString());
				item.setKemail2(v.get(85).toString());
				
				item.setPalamat1(v.get(86).toString());
				item.setPalamat2(v.get(87).toString());
				item.setPalamat3(v.get(88).toString());
				item.setPkota(v.get(89).toString());
				item.setPkodepos(v.get(90).toString());
				item.setPnotelp(v.get(91).toString());
				item.setPnofax(v.get(92).toString());
				item.setPemail(v.get(93).toString());
				item.setPkontak1(v.get(94).toString());
				item.setPkontak2(v.get(95).toString());
				item.setPnohp1(v.get(96).toString());
				item.setPnohp2(v.get(97).toString());
				item.setPemail1(v.get(98).toString());
				item.setPemail2(v.get(99).toString());
				
				item.setRecstatus(v.get(100).toString());
				item.setUserinput(v.get(101).toString());
				item.setTglinput(Long.parseLong(v.get(102).toString()));
				item.setTglupdate(Long.parseLong(v.get(103).toString()));
				item.setUserupdate(v.get(104).toString());
				item.setKindustridesc(item.getKindustri() + "-" + v.get(105).toString());
				item.setKdtrsdesc(item.getKdtrs() + "-" + v.get(106).toString());
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
	public sf.crm.Customer[] getCustomersByCabang(String kcabang,String cmpType) throws DAException
	{
		sf.crm.Customer[] items;// new Branch[count];
		try
		{
			String strSQL="SELECT a.*,b.nindustri,c.descr FROM mcustomer a,mindustri b,mtpajak c where a.recstatus<>? and a.kcabang=? and a.kindustri=b.kindustri and a.kdtrs=c.codes";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kcabang);
			Vector rows = db.getData(p);
			int count=rows.size();
			items = new sf.crm.Customer[count];
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				sf.crm.Customer item=new sf.crm.Customer();
				item.setKclient(v.get(0).toString());
				item.setKtitel(v.get(1).toString());
				item.setNclient(v.get(2).toString());
				item.setKindustri(v.get(3).toString());
				item.setKclass(v.get(4).toString());
				item.setKstatus(v.get(5).toString());
				item.setKsales(v.get(6).toString());
				item.setKcabang(v.get(7).toString());
				item.setKcompany(v.get(8).toString());
				item.setKclient1(v.get(9).toString());
				item.setNpwp(v.get(10).toString());
				item.setKdtrs(v.get(11).toString());
				item.setPlafond(Double.parseDouble(v.get(12).toString()));
				item.setJtempo(Integer.parseInt(v.get(13).toString()));
				item.setTfaktur1(v.get(14).toString());
				item.setTfaktur2(v.get(15).toString());
				item.setTfaktur3(v.get(16).toString());
				item.setTfaktur4(v.get(17).toString());
				item.setTfaktur5(v.get(18).toString());
				item.setTfaktur6(v.get(19).toString());
				
				item.setKpdir1(v.get(20).toString());
				item.setEmdir1(v.get(21).toString());
				item.setHpdir1(v.get(22).toString());
				
				item.setKpdir2(v.get(23).toString());
				item.setEmdir2(v.get(24).toString());
				item.setHpdir2(v.get(25).toString());
				
				item.setKpgm1(v.get(26).toString());
				item.setEmgm1(v.get(27).toString());
				item.setHpgm1(v.get(28).toString());
				
				item.setKpgm2(v.get(29).toString());
				item.setEmgm2(v.get(30).toString());
				item.setHpgm2(v.get(31).toString());
				
				item.setKpbeli1(v.get(32).toString());
				item.setEmbeli1(v.get(33).toString());
				item.setHpbeli1(v.get(34).toString());
				
				item.setKpbeli2(v.get(35).toString());
				item.setEmbeli2(v.get(36).toString());
				item.setHpbeli2(v.get(37).toString());
				
				item.setKpuser1(v.get(38).toString());
				item.setEmuser1(v.get(39).toString());
				item.setHpuser1(v.get(40).toString());
				
				item.setKpuser2(v.get(41).toString());
				item.setEmuser2(v.get(42).toString());
				item.setHpuser2(v.get(43).toString());
				
				
				item.setIalamat1(v.get(44).toString());
				item.setIalamat2(v.get(45).toString());
				item.setIalamat3(v.get(46).toString());
				item.setIkota(v.get(47).toString());
				item.setIkodepos(v.get(48).toString());
				item.setInotelp(v.get(49).toString());
				item.setInofax(v.get(50).toString());
				item.setIemail(v.get(51).toString());
				item.setIkontak1(v.get(52).toString());
				item.setIkontak2(v.get(53).toString());
				item.setInohp1(v.get(54).toString());
				item.setInohp2(v.get(55).toString());
				item.setIemail1(v.get(56).toString());
				item.setIemail2(v.get(57).toString());
				
				item.setTalamat1(v.get(58).toString());
				item.setTalamat2(v.get(59).toString());
				item.setTalamat3(v.get(60).toString());
				item.setTkota(v.get(61).toString());
				item.setTkodepos(v.get(62).toString());
				item.setTnotelp(v.get(63).toString());
				item.setTnofax(v.get(64).toString());	
				item.setTemail(v.get(65).toString());
				item.setTkontak1(v.get(66).toString());
				item.setTkontak2(v.get(67).toString());
				item.setTnohp1(v.get(68).toString());
				item.setTnohp2(v.get(69).toString());
				item.setTemail1(v.get(70).toString());
				item.setTemail2(v.get(71).toString());
				
				item.setKalamat1(v.get(72).toString());
				item.setKalamat2(v.get(73).toString());
				item.setKalamat3(v.get(74).toString());
				item.setKkota(v.get(75).toString());
				item.setKkodepos(v.get(76).toString());
				item.setKnotelp(v.get(77).toString());
				item.setKnofax(v.get(78).toString());
				item.setKemail(v.get(79).toString());
				item.setKkontak1(v.get(80).toString());
				item.setKkontak2(v.get(81).toString());
				item.setKnohp1(v.get(82).toString());
				item.setKnohp2(v.get(83).toString());
				item.setKemail1(v.get(84).toString());
				item.setKemail2(v.get(85).toString());
				
				item.setPalamat1(v.get(86).toString());
				item.setPalamat2(v.get(87).toString());
				item.setPalamat3(v.get(88).toString());
				item.setPkota(v.get(89).toString());
				item.setPkodepos(v.get(90).toString());
				item.setPnotelp(v.get(91).toString());
				item.setPnofax(v.get(92).toString());
				item.setPemail(v.get(93).toString());
				item.setPkontak1(v.get(94).toString());
				item.setPkontak2(v.get(95).toString());
				item.setPnohp1(v.get(96).toString());
				item.setPnohp2(v.get(97).toString());
				item.setPemail1(v.get(98).toString());
				item.setPemail2(v.get(99).toString());
				
				item.setRecstatus(v.get(100).toString());
				item.setUserinput(v.get(101).toString());
				item.setTglinput(Long.parseLong(v.get(102).toString()));
				item.setTglupdate(Long.parseLong(v.get(103).toString()));
				item.setUserupdate(v.get(104).toString());
				item.setKindustridesc(item.getKindustri() + "-" + v.get(105).toString());
				item.setKdtrsdesc(item.getKdtrs() + "-" + v.get(106).toString());
				
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
	public sf.crm.Customer getCustomer(String kclient,String cmpType) throws DAException
	{
		sf.crm.Customer item=new sf.crm.Customer();
		try
		{
			String strSQL="SELECT a.*,b.nindustri,c.descr FROM mcustomer a,mindustri b,mtpajak c where a.recstatus<>? and a.kclient=? and a.kindustri=b.kindustri and a.kdtrs=c.codes";
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, "D");
			p.setString(2, kclient);
			Vector rows = db.getData(p);
			int count=rows.size();
			for(int i=0; i < count;i++)
			{
				Vector v=(Vector)rows.get(i);
				
				item.setKclient(v.get(0).toString());
				item.setKtitel(v.get(1).toString());
				item.setNclient(v.get(2).toString());
				item.setKindustri(v.get(3).toString());
				item.setKclass(v.get(4).toString());
				item.setKstatus(v.get(5).toString());
				item.setKsales(v.get(6).toString());
				item.setKcabang(v.get(7).toString());
				item.setKcompany(v.get(8).toString());
				item.setKclient1(v.get(9).toString());
				item.setNpwp(v.get(10).toString());
				item.setKdtrs(v.get(11).toString());
				item.setPlafond(Double.parseDouble(v.get(12).toString()));
				item.setJtempo(Integer.parseInt(v.get(13).toString()));
				item.setTfaktur1(v.get(14).toString());
				item.setTfaktur2(v.get(15).toString());
				item.setTfaktur3(v.get(16).toString());
				item.setTfaktur4(v.get(17).toString());
				item.setTfaktur5(v.get(18).toString());
				item.setTfaktur6(v.get(19).toString());
				
				item.setKpdir1(v.get(20).toString());
				item.setEmdir1(v.get(21).toString());
				item.setHpdir1(v.get(22).toString());
				
				item.setKpdir2(v.get(23).toString());
				item.setEmdir2(v.get(24).toString());
				item.setHpdir2(v.get(25).toString());
				
				item.setKpgm1(v.get(26).toString());
				item.setEmgm1(v.get(27).toString());
				item.setHpgm1(v.get(28).toString());
				
				item.setKpgm2(v.get(29).toString());
				item.setEmgm2(v.get(30).toString());
				item.setHpgm2(v.get(31).toString());
				
				item.setKpbeli1(v.get(32).toString());
				item.setEmbeli1(v.get(33).toString());
				item.setHpbeli1(v.get(34).toString());
				
				item.setKpbeli2(v.get(35).toString());
				item.setEmbeli2(v.get(36).toString());
				item.setHpbeli2(v.get(37).toString());
				
				item.setKpuser1(v.get(38).toString());
				item.setEmuser1(v.get(39).toString());
				item.setHpuser1(v.get(40).toString());
				
				item.setKpuser2(v.get(41).toString());
				item.setEmuser2(v.get(42).toString());
				item.setHpuser2(v.get(43).toString());
				
				
				item.setIalamat1(v.get(44).toString());
				item.setIalamat2(v.get(45).toString());
				item.setIalamat3(v.get(46).toString());
				item.setIkota(v.get(47).toString());
				item.setIkodepos(v.get(48).toString());
				item.setInotelp(v.get(49).toString());
				item.setInofax(v.get(50).toString());
				item.setIemail(v.get(51).toString());
				item.setIkontak1(v.get(52).toString());
				item.setIkontak2(v.get(53).toString());
				item.setInohp1(v.get(54).toString());
				item.setInohp2(v.get(55).toString());
				item.setIemail1(v.get(56).toString());
				item.setIemail2(v.get(57).toString());
				
				item.setTalamat1(v.get(58).toString());
				item.setTalamat2(v.get(59).toString());
				item.setTalamat3(v.get(60).toString());
				item.setTkota(v.get(61).toString());
				item.setTkodepos(v.get(62).toString());
				item.setTnotelp(v.get(63).toString());
				item.setTnofax(v.get(64).toString());	
				item.setTemail(v.get(65).toString());
				item.setTkontak1(v.get(66).toString());
				item.setTkontak2(v.get(67).toString());
				item.setTnohp1(v.get(68).toString());
				item.setTnohp2(v.get(69).toString());
				item.setTemail1(v.get(70).toString());
				item.setTemail2(v.get(71).toString());
				
				item.setKalamat1(v.get(72).toString());
				item.setKalamat2(v.get(73).toString());
				item.setKalamat3(v.get(74).toString());
				item.setKkota(v.get(75).toString());
				item.setKkodepos(v.get(76).toString());
				item.setKnotelp(v.get(77).toString());
				item.setKnofax(v.get(78).toString());
				item.setKemail(v.get(79).toString());
				item.setKkontak1(v.get(80).toString());
				item.setKkontak2(v.get(81).toString());
				item.setKnohp1(v.get(82).toString());
				item.setKnohp2(v.get(83).toString());
				item.setKemail1(v.get(84).toString());
				item.setKemail2(v.get(85).toString());
				
				item.setPalamat1(v.get(86).toString());
				item.setPalamat2(v.get(87).toString());
				item.setPalamat3(v.get(88).toString());
				item.setPkota(v.get(89).toString());
				item.setPkodepos(v.get(90).toString());
				item.setPnotelp(v.get(91).toString());
				item.setPnofax(v.get(92).toString());
				item.setPemail(v.get(93).toString());
				item.setPkontak1(v.get(94).toString());
				item.setPkontak2(v.get(95).toString());
				item.setPnohp1(v.get(96).toString());
				item.setPnohp2(v.get(97).toString());
				item.setPemail1(v.get(98).toString());
				item.setPemail2(v.get(99).toString());
				
				item.setRecstatus(v.get(100).toString());
				item.setUserinput(v.get(101).toString());
				item.setTglinput(Long.parseLong(v.get(102).toString()));
				item.setTglupdate(Long.parseLong(v.get(103).toString()));
				item.setUserupdate(v.get(104).toString());
				item.setKindustridesc(item.getKindustri() + "-" + v.get(105).toString());
				item.setKdtrsdesc(item.getKdtrs() + "-" + v.get(106).toString());
			}
		}
		catch(Exception ex)
		{
			throw new DAException (ex.getLocalizedMessage());
		}
		
		return item;
	}
	
	public boolean insertCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		if(cust.checkIsNULL())
		{
			throw new DAException(cust.getErr());
		}
		
		String strSQL="INSERT INTO mcustomer values (?,?,?,?,?,?,?,?,?,?," +
													"?,?,?,?,?,?,?,?,?,?," +
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?,?,?,?,?,?," +
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?,?,?,?,?,?,"+
													"?,?,?,?,?)";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			int idx=1;
			p.setString(idx,cust.getKclient());idx++;
			p.setString(idx,cust.getKtitel());idx++;
			p.setString(idx,cust.getNclient());idx++;
			p.setString(idx,cust.getKindustri());idx++;
			p.setString(idx,cust.getKclass());idx++;
			p.setString(idx,cust.getKstatus());idx++;
			p.setString(idx,cust.getKsales());idx++;
			p.setString(idx,cust.getKcabang());idx++;
			p.setString(idx,cust.getKcompany());idx++;
			p.setString(idx,cust.getKclient1());idx++;
			p.setString(idx,cust.getNpwp());idx++;
			p.setString(idx,cust.getKdtrs());idx++;
			p.setDouble(idx,cust.getPlafond());idx++;
			p.setInt(idx,cust.getJtempo());idx++;
			p.setString(idx,cust.getTfaktur1());idx++;
			p.setString(idx,cust.getTfaktur2());idx++;
			p.setString(idx,cust.getTfaktur3());idx++;
			p.setString(idx,	cust.getTfaktur4());idx++;
			p.setString(idx,	cust.getTfaktur5());idx++;
			p.setString(idx,		cust.getTfaktur6());idx++;
			p.setString(idx,		cust.getKpdir1());idx++;
			p.setString(idx,		cust.getEmdir1());idx++;
			p.setString(idx,		cust.getHpdir1());idx++;
			p.setString(idx,		cust.getKpdir2());idx++;
			p.setString(idx,		cust.getEmdir2());idx++;
			p.setString(idx,		cust.getHpdir2());idx++;
			p.setString(idx,		cust.getKpgm1());idx++;
			p.setString(idx,		cust.getEmgm1());idx++;
			p.setString(idx,		cust.getHpgm1());idx++;
			p.setString(idx,		cust.getKpgm2());idx++;
			p.setString(idx,		cust.getEmgm2());idx++;
			p.setString(idx,		cust.getHpgm2());idx++;
			p.setString(idx,		cust.getKpbeli1());idx++;
			p.setString(idx,		cust.getEmbeli1());idx++;
			p.setString(idx,		cust.getHpbeli1());idx++;
			p.setString(idx,		cust.getKpbeli2());idx++;
			p.setString(idx,		cust.getEmbeli2());idx++;
			p.setString(idx,		cust.getHpbeli2());idx++;
			p.setString(idx,		cust.getKpuser1());idx++;
			p.setString(idx,		cust.getEmuser1());idx++;
			p.setString(idx,		cust.getHpuser1());idx++;
			p.setString(idx,		cust.getKpuser2());idx++;
			p.setString(idx,		cust.getEmuser2());idx++;
			p.setString(idx,		cust.getHpuser2());idx++;
			p.setString(idx,		cust.getIalamat1());idx++;
			p.setString(idx,		cust.getIalamat2());idx++;
			p.setString(idx,		cust.getIalamat3());idx++;
			p.setString(idx,		cust.getIkota());idx++;
			p.setString(idx,	cust.getIkodepos());idx++;
			p.setString(idx,	cust.getInotelp());idx++;
			p.setString(idx,	cust.getInofax());idx++;
			p.setString(idx,	cust.getIemail());idx++;
			p.setString(idx,		cust.getIkontak1());idx++;
			p.setString(idx,		cust.getIkontak2());idx++;
			p.setString(idx,		cust.getInohp1());idx++;
			p.setString(idx,		cust.getInohp2());idx++;
			p.setString(idx,		cust.getIemail1());idx++;
			p.setString(idx,		cust.getIemail2());idx++;
			p.setString(idx,			cust.getTalamat1());idx++;
			p.setString(idx,		cust.getTalamat2());idx++;
			p.setString(idx,		cust.getTalamat3());idx++;
			p.setString(idx,		cust.getTkota());idx++;
			p.setString(idx,		cust.getTkodepos());idx++;
			p.setString(idx,		cust.getTnotelp());idx++;
			p.setString(idx,		cust.getTnofax());idx++;
			p.setString(idx,		cust.getTemail());idx++;
			p.setString(idx,			cust.getTkontak1());idx++;
			p.setString(idx,		cust.getTkontak2());idx++;
			p.setString(idx,			cust.getTnohp1());idx++;
			p.setString(idx,			cust.getTnohp2());idx++;
			p.setString(idx,		cust.getTemail1());idx++;
			p.setString(idx,			cust.getTemail2());idx++;
			p.setString(idx,		cust.getKalamat1());idx++;
			p.setString(idx,		cust.getKalamat2());idx++;
			p.setString(idx,			cust.getKalamat3());idx++;
			p.setString(idx,		cust.getKkota());idx++;
			p.setString(idx,			cust.getKkodepos());idx++;
			p.setString(idx,		cust.getKnotelp());idx++;
			p.setString(idx,		cust.getKnofax());idx++;
			p.setString(idx,		cust.getKemail());idx++;
			p.setString(idx,		cust.getKkontak1());idx++;
			p.setString(idx,		cust.getKkontak2());idx++;
			p.setString(idx,			cust.getKnohp1());idx++;
			p.setString(idx,		cust.getKnohp2());idx++;
			p.setString(idx,		cust.getKemail1());idx++;
			p.setString(idx,		cust.getKemail2());idx++;
			p.setString(idx,		cust.getPalamat1());idx++;
			p.setString(idx,			cust.getPalamat2());idx++;
			p.setString(idx,		cust.getPalamat3());idx++;
			p.setString(idx,		cust.getPkota());idx++;
			p.setString(idx,			cust.getPkodepos());idx++;
			p.setString(idx,	cust.getPnotelp());idx++;
			p.setString(idx,cust.getPnofax());idx++;
			p.setString(idx,	cust.getPemail());idx++;
			p.setString(idx,	cust.getPkontak1());idx++;
			p.setString(idx,	cust.getPkontak2());idx++;
			p.setString(idx,	cust.getPnohp1());idx++;
			p.setString(idx,	cust.getPnohp2());idx++;
			p.setString(idx,	cust.getPemail1());idx++;
			p.setString(idx,	cust.getPemail2());idx++;
			p.setString(idx,	cust.getRecstatus());idx++;
			p.setString(idx,	cust.getUserinput());idx++;
			p.setLong(idx,	cust.getTglinput());idx++;
			p.setLong(idx,	cust.getTglupdate());idx++;
			p.setString(idx,	cust.getUserupdate());
			
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean updateCustomer(sf.crm.Customer cust,String cmpType) throws DAException
	{
		if(cust.checkIsNULL())
		{
			throw new DAException(cust.getErr());
		}
		
		String strSQL="UPDATE mcustomer set ktitel=?,nclient=?,kindustri=?,kclass=?,kstatus=?,ksales=?,kcabang=?,kcompany=?,kclient1=?,npwp=?," +
				"kdtrs=?,plafond=?,jtempo=?,tfaktur1=?,tfaktur2=?,tfaktur3=?,tfaktur4=?,tfaktur5=?,tfaktur6=?," +
				"kpdir1=?,emdir1=?,hpdir1=?," +
				"kpdir2=?,emdir2=?,hpdir2=?," +
				"kpgm1=?,emgm1=?,hpgm1=?," +
				"kpgm2=?,emgm2=?,hpgm2=?," +
				"kpbeli1=?,embeli1=?,hpbeli1=?," +
				"kpbeli2=?,embeli2=?,hpbeli2=?," +
				"kpuser1=?,emuser1=?,hpuser1=?," +
				"kpuser2=?,emuser2=?,hpuser2=?," +
				"ialamat1=?,ialamat2=?,ialamat3=?,ikota=?,ikodepos=?,inotelp=?,inofax=?,iemail=?,ikontak1=?,ikontak2=?,inohp1=?,inohp2=?,iemail1=?,iemail2=?," +
				"talamat1=?,talamat2=?,talamat3=?,tkota=?,tkodepos=?,tnotelp=?,tnofax=?,temail=?,tkontak1=?,tkontak2=?,tnohp1=?,tnohp2=?,temail1=?,temail2=?," +
				"kalamat1=?,kalamat2=?,kalamat3=?,kkota=?,kkodepos=?,knotelp=?,knofax=?,kemail=?,kkontak1=?,kkontak2=?,knohp1=?,knohp2=?,kemail1=?,kemail2=?," +
				"palamat1=?,palamat2=?,palamat3=?,pkota=?,pkodepos=?,pnotelp=?,pnofax=?,pemail=?,pkontak1=?,pkontak2=?,pnohp1=?,pnohp2=?,pemail1=?,pemail2=?," +
				"recstatus=?,tglupdate=?,userupdate=? where kclient=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			
			int idx=1;
			
			p.setString(idx,cust.getKtitel());idx++;
			p.setString(idx,cust.getNclient());idx++;
			p.setString(idx,cust.getKindustri());idx++;
			p.setString(idx,cust.getKclass());idx++;
			p.setString(idx,cust.getKstatus());idx++;
			p.setString(idx,cust.getKsales());idx++;
			p.setString(idx,cust.getKcabang());idx++;
			p.setString(idx,cust.getKcompany());idx++;
			p.setString(idx,cust.getKclient1());idx++;
			p.setString(idx,cust.getNpwp());idx++;
			p.setString(idx,cust.getKdtrs());idx++;
			p.setDouble(idx,cust.getPlafond());idx++;
			p.setInt(idx,cust.getJtempo());idx++;
			p.setString(idx,cust.getTfaktur1());idx++;
			p.setString(idx,cust.getTfaktur2());idx++;
			p.setString(idx,cust.getTfaktur3());idx++;
			p.setString(idx,	cust.getTfaktur4());idx++;
			p.setString(idx,	cust.getTfaktur5());idx++;
			p.setString(idx,		cust.getTfaktur6());idx++;
			
			p.setString(idx,		cust.getKpdir1());idx++;
			p.setString(idx,		cust.getEmdir1());idx++;
			p.setString(idx,		cust.getHpdir1());idx++;
			
			p.setString(idx,		cust.getKpdir2());idx++;
			p.setString(idx,		cust.getEmdir2());idx++;
			p.setString(idx,		cust.getHpdir2());idx++;
			
			p.setString(idx,		cust.getKpgm1());idx++;
			p.setString(idx,		cust.getEmgm1());idx++;
			p.setString(idx,		cust.getHpgm1());idx++;
			
			p.setString(idx,		cust.getKpgm2());idx++;
			p.setString(idx,		cust.getEmgm2());idx++;
			p.setString(idx,		cust.getHpgm2());idx++;
			
			p.setString(idx,		cust.getKpbeli1());idx++;
			p.setString(idx,		cust.getEmbeli1());idx++;
			p.setString(idx,		cust.getHpbeli1());idx++;
			
			p.setString(idx,		cust.getKpbeli2());idx++;
			p.setString(idx,		cust.getEmbeli2());idx++;
			p.setString(idx,		cust.getHpbeli2());idx++;
			
			p.setString(idx,		cust.getKpuser1());idx++;
			p.setString(idx,		cust.getEmuser1());idx++;
			p.setString(idx,		cust.getHpuser1());idx++;
			
			p.setString(idx,		cust.getKpuser2());idx++;
			p.setString(idx,		cust.getEmuser2());idx++;
			p.setString(idx,		cust.getHpuser2());idx++;
			
			p.setString(idx,			cust.getIalamat1());idx++;
			p.setString(idx,		cust.getIalamat2());idx++;
			p.setString(idx,		cust.getIalamat3());idx++;
			p.setString(idx,		cust.getIkota());idx++;
			p.setString(idx,	cust.getIkodepos());idx++;
			p.setString(idx,	cust.getInotelp());idx++;
			p.setString(idx,	cust.getInofax());idx++;
			p.setString(idx,	cust.getIemail());idx++;
			p.setString(idx,		cust.getIkontak1());idx++;
			p.setString(idx,		cust.getIkontak2());idx++;
			p.setString(idx,		cust.getInohp1());idx++;
			p.setString(idx,		cust.getInohp2());idx++;
			p.setString(idx,		cust.getIemail1());idx++;
			p.setString(idx,		cust.getIemail2());idx++;
			
			p.setString(idx,			cust.getTalamat1());idx++;
			p.setString(idx,		cust.getTalamat2());idx++;
			p.setString(idx,		cust.getTalamat3());idx++;
			p.setString(idx,		cust.getTkota());idx++;
			p.setString(idx,		cust.getTkodepos());idx++;
			p.setString(idx,		cust.getTnotelp());idx++;
			p.setString(idx,		cust.getTnofax());idx++;
			p.setString(idx,		cust.getTemail());idx++;
			p.setString(idx,			cust.getTkontak1());idx++;
			p.setString(idx,		cust.getTkontak2());idx++;
			p.setString(idx,			cust.getTnohp1());idx++;
			p.setString(idx,			cust.getTnohp2());idx++;
			p.setString(idx,		cust.getTemail1());idx++;
			p.setString(idx,			cust.getTemail2());idx++;
			
			p.setString(idx,		cust.getKalamat1());idx++;
			p.setString(idx,		cust.getKalamat2());idx++;
			p.setString(idx,			cust.getKalamat3());idx++;
			p.setString(idx,		cust.getKkota());idx++;
			p.setString(idx,			cust.getKkodepos());idx++;
			p.setString(idx,		cust.getKnotelp());idx++;
			p.setString(idx,		cust.getKnofax());idx++;
			p.setString(idx,		cust.getKemail());idx++;
			p.setString(idx,		cust.getKkontak1());idx++;
			p.setString(idx,		cust.getKkontak2());idx++;
			p.setString(idx,			cust.getKnohp1());idx++;
			p.setString(idx,		cust.getKnohp2());idx++;
			p.setString(idx,		cust.getKemail1());idx++;
			p.setString(idx,		cust.getKemail2());idx++;
			
			p.setString(idx,		cust.getPalamat1());idx++;
			p.setString(idx,			cust.getPalamat2());idx++;
			p.setString(idx,		cust.getPalamat3());idx++;
			p.setString(idx,		cust.getPkota());idx++;
			p.setString(idx,			cust.getPkodepos());idx++;
			p.setString(idx,	cust.getPnotelp());idx++;
			p.setString(idx,cust.getPnofax());idx++;
			p.setString(idx,	cust.getPemail());idx++;
			p.setString(idx,	cust.getPkontak1());idx++;
			p.setString(idx,	cust.getPkontak2());idx++;
			p.setString(idx,	cust.getPnohp1());idx++;
			p.setString(idx,	cust.getPnohp2());idx++;
			p.setString(idx,	cust.getPemail1());idx++;
			p.setString(idx,	cust.getPemail2());idx++;
			
			
			p.setString(idx,	cust.getRecstatus());idx++;
			p.setLong(idx,	cust.getTglupdate());idx++;
			p.setString(idx,	cust.getUserupdate());idx++;
			p.setString(idx,cust.getKclient());
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
	
	public boolean deleteCustomer(String kclient,String cmpType) throws DAException
	{
		String strSQL="DELETE FROM " + (cmpType.equals("EPP")? "mcustomer" : "wcustomer") + " where kclient=?";
		try {
			PreparedStatement p=db.getStatement(strSQL);
			p.setString(1, kclient);
			return db.execute(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAException(e.getMessage());
		}
	}
}
