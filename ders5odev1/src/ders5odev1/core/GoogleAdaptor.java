package ders5odev1.core;

import ders5odev1.authorizationService.Google;

public class GoogleAdaptor implements AuthorizationService{
	
	@Override
	public void giveAuthorization() {
		Google google = new Google();
		google.giveAuthorization();
	}
	
}
