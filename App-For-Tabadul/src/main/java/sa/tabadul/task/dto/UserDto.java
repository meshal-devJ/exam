package sa.tabadul.task.dto;

import java.util.List;


import lombok.Getter;
import lombok.Setter;
import sa.tabadul.task.entity.Comment;
import sa.tabadul.task.entity.Privileges;

@Getter
@Setter
public class UserDto {

	private String userName;

	private String mobileNumber;

	private String password;

	private String email;



}
