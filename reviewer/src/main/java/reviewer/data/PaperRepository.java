package reviewer.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import reviewer.model.Paper;



@Repository
public interface PaperRepository extends JpaRepository<Paper,Long>{
	Paper findPaperById(Long Id);
}
 