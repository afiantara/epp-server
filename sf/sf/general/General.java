package sf.general;

import java.io.Serializable;

public class General implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recstatus="A";
	private long tglupdate;
	private String userupdate;
	private long tglinput;
	private String userinput;
	
	public General()
	{
		
	}
	public void setRecstatus(String recstatus) {
		this.recstatus = recstatus;
	}
	public String getRecstatus() {
		return recstatus;
	}
	public void setTglupdate(long tglupdate) {
		this.tglupdate = tglupdate;
	}
	public long getTglupdate() {
		return tglupdate;
	}
	public void setUserupdate(String userupdate) {
		this.userupdate = userupdate;
	}
	public String getUserupdate() {
		return userupdate;
	}
	public void setTglinput(long tglinsert) {
		this.tglinput = tglinsert;
	}
	public long getTglinput() {
		return tglinput;
	}
	public void setUserinput(String userinput) {
		this.userinput = userinput;
	}
	public String getUserinput() {
		return userinput;
	}
}
