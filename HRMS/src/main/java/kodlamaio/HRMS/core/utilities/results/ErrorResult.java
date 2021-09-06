package kodlamaio.HRMS.core.utilities.results;

public class ErrorResult extends Result {

	public ErrorResult(boolean success) {
		super(false);
		
	}
	public ErrorResult(boolean success,String message) {
		super(false, message);
		
	}
	public ErrorResult(String message) {
		super(false,message);
		
	}
}
