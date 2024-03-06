package reviewer.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;


@RestController
@RequestMapping(path="/api/to-review" , produces="application/json")
public class ApiToReviewController {
	
	@Autowired
	ReviewRepository reviewRepo;
	
	
	@GetMapping
	@Operation(
		    tags = {"Papers Yet to Review"},
		    operationId = "findPapers",
		    summary = "Find Papers",
		    description = "Search for papers assigned to a user which are yet to be reviewed and display if present.",
		    parameters = @Parameter(name="username" ,description = "The username of the user for whom papers are to be searched." , example="jonny")
		)
	public Iterable<Review> toReview(@RequestParam("username") String username)
	{
		
		//TODO search by review_status 
		ArrayList<Review> reviewList = new ArrayList<Review>();
		reviewList= reviewRepo.findAllByIdUserId(username);
	    return reviewList;
	}
	

}
