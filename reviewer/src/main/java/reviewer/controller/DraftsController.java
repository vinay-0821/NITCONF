package reviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DraftsController {
	
	@GetMapping("/drafts")
	public String drafts() {
		return "drafts";
	}

}
