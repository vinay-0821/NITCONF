package reviewer.model;


import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import reviewer.util.ReviewForm;
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
	private Calendar deadline;
	
	@Column
	private Calendar submissionTime;
	
	@Column
	private Calendar excuse;
	
	@Column
	private String comment;
	
	
	@Column(columnDefinition = "varchar(255) default 'accept'")
	private String reviewerStatus;
	
	
	// values = new , draft , submit
	@Column(columnDefinition = "varchar(255) default 'new'")
	private String reviewStatus;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	@JoinColumn(name="user_id")
	User user;
	
	@JsonIgnore
	@ManyToOne 
	@MapsId("paperId")
	@JoinColumn(name="paper_id")
	Paper paper;
	

	public Review(ReviewKey reviewKey) {
		this.id=reviewKey;
		// TODO Auto-generated constructor stub
	}

	public void modifyReview(ReviewForm review) {

 		this.originality = review.getOriginality();
 		this.technical = review.getTechnical();
 		this.significance = review.getSignificance();
 		this.originality  = review.getOriginality();
 		this.appropriate = review.getAppropriate();
 		this.organization = review.getOrganization();
 		this.style = review.getStyle();
 		this.refeersConfidence = review.getRefeersConfidence();
 		this.overall  = review.getOverall();
 		this.comment   = review.getComment();

 	}
	
	public void setReviewStatus(String reviewStatus) {
 		this.reviewStatus = reviewStatus;
 	}

	public void setReviewKey(ReviewKey reviewKey) {
		
		this.id = reviewKey;
		
	}

	public ReviewKey getId() {
		
		return this.id;
	}

	
	public void setSubmissionTime(Calendar submissionTime)
	{
		this.submissionTime = submissionTime;
	}
	
	
	

	
	
	
}
