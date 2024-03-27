package MuleSoftDeveloper.com.Students_Mangement.Repository;

import MuleSoftDeveloper.com.Students_Mangement.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepo extends JpaRepository<Students,Long> {


}
