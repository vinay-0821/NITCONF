package reviewer.rest;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.PaperRepository;
import reviewer.data.ReviewRepository;
import reviewer.model.Paper;
import reviewer.model.Review;


@RestController
@RequestMapping(path="/api" , produces="application/json")
public class ApiToReviewController {
	

	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private PaperRepository paperRepo;
	
	
	
	private String getUsernameFromToken()
	{
	    String authHeader = request.getHeader("Authorization");
	    String jwt = authHeader.substring(7);  
	    String username = jwtService.extractUsername(jwt);
	    return username;
	}
	
	
	@GetMapping("/get-to-review")
	public Iterable<Review> toReview()
	{
		
		String username = getUsernameFromToken();
		ArrayList<Review> reviewList = new ArrayList<Review>();
		
		//TODO search by status also
		reviewList= reviewRepo.findAllByIdUserIdAndReviewerStatus(username,"accept");
		for(Review review : reviewList)
		{
			System.out.println(review.toString());
		}
	    return reviewList;
	}
	
	@GetMapping("/get-paper")
	public Paper getPaper(@RequestParam Long paperId)
	{
		Optional<Paper> optPaper =  paperRepo.findPaperById(paperId);
	
		if(optPaper.isPresent())
		{
			return optPaper.get();	
		}
		
		return null;
	}
		
		
	

	

}



//	@Operation(
//    tags = {"Papers Yet to Review"},
//    operationId = "findPapers",
//    summary = "Find Papers",
//    description = "Search for papers assigned to a user which are yet to be reviewed and display if present.",
//    parameters = @Parameter(name="username" ,description = "The username of the user for whom papers are to be searched." , example="jonny")
//)
