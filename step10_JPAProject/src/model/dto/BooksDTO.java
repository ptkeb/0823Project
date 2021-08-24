 package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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

@NamedQuery(query = "select b from BOOKS b where b.bookId=:bookId", name = "Books.findByBookId")
@NamedQuery(query = "select b from BOOKS b", name = "Books.findAllBooks")

@Entity(name = "BOOKS")
@SequenceGenerator(name="book_seq_gen", sequenceName="book_seq_id", initialValue=1, allocationSize=1)
public class BooksDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq_gen")
	@Column(name="bookid")
	private int bookId;
	
	@Column(name="bookname")
	private String bookName;
	
//	@ManyToOne
//	@JoinColumn(name = "mainCategoryId")
	@Column(name="categoryId")
	private int categoryId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDTO renterId;
}
