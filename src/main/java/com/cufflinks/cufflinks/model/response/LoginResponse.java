/**
 * 
 */
package com.cufflinks.cufflinks.model.response;

import com.cufflinks.cufflinks.model.BaseResponse;

/**
 *
 * @author Ashwani Pandey
 *
 * createdAt 5 Jul, 2020
 *
*/
public class LoginResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6992461492309338355L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
