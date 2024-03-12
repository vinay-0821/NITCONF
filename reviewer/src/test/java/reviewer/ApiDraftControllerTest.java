package reviewer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.servlet.http.HttpServletRequest;
import reviewer.config.JwtService;
import reviewer.data.ReviewRepository;
import reviewer.model.Review;
import reviewer.rest.ApiDraftController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDraftControllerTest {

    @Autowired
    private ApiDraftController controller;

    @MockBean
    private ReviewRepository reviewRepo;

    @MockBean
    private JwtService jwtService;

    @Mock
    private HttpServletRequest request;

    @Test
    public void testDraftsSuccess() throws Exception {
        // Arrange
        String username = "test_user";
        String jwtToken = "eyJhbGciOiJIUzI1NiJ9..."; // Mock JWT with username
        ArrayList<Review> expectedDrafts = new ArrayList<>(); // Use ArrayList directly
        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
        Mockito.when(jwtService.extractUsername(jwtToken)).thenReturn(username);
        Mockito.when(reviewRepo.findAllByIdUserIdAndReviewStatus(username, "draft"))
                .thenReturn(expectedDrafts);

        // Act
        Iterable<Review> actualDrafts = controller.drafts();

        // Assert
        assertEquals(expectedDrafts, actualDrafts);
        verify(jwtService).extractUsername(jwtToken);
        verify(reviewRepo).findAllByIdUserIdAndReviewStatus(username, "draft");
    }

    @Test
    public void testDraftsEmpty() throws Exception {
        // Arrange
        String username = "test_user";
        String jwtToken = "eyJhbGciOiJIUzI1NiJ9..."; // Mock JWT with username
        List<Review> expectedDrafts = Collections.emptyList();
        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
        Mockito.when(jwtService.extractUsername(jwtToken)).thenReturn(username);
        Mockito.when(reviewRepo.findAllByIdUserIdAndReviewStatus(username, "draft"))
                .thenReturn((ArrayList<Review>) expectedDrafts);

        // Act
        Iterable<Review> actualDrafts = controller.drafts();

        // Assert
        assertEquals(expectedDrafts, actualDrafts);
        verify(jwtService).extractUsername(jwtToken);
        verify(reviewRepo).findAllByIdUserIdAndReviewStatus(username, "draft");
    }

    @Test
    public void testDraftsJwtServiceError() throws Exception {
        // Arrange
        String jwtToken = "invalid_token"; // Mock invalid JWT
        Mockito.when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
        Mockito.when(jwtService.extractUsername(jwtToken)).thenThrow(new RuntimeException("Mock JWT error"));

        // Act (exception expected)
        // You may want to change the expected exception type based on your actual implementation
        assertThrows(RuntimeException.class, () -> controller.drafts());
    }
}
