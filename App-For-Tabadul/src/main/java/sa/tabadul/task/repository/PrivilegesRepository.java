package sa.tabadul.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sa.tabadul.task.entity.Privileges;

@Repository
public interface PrivilegesRepository extends JpaRepository<Privileges, Long> {

}
