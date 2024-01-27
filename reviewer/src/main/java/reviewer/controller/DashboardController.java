package reviewer.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.data.UserRepository;
import reviewer.model.User;


@Controller
@RequestMapping("/dashboard")
@SessionAttributes("user")
public class DashboardController {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@ModelAttribute("user")
	public User user(Principal principal)
	{
		return userRepository.findUserByUsername(principal.getName());
	}

	
	
	@GetMapping
	public String dashboard(Principal principal,Model model)
	{
		user(principal);
		return "dashboard";
	}
//	
//	@GetMapping("/edit-profile")
//	public String editProfile(Model model)
//	{
//		return "editprofile";
//	}
	
	
}
