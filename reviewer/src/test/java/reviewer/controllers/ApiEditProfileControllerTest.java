package reviewer.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import io.jsonwebtoken.lang.Assert;
import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.ReviewRepository;
import reviewer.data.TagsRepository;
import reviewer.data.UserRepository;
import reviewer.model.Review;
import reviewer.model.Tags;
import reviewer.model.User;
import reviewer.rest.ApiEditProfileController;
import reviewer.rest.ApiReviewController;
import reviewer.service.JwtExtractor;

@SpringBootTest
public class ApiEditProfileControllerTest {

    @Autowired
    private ApiEditProfileController controller;

    @MockBean
    private TagsRepository tagsRepository;
    
    @Mock
	private JwtService jwtService;

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private UserRepository userRepo;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@Mock 
	private JwtExtractor jwtExtractor;
	
	@InjectMocks
	private ApiReviewController apiReviewController;
	
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllTagsTest() throws Exception {
        // Mock data
        List<Tags> mockTags = new ArrayList<>();
        Long id1 = null;
		mockTags.add(new Tags(id1, "tag1"));
        mockTags.add(new Tags(id1, "tag2"));

        // Mock repository behavior
        Mockito.when(tagsRepository.findAll()).thenReturn((ArrayList<Tags>) mockTags);

        // Perform the test
        Iterable<Tags> returnedTags = controller.getAllTags();

        // Assert the results
//        Assertions.assertThat(returnedTags)
//        .as("Returned tags")
//        .containsExactlyElementsOf(mockTags);
        assertEquals(mockTags, returnedTags);
    }
    
    @Test
    public void getUserDetailsTest_validToken() throws Exception {
     
        
		

    }
    
    @Test
    public void getUserDetailsTest_invalidToken() throws Exception {
    	
//        CrudRepository<Tags, Long> userRepositoryMock;
		// Mock dependencies (no need to mock username extraction since it's not called)
//        Mockito.when(UserRepository.findById(anyString())).thenReturn(Optional.empty());
//    	Mockito.when(userRepositoryMock.findById(anyString())).thenReturn(Optional.empty());
    	
    	UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);

    	Mockito.when(userRepositoryMock.findById(anyString())).thenReturn(Optional.empty());



        // Simulate request with invalid token (replace with actual token generation logic)
        String mockToken = "invalid_token";
        HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockRequest.getHeader("Authorization")).thenReturn("Bearer " + mockToken);

        // Perform the test
        User returnedUser = controller.getUserDetails();

        // Assert the results
        Assert.notNull(returnedUser);
    }


}
