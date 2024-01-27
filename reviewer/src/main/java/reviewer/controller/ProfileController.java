package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/profile")
@SessionAttributes("user")
public class ProfileController {
	
	@GetMapping
	public String viewprofile()
	{
		return "profile";
	}
	
	@PostMapping
	public String profilEdit()
	{
		
		System.out.println("profile submitted");
		return "profile";
	}

}
