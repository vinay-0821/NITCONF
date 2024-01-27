package reviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.data.UserRepository;
import reviewer.model.User;

@Controller
@RequestMapping("/edit-profile")
@SessionAttributes("user")
public class EditProfileController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String editProfile()
	{
		return "edit-profile";
	}
	
	@PostMapping
	public String editProfileform(@ModelAttribute User user)
	{
		System.out.println(user.toString());
		userRepository.save(user);
		System.out.println("it should be added to database");
		//update database
		return "profile";
	}

}
