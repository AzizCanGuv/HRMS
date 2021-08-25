package kodlamaio.HRMS.core.verification.concretes;

import kodlamaio.HRMS.core.verification.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public boolean isEmailVerified(String email) {
		return true;
	}

	@Override
	public boolean isEmailExists(String email) {
		return true;
	}

	
}
