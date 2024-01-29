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

import reviewer.data.PaperRepository;
import reviewer.model.Paper;
import reviewer.model.Tags;
import reviewer.model.User;

@Controller
@RequestMapping("/to-review")
@SessionAttributes(("user"))
public class ToReviewController {
	
	
	@Autowired
	PaperRepository paperRepository;
	
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
	
	
	@GetMapping
	public String toReview(@ModelAttribute User user , Model model)
	{
		
		System.out.println(user.toString());
		 //TODO check status for the papers while adding in list
		
		ArrayList<Paper> papers = new ArrayList<Paper>();
		for(Paper paper : user.getPaper())
		{
			papers.add(paperRepository.findPaperById(paper.getId()));
		}
		model.addAttribute("papers", papers);
		return "to-review";
	}
	
	

}
