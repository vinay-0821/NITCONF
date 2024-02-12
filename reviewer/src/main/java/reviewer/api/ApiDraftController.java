package reviewer.api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
	public Iterable<Review> drafts(@RequestParam("username") String username) 
	{
		ArrayList<Review> draftList = new ArrayList<Review>();
     	draftList = reviewRepo.findAllByIdUserIdAndReviewStatus(username,"draft");
		return draftList;
	}

}
