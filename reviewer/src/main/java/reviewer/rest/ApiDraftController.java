package reviewer.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;
import reviewer.service.JwtExtractor;

@RestController
@RequestMapping(path="/api/get-drafts" , produces="application/json")
public class ApiDraftController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private JwtExtractor jwtExtractor;
	
	
	
	public String getUsernameFromToken()
	{
	    String authHeader = request.getHeader("Authorization");
		    
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {  
        	
          return null;
        }
	    System.out.println("authHeader " + authHeader);
	    String jwt = authHeader.substring(7);  
	    String username = jwtService.extractUsername(jwt);
	    System.out.println("username " + username);
	    return username;
	}

	
	@GetMapping
	@Operation(
		    tags = {"Drafts and Submissions"},
		    operationId = "",
		    summary = "Find drafts",
		    description = "Retrieve drafts associated with the provided username.",
		    parameters = @Parameter(name="username" ,description = "The username for which to retrieve drafts.",example="jonny")
		)
	public Iterable<Review> drafts() 
	{
	   
	    String username = jwtExtractor.getUsernameFromToken();
		ArrayList<Review> draftList = new ArrayList<Review>();
     	draftList = reviewRepo.findAllByIdUserIdAndReviewStatus(username,"draft");
		return draftList;
	}

}
