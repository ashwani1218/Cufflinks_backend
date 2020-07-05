/**
 * 
 */
package com.cufflinks.cufflinks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cufflinks.cufflinks.implementer.CufflinksImplementer;
import com.cufflinks.cufflinks.model.request.LoginRequest;
import com.cufflinks.cufflinks.model.request.RegistrationRequest;
import com.cufflinks.cufflinks.model.response.LoginResponse;
import com.cufflinks.cufflinks.model.response.RegistrationResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
@CrossOrigin(origins = "*")
@RestController
public class IndexController {

	@Autowired
	private CufflinksImplementer implementer;
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest req) {
		return implementer.implementLogin(req);
	}
	
	
	@PostMapping("/register")
	public RegistrationResponse register(@RequestBody RegistrationRequest req) {
		return implementer.implementRegistration(req);
	}
	
}
