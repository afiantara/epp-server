package sf.inventory;

public class PType {
	private String ktype;
	private String ntype;
	
	private PType[] ptypes;
	
	public void setKtype(String ktype) {
		this.ktype = ktype;
	}
	public String getKtype() {
		return ktype;
	}
	public void setNtype(String ntype) {
		this.ntype = ntype;
	}
	public String getNtype() {
		return ntype;
	}
	public void setPtypes(PType[] ptypes) {
		this.ptypes = ptypes;
	}
	public PType[] getPtypes() {
		return ptypes;
	}
}
