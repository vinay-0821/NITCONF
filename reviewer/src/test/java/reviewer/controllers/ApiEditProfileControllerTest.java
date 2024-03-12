package reviewer.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import io.jsonwebtoken.lang.Assert;
import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.TagsRepository;
import reviewer.data.UserRepository;
import reviewer.model.Review;
import reviewer.model.Tags;
import reviewer.model.User;
import reviewer.rest.ApiEditProfileController;

@SpringBootTest
public class ApiEditProfileControllerTest {

    @Autowired
    private ApiEditProfileController controller;

    @MockBean
    private TagsRepository tagsRepository;

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
        // Mock data
        String username = null;
        String password = null;
		String name = null;
		String contactno = null;
		String bio = null;
		List<Tags> tags = null;
		List<Review> review = null;
		User mockUser = new User(username, password, name, contactno, bio, tags, review);

        // Mock dependencies
//        when(JwtService.extractUsername(Mockito.anyString())).thenReturn(username);
		JwtService jwtServiceMock = Mockito.mock(JwtService.class);
		Mockito.when(jwtServiceMock.extractUsername(Mockito.anyString())).thenReturn(username);

//        CrudRepository<Tags, Long> userRepositoryMock;
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
		//        when(UserRepository.findById(username)).thenReturn(Optional.of(mockUser));
        Mockito.when(userRepositoryMock.findById(username)).thenReturn(Optional.of(mockUser));


        // Simulate request with valid token (replace with actual token generation logic)
        String mockToken = "your_valid_token";
        HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockRequest.getHeader("Authorization")).thenReturn("Bearer " + mockToken);

        // Perform the test
        User returnedUser = controller.getUserDetails();

        // Assert the results
        Assert.notNull(returnedUser);
//        String s=returnedUser.getUsername();
//        
//        char[] ch = new char[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            ch[i] = s.charAt(i);
//        }
//        
//        char[] ch1 = new char[username.length()];
//        for (int i = 0; i < username.length(); i++) {
//            ch1[i] = username.charAt(i);
//        }
        
        assertEquals(username, returnedUser.getUsername());
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
