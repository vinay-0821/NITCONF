package reviewer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.data.PaperRepository;
import reviewer.data.ReviewRepository;
import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.util.ReviewForm;
import reviewer.util.ReviewKey;


@Controller
@RequestMapping("/review")
@SessionAttributes("user")
public class ReviewController {
	
	
   @Autowired
   private ReviewRepository reviewRepo;
   

   
   
   @GetMapping
	public String getReview(@RequestParam("id") Long paperId,Model model,@ModelAttribute User user)
	{
	    
	    Review review = reviewRepo.findById(new ReviewKey(paperId,user.getUsername())).get();
	    model.addAttribute("review",review);
	    model.addAttribute("reviewForm",new ReviewForm(review));
	    System.out.println(review.toString());
	    
		return "review";
	}
   
   
   @PostMapping
   public String saveReview(@RequestParam("id") Long paperId,@ModelAttribute("reviewForm") ReviewForm reviewForm ,@ModelAttribute("user") User user)
   {
	   System.out.println(paperId);
	   System.out.println(reviewForm.toString());
	   Review review = reviewRepo.findById(new ReviewKey(paperId,user.getUsername())).get();
	   review.modifyReview(reviewForm);
	   System.out.println(review.toString());
	   reviewRepo.save(review);
	   return "redirect:/drafts";
   }

	
}
