package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import pl.coderslab.entities.User;

@Controller
public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByUsernameAndPassword(String username, String password);
	
	User findOneByUsername(String username);
	
}
