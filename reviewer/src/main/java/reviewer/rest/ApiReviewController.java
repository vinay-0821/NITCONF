package reviewer.rest;


import java.util.Calendar;
import java.util.Date;
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
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;
import reviewer.util.ReviewForm;
import reviewer.util.ReviewKey;


@RestController
@RequestMapping(path="/api/review" , produces="application/json")
public class ApiReviewController {
	
	
		@Autowired
		private HttpServletRequest request;
		
		@Autowired
		private JwtService jwtService;
	
		@Autowired
		private ReviewRepository reviewRepo;
		
		
		
		
		
		public String getUsernameFromToken()
		{
		    String authHeader = request.getHeader("Authorization");
			    
			//	    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {     // no need of this as token will be verified before
			//	      return null;
			//	    }
		    System.out.println("authHeader " + authHeader);
		    String jwt = authHeader.substring(7);  
		    String username = jwtService.extractUsername(jwt);
		    System.out.println("username " + username);
		    return username;
		}
		
	 
	 
	    @GetMapping("/get")
		public ResponseEntity<Review> getReview(@RequestParam("paperId") Long paperId)
		{
		     
	    	 String username = getUsernameFromToken();
	    	 
		     Optional<Review> optReview = reviewRepo.findById(new ReviewKey(paperId,username));
             System.out.println(optReview);
		     
		     if(optReview.isPresent() == false)
		     {
		    	 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);   
		     }
		     
		     Review review = optReview.get();
		     System.out.println(review.toString());
			 return new ResponseEntity<>(review,HttpStatus.OK);
		    
		}
	    
	    
	    @GetMapping("/clear")
		public ResponseEntity<Review> clearReview(@RequestParam("paperId") Long paperId)
		{
		     
	    	 String username = getUsernameFromToken();
	    	 
		     Optional<Review> optReview = reviewRepo.findById(new ReviewKey(paperId,username));
		     
		     if(optReview.isPresent() == false)
		     {
		    	 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);   
		     }
		     
		     Review review = optReview.get();
		     
	    	 review.modifyReview(new ReviewForm());
	    	 review.setReviewStatus("new");
		     reviewRepo.save(review);
		     return new ResponseEntity<>(review,HttpStatus.OK);	
		    
		    
	
		}

	    
	    
	    
	    @PostMapping("/save")
	    public ResponseEntity<Review> updateReview(@RequestParam("paperId") Long paperId,@RequestBody ReviewForm reviewForm )
	    {
	    	
	    	 String username = getUsernameFromToken();
             Optional<Review> optReview = reviewRepo.findById(new ReviewKey(paperId,username));
		     
		     if(optReview.isPresent() == false)
		     {
		    	 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);   
		     }
		     
		     Review review = optReview.get();
			 review.modifyReview(reviewForm);
			 review.setReviewStatus("draft");
	 	  
	 		 reviewRepo.save(review);
	 		 return new ResponseEntity<>(review,HttpStatus.OK);
	 	  
	    }
	    
	    @PostMapping("/submit")
	    public ResponseEntity<Review> saveReview(@RequestParam("paperId") Long paperId,@RequestBody ReviewForm reviewForm )
	    {
	    	
	    	 String username = getUsernameFromToken();
             Optional<Review> optReview = reviewRepo.findById(new ReviewKey(paperId,username));
		     
		     if(optReview.isPresent() == false)
		     {
		    	 return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);   
		     }
		     
		     //TODO fill the actions
		     // add submission date for submissions
		     //check for excuse date for submission
		        
		     Review review = optReview.get();
		     review.modifyReview(reviewForm);
		     review.setSubmissionTime(Calendar.getInstance());
		     review.setReviewStatus("submit");
		     
		     /*System.out.println(review.getSubmissionTime());
		     System.out.println(review.getSubmissionTime().get(Calendar.HOUR));
		     System.out.println(review.getSubmissionTime().get(Calendar.MINUTE));
		     System.out.println(review.getSubmissionTime().get(Calendar.SECOND));
		     System.out.println(review.getSubmissionTime().get(Calendar.YEAR));
			 Calendar deadline = Calendar.getInstance();
			 deadline.set(2024,03,18,12,0,0);
	         review.setDeadline(deadline);*/
		     reviewRepo.save(review);
			
	 	   
	 		   
	 		 return new ResponseEntity<>(review,HttpStatus.OK);
	    }
	
}
