package reviewer.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import io.swagger.v3.oas.annotations.Operation;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;
import reviewer.util.ReviewForm;
import reviewer.util.ReviewKey;


@RestController
@RequestMapping(path="/api/review" , produces="application/json")
@SessionAttributes("user")
public class ApiReviewController {
	
	   @Autowired
	   private ReviewRepository reviewRepo;
	 
	 
	    @GetMapping
	    @Operation(
	    		tags= {"give review "},
	    		operationId = " ",
	    		summary = " search review",
	    		description = " find the asked review and show it "
	    	)
		public ResponseEntity<Review> getReview(@RequestParam(name = "action")String action ,@RequestParam("id") Long paperId,@RequestParam("username")String username)
		{
		  
		     Optional<Review> optReview = reviewRepo.findById(new ReviewKey(paperId,username));
		     
		     if(optReview.isPresent() == false)
		     {
		    	 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);   
		     }
		     
		     Review review = optReview.get();
		  
		    if(action.equals("view"))
		    {
			    System.out.println(review.toString());
				return new ResponseEntity<>(review,HttpStatus.OK);
		    }
		    
		    
		    if(action.equals("clear"))
		    {
		    	 review.modifyReview(new ReviewForm());
		    	 review.setReviewStatus("new");
		    	 reviewRepo.save(review);
		    	 return new ResponseEntity<>(review,HttpStatus.OK);	
		    }
		    
		   return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}

	    
	    @PostMapping
	    @Operation(
	    		tags= {"paper reviews"},
	    		operationId = " ",
	    		summary = " save review ",
	    		description = " saves the current progress in review "
	    	)
	    public ResponseEntity<Review> saveReview(@RequestParam(name = "action")String action ,@RequestParam("id") Long paperId,@RequestParam("username")String username, @RequestBody ReviewForm reviewForm )
	    {
             Optional<Review> optReview = reviewRepo.findById(new ReviewKey(paperId,username));
		     
		     if(optReview.isPresent() == false)
		     {
		    	 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);   
		     }
		     
		     Review review = optReview.get();
	 	   if(action.equals("update"))
	 	   {
	 		   review.modifyReview(reviewForm);
	 		   review.setReviewStatus("draft");
	 		   reviewRepo.save(review);
	 		   return new ResponseEntity<>(review,HttpStatus.OK);
	 	   }
	 	   
	 	   if(action.equals("save"))
	 	   {
	 		   
	 		   //TODO fill the actions
	 		   return new ResponseEntity<>(null,HttpStatus.OK);
	 	   }
	 	   
	 	   
	 	
	 	  return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	 	  
	    }
	
	
}
