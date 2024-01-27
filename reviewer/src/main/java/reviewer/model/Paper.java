package reviewer.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="paper")
public class Paper {
	
	@Id
	private Long Id;
	private List<String> tags;
	private LocalDateTime Deadline;
	
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
