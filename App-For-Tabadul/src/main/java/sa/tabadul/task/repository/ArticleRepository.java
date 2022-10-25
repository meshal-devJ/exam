package sa.tabadul.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import sa.tabadul.task.entity.Article;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
	
	public byte[] findImageById(Long id);
	
	@Query("select a from Article a where a.disabled <> 0")
	public List<Article> findAllArticleNotDisabled();

}
