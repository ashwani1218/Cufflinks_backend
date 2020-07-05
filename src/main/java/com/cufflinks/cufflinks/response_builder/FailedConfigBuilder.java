/**
 * 
 */
package com.cufflinks.cufflinks.response_builder;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.cufflinks.cufflinks.constants.ResponseConstants;
import com.cufflinks.cufflinks.model.response.LoginResponse;
import com.cufflinks.cufflinks.model.response.RegistrationResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 30 Jun, 2020
 *
*/
@Component
public class FailedConfigBuilder {

	/**
	 * @return
	 */
	public LoginResponse emptyLoginRequest() {
		LoginResponse resp = new LoginResponse();
		
		resp.setHttpStatus(HttpStatus.BAD_REQUEST);
		resp.setResponseCode(ResponseConstants.EMPTY_LOGIN_REQUEST);
		resp.setResponseDescription(ResponseConstants.EMPTY_LOGIN_REQUEST);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		
		return resp;
	}

	/**
	 * @return
	 */
	public LoginResponse invalidCredentials() {
		LoginResponse resp = new LoginResponse();
		resp.setHttpStatus(HttpStatus.UNAUTHORIZED);
		resp.setResponseCode(ResponseConstants.UNAUTHENTIC_CODE);
		resp.setResponseDescription(ResponseConstants.UNAUTHENTIC_USER);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		
		return resp;
	}

	/**
	 * @return
	 */
	public RegistrationResponse alreadyATeam() {
		RegistrationResponse resp = new RegistrationResponse();
		
		resp.setHttpStatus(HttpStatus.BAD_REQUEST);
		resp.setResponseCode(ResponseConstants.ALREADY_USER_CODE);
		resp.setResponseDescription(ResponseConstants.ALREADY_TEAM);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		
		return resp;
	}

	/**
	 * @return
	 */
	public RegistrationResponse emptyRegisterRequest() {
		RegistrationResponse resp = new RegistrationResponse();
		
		resp.setHttpStatus(HttpStatus.BAD_REQUEST);
		resp.setResponseCode(ResponseConstants.FAILURE_CODE);
		resp.setResponseDescription(ResponseConstants.EMPTY_REGISTRATION_REQUEST);
		resp.setStatus(ResponseConstants.FAILED_STATUS);
		
		return resp;
	}

}










