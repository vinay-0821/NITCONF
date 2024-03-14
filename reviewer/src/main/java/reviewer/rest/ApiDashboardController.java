package reviewer.rest;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ApiDashboardController {
	
	
	 private String url = "http://localhost:8080/api/dashboard";
	
//	 @GetMapping("/api/dashboard")
//	    public ResponseEntity<ModelAndView> welcome() {
//	        ModelAndView modelAndView = new ModelAndView();
//	        modelAndView.setViewName("dashboard.html");
//	        return new ResponseEntity<>(modelAndView,HttpStatus.MOVED_PERMANENTLY);
//	    }
	 
	 @GetMapping("/api/redirect")
	  public ModelAndView redirect()
	  {
		  RedirectView rv = new RedirectView();
		  rv.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		  rv.setUrl("http://google.com");
		  ModelAndView mv = new ModelAndView(rv);
		  return mv;
	  }
	 
//	   @GetMapping("/api/foo")
//	   void handleFoo(HttpServletResponse response) throws IOException {
//	     response.sendRedirect("http://localhost:8080/api/dashboard");
//	   }
	   
	    @GetMapping("/api/foo")
	    public ResponseEntity<HttpHeaders> handleFoo() {
	    	
	    	System.out.println("foo");
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setLocation(URI.create(url));
	    	return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	        //return new RedirectView("http://google.com");
	    }

	 

}
