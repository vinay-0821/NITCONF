package reviewer.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor       //why we actually need them
@Table(name="user")
public class User implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;  //what it actually means ?
	
	@Id
	private String username;
	private String password;
	
	public User()
	{
		
	}
	
	public User(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {     
		// what should we return here
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getPassword() {
		
		return password;
	}
	
	@Override
	public String getUsername() {
		
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	
	

}
