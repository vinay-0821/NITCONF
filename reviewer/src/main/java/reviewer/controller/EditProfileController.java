package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/edit-profile")
@SessionAttributes("user")
public class EditProfileController {
	
	
	@GetMapping
	public String editProfile()
	{
		return "edit-profile";
	}
	
	@PostMapping
	public String editProfileform()
	{
		
		//update database
		return "profile";
	}

}
