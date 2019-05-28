package p3.model.work;

import p3.model.book.Book;
import p3.model.library.Library;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="work")
//@XmlType(name = "Work")
public class Work implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "gen_work", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "gen_work", sequenceName = "seq_work", allocationSize = 1)
    Integer id;

    private String title;

    private String author;

    private Date publicationDate;

    private String description;

    private Boolean available;
//    @XmlTransient
    @OneToMany(fetch = FetchType.EAGER)
    private List<Book> books;


    public Work(Integer id,
                String title,
                String author,
                Date publicationDate,
                String description,
                Library library,
                List<Book> books) {
        super();

        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate  = publicationDate;
        this.description = description;
        this.books = books;
    }

    public Work() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Boolean empruntable() {
        Boolean dispo = false;

        for(Book b : getBooks()) {
            if(b.isAvailable()) {
                dispo = true;
                break;
            }
        }

        return dispo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
