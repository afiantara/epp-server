package sf.crm;

import java.text.DecimalFormat;

import sf.general.General;

public class Customer extends General{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String kclient;
	private String ktitel;
	private String nclient;
	private String kindustri;
	private String kindustridesc;
	private String kclass="C";
	private String kstatus="C" ;
	private String kstatusdesc="Customer" ;
	private String ksales;
	private String kcabang;
	private String kcompany;
	private String kclient1;
	private String npwp;
	private String kdtrs;
	private String kdtrsdesc;
	private double plafond=0;
	private int jtempo=30;
	private String tfaktur1="N";
	private boolean btfaktur1=false;
	private String tfaktur2="N";
	private boolean btfaktur2=false;
	private String tfaktur3="N";
	private boolean btfaktur3=false;
	private String tfaktur4="N";
	private boolean btfaktur4=false;
	private String tfaktur5="N";
	private boolean btfaktur5=false;
	private String tfaktur6="N";
	private boolean btfaktur6=false;
	private String kpdir1;
	private String emdir1;
	private String hpdir1;
	private String kpdir2;
	private String emdir2;
	private String hpdir2;
	private String kpgm1;
	private String emgm1;
	private String hpgm1;
	private String kpgm2;
	private String emgm2;
	private String hpgm2;
	private String kpbeli1;
	private String embeli1;
	private String hpbeli1;
	private String kpbeli2;
	private String embeli2;
	private String hpbeli2;
	private String kpuser1;
	private String emuser1;
	private String hpuser1;
	private String kpuser2;
	private String emuser2;
	private String hpuser2;
	
	private String ialamat1;
	private String ialamat2;
	private String ialamat3;
	private String ikota;
	private String ikodepos ;
	private String inotelp;
	private String inofax ;
	private String iemail;
	private String ikontak1;
	private String ikontak2;
	private String inohp1;
	private String inohp2;
	private String iemail1;
	private String iemail2;
		
	private String talamat1;
	private String talamat2;
	private String talamat3;
	private String tkota;
	private String tkodepos;
	private String tnotelp;
	private String tnofax;
	private String temail;
	private String tkontak1;
	private String tkontak2;
	private String tnohp1;
	private String tnohp2;
	private String temail1;
	private String temail2;
	
	private String kalamat1;
	private String kalamat2;
	private String kalamat3;
	private String kkota;
	private String kkodepos;
	private String knotelp;
	private String knofax;
	private String kemail;
	private String kkontak1;
	private String kkontak2;
	private String knohp1;
	private String knohp2;
	private String kemail1;
	private String kemail2;
	
	private String palamat1;
	private String palamat2;
	private String palamat3;
	private String pkota ;
	private String pkodepos;
	private String pnotelp ;
	private String pnofax;
	private String pemail ;
	private String pkontak1;
	private String pkontak2;
	private String pnohp1;
	private String pnohp2;
	private String pemail1;
	private String pemail2;
	
	private Customer[] customers;
	
	public Customer()
	{
		
	}
	
	private String[] headers=new String[]{
			"kclient",
			"nclient",
			"kindustri",
			"kclass",
			"kstatus",
			"kinvoice",
			"ksales",
			"kcabang",
			"kclient1",
			"npwp",
			"nppkp",
			"kdtrs",
			"plafond",
			"jtempo",
			"tfaktur1",
			"tfaktur2",
			"tfaktur3",
			"tfaktur4",
			"tfaktur5",
			"tfaktur6",
			"talamat1",
			"talamat2",
			"talamat3",
			"tkota",
			"tkodepos",
			"tnotelp",
			"tnofax",
			"temail",
			"tkontak1",
			"tkontak2",
			"tnohp1",
			"tnohp2",
			"temail1",
			"temail2",
			"ialamat1",
			"ialamat2",
			"ialamat3",
			"ikota",
			"ikodepos",
			"inotelp",
			"inofax",
			"iemail",
			"ikontak1",
			"ikontak2",
			"inohp1",
			"inohp2",
			"iemail1",
			"iemail2",
			"kalamat1",
			"kalamat2",
			"kalamat3",
			"kkota",
			"kkodepos",
			"knotelp",
			"knofax",
			"kemail",
			"kkontak1",
			"kkontak2",
			"knohp1",
			"knohp2",
			"kemail1",
			"kemail2",
			"palamat1",
			"palamat2",
			"palamat3",
			"pkota",
			"pkodepos",
			"pnotelp",
			"pnofax",
			"pemail",
			"pkontak1",
			"pkontak2",
			"pnohp1",
			"pnohp2",
			"pemail1",
			"pemail2",
			"recstatus",
			"tglupdate",
			"userupdate"
		};
		
		public String[] getHeader()
		{
			return headers;
		}
		
		public String[] getContent()
		{
			DecimalFormat dc = new DecimalFormat("###0");
			//SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			String[] contents=new String[]{
					this.getKclient(),
					this.getNclient(),
					this.getKindustri(),
					this.getKclass(),
					this.getKstatus(),
					this.getKsales(),
					this.getKcabang(),
					this.getKclient1(),
					this.getNpwp(),
					this.getKdtrs(),
					dc.format(this.getPlafond()),
					dc.format(this.getJtempo()),
					this.getTfaktur1(),
					this.getTfaktur2(),
					this.getTfaktur3(),
					this.getTfaktur4(),
					this.getTfaktur5(),
					this.getTfaktur6(),
					this.getTalamat1(),
					this.getTalamat2(),
					this.getTalamat3(),
					this.getTkota(),
					this.getTkodepos(),
					this.getTnotelp(),
					this.getTnofax(),
					this.getTemail(),
					this.getTkontak1(),
					this.getTkontak2(),
					this.getTemail1(),
					this.getTemail2(),
					this.getIalamat1(),
					this.getIalamat2(),
					this.getIalamat3(),
					this.getIkota(),
					this.getIkodepos(),
					this.getInotelp(),
					this.getInofax(),
					this.getIemail(),
					this.getIkontak1(),
					this.getIkontak2(),
					this.getIemail1(),
					this.getIemail2(),
					this.getKalamat1(),
					this.getKalamat2(),
					this.getKalamat3(),
					this.getKkota(),
					this.getKkodepos(),
					this.getKnotelp(),
					this.getKnofax(),
					this.getKemail(),
					this.getKkontak1(),
					this.getKkontak2(),
					this.getKemail1(),
					this.getKemail2(),
					this.getPalamat1(),
					this.getPalamat2(),
					this.getPalamat3(),
					this.getPkota(),
					this.getPkodepos(),
					this.getPnotelp(),
					this.getPnofax(),
					this.getPemail(),
					this.getPkontak1(),
					this.getPkontak2(),
					this.getPemail1(),
					this.getPemail2(),
					this.getRecstatus(),
					String.valueOf(this.getTglupdate()),
					this.getUserupdate()
					};
			return contents;
		}
		
	private String _err="";
	
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		if(this.getKclient()==null || "".equals(this.getKclient()))
		{
			_err="Error,Invalid Kode Customer. Could not empty.";
			return true;
		}
		if(this.getNclient()==null || "".equals(this.getNclient()))
		{
			_err="Error,Invalid Nama Customer.Could not empty.";
			return true;
		}
		
		if(this.getKindustri()==null || "".equals(this.getKindustri()))
		{
			_err="Error,Invalid Kode Industri.Could not empty.";
			return true;
		}
		if(this.getKstatus()==null || "".equals(this.getKstatus()))
		{
			_err="Error,Invalid Kode Status.Could not empty.";
			return true;
		}
		if(this.getKsales()==null || "".equals(this.getKsales()))
		{
			_err="Error,Invalid Kode Sales.Could not empty.";
			return true;
		}
		if(this.getKcabang()==null || "".equals(this.getKcabang()))
		{
			_err="Error,Invalid Kode Cabang.Could not empty.";
			return true;
		}
		if(this.getKdtrs()==null || "".equals(this.getKdtrs()))
		{
			_err="Error,Invalid Kode DTRS. Could not empty.";
			return true;
		}
		if(this.getTalamat1()==null || "".equals(this.getTalamat1()))
		{
			_err="Error,Invalid TAlamat1. Could not empty.";
			return true;
		}
		if(this.getKalamat1()==null || "".equals(this.getKalamat1()))
		{
			_err="Error,Invalid Alamat1. Could not empty.";
			return true;
		}
		if(this.getIalamat1()==null || "".equals(this.getIalamat1()))
		{
			_err="Error,Invalid IAlamat1. Could not empty.";
			return true;
		}
		if(this.getIalamat1()==null || "".equals(this.getIalamat1()))
		{
			_err="Error,Invalid IAlamat1. Could not empty.";
			return true;
		}
		if(this.getPalamat1()==null || "".equals(this.getPalamat1()))
		{
			_err="Error,Invalid PAlamat1. Could not empty.";
			return true;
		}
		if(this.getKclient().equals(this.getKclient1()))
		{
			_err="Error,Invalid Group Customer. Group customer tidak boleh terhadap dirinya sendiri.";
			return true;
		}
		return false;
	}

	public void setKclient(String kclient) {
		this.kclient = kclient;
	}

	public String getKclient() {
		return kclient;
	}

	public void setNclient(String nclient) {
		this.nclient = nclient;
	}

	public String getNclient() {
		return nclient;
	}

	public void setKindustri(String kindustri) {
		this.kindustri = kindustri;
	}

	public String getKindustri() {
		return kindustri;
	}

	public void setKclass(String kclass) {
		this.kclass = kclass;
	}

	public String getKclass() {
		return kclass;
	}

	public void setKstatus(String kstatus) {
		this.kstatus = kstatus;
	}

	public String getKstatus() {
		return kstatus;
	}

	public void setKsales(String ksales) {
		this.ksales = ksales;
	}

	public String getKsales() {
		return ksales;
	}

	public void setKcabang(String kcabang) {
		this.kcabang = kcabang;
	}

	public String getKcabang() {
		return kcabang;
	}

	public void setKclient1(String kclient1) {
		this.kclient1 = kclient1;
	}

	public String getKclient1() {
		return kclient1;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setKdtrs(String kdtrs) {
		this.kdtrs = kdtrs;
	}

	public String getKdtrs() {
		return kdtrs;
	}

	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}

	public double getPlafond() {
		return plafond;
	}

	public void setJtempo(int jtempo) {
		this.jtempo = jtempo;
	}

	public int getJtempo() {
		return jtempo;
	}

	public void setTfaktur1(String tfaktur1) {
		this.tfaktur1 = tfaktur1;
	}

	public String getTfaktur1() {
		return tfaktur1;
	}

	public void setTfaktur2(String tfaktur2) {
		this.tfaktur2 = tfaktur2;
	}

	public String getTfaktur2() {
		return tfaktur2;
	}

	public void setTfaktur3(String tfaktur3) {
		this.tfaktur3 = tfaktur3;
	}

	public String getTfaktur3() {
		return tfaktur3;
	}

	public void setTfaktur4(String tfaktur4) {
		this.tfaktur4 = tfaktur4;
	}

	public String getTfaktur4() {
		return tfaktur4;
	}

	public void setTfaktur5(String tfaktur5) {
		this.tfaktur5 = tfaktur5;
	}

	public String getTfaktur5() {
		return tfaktur5;
	}

	public void setTfaktur6(String tfaktur6) {
		this.tfaktur6 = tfaktur6;
	}

	public String getTfaktur6() {
		return tfaktur6;
	}

	public void setTalamat1(String talamat1) {
		this.talamat1 = talamat1;
	}

	public String getTalamat1() {
		return talamat1;
	}

	public void setTalamat2(String talamat2) {
		this.talamat2 = talamat2;
	}

	public String getTalamat2() {
		return talamat2;
	}

	public void setTalamat3(String talamat3) {
		this.talamat3 = talamat3;
	}

	public String getTalamat3() {
		return talamat3;
	}

	public void setTkota(String tkota) {
		this.tkota = tkota;
	}

	public String getTkota() {
		return tkota;
	}

	public void setTkodepos(String tkodepos) {
		this.tkodepos = tkodepos;
	}

	public String getTkodepos() {
		return tkodepos;
	}

	public void setTnotelp(String tnotelp) {
		this.tnotelp = tnotelp;
	}

	public String getTnotelp() {
		return tnotelp;
	}

	public void setTnofax(String tnofax) {
		this.tnofax = tnofax;
	}

	public String getTnofax() {
		return tnofax;
	}

	public void setTemail(String temail) {
		this.temail = temail;
	}

	public String getTemail() {
		return temail;
	}

	public void setTkontak1(String tkontak1) {
		this.tkontak1 = tkontak1;
	}

	public String getTkontak1() {
		return tkontak1;
	}

	public void setTkontak2(String tkontak2) {
		this.tkontak2 = tkontak2;
	}

	public String getTkontak2() {
		return tkontak2;
	}

	public void setTnohp1(String tnohp1) {
		this.tnohp1 = tnohp1;
	}

	public String getTnohp1() {
		return tnohp1;
	}

	public void setTnohp2(String tnohp2) {
		this.tnohp2 = tnohp2;
	}

	public String getTnohp2() {
		return tnohp2;
	}

	public void setTemail1(String temail1) {
		this.temail1 = temail1;
	}

	public String getTemail1() {
		return temail1;
	}

	public void setTemail2(String temail2) {
		this.temail2 = temail2;
	}

	public String getTemail2() {
		return temail2;
	}

	public void setIalamat1(String ialamat1) {
		this.ialamat1 = ialamat1;
	}

	public String getIalamat1() {
		return ialamat1;
	}

	public void setIalamat2(String ialamat2) {
		this.ialamat2 = ialamat2;
	}

	public String getIalamat2() {
		return ialamat2;
	}

	public void setIalamat3(String ialamat3) {
		this.ialamat3 = ialamat3;
	}

	public String getIalamat3() {
		return ialamat3;
	}

	public void setIkota(String ikota) {
		this.ikota = ikota;
	}

	public String getIkota() {
		return ikota;
	}

	public void setIkodepos(String ikodepos) {
		this.ikodepos = ikodepos;
	}

	public String getIkodepos() {
		return ikodepos;
	}

	public void setInotelp(String inotelp) {
		this.inotelp = inotelp;
	}

	public String getInotelp() {
		return inotelp;
	}

	public void setInofax(String inofax) {
		this.inofax = inofax;
	}

	public String getInofax() {
		return inofax;
	}

	public void setIemail(String iemail) {
		this.iemail = iemail;
	}

	public String getIemail() {
		return iemail;
	}

	public void setIkontak1(String ikontak1) {
		this.ikontak1 = ikontak1;
	}

	public String getIkontak1() {
		return ikontak1;
	}

	public void setIkontak2(String ikontak2) {
		this.ikontak2 = ikontak2;
	}

	public String getIkontak2() {
		return ikontak2;
	}

	public void setInohp1(String inohp1) {
		this.inohp1 = inohp1;
	}

	public String getInohp1() {
		return inohp1;
	}

	public void setInohp2(String inohp2) {
		this.inohp2 = inohp2;
	}

	public String getInohp2() {
		return inohp2;
	}

	public void setIemail1(String iemail1) {
		this.iemail1 = iemail1;
	}

	public String getIemail1() {
		return iemail1;
	}

	public void setIemail2(String iemail2) {
		this.iemail2 = iemail2;
	}

	public String getIemail2() {
		return iemail2;
	}

	public void setKalamat1(String kalamat1) {
		this.kalamat1 = kalamat1;
	}

	public String getKalamat1() {
		return kalamat1;
	}

	public void setKalamat2(String kalamat2) {
		this.kalamat2 = kalamat2;
	}

	public String getKalamat2() {
		return kalamat2;
	}

	public void setKalamat3(String kalamat3) {
		this.kalamat3 = kalamat3;
	}

	public String getKalamat3() {
		return kalamat3;
	}

	public void setKkota(String kkota) {
		this.kkota = kkota;
	}

	public String getKkota() {
		return kkota;
	}

	public void setKkodepos(String kkodepos) {
		this.kkodepos = kkodepos;
	}

	public String getKkodepos() {
		return kkodepos;
	}

	public void setKnotelp(String knotelp) {
		this.knotelp = knotelp;
	}

	public String getKnotelp() {
		return knotelp;
	}

	public void setKnofax(String knofax) {
		this.knofax = knofax;
	}

	public String getKnofax() {
		return knofax;
	}

	public void setKemail(String kemail) {
		this.kemail = kemail;
	}

	public String getKemail() {
		return kemail;
	}

	public void setKkontak1(String kkontak1) {
		this.kkontak1 = kkontak1;
	}

	public String getKkontak1() {
		return kkontak1;
	}

	public void setKkontak2(String kkontak2) {
		this.kkontak2 = kkontak2;
	}

	public String getKkontak2() {
		return kkontak2;
	}

	public void setKnohp1(String knohp1) {
		this.knohp1 = knohp1;
	}

	public String getKnohp1() {
		return knohp1;
	}

	public void setKnohp2(String knohp2) {
		this.knohp2 = knohp2;
	}

	public String getKnohp2() {
		return knohp2;
	}

	public void setKemail1(String kemail1) {
		this.kemail1 = kemail1;
	}

	public String getKemail1() {
		return kemail1;
	}

	public void setKemail2(String kemail2) {
		this.kemail2 = kemail2;
	}

	public String getKemail2() {
		return kemail2;
	}

	public void setPnofax(String pnofax) {
		this.pnofax = pnofax;
	}

	public String getPnofax() {
		return pnofax;
	}

	public void setPalamat1(String palamat1) {
		this.palamat1 = palamat1;
	}

	public String getPalamat1() {
		return palamat1;
	}

	public void setPalamat2(String palamat2) {
		this.palamat2 = palamat2;
	}

	public String getPalamat2() {
		return palamat2;
	}

	public void setPalamat3(String palamat3) {
		this.palamat3 = palamat3;
	}

	public String getPalamat3() {
		return palamat3;
	}

	public void setPkota(String pkota) {
		this.pkota = pkota;
	}

	public String getPkota() {
		return pkota;
	}

	public void setPkodepos(String pkodepos) {
		this.pkodepos = pkodepos;
	}

	public String getPkodepos() {
		return pkodepos;
	}

	public void setPnotelp(String pnotelp) {
		this.pnotelp = pnotelp;
	}

	public String getPnotelp() {
		return pnotelp;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPkontak1(String pkontak1) {
		this.pkontak1 = pkontak1;
	}

	public String getPkontak1() {
		return pkontak1;
	}

	public void setPkontak2(String pkontak2) {
		this.pkontak2 = pkontak2;
	}

	public String getPkontak2() {
		return pkontak2;
	}

	public void setPnohp1(String pnohp1) {
		this.pnohp1 = pnohp1;
	}

	public String getPnohp1() {
		return pnohp1;
	}

	public void setPnohp2(String pnohp2) {
		this.pnohp2 = pnohp2;
	}

	public String getPnohp2() {
		return pnohp2;
	}

	public void setPemail1(String pemail1) {
		this.pemail1 = pemail1;
	}

	public String getPemail1() {
		return pemail1;
	}

	public void setPemail2(String pemail2) {
		this.pemail2 = pemail2;
	}

	public String getPemail2() {
		return pemail2;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setKtitel(String ktitel) {
		this.ktitel = ktitel;
	}

	public String getKtitel() {
		return ktitel;
	}

	public void setKcompany(String kcompany) {
		this.kcompany = kcompany;
	}

	public String getKcompany() {
		return kcompany;
	}

	public void setKpdir1(String kpdir1) {
		this.kpdir1 = kpdir1;
	}

	public String getKpdir1() {
		return kpdir1;
	}

	public void setEmdir1(String emdir1) {
		this.emdir1 = emdir1;
	}

	public String getEmdir1() {
		return emdir1;
	}

	public void setHpdir1(String hpdir1) {
		this.hpdir1 = hpdir1;
	}

	public String getHpdir1() {
		return hpdir1;
	}

	public void setKpdir2(String kpdir2) {
		this.kpdir2 = kpdir2;
	}

	public String getKpdir2() {
		return kpdir2;
	}

	public void setEmdir2(String emdir2) {
		this.emdir2 = emdir2;
	}

	public String getEmdir2() {
		return emdir2;
	}

	public void setHpdir2(String hpdir2) {
		this.hpdir2 = hpdir2;
	}

	public String getHpdir2() {
		return hpdir2;
	}

	public void setKpgm1(String kpgm1) {
		this.kpgm1 = kpgm1;
	}

	public String getKpgm1() {
		return kpgm1;
	}

	public void setEmgm1(String emgm1) {
		this.emgm1 = emgm1;
	}

	public String getEmgm1() {
		return emgm1;
	}

	public void setHpgm1(String hpgm1) {
		this.hpgm1 = hpgm1;
	}

	public String getHpgm1() {
		return hpgm1;
	}

	public void setKpgm2(String kpgm2) {
		this.kpgm2 = kpgm2;
	}

	public String getKpgm2() {
		return kpgm2;
	}

	public void setEmgm2(String emgm2) {
		this.emgm2 = emgm2;
	}

	public String getEmgm2() {
		return emgm2;
	}

	public void setHpgm2(String hpgm2) {
		this.hpgm2 = hpgm2;
	}

	public String getHpgm2() {
		return hpgm2;
	}

	public void setKpbeli1(String kpbeli1) {
		this.kpbeli1 = kpbeli1;
	}

	public String getKpbeli1() {
		return kpbeli1;
	}

	public void setEmbeli1(String embeli1) {
		this.embeli1 = embeli1;
	}

	public String getEmbeli1() {
		return embeli1;
	}

	public void setHpbeli1(String hpbeli1) {
		this.hpbeli1 = hpbeli1;
	}

	public String getHpbeli1() {
		return hpbeli1;
	}

	public void setKpbeli2(String kpbeli2) {
		this.kpbeli2 = kpbeli2;
	}

	public String getKpbeli2() {
		return kpbeli2;
	}

	public void setEmbeli2(String embeli2) {
		this.embeli2 = embeli2;
	}

	public String getEmbeli2() {
		return embeli2;
	}

	public void setHpbeli2(String hpbeli2) {
		this.hpbeli2 = hpbeli2;
	}

	public String getHpbeli2() {
		return hpbeli2;
	}

	public void setKpuser1(String kpuser1) {
		this.kpuser1 = kpuser1;
	}

	public String getKpuser1() {
		return kpuser1;
	}

	public void setEmuser1(String emuser1) {
		this.emuser1 = emuser1;
	}

	public String getEmuser1() {
		return emuser1;
	}

	public void setHpuser1(String hpuser1) {
		this.hpuser1 = hpuser1;
	}

	public String getHpuser1() {
		return hpuser1;
	}

	public void setKpuser2(String kpuser2) {
		this.kpuser2 = kpuser2;
	}

	public String getKpuser2() {
		return kpuser2;
	}

	public void setEmuser2(String emuser2) {
		this.emuser2 = emuser2;
	}

	public String getEmuser2() {
		return emuser2;
	}

	public void setHpuser2(String hpuser2) {
		this.hpuser2 = hpuser2;
	}

	public String getHpuser2() {
		return hpuser2;
	}

	public void setKstatusdesc(String kstatusdesc) {
		this.kstatusdesc = kstatusdesc;
	}

	public String getKstatusdesc() {
		return kstatusdesc;
	}

	public void setBtfaktur1(boolean btfaktur1) {
		this.btfaktur1 = btfaktur1;
	}

	public boolean isBtfaktur1() {
		return btfaktur1;
	}

	public void setBtfaktur2(boolean btfaktur2) {
		this.btfaktur2 = btfaktur2;
	}

	public boolean isBtfaktur2() {
		return btfaktur2;
	}

	public void setBtfaktur3(boolean btfaktur3) {
		this.btfaktur3 = btfaktur3;
	}

	public boolean isBtfaktur3() {
		return btfaktur3;
	}

	public void setBtfaktur4(boolean btfaktur4) {
		this.btfaktur4 = btfaktur4;
	}

	public boolean isBtfaktur4() {
		return btfaktur4;
	}

	public void setBtfaktur5(boolean btfaktur5) {
		this.btfaktur5 = btfaktur5;
	}

	public boolean isBtfaktur5() {
		return btfaktur5;
	}

	public void setBtfaktur6(boolean btfaktur6) {
		this.btfaktur6 = btfaktur6;
	}

	public boolean isBtfaktur6() {
		return btfaktur6;
	}

	public void setKdtrsdesc(String kdtrsdesc) {
		this.kdtrsdesc = kdtrsdesc;
	}

	public String getKdtrsdesc() {
		return kdtrsdesc;
	}

	public void setKindustridesc(String kindustridesc) {
		this.kindustridesc = kindustridesc;
	}

	public String getKindustridesc() {
		return kindustridesc;
	}
}
