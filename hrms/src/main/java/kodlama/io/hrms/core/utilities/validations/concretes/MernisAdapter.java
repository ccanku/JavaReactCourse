package kodlama.io.hrms.core.utilities.validations.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.validations.abstracts.IdentityVerificationService;
import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements IdentityVerificationService{

	@Override
	public boolean CheckIfRealPerson(Candidate candidate) {
		return true;
	}
	
	
	/*
	@Override
	public boolean CheckIfRealPerson(Candidate candidate) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			boolean result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalId()),
					candidate.getFirstName().toUpperCase(), 
					candidate.getLastName().toUpperCase(), 
					Integer.parseInt(candidate.getYearOfBirth()));
			if(result) {
				return result;
			}
		} catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
			System.out.println("Hata: " + e);
			return false;
		}
		return false;
	}*/
}
