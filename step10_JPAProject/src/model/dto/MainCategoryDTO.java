package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "MainCategory")
@NamedQuery(name = "category.findById", query = "select c from MainCategory c where c.mainCategoryId = :mainCategoryId ")
@NamedQuery(name = "category.findAllById", query = "select c from MainCategory c")
public class MainCategoryDTO {
	@Id
	private String mainCategoryId;
	
	private String mainCategoryName;
	
	private int librarianId;
	
	public String toString() {
		return "[대분류 번호] " + mainCategoryId + "\n" +
			   "[대분류 이름] " + mainCategoryName + "\n" +
			   "[담당 사서] " + librarianId + "\n";

	}
}
