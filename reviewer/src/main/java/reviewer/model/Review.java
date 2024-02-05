package reviewer.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import reviewer.util.ReviewForm;
import reviewer.util.ReviewKey;


@Entity
public class Review {

	@EmbeddedId
	private ReviewKey id;
	
	
	
	//add attribute for review entity
	
	@Column(nullable=true)
	private Integer originality;
	
	@Column(columnDefinition = "varchar(255) default 'accept'")
	private String reviewerStatus;
	
	@Column(columnDefinition = "varchar(255) default 'new'")
	private String reviewStatus;
	
	
	@ManyToOne 
	@MapsId("userId")
	@JoinColumn(name="user_id")
	User user;
	
	
	@ManyToOne 
	@MapsId("paperId")
	@JoinColumn(name="paper_id")
	Paper paper;


	public ReviewKey getId() {
		return id;
	}


	public void setId(ReviewKey id) {
		this.id = id;
	}


	public Integer getOriginality() {
		return originality;
	}


	public void setOriginality(Integer originality) {
		this.originality = originality;
	}


	public String getReviewerStatus() {
		return reviewerStatus;
	}


	public void setReviewerStatus(String reviewerStatus) {
		this.reviewerStatus = reviewerStatus;
	}


	public String getReviewStatus() {
		return reviewStatus;
	}


	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Paper getPaper() {
		return paper;
	}


	public void setPaper(Paper paper) {
		this.paper = paper;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", originality=" + originality + ", reviewerStatus=" + reviewerStatus
				+ ", reviewStatus=" + reviewStatus + ", user=" + user + ", paper=" + paper + "]";
	}

	
	public void modifyReview(ReviewForm reviewFrom)
	{
		 this.reviewStatus = "draft";
		 this.originality = reviewFrom.getOriginality();
	}


	
} 
