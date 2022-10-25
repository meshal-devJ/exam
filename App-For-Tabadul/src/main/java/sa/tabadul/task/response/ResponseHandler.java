package sa.tabadul.task.response;


import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseHandler <T> {
	
	
	private int status_code ;
	private T data ;
	public ResponseHandler(int status_code, T data) {
		super();
		this.status_code = status_code;
		this.data = data;
	}
	public ResponseHandler(String string, HttpStatus badRequest) {
		// TODO Auto-generated constructor stub
	}
	
	

}
