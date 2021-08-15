package kodlama.io.hrms.core.utilities.validations.abstracts;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface IdentityVerificationService {
	boolean CheckIfRealPerson(Candidate candidate);
}
