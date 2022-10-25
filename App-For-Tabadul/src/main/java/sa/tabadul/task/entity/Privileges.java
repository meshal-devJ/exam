package sa.tabadul.task.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "privileges")
@Setter
@Getter
@NoArgsConstructor
public class Privileges implements Serializable {

	
	private static final long serialVersionUID = 6618216826499759140L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name = "name")
	private String name ;
	
	
	@ManyToMany(mappedBy = "privileges")
    private List<User> users = new ArrayList<>();


	

}
