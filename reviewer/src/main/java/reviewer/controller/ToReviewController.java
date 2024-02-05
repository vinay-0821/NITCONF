package reviewer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.data.ReviewRepository;
import reviewer.model.Paper;
import reviewer.model.Review;
import reviewer.model.Tags;
import reviewer.model.User;

@Controller
@RequestMapping("/to-review")
@SessionAttributes(("user"))
public class ToReviewController {
	
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@ModelAttribute("paper")
	public Paper paper()
	{
		return new Paper();
	}
	
	@ModelAttribute("tag")
	public Tags tag()
	{
		return new Tags();
	}
	
	
	@ModelAttribute("review")
	public Review review()
	{
		return new Review();
	}
	
	
	
	
	@GetMapping
	public String toReview(@ModelAttribute User user , Model model)
	{
		
//		System.out.println(user.toString());
		
		ArrayList<Review> reviewList = new ArrayList<Review>();
		reviewList= reviewRepo.findAllByIdUserId(user.getUsername());
	
//		for(Review review : reviewList)
//		{
//			System.out.println(review.toString()); 
//			System.out.println(review.getPaper().getId()); 
//
//			
//		}
		
//		ArrayList<Review> draftList = new ArrayList<Review>();
//		draftList = reviewRepo.findAllByIdUserIdAndReviewStatus(user.getUsername(),"draft");
//		
//		
//		
//		for(Review review : draftList)
//		{
//			System.out.println(review.toString()); 
//			System.out.println(review.getPaper().getId()); 
//
//			
//		}
//		
		
		
		model.addAttribute("reviewList", reviewList);
		return "to-review";
	}
	
	

}
