package model.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BooksDTO {
	@Id
	private int bookId;
	private String bookName;
	private int renterId;
	private int categoryId;
	
}
