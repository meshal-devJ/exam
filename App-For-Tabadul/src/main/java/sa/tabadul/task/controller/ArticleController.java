package sa.tabadul.task.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sa.tabadul.task.dto.ArticleDto;
import sa.tabadul.task.dto.CommentDto;
import sa.tabadul.task.entity.Article;
import sa.tabadul.task.response.ResponseHandler;
import sa.tabadul.task.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService ;
	
	
	@PostMapping
	public void addArticle(@RequestBody ArticleDto articleDto) {
		this.articleService.addArticle(articleDto);
	}
	
	
	@GetMapping("/{id}")
	public ResponseHandler<ArticleDto> getOne(@PathVariable Long id) {
		ResponseHandler<ArticleDto> articleDto =  this.articleService.getOne(id);   
		return articleDto ;
	}
	
	@GetMapping
	public List<ArticleDto> getAll(){
		return this.articleService.getAll();
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.articleService.delete(id);
	}
	
	
	@PostMapping("/{id}/comment")
	public void addComment(@RequestBody CommentDto commentDto) {
		this.articleService.addComment(commentDto);
	}
	

	@GetMapping("/{id}/comment")
	public ResponseHandler<List<CommentDto>>  getComments(@PathVariable Long id) {
		return this.articleService.getCommentByArticleId(id);
	}
	

	@PutMapping("/{id}/like")
	public void addLike(@PathVariable Long id) {
		this.articleService.addLike(id);
	}
	
	@PutMapping("/{id}/dislike")
	public void addDislike(@PathVariable Long id) {
		this.articleService.addDislike(id);
	}
	
	@PutMapping("/{id}/disable")
	public void setDisable(@PathVariable Long id) {
		this.articleService.addDisable(id);
	}
	
	@PutMapping("/{id}/enable")
	public void setEnable(@PathVariable Long id) {
		this.articleService.addEnable(id);
	}

}












