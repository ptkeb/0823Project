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
@ToString

@Entity(name = "MainCategory")
@NamedQuery(name = "category.findById", query = "select c from MainCategory c where c.mainCategoryId = :mainCategoryId ")
@NamedQuery(name = "category.findAllById", query = "select c from MainCategory c")
public class MainCategoryDTO {
	@Id
//	@OneToMany
	private String mainCategoryId;
	
	private String mainCategoryName;
	
//	@OneToOne
//	@JoinColumn(name = "librarianId")
	private int librarianId;
}
