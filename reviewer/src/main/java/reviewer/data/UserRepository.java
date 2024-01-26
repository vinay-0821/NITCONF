package reviewer.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reviewer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	User findUserByUsername(String username);

}
