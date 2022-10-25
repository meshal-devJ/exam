package sa.tabadul.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sa.tabadul.task.dto.UserDto;
import sa.tabadul.task.response.ResponseHandler;
import sa.tabadul.task.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService ;
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<UserDto> getOne(@PathVariable Long id) {
		return null ;
	}
	
	
	@PostMapping
	public ResponseHandler<UserDto> addUser(@RequestBody UserDto userDto) {
		return this.userService.addUser(userDto);
	}
	
	@GetMapping("/login")
	public void login() {
		
	}

}
