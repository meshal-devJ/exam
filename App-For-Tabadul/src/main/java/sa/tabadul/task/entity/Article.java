package sa.tabadul.task.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.tabadul.task.audit.Auditing;


@Entity
@Table(name = "article")
@Setter
@Getter
@NoArgsConstructor
public class Article extends Auditing<Date> implements Serializable {

	
	private static final long serialVersionUID = -6764835943764703883L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name ="title")
	@Length(max = 100)
	private String title ;
	
	@Column(name = "body")
	@Length(max = 500)
	private String body ;
	
	@Column(name = "author")
	private Long author ;
	
	@Column(name = "image")
	private byte[] image;
	
	@Column(name ="likes")
	private int likes ;
	
	@Column(name = "dislikes")
	private int dislikes ;
	
	@Column(name = "disabled")
	private boolean disabled ;
	
	
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Comment> comments ;
	
	

}







