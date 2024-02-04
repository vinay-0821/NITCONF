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
	
	@OneToMany(mappedBy= "paper")
	private List<Review> review;                        //change to set?
	
	

}
