package da.error;

import org.apache.log4j.Category;

public class DAException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int intError;
	static final Category log = Category.getInstance(DAException.class);
	
	public int getErrNo()
	{
		return intError;
	}
	
	public DAException(int intErrNo){
	    intError = intErrNo;
	}

	public DAException(String strMessage){
	    super(strMessage);
	    log.error(strMessage);
	}
	
	public DAException(String strMessage,int errNo){
	    super(strMessage);
	    intError = errNo;
	    log.error(strMessage);
	}

   public String toString(){
	   return "DAException["+intError+"]";
   }  
	   
}
