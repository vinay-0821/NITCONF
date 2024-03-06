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
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.TagsRepository;
import reviewer.data.UserRepository;
import reviewer.model.Tags;
import reviewer.model.User;


@RestController
@RequestMapping(path="/api/edit-profile" , produces="application/json")
public class ApiEditProfileController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TagsRepository tagsRepo;
	
	
	@GetMapping("/all-tags")
	@Operation(
		    tags = {"Navigation and Profile"},
		    operationId = "displayTags",
		    summary = "Display tags",
		    description = "Show all tags currently available."
		)
	public Iterable<Tags> getAllTags()
	{
		ArrayList<Tags> tags = tagsRepo.findAll();
		return tags;
	}
	
	@GetMapping
	@Operation(
		    tags = {"Navigation and Profile"},
		    operationId = "findUser",
		    summary = "Find user",
		    description = "Search for a user and display their details including bio, tags, contact, etc.",
		    parameters = @Parameter(name="username" ,description = "The username of the user to retrieve details for." , example="jonny")
		)
	public User getUserDetails()
	{
		
		String authHeader = request.getHeader("Authorization");
	    
//	    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {     // no need of this as token will be verified before
//	      return null;
//	    }
	    
	   String jwt = authHeader.substring(7);  
	   String username = jwtService.extractUsername(jwt);
	   Optional<User> optUser = userRepo.findById(username);
		
		if(optUser.isPresent())
		{
			return userRepo.findById(username).get();	
		}
		
		return null;
		
	}
	
	

}
