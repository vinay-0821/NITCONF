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

	
	public void modifyReview(ReviewForm reviewform) {
		 
		this.originality = reviewform.getOriginality();
		this.technical = reviewform.getTechnical();
		this.significance = reviewform.getSignificance();
		this.originality  = reviewform.getOriginality();
		this.appropriate = reviewform.getAppropriate();
		this.organization = reviewform.getOrganization();
		this.style = reviewform.getStyle();
		this.refeersConfidence = reviewform.getRefeersConfidence();
		this.overall  = reviewform.getOverall();
		this.comment   = reviewform.getComment();
		
	}

	public ReviewKey getId() {
		return id;
	}


	public void setId(ReviewKey id) {
		this.id = id;
	}


	public Integer getTechnical() {
		return technical;
	}


	public void setTechnical(Integer technical) {
		this.technical = technical;
	}


	public Integer getSignificance() {
		return significance;
	}


	public void setSignificance(Integer significance) {
		this.significance = significance;
	}


	public Integer getOriginality() {
		return originality;
	}


	public void setOriginality(Integer originality) {
		this.originality = originality;
	}


	public Integer getAppropriate() {
		return appropriate;
	}


	public void setAppropriate(Integer appropriate) {
		this.appropriate = appropriate;
	}


	public Integer getOrganization() {
		return organization;
	}


	public void setOrganization(Integer organization) {
		this.organization = organization;
	}


	public Integer getStyle() {
		return style;
	}


	public void setStyle(Integer style) {
		this.style = style;
	}


	public Integer getRefeersConfidence() {
		return refeersConfidence;
	}


	public void setRefeersConfidence(Integer refeersConfidence) {
		this.refeersConfidence = refeersConfidence;
	}


	public Integer getOverall() {
		return overall;
	}


	public void setOverall(Integer overall) {
		this.overall = overall;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
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
		return "Review [id=" + id + ", technical=" + technical + ", significance=" + significance + ", originality="
				+ originality + ", appropriate=" + appropriate + ", organization=" + organization + ", style=" + style
				+ ", refeersConfidence=" + refeersConfidence + ", Overall=" + overall + ", comment=" + comment
				+ ", reviewerStatus=" + reviewerStatus + ", reviewStatus=" + reviewStatus + ", user=" + user
				+ ", paper=" + paper + "]";
	}


	


	
}
