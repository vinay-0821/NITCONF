package reviewer.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class AuthenticationResponse {
	
    public AuthenticationResponse(String jwtToken) {
		this.token = jwtToken;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
}
