package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
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

@Entity
@NamedQuery(name = "category.findById", query = "select c from MainCategoryDTO c where c.mainCategoryId = :mainCategoryId ")
@NamedQuery(name = "category.findAllById", query = "select c from MainCategoryDTO c")
public class MainCategoryDTO {
	@Id
	@OneToMany
	private int mainCategoryId;
	
	private String mainCategoryName;
	
	@OneToOne
	private int librarianId;
}
