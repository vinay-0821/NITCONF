package reviewer.Controllers;



import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.UserRepository;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.rest.ApiReviewController;

public class TestReviewController {

	@Mock
	private JwtService jwtService;

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private UserRepository userRepo;
	
	@InjectMocks
	private ApiReviewController apiReviewController;
	
	@BeforeEach
	public void setUp() {
		
	   
	    MockitoAnnotations.openMocks(this);
	    
	}
	

	@Test 
	public void testGetUsernameFromToken() {
	    // Define behavior for UserRepository mock
	    User user = new User();
	    user.setUsername("tarun");// Mock user creation or use a real user object
	    when(userRepo.findUserByUsername("tarun")).thenReturn(user);
	    

	    // Define behavior for JwtService mock
	    String mockJwtToken = ""; // Define a mock JWT token
	    when(jwtService.generateToken(user)).thenReturn(mockJwtToken);
	    when(jwtService.extractUsername(mockJwtToken)).thenReturn("tarun");

   

	     String jwtToken = jwtService.generateToken(user);
	     String username = jwtService.extractUsername(jwtToken);
	     System.out.println(jwtToken + " " + username);
	     Assertions.assertEquals(username, user.getUsername());
	    
	}
	
	
	@Test
	public void testGetReview()
	{
		Long paperId = 1L;
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		String jwtToken = jwtService.generateToken(userRepo.findUserByUsername("tarun")); 
		mockRequest.addHeader("Authorization", "Bearer " + jwtToken);
		mockRequest.addHeader("Custom-Header", "value");
		
		// Add request parameter
		mockRequest.setParameter("id", "1");
		
		    
		// Assign the MockHttpServletRequest to your private variable
		request = mockRequest;
		String authHeader = request.getHeader("Authorization");
		System.out.println(authHeader);
		System.out.println(jwtToken);
		
		ResponseEntity<Review> responseEntity =  apiReviewController.getReview(paperId);
		
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		
		
	}
}
