package reviewer.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


//@Data   data annotation is not creating getters and setters  
@Entity
@Table(name="tags")
public class Tags {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name="name")
	private String name;
	

	public Tags()
	{
		
	}
	
	public Tags(Long id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
