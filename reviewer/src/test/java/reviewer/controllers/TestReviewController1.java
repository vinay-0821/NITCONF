//package reviewer.controllers;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import jakarta.servlet.http.HttpServletRequest;
//import reviewer.config.JwtService;
//import reviewer.data.ReviewRepository;
//import reviewer.model.Review;
//import reviewer.rest.ApiReviewController;
//import reviewer.util.ReviewForm;
//import reviewer.util.ReviewKey;
//
//class TestReviewController1 {
//
//	@MockBean
//    private HttpServletRequest request;
//
//    @MockBean
//    private JwtService jwtService;
//
//    @MockBean
//    private ReviewRepository reviewRepo;
//
//    @Autowired
//    private ApiReviewController controller;
//
//    // Helper method to create a mock Review object
//    private Review createMockReview(Long paperId, String username) {
//        Review review = new Review();
//        review.setReviewKey(new ReviewKey(paperId, username));
//        return review;
//    }
//
//    @Test
//    public void testGetReview_Success() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String username = "test_user";
//        String jwtToken = "eyJhbGciOiJIUzI1NiJ9..."; // Mock JWT with username
//        Review expectedReview = createMockReview(paperId, username);
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//        when(jwtService.extractUsername(jwtToken)).thenReturn(username);
//        when(reviewRepo.findById(new ReviewKey(paperId, username))).thenReturn(Optional.of(expectedReview));
//
//        // Act
//        ResponseEntity<Review> response = controller.getReview(paperId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(expectedReview, response.getBody());
//
//        verify(request).getHeader("Authorization");
//        verify(jwtService).extractUsername(jwtToken);
//        verify(reviewRepo).findById(new ReviewKey(paperId, username));
//    }
//
//    @Test
//    public void testGetReview_Unauthorized() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String jwtToken = "invalid_token"; // Mock invalid JWT
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//
//        // Act & Assert
//        assertThrows(Exception.class, () -> controller.getReview(paperId));
//
//        verify(request).getHeader("Authorization");
//        // Not calling jwtService.extractUsername or reviewRepo.findById since token is invalid
//    }
//
//    @Test
//    public void testUpdateReview_Success() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String username = "test_user";
//        String jwtToken = "eyJhbGciOiJIUzI1NiJ9..."; // Mock JWT with username
//        Review review = createMockReview(paperId, username);
//        ReviewForm reviewForm = new ReviewForm(); // Mock form data
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//        when(jwtService.extractUsername(jwtToken)).thenReturn(username);
//        when(reviewRepo.findById(new ReviewKey(paperId, username))).thenReturn(Optional.of(review));
//
//        // Act
//        ResponseEntity<Review> response = controller.updateReview(paperId, reviewForm);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        // TODO: Verify update logic on the review object based on reviewForm
//
//        verify(request).getHeader("Authorization");
//        verify(jwtService).extractUsername(jwtToken);
//        verify(reviewRepo).findById(new ReviewKey(paperId, username));
//        // TODO: Verify methods called on the mock review object to update its content
//    }
//    
//    @Test
//    public void testSaveReview_Success() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String username = "test_user";
//        String jwtToken = "eyJhbGciOiJIUzI1NiJ9..."; // Mock JWT with username
//        Review review = createMockReview(paperId, username);
//        ReviewForm reviewForm = new ReviewForm(); // Mock form data with filled content
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//        when(jwtService.extractUsername(jwtToken)).thenReturn(username);
//        when(reviewRepo.findById(new ReviewKey(paperId, username))).thenReturn(Optional.of(review));
//        // Mock saving the updated review
//        when(reviewRepo.save(any(Review.class))).thenReturn(review);
//
//        // Act
//        ResponseEntity<Review> response = controller.saveReview(paperId, reviewForm);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        // Verify the response body contains the updated review details based on reviewForm
//        // TODO: Assert specific fields in the response body are updated based on reviewForm
//
//        verify(request).getHeader("Authorization");
//        verify(jwtService).extractUsername(jwtToken);
//        verify(reviewRepo).findById(new ReviewKey(paperId, username));
//        // Verify the review object was saved with updated content
//        verify(reviewRepo).save(review);
//    }
//
//    @Test
//    public void testSaveReview_Unauthorized() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String jwtToken = "invalid_token"; // Mock invalid JWT
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//
//        // Act & Assert
//        assertThrows(Exception.class, () -> controller.saveReview(paperId, new ReviewForm()));
//
//        verify(request).getHeader("Authorization");
//        // Not calling jwtService.extractUsername or reviewRepo.findById since token is invalid
//    }
//
//    @Test
//    public void testClearReview_Success() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String username = "test_user";
//        String jwtToken = "eyJhbGciOiJIUzI1NiJ9..."; // Mock JWT with username
//        Review review = createMockReview(paperId, username);
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//        when(jwtService.extractUsername(jwtToken)).thenReturn(username);
//        when(reviewRepo.findById(new ReviewKey(paperId, username))).thenReturn(Optional.of(review));
//
//        // Act
//        ResponseEntity<Review> response = controller.clearReview(paperId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        // TODO: Verify the logic for clearing the review content (if applicable)
//
//        verify(request).getHeader("Authorization");
//        verify(jwtService).extractUsername(jwtToken);
//        verify(reviewRepo).findById(new ReviewKey(paperId, username));
//        // TODO: Verify methods called on the mock review object to clear its content (if applicable)
//    }
//
//    @Test
//    public void testClearReview_Unauthorized() throws Exception {
//        // Arrange
//        Long paperId = 1L;
//        String jwtToken = "invalid_token"; // Mock invalid JWT
//
//        when(request.getHeader("Authorization")).thenReturn("Bearer " + jwtToken);
//
//        // Act & Assert
//        assertThrows(Exception.class, () -> controller.clearReview(paperId));
//
//        verify(request).getHeader("Authorization");
//        // Not calling jwtService.extractUsername or reviewRepo.findById since token is invalid
//    }
//
//}