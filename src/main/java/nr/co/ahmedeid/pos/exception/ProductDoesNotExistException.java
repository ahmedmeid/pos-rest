package nr.co.ahmedeid.pos.exception;

public class ProductDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6554317293359255583L;
	private static final String MESSAGE_FORMAT = "Product with barcode: '%s' does not exist";
	
	public ProductDoesNotExistException(String barcode)
	{
		 super(String.format(MESSAGE_FORMAT,barcode));
	}

}
