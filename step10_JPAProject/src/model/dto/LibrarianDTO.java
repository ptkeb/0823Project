package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NamedQuery(query="select e from LIBRARIAN e where e.librarianId=:librarianId",name="LIBRARIAN.findByLibrarianId")
@NamedQuery(query="select e from LIBRARIAN e", name="LIBRARIAN.findAllByLibrarianId")
@ToString
@Entity(name = "LIBRARIAN")
public class LibrarianDTO {
	
	@Id
	@Column(name = "librarianId")
	private int librarianId;
	
	private String librarianName;
	
	private String offDay;
}
