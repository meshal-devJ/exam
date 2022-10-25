package sa.tabadul.task.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Exception {
	
	
	@ExceptionHandler({EmailExists.class})
	@ResponseBody
	public ResponseEntity<Object> handleEmailExists(EmailExists ex){
		 return new ResponseEntity<Object>("Email Exists", HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler({UserExists.class})
	@ResponseBody
	public ResponseEntity<Object> handleUserExists(UserExists ex){
		 return new ResponseEntity<Object>("UserName Exists", HttpStatus.BAD_REQUEST);	
	}
	
	

}
