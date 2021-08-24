package model.dto;

import java.util.List;

import javax.persistence.Column;
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

@Entity(name = "libuser")
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
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_addres")
	private String userAddress;
	
	@OneToMany(mappedBy="renterId")
	List<BooksDTO> books;
}
