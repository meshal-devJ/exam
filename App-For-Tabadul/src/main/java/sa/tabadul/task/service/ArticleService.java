package sa.tabadul.task.service;


import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;

import sa.tabadul.task.dto.ArticleDto;
import sa.tabadul.task.dto.CommentDto;
import sa.tabadul.task.entity.Article;
import sa.tabadul.task.entity.Comment;
import sa.tabadul.task.repository.ArticleRepository;
import sa.tabadul.task.repository.CommentRepository;
import sa.tabadul.task.response.ResponseHandler;

import org.modelmapper.TypeToken;
@Service
public class ArticleService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CommentRepository commentRepository;

	public void addArticle(ArticleDto articleDto) {
		Article article = this.modelMapper.map(articleDto, Article.class);
		this.articleRepository.save(article);
	}

	public ResponseHandler<ArticleDto> getOne(Long id) {
		Article article = this.articleRepository.findById(id).orElseThrow();
		ArticleDto articleDto = this.modelMapper.map(article, ArticleDto.class);
		return new ResponseHandler<ArticleDto>(200 , articleDto);
	}
	
	public List<ArticleDto> getAll() {
		List<Article> result = this.articleRepository.findAllArticleNotDisabled();
		Type listType = new TypeToken<List<ArticleDto>>(){}.getType();
		List<ArticleDto> articleDtoList = this.modelMapper.map(result,listType);
		return articleDtoList ;
		
	}
	
	

	public void delete(Long id) {
		this.articleRepository.deleteById(id);
	}

	public void addComment(CommentDto commentDto) {
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		this.commentRepository.save(comment);
	}

	public ResponseHandler<List<CommentDto>> getCommentByArticleId(Long id) {
		List<Comment> comment = this.commentRepository.findAllByArticleId(id);
		Type listType = new TypeToken<List<CommentDto>>() {}.getType();
		List<CommentDto> commentDto = this.modelMapper.map(comment,listType);
		return new ResponseHandler<List<CommentDto>>(200 , commentDto);

	}

	public void addLike(Long id) {
		Article article = this.articleRepository.findById(id).orElseThrow();
		article.setLikes(article.getLikes() + 1);
		this.articleRepository.save(article);
	}

	public void addDislike(Long id) {
		Article article = this.articleRepository.findById(id).orElseThrow();
		article.setDislikes(article.getDislikes() + 1);
		this.articleRepository.save(article);
	}

	public void addDisable(Long id) {
		Article article = this.articleRepository.findById(id).orElseThrow();
		article.setDisabled(true);
		this.articleRepository.save(article);
	}

	public void addEnable(Long id) {
		Article article = this.articleRepository.findById(id).orElseThrow();
		article.setDisabled(false);
		this.articleRepository.save(article);
	}

}
