package sf.accounting;

import sf.general.General;

public class Invoice extends General{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kinvoice;
	private String keterangan;
	private String kenappn="Y";
	private String kenappndesc="Ya";
	private String konfirmppn="Y";
	private String konfirmppndesc="Ya";
	private String accpiutang;
	private String accpiutangdesc;
	private String accsales;
	private String accsalesdesc;
	private String accdp;
	private String accdpdesc;
	private String accppn;
	private String accppndesc;
	private String direksi;
	private Invoice[] invoices;
	
	public Invoice()
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
		
		if(this.getKinvoice()==null || "".equals(this.getKinvoice()))
		{
			_err="Error,Invalid Invoice Code.Could not empty.";
			return true;
		}
		return false;
	}

	public void setKinvoice(String kinvoice) {
		this.kinvoice = kinvoice;
	}

	public String getKinvoice() {
		return kinvoice;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKenappn(String kenappn) {
		this.kenappn = kenappn;
	}

	public String getKenappn() {
		return kenappn;
	}

	public void setAccpiutang(String accpiutang) {
		this.accpiutang = accpiutang;
	}

	public String getAccpiutang() {
		return accpiutang;
	}

	public void setAccsales(String accsales) {
		this.accsales = accsales;
	}

	public String getAccsales() {
		return accsales;
	}

	public void setAccdp(String accdp) {
		this.accdp = accdp;
	}

	public String getAccdp() {
		return accdp;
	}

	public void setAccppn(String accppn) {
		this.accppn = accppn;
	}

	public String getAccppn() {
		return accppn;
	}

	public void setDireksi(String direksi) {
		this.direksi = direksi;
	}

	public String getDireksi() {
		return direksi;
	}

	public void setInvoices(Invoice[] invoices) {
		this.invoices = invoices;
	}

	public Invoice[] getInvoices() {
		return invoices;
	}

	public void setKonfirmppn(String konfirmppn) {
		this.konfirmppn = konfirmppn;
	}

	public String getKonfirmppn() {
		return konfirmppn;
	}

	public void setKenappndesc(String kenappndesc) {
		this.kenappndesc = kenappndesc;
	}

	public String getKenappndesc() {
		return kenappndesc;
	}

	public void setKonfirmppndesc(String konfirmppndesc) {
		this.konfirmppndesc = konfirmppndesc;
	}

	public String getKonfirmppndesc() {
		return konfirmppndesc;
	}

	public void setAccpiutangdesc(String accpiutangdesc) {
		this.accpiutangdesc = accpiutangdesc;
	}

	public String getAccpiutangdesc() {
		return accpiutangdesc;
	}

	public void setAccsalesdesc(String accsalesdesc) {
		this.accsalesdesc = accsalesdesc;
	}

	public String getAccsalesdesc() {
		return accsalesdesc;
	}

	public void setAccdpdesc(String accdpdesc) {
		this.accdpdesc = accdpdesc;
	}

	public String getAccdpdesc() {
		return accdpdesc;
	}

	public void setAccppndesc(String accppndesc) {
		this.accppndesc = accppndesc;
	}

	public String getAccppndesc() {
		return accppndesc;
	}
}
