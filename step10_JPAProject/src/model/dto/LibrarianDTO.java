package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NamedQuery(query="select e from LibrarianDTO e where e.librarianId=:librarianId",name="LibrarianDTO.findByLibrarianId")
@NamedQuery(query="select e from LibrarianDTO e", name="LibrarianDTO.findAllByLibrarianId")
@Entity
@ToString
public class LibrarianDTO {
	
	@Id
	private int librarianId;
	
	private String librarianName;
	
	private String offDay;

	
	
	
}
