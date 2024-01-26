package reviewer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import reviewer.data.UserRepository;
import reviewer.model.User;


@Service
public class SecurityUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User user = userRepository.findUserByUsername(username);
		
		if(user!= null)
			return user;
		
		System.out.println("Usernotfound");
		throw new UsernameNotFoundException("Username Not Found");
	} 
	
	
	
	 public void createUser(UserDetails user) { 
	      userRepository.save((User) user); 
	   }

}
