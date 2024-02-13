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
@RequestMapping(path="/api/to-review" , produces="application/json")
public class ApiToReviewController {
	
	@Autowired
	ReviewRepository reviewRepo;
	
	
	@GetMapping
	@Operation(
			tags= {"papers yet to review"},
			operationId = " ",
			summary = " find papers",
			description = " search papers assigned to user which are yet to be reviewd and display if present"
		)
	public Iterable<Review> toReview(@RequestParam("username") String username)
	{
		
		//TODO search by review_status 
		ArrayList<Review> reviewList = new ArrayList<Review>();
		reviewList= reviewRepo.findAllByIdUserId(username);
	    return reviewList;
	}
	

}
