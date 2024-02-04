package reviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reviewer.data.PaperRepository;
import reviewer.model.Paper;


@Controller
@RequestMapping("/review")
public class ReviewController {
	
	
   @Autowired
   private PaperRepository paperRepo;
   
   
   @GetMapping
	public String review(@RequestParam("id") Long id,Model model)
	{
	    
	    Paper paper = paperRepo.findPaperById(id);
	    paper.toString();
	    model.addAttribute("paper", paper);
		return "review";
	}

	
}
