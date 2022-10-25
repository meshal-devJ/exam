package sa.tabadul.task.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
public class User implements Serializable {

	
	private static final long serialVersionUID = -2865149436290610020L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name = "user_name" , unique = true)
	private String userName ;
	
	@Column(name = "mobile_number")
	private String mobileNumber ;
	
	@Column(name = "password" , length = 255)
	private String password ;
	
	@Column(name = "email" , unique = true)
	private String email ;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "user_privilege", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "Privilege_id") }
    )
    List<Privileges> privileges = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Comment> comments ;

}
