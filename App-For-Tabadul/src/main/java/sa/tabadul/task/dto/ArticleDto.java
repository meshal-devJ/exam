package sa.tabadul.task.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArticleDto {
	

	private String title ;
	
	private String body ;
	
	private Long author ;
	
	private byte[] image;
	
	private Long likes ;
	
	private Long dislikes ;
	
	private boolean isDisabled ;

}
