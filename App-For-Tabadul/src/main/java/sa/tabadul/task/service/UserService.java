package sa.tabadul.task.service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import sa.tabadul.task.dto.UserDto;
import sa.tabadul.task.entity.Privileges;
import sa.tabadul.task.entity.User;
import sa.tabadul.task.exception.EmailExists;
import sa.tabadul.task.exception.UserExists;
import sa.tabadul.task.repository.UserRepository;
import sa.tabadul.task.response.ResponseHandler;

@Service
public class UserService  {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepository;

	
	
	
	public ResponseHandler<UserDto> addUser(UserDto userDto) {

		String email = userDto.getEmail();
		String userName = userDto.getUserName();
		User userEmailCheck = this.userRepository.findUserByEmail(email);
		User userNameCkeck = this.userRepository.findUserByuserName(userName);
		if (userEmailCheck != null && userEmailCheck.getEmail().equalsIgnoreCase(email)) {
			throw new EmailExists();
		}
		if (userNameCkeck != null && userNameCkeck.getUserName().equalsIgnoreCase(userName)) {
			throw new UserExists();
		}
		
		User userEntity = this.mapper.map(userDto, User.class);
	
		Privileges privileges = new Privileges();
		privileges.setName("ROLE_USER");
		List<Privileges> list = Arrays.asList(privileges);
		userEntity.setPrivileges(list);
        userRepository.save(userEntity);

        return new ResponseHandler<UserDto>(200, userDto);


	}
    

}
