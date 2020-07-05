/**
 * 
 */
package com.cufflinks.cufflinks.validator;

import org.springframework.stereotype.Component;

import com.cufflinks.cufflinks.model.request.LoginRequest;
import com.cufflinks.cufflinks.model.request.RegistrationRequest;
import com.cufflinks.cufflinks.util.CufflinksUtils;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
@Component
public class ModelValidator {
	
	
	
	/**
	 * @param req
	 * @return
	 */
	public boolean isValidLoginRequest(LoginRequest req) {
		if(CufflinksUtils.isNullOrEmpty(req.getTeamname())
				||CufflinksUtils.isNullOrEmpty(req.getPassword())
				) {
			return false;
			
		}
		else {
			return true;
		}
		
	}

	/**
	 * @param req
	 * @return
	 */
	public boolean isValidRegistrationRequest(RegistrationRequest req) {
		if(CufflinksUtils.isNullOrEmpty(req.getTeamname())
				||CufflinksUtils.isNullOrEmpty(req.getPassword())
				) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
