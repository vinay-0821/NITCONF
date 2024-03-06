package reviewer.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;
import reviewer.model.User;

@RestController
@RequestMapping(path="/api/submissions" , produces="application/json")
@SessionAttributes("user")
public class ApiSubmissionsController {
	
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@GetMapping
	@Operation(
		    tags = {"Drafts and Submissions"},
		    operationId = "listSubmissions",
		    summary = "List submissions",
		    description = "Display all submissions made by the provided user from the past up to the present.",
		    parameters = @Parameter(name="username" ,description = "The username of the user to retrieve submissions for." , example="jonny")
		)
	public ResponseEntity<ArrayList<Review>> submission(String username)
	{
		ArrayList<Review> SubmissionList = new ArrayList<Review>();
     	SubmissionList = reviewRepo.findAllByIdUserIdAndReviewStatus(username,"submit");
     	return new ResponseEntity<>(SubmissionList,HttpStatus.OK);
		
	}
	
	
	public String getSubmission(@RequestParam(name = "action")String action ,@RequestParam("id") Long paperId)
	{
		
		//TODO implement the feature
	    return "submission";
	    
	}
}
