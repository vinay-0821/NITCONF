package reviewer.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import reviewer.data.UserRepository;
import reviewer.model.User;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String dashboard(Principal principal,Model model)
	{
		
		User user = userRepository.findUserByUsername(principal.getName());
		
		model.addAttribute("user", user);
		
		return "dashboard";
	}
}
