package sf.purchasing;

import java.io.Serializable;

public class Title implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ktitel ;
	
	private Title[] titles;

	public void setKtitel(String ktitel) {
		this.ktitel = ktitel;
	}

	public String getKtitel() {
		return ktitel;
	}

	public void setTitles(Title[] titles) {
		this.titles = titles;
	}

	public Title[] getTitles() {
		return titles;
	}
}
