package reviewer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="paper")
public class Paper {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String pdfLink;
	
	private LocalDateTime deadline;
	
	@ManyToMany()
    private List<Tags> tags = new ArrayList<>();
	
	@ManyToMany(mappedBy = "paper")
	private List<User> user = new ArrayList<>();
	
	@OneToMany()
	private List<Review> review = new ArrayList<>();
	
	public Paper()
	{
		
	}
	
	public Paper(Long id, String name, String pdfLink, LocalDateTime deadline, List<Tags> tags, List<User> user,
			List<Review> review) {
		super();
		this.id = id;
		this.name = name;
		this.pdfLink = pdfLink;
		this.deadline = deadline;
		this.tags = tags;
		this.user = user;
		this.review = review;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPdfLink() {
		return pdfLink;
	}

	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	
	

}
