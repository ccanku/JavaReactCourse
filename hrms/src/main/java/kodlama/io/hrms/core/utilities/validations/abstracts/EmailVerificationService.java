package kodlama.io.hrms.core.utilities.validations.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.abstracts.User;

public interface EmailVerificationService {
	Result sendVerificationMail(String email);
	Result confirmVerification(User user);
}
