package model.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedQuery(name = "user.findById", query = "select u from UserDTO u where u.userId = :userId ")
@NamedQuery(name = "user.findAllById", query = "select u from UserDTO u")
@SequenceGenerator(name="member_seq_gen", sequenceName="member_seq_id", initialValue=1, allocationSize=50)

public class UserDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq_gen")
	
	private int userId;
	
	private String userName;
	
	private String userAddress;
	
	@OneToMany(mappedBy="renterId")
	List<BooksDTO> books;
}
