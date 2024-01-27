package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubmissionController {
	
	@GetMapping("/submission")
	public String submission() {
		return "submission";
	}

}
