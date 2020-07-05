/**
 * 
 */
package com.cufflinks.cufflinks.implementer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cufflinks.cufflinks.model.request.LoginRequest;
import com.cufflinks.cufflinks.model.request.RegistrationRequest;
import com.cufflinks.cufflinks.model.response.LoginResponse;
import com.cufflinks.cufflinks.model.response.RegistrationResponse;
import com.cufflinks.cufflinks.response_builder.FailedConfigBuilder;
import com.cufflinks.cufflinks.response_builder.SuccessConfigBuilder;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
@SpringBootTest
public class CufflinksImplementerTest {

	@Autowired
	private SuccessConfigBuilder successConfigBuilder;
	
	@Autowired
	private FailedConfigBuilder failedConfigBuilder;
	
	@Autowired
	private CufflinksImplementer implementer;
	
	
	@Test
	public void testLoginWithCorrectCredential_shouldReturnSuccess() {
		
		LoginResponse successResponse = successConfigBuilder.successLoginRequest("xyz");
		LoginRequest req = new LoginRequest();
		req.setTeamname("test");
		req.setPassword("test");
		
		assertEquals(successResponse, implementer.implementLogin(req));
		
	}
	
	
	@Test
	public void testLoginWithInvalidCredential_shouldReturnFailure() {
		
		LoginResponse Response = failedConfigBuilder.invalidCredentials();
		LoginRequest req = new LoginRequest();
		req.setTeamname("nan");
		req.setPassword("test");
		
		assertEquals(Response, implementer.implementLogin(req));
		
	}
	
	
	@Test
	public void testLoginWithInvalidRequest_shouldReturnFailure() {
		
		LoginResponse Response = failedConfigBuilder.emptyLoginRequest();
		LoginRequest req = new LoginRequest();
		
		assertEquals(Response, implementer.implementLogin(req));
		
	}
	
	
	
	
	@Test
	public void testRegisterWithInvalidRequest_shouldReturnFailure() {
		
		RegistrationResponse Response = failedConfigBuilder.emptyRegisterRequest();
		RegistrationRequest req = new RegistrationRequest();
		
		assertEquals(Response, implementer.implementRegistration(req));
		
	}
	
	
	
	@Test
	public void testRegistrationWithAlreadyRegisteredCredentials_shouldReturnFailure() {
		

		RegistrationResponse Response = failedConfigBuilder.alreadyATeam();
		RegistrationRequest req = new RegistrationRequest();
		req.setTeamname("test");
		req.setPassword("test");
		
		assertEquals(Response, implementer.implementRegistration(req));
		
	}
//	@Test
//	public void testRegistrationWithCorrectCredentials_shouldReturnSuccess() {
//		
//		
//		RegistrationResponse Response = successConfigBuilder.successRegisterRequest();
//		RegistrationRequest req = new RegistrationRequest();
//		req.setTeamname("test1");
//		req.setPassword("test");
//		
//		assertEquals(Response, implementer.implementRegistration(req));
//		
//	}
	
	

}








