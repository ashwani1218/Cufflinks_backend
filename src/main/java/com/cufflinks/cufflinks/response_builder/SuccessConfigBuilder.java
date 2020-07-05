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
public class SuccessConfigBuilder {

	/**
	 * @param token
	 * @return
	 */
	public LoginResponse successLoginRequest(String token) {
		LoginResponse resp = new LoginResponse();
		
		resp.setHttpStatus(HttpStatus.OK);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(ResponseConstants.SUCCESS_LOGIN_DESCRIPTION);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		resp.setToken(token);
		return resp;
	}

	/**
	 * @return
	 */
	public RegistrationResponse successRegisterRequest() {
		RegistrationResponse resp = new RegistrationResponse();
		resp.setHttpStatus(HttpStatus.CREATED);
		resp.setResponseCode(ResponseConstants.SUCCESS_CODE);
		resp.setResponseDescription(ResponseConstants.SUCCESS_REGISTRATION);
		resp.setStatus(ResponseConstants.SUCCESS_STATUS);
		return resp;
	}

}
