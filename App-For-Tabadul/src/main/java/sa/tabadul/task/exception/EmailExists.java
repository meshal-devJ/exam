package sa.tabadul.task.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailExists extends RuntimeException {
	
	
	private static final long serialVersionUID = 2098704265471135903L;
	
	private String massage ;
	
	
	public EmailExists() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
