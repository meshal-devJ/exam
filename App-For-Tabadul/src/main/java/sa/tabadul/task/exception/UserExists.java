package sa.tabadul.task.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserExists  extends RuntimeException {
	
	
	private static final long serialVersionUID = -9114340314083021594L;
	private String massage ;
	
	
	public UserExists() {
		// TODO Auto-generated constructor stub
	}
	
}
