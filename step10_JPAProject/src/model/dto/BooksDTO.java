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

@NamedQuery(query = "select b from BOOKS b where b.bookId=:bookId", name = "BOOKS.findByBookId")
@NamedQuery(query = "select b from BOOKS b", name = "BOOKS.findAllBooks")

@Entity(name = "BOOKS")
@SequenceGenerator(name="book_seq_gen", sequenceName="book_seq_id", initialValue=100, allocationSize=1)
public class BooksDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_seq_gen")
	@Column(name="bookid")
	private int bookId;
	
	@Column(name="bookname")
	private String bookName;
	
	@Column(name="categoryId")
	private String categoryId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserDTO renterId;

	@Override
	public String toString() {
		return "BooksDTO [bookId=" + bookId + ", bookName=" 
				+ bookName + ", categoryId=" + categoryId + " 대여자 : " + renterId.getUserId() + "]";
	}
}