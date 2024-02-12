package reviewer.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.data.ReviewRepository;
import reviewer.data.UserRepository;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.util.ReviewForm;
import reviewer.util.ReviewKey;


@RestController
@RequestMapping(path="/api/review" , produces="application/json")
@SessionAttributes("user")
public class ApiReviewController {
	
	 @Autowired
	 private ReviewRepository reviewRepo;
	 
	 
	  @GetMapping
		public ResponseEntity<Review> getReview(@RequestParam(name = "action")String action ,@RequestParam("id") Long paperId,@RequestParam("username")String username)
		{
		    if(action.equals("view"))
		    {
			    Review review = reviewRepo.findById(new ReviewKey(paperId,username)).get();
			    
			    System.out.println(review.toString());
				return new ResponseEntity<>(review,HttpStatus.OK);
		    }
		    
		    
		    if(action.equals("clear"))
		    {
		    	 Review review = reviewRepo.findById(new ReviewKey(paperId,username)).get();
		    	 review.modifyReview(new ReviewForm());
		    	 review.setReviewStatus("new");
		    	 reviewRepo.save(review);
		    	 return new ResponseEntity<>(review,HttpStatus.OK);
		    	
		    }
		    
		   return null;
		    
		    
		}

	
	
}
