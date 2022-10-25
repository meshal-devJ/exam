package sa.tabadul.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sa.tabadul.task.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	User findUserByEmail(String email);
	User findUserByuserName(String username);

}
