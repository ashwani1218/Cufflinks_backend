/**
 * 
 */
package com.cufflinks.cufflinks.implementer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cufflinks.cufflinks.dataservice.TeamService;
import com.cufflinks.cufflinks.entity.Team;
import com.cufflinks.cufflinks.model.request.LoginRequest;
import com.cufflinks.cufflinks.model.request.RegistrationRequest;
import com.cufflinks.cufflinks.model.response.LoginResponse;
import com.cufflinks.cufflinks.model.response.RegistrationResponse;
import com.cufflinks.cufflinks.response_builder.FailedConfigBuilder;
import com.cufflinks.cufflinks.response_builder.SuccessConfigBuilder;
import com.cufflinks.cufflinks.translator.TeamTranslator;
import com.cufflinks.cufflinks.util.JWTUtil;
import com.cufflinks.cufflinks.validator.DbValidator;
import com.cufflinks.cufflinks.validator.ModelValidator;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
@Component
public class CufflinksImplementer {
	
	@Autowired
	private TeamTranslator translator;
	
	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private ModelValidator modelValidator;
	
	@Autowired
	private DbValidator dbValidator;
	
	@Autowired
	private FailedConfigBuilder failedConfigBuilder;
	
	@Autowired
	private SuccessConfigBuilder successConfigBuilder;
	
	@Autowired
	private TeamService teamService;
	
	/**
	 * @param req
	 * @return
	 */
	private boolean isAuthentic(LoginRequest req) {
		Optional<Team> team = teamService.findByTeamName(req.getTeamname());
		if(team.isPresent()) {
			if(team.get().getPassword().equals(req.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	/**
	 * @param req
	 * @return
	 */
	public LoginResponse implementLogin(LoginRequest req) {
		LoginResponse resp = new LoginResponse();
		if(modelValidator.isValidLoginRequest(req)) {
			if(isAuthentic(req)) {
				Team team = translator.translateLoginToTeam(req);
				String token = jwtUtil.generateToken(team);
				resp = successConfigBuilder.successLoginRequest(token);
				
			}else {
				resp = failedConfigBuilder.invalidCredentials();
			}
		}
		else {
			resp = failedConfigBuilder.emptyLoginRequest();
		}
		
		return resp;
	}

	/**
	 * @param req
	 * @return
	 */
	public RegistrationResponse implementRegistration(RegistrationRequest req) {
		RegistrationResponse resp = new RegistrationResponse();
		if(modelValidator.isValidRegistrationRequest(req)) {
			if(!dbValidator.isAlreadyAUser(req)) {
				Team team = translator.translateRegisterToTeam(req);
				teamService.save(team);
				resp = successConfigBuilder.successRegisterRequest();
			}
			else {
				resp = failedConfigBuilder.alreadyATeam();
			}
		}
		else {
			resp = failedConfigBuilder.emptyRegisterRequest();
		}
		return resp;
	}

}
