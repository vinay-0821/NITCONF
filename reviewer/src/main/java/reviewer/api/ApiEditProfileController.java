package reviewer.api;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import reviewer.data.TagsRepository;
import reviewer.data.UserRepository;
import reviewer.model.Tags;
import reviewer.model.User;


@RestController
@RequestMapping(path="/api/edit-profile" , produces="application/json")
public class ApiEditProfileController {
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TagsRepository tagsRepo;
	
	
	@GetMapping("/all-tags")
	@Operation(
		tags= {"navigation and profile"},
		operationId = "id1",
		summary = " display tags",
		description = " shows all the tags that are present now "
	)
	public Iterable<Tags> getAllTags()
	{
		ArrayList<Tags> tags = tagsRepo.findAll();
		return tags;
	}
	
	@GetMapping
	@Operation(
			tags= {"navigation and profile"},
			operationId = " ",
			summary = "find user",
			description = " search user and display his/her details about bio,tags,contact,ect.."
	)
	public User getUser(@RequestParam("username")String username)
	{
		Optional<User> optUser = userRepo.findById(username);
		
		if(optUser.isPresent())
		{
			return userRepo.findById(username).get();	
		}
		
		return null;
		
	}
	
	

}
