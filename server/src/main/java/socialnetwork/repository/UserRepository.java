package socialnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import socialnetwork.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	

	User findByUsernameAndPassword(String userName, String password);

}
