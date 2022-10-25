package sa.tabadul.task.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  
@Component 
public class Logging {
	
	
	// Print Befor Call Controller -> Use Log4J For Logging
	@Before(value = "execution(* sa.tabadul.task.controller.*.*(..))")  
	public void printLogBeforeController() {
		System.out.println("\n\n\n" + "Done" + "\n\n\n");
	}

}
