package sa.tabadul.task.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sa.tabadul.task.audit.Auditing;


@Entity
@Table(name = "comment")
@Setter
@Getter
@NoArgsConstructor
public class Comment extends Auditing<Date> implements Serializable {

	
	private static final long serialVersionUID = 6228105416800313817L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id ;
	
	@Column(name = "text")
	private String text ;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user ;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article ; 

}
