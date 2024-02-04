package reviewer.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import reviewer.util.ReviewKey;


@Entity
public class Review {

	@EmbeddedId
	private ReviewKey id;
	
	
	
	//add attribute for review entity
	
	
	@ManyToOne 
	@MapsId("userId")
	@JoinColumn(name="user_id")
	User user;
	
	
	@ManyToOne 
	@MapsId("paperId")
	@JoinColumn(name="paper_id")
	Paper paper;
	
	
	
} 
