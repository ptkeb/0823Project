package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LibrarianDTO {
	@Id
	private int librarianId;
	private String librarianName;
	private String offDay;
}
