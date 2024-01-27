package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.model.User;

@Controller
@RequestMapping("/profile")
@SessionAttributes("user")
public class ProfileController {
	
	@GetMapping
	public String viewprofile(@SessionAttribute User user)
	{
		
		System.out.println(user.toString());
		return "profile";
	}


}
