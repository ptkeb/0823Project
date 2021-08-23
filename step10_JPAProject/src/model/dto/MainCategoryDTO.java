package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MainCategoryDTO {
	@Id
	private int mainCategoryId;
	private String mainCategoryName;
	private int librarianId;
}
