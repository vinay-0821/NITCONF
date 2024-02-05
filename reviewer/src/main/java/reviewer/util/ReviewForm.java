package reviewer.util;

import reviewer.model.Review;

public class ReviewForm {
	
	
	private Integer originality;
	
	
	public ReviewForm()
	{
		
	}

	public ReviewForm(Review review) {
		 
		this.originality = review.getOriginality();
		
	}

	public int getOriginality() {
		return originality;
	}

	public void setOriginality(int originality) {
		this.originality = originality;
	}

	@Override
	public String toString() {
		return "ReviewForm [originality=" + originality + "]";
	}

}