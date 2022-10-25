package sa.tabadul.task.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sa.tabadul.task.entity.User;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {

	private Long id;

	private String text;

	private Long userId;

	private Long articleId;

}
