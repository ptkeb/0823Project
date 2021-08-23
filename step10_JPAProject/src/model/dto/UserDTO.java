package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDTO {
	@Id
	private int userId;
	private String userName;
	private String userAddress;
}
