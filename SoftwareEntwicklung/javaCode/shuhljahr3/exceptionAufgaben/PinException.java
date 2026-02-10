package shuhljahr3.exceptionAufgaben;

public class PinException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Falscher Pin";
	}

}
