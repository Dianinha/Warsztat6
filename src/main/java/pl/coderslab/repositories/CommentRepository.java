package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import pl.coderslab.entities.Comment;

@Component
public interface CommentRepository extends JpaRepository<Comment, Long>{

	
	@Query("select comment from Comment comment where id_tweet = ?1")
	List<Comment> findByTweetId(long id);
}
