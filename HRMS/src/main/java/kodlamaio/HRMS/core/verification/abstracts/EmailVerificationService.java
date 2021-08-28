package kodlamaio.HRMS.core.verification.abstracts;

public interface EmailVerificationService {

	public boolean isEmailVerified(String email);
	public boolean isEmailExists(String email); 
	public boolean isEmailFormatCorrect(String email);
}
