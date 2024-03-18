package reviewer.controllers;



import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.ReviewRepository;
import reviewer.data.UserRepository;
import reviewer.model.Review;
import reviewer.model.User;
import reviewer.rest.ApiReviewController;
import reviewer.util.ReviewKey;


//@RunWith(MockitoJunitRunner.class)
public class TestReviewController {

	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    
    private String mockJwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0YXJ1biIsImlhdCI6MTcxMDIyMzAwMywiZXhwIjoxNzEwMjI0NDQzfQ.RyM3fOZr6AHKlL3hwhp6lgJKwS7uDk8rqJ8CujAsNws";
	
	
	@Mock
	private JwtService jwtService;

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private UserRepository userRepo;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@InjectMocks
	private ApiReviewController apiReviewController;
	
	@BeforeEach
	public void setUp() {
		
	    MockitoAnnotations.openMocks(this);
	    this.mockMvc = MockMvcBuilders.standaloneSetup(apiReviewController).build();
	    
	}
	

	@Test 
	public void testGetUsernameFromToken() {
		
       User user = new User();
       user.setUsername("tarun");
       when(userRepo.findUserByUsername("tarun")).thenReturn(user);

		when(jwtService.generateToken(user)).thenReturn(mockJwtToken);
		when(jwtService.extractUsername(mockJwtToken)).thenReturn("tarun");
		
		String jwtToken = jwtService.generateToken(user);  
		String username = jwtService.extractUsername(jwtToken); 
		
		//System.out.println(jwtToken + " " + username); 
		Assertions.assertEquals(username, user.getUsername());
	    
	     
	     
	}
	
	
    @Test
	public void testGetReview()
	{
		Long paperId = 1L;
		String username = "taurn";
		Review review = new Review();

		when(request.getHeader("Authorization")).thenReturn("Bearer " + mockJwtToken);
		when(reviewRepo.findById(new ReviewKey(paperId,username))).thenReturn(Optional.of(review));
		when(apiReviewController.getUsernameFromToken()).thenReturn("tarun");
		
		ResponseEntity<Review> responseEntity =  apiReviewController.getReview(paperId);
		System.out.println(responseEntity);
		
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		
		
	}
}
