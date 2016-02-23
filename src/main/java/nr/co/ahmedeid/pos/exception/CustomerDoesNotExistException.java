package nr.co.ahmedeid.pos.exception;

public class CustomerDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7357481075904407688L;
	private static final String MESSAGE_FORMAT = "Customer '%d' does not exist";
	
	public CustomerDoesNotExistException(Long customerId)
	{
		 super(String.format(MESSAGE_FORMAT, customerId));
	}

}
