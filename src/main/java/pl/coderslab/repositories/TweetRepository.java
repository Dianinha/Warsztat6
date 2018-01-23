package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;

@Component
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	@Query("select tweet from Tweet tweet where id_user = ?1")
	List<Tweet> findByUserId(long id);

//	@Query("select tweet from Tweet tweet where title LIKE ?1% ORDER BY created DESC")
//	List<Tweet> findBeginingWith(String text);
	
}
