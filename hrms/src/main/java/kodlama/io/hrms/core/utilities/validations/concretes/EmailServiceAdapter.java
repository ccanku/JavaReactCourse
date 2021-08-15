package kodlama.io.hrms.core.utilities.validations.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.validations.abstracts.EmailVerificationService;
import kodlama.io.hrms.entities.abstracts.User;

@Service
public class EmailServiceAdapter implements EmailVerificationService{

	@Override
	public Result sendVerificationMail(String email) {
		return new SuccessResult("E-posta gönderildi.");
	}

	@Override
	public Result confirmVerification(User user) {
		return new SuccessResult("E-posta onaylandı.");
	}

}
