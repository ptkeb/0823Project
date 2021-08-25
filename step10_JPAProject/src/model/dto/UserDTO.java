package model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@NamedQuery(name = "user.findById", query = "select u from LIBUSER u where u.userId = :userId ")
@NamedQuery(name = "user.findAllById", query = "select u from LIBUSER u")
@SequenceGenerator(name="member_seq_gen", sequenceName="member_seq_id", initialValue=1, allocationSize=1)

@Entity(name = "LIBUSER")
public class UserDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq_gen")
	@Column(name="userid")
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="useraddress")
	private String userAddress;
	
	@OneToMany(mappedBy="userId") 
	private List<BooksDTO> books = new ArrayList<>();
	
	public String toString() {
		return "[사용자 번호] " + userId + "\n" +
			   "[사용자 이름] " + userName + "\n" +
			   "[사용자 주소] " + userAddress + "\n" +
			   "[대여중인 책] " + books + "\n";

	}
}
