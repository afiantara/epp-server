package sf.accounting;

import java.text.DecimalFormat;
import java.text.ParseException;

import sf.general.General;

public class Account extends General{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accno;
	private String accdesc;
	private String acclevel="H";  
	private String accleveldesc="Header";
	private String accgroup="A"; 
	private String accgroupdesc="Aktiva";
	private String acctype="N";
	private String acctypedesc="Non K/B";
	private String accbiayab="N";
	private String accbiayap="N";
	private String accbiayas="N";
	private String accbiayak="N";
	private boolean boolaccbiayab=false;
	private boolean boolaccbiayap=false;
	private boolean boolaccbiayas=false;
	private boolean boolaccbiayak=false;
	private String kodein;
	private String kodeout;
	private int noin=0;
	private int noout=0;
	
	private Account[] accounts;
	
	private String[] headers=new String[]{
			"accno",
			"accdesc",
			"acclevel",
			"accgroup",
			"accbiayab",
			"accbiayap",
			"accbiayas",
			"accbiayak",
			"kodein",
			"kodeout",
			"noin",
			"noout"
		};
		
		public String[] getHeader()
		{
			return headers;
		}
		
		public String[] getContent()
		{
			DecimalFormat dc =new DecimalFormat("000");
			String[] contents=null;
			try {
				contents = new String[]{
						Tools.AccountNoFormat(this.getAccno()),
						this.getAccdesc(),
						this.getAcclevel(),
						this.getAccgroup(),
						this.getAccbiayab(),
						this.getAccbiayap(),
						this.getAccbiayas(),
						this.getAccbiayak(),
						this.getKodein(),
						this.getKodeout(),
						dc.format(this.getNoin()),
						dc.format(this.getNoout())};
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return contents;
		}
		
	public Account()
	{
		
	}
	
	private String _err="";
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		if(this.getAccno()==null || "".equals(this.getAccno()))
		{
			_err="Error,Invalid Account No.Could not empty.";
			return true;
		}
		if(this.getAccdesc()==null || "".equals(this.getAccdesc()))
		{
			_err="Error,Invalid Account Desc.Could not empty.";
			return true;
		}
		
		if(this.getAcclevel()==null || "".equals(this.getAcclevel()))
		{
			_err="Error,Invalid Access Level.Could not empty.";
			return true;
		}
		if(this.getAccgroup()==null || "".equals(this.getAccgroup()))
		{
			_err="Error,Invalid Account Group.Could not empty.";
			return true;
		}
		if(this.getAcctype()==null || "".equals(this.getAcctype()))
		{
			_err="Error,Invalid Account Type.Could not empty.";
			return true;
		}
		return false;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccdesc(String accdesc) {
		this.accdesc = accdesc;
	}

	public String getAccdesc() {
		return accdesc;
	}

	public void setAcclevel(String acclevel) {
		this.acclevel = acclevel;
	}

	public String getAcclevel() {
		return acclevel;
	}

	public void setAccgroup(String accgroup) {
		this.accgroup = accgroup;
	}

	public String getAccgroup() {
		return accgroup;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAccbiayap(String accbiayap) {
		this.accbiayap = accbiayap;
	}

	public String getAccbiayap() {
		return accbiayap;
	}

	public void setAccbiayas(String accbiayas) {
		this.accbiayas = accbiayas;
	}

	public String getAccbiayas() {
		return accbiayas;
	}

	public void setAccbiayak(String accbiayak) {
		this.accbiayak = accbiayak;
	}

	public String getAccbiayak() {
		return accbiayak;
	}

	public void setKodein(String kodein) {
		this.kodein = kodein;
	}

	public String getKodein() {
		return kodein;
	}

	public void setKodeout(String kodeout) {
		this.kodeout = kodeout;
	}

	public String getKodeout() {
		return kodeout;
	}

	public void setNoin(int noin) {
		this.noin = noin;
	}

	public int getNoin() {
		return noin;
	}

	public void setNoout(int noout) {
		this.noout = noout;
	}

	public int getNoout() {
		return noout;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccbiayab(String accbiayab) {
		this.accbiayab = accbiayab;
	}

	public String getAccbiayab() {
		return accbiayab;
	}

	public void setAccleveldesc(String accleveldesc) {
		this.accleveldesc = accleveldesc;
	}

	public String getAccleveldesc() {
		return accleveldesc;
	}

	public void setAccgroupdesc(String accgroupdesc) {
		this.accgroupdesc = accgroupdesc;
	}

	public String getAccgroupdesc() {
		return accgroupdesc;
	}

	public void setAcctypedesc(String acctypedesc) {
		this.acctypedesc = acctypedesc;
	}

	public String getAcctypedesc() {
		return acctypedesc;
	}

	public void setBoolaccbiayab(boolean boolaccbiayab) {
		this.boolaccbiayab = boolaccbiayab;
	}

	public boolean isBoolaccbiayab() {
		return boolaccbiayab;
	}

	public void setBoolaccbiayap(boolean boolaccbiayap) {
		this.boolaccbiayap = boolaccbiayap;
	}

	public boolean isBoolaccbiayap() {
		return boolaccbiayap;
	}

	public void setBoolaccbiayas(boolean boolaccbiayas) {
		this.boolaccbiayas = boolaccbiayas;
	}

	public boolean isBoolaccbiayas() {
		return boolaccbiayas;
	}

	public void setBoolaccbiayak(boolean boolaccbiayak) {
		this.boolaccbiayak = boolaccbiayak;
	}

	public boolean isBoolaccbiayak() {
		return boolaccbiayak;
	}
}
