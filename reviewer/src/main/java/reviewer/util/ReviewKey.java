package reviewer.util;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class ReviewKey implements Serializable{

	

	@Column(name="user_id")
	private String userId;
	
	@Column(name="paper_id")
	private Long paperId;
	
    public ReviewKey(){
		
	}

	public ReviewKey(Long paperId, String userId) {
		
		this.paperId = paperId;
		this.userId = userId;
		
	}

	public String getUserId() {
		return userId;
	}

	public Long getPaperId() {
		return paperId;
	}
	
	
	
	

}
