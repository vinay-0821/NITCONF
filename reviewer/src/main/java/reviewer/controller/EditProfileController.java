package reviewer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import reviewer.data.TagsRepository;
import reviewer.data.UserRepository;
import reviewer.model.SelectedTags;
import reviewer.model.Tags;
import reviewer.model.User;

@Controller
@RequestMapping("/edit-profile")
@SessionAttributes("user")
public class EditProfileController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TagsRepository tagsRepository;
	
	@ModelAttribute("tag")
	public Tags tag()
	{
		return new Tags();
	}
	
	@ModelAttribute("selectedTags")
	public SelectedTags selected()
	{
		return new SelectedTags();
	}
	
	@GetMapping
	public String editProfile(Model model)
	{    
	    ArrayList<Tags> tags = tagsRepository.findAll();
	    System.out.println(tags.toString());
		model.addAttribute("tags", tags);
		return "edit-profile";
	}
	
	@PostMapping
	public String editProfileform(@ModelAttribute("user") User user,@ModelAttribute("selectedTags") SelectedTags selectedTags)
	{
		System.out.println("postman");
		System.out.println(selectedTags.toString());
		user.removeTags();
		for(String str : selectedTags.getSelectedTags())
		{
			  user.addToTags(tagsRepository.findByName(str));
		}
		System.out.println(user.toString());
		userRepository.save(user);
		System.out.println("it should be added to database");
		//update database
		return "profile";
	}

}
