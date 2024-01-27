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

@Entity
@Table(name="paper")
public class Paper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private List<String> tags;
	private LocalDateTime Deadline;
	
	@ManyToMany(mappedBy = "paper")
	private List<User> user = new ArrayList<>(); 
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public LocalDateTime getDeadline() {
		return Deadline;
	}
	public void setDeadline(LocalDateTime deadline) {
		Deadline = deadline;
	}
	
	

}
