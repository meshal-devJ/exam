package sa.tabadul.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sa.tabadul.task.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	
	// @Query("select Comment WHERE article_id = ?")
	// @Query("select c from Comment c where c.article_id = :id LEFT JOIN Article ")
	public List<Comment> findAllByArticleId(Long article_id);

}
