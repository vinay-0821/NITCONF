package reviewer.util;

import reviewer.model.Review;

public class ReviewForm {
	
	private Integer technical;
	private Integer significance;
	private Integer originality;
	private Integer appropriate;
	private Integer organization;
	private Integer style;
	private Integer refeersConfidence;
	private Integer overall;
	private String comment;
	
	
	public ReviewForm()
	{
		
	}

	public ReviewForm(Review review) {
		 
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

	@Override
	public String toString() {
		return "ReviewForm [technical=" + technical + ", significance=" + significance + ", originality=" + originality
				+ ", appropriate=" + appropriate + ", organization=" + organization + ", style=" + style
				+ ", refeersConfidence=" + refeersConfidence + ", Overall=" + overall + ", comment=" + comment + "]";
	}

	

}

