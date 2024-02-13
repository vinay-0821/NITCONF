package reviewer.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;

@RestController
@RequestMapping(path="/api/draft" , produces="application/json")
public class ApiDraftController {
	

	@Autowired
	private ReviewRepository reviewRepo;
	
	 /**
     * Retrieves and displays the drafts associated with the logged-in user.
     * 
     * @param user  the user object retrieved from the session
     * @param model the model to which attributes can be added
     * @return the view name for the "drafts" page which contains the drafts of the user
     */
	@GetMapping
	@Operation(
			tags= {"drafts and submissions"},
			operationId = " ",
			summary = " find drafts",
			description = " search drafts there for username provided and display them"
		)
	public Iterable<Review> drafts(@RequestParam("username") String username) 
	{
		ArrayList<Review> draftList = new ArrayList<Review>();
     	draftList = reviewRepo.findAllByIdUserIdAndReviewStatus(username,"draft");
		return draftList;
	}

}
