package p3.model.borrowing;

import p3.model.book.Book;
import p3.model.user.User;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="borrowing")
//@XmlType(name = "Borrowing")
public class Borrowing implements Serializable{
	
	@Id
	@GeneratedValue(generator = "gen_borrowing", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_borrowing", sequenceName = "seq_borrowing", allocationSize = 1)
	Integer id;
	
	@ManyToOne
    private User user;
	
   	@ManyToOne
    private Book book;
   	
    private Date issueDate;

    private Date returnDate;

    private String status;

    private String title;
    private String author;
    private String description;


    private boolean isExtended;

    public Borrowing() {
    }

	public Borrowing(User user,
					 Book book,
					 Date issueDate,
					 Date returnDate,
					 String status,
					 boolean isExtended) {
		super();
		this.user = user;
		this.book = book;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.status = status;
		this.isExtended = isExtended;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isExtended() {
		return isExtended;
	}

	public void setExtended(boolean isExtended) {
		this.isExtended = isExtended;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//   public String getTitle() {
//    	return book.getWorks().getTitle();
//   }
//
//   public String getAuthor() {
//    	return book.getWorks().getAuthor();
//   }
//
//   public String getDescription() {
//    	return book.getWorks().getDescription();
//   }
}
