package sf.sales;


public class SCardHeader {
	private String noscard;
	
	private SCardHeader[] cards;
	public void setNoscard(String noscard) {
		this.noscard = noscard;
	}

	public String getNoscard() {
		return noscard;
	}
	
	private String _err="";
	public String getErr()
	{
		return _err;
	}
	
	public boolean checkIsNULL()
	{
		_err="";
		
		if(this.getNoscard()==null || "".equals(this.getNoscard()))
		{
			_err="Error,No sCard Could not empty.";
			return true;
		}
		return false;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(SCardHeader[] cards) {
		this.cards = cards;
	}

	/**
	 * @return the cards
	 */
	public SCardHeader[] getCards() {
		return cards;
	}
}
