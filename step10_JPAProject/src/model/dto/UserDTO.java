package model.dto;

import java.util.ArrayList;
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

@Entity(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@NamedQuery(name = "user.findById", query = "select u from USER u where u.userId = :userId ")
@NamedQuery(name = "user.findAllById", query = "select u from USER u")
@SequenceGenerator(name="member_seq_gen", sequenceName="member_seq_id", initialValue=1, allocationSize=50)

public class UserDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq_gen")
	@Column(name="userId")
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="useraddres")
	private String userAddress;
	
	@OneToMany(mappedBy="renterId")
	private List<BooksDTO> books = new ArrayList<>();
}
