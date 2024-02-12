package reviewer.api;

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
	public ResponseEntity<ArrayList<Review>> submission(String username)
	{
		ArrayList<Review> SubmissionList = new ArrayList<Review>();
     	SubmissionList = reviewRepo.findAllByIdUserIdAndReviewStatus(username,"submit");
     	return new ResponseEntity<>(SubmissionList,HttpStatus.OK);
		
	}
	
	
	public String getSubmission(@RequestParam(name = "action")String action ,@RequestParam("id") Long paperId,Model model,@ModelAttribute User user)
	{
		
		//TODO implement the feature
	    return "submission";
	    
	}
}
