package reviewer.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import reviewer.util.ReviewKey;


@Entity
@Data
public class Review {

	@EmbeddedId
	private ReviewKey id;
	
	//add attribute for review entity
	
	
	@Column
	private Integer technical;
	
	@Column
	private Integer significance;
	
	@Column
	private Integer originality;
	
	@Column
	private Integer appropriate;
	
	@Column
	private Integer organization;
	
	@Column
	private Integer style;
	
	
	@Column
	private Integer refeersConfidence;
	
	@Column
	private Integer overall;
	
	
	@Column
	private String comment;
	
	
	@Column(columnDefinition = "varchar(255) default 'accept'")
	private String reviewerStatus;
	
	
	// values = new , draft , submit
	@Column(columnDefinition = "varchar(255) default 'new'")
	private String reviewStatus;
	
	@JsonIgnore
	@ManyToOne 
	@MapsId("userId")
	@JoinColumn(name="user_id")
	User user;
	
	@JsonIgnore
	@ManyToOne 
	@MapsId("paperId")
	@JoinColumn(name="paper_id")
	Paper paper;

	
	
	
}
