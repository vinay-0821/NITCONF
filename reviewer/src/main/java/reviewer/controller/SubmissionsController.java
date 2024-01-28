package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubmissionsController {
	
	@GetMapping("/submissions")
	public String submissions() {
		return "submissions";
	}

}
