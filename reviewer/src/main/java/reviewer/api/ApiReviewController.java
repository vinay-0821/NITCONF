package reviewer.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reviewer.model.User;


@RestController
@RequestMapping(path="/api/reviewer" , produces="application/json")
public class ApiReviewController {
	
	@GetMapping
	public User getPapers(User user)
	{
		return user;
	}

	
	
}
