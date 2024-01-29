package reviewer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor       //why we actually need them
@Table(name="user")
public class User implements UserDetails{
	

	private static final long serialVersionUID = 1L;  //what it actually means ?
	
	@Id
	private String username;
	private String password;
	private String name;
	private String contactno;
	private String bio;
	
	@ManyToMany()
    private List<Tags> tags = new ArrayList<>();
	
	@ManyToMany()
	private List<Paper> paper = new ArrayList<>();
	
	@OneToMany()
	private List<Review> review = new ArrayList<>();
	
	
	public User()
	{
		
	}
	
	public User(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, String name, String contactno, String bio, List<Tags> tags,List<Paper> paper) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.contactno = contactno;
		this.bio = bio;
		this.tags = tags;
		this.paper = paper;
	}
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", contactno=" + contactno
				+ ", bio=" + bio + ", tags=" + tags + ", paper=" + paper + "]";
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {     
		// what should we return here
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getPassword() {
		
		return password;
	}
	
	@Override
	public String getUsername() {
		
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public void addToTags(Tags tag)
	{
		
		//need to modify delete previous list
		tags.add(tag);
		return;
	}
	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public List<Paper> getPaper() {
		return paper;
	}

	public void setPaper(List<Paper> paper) {
		this.paper = paper;
	}

	public void removeTags() {
		
		tags.clear();
		// TODO Auto-generated method stub
		
	}

	

	


}
