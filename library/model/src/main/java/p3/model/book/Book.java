package p3.model.book;

import p3.model.work.Work;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "book")
//@XmlType(name = "Book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(generator = "gen_book", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "gen_book", sequenceName = "seq_book", allocationSize = 1)
    Integer id;

    private String referenceCode;

    private boolean isAvailable;



    public Book(String referenceCode, boolean isAvailable) {
        this.referenceCode = referenceCode;
        this.isAvailable = isAvailable;
    }

//    public Book(String referenceCode, boolean isAvailable, Work works) {
//        this.referenceCode = referenceCode;
//        this.isAvailable = isAvailable;
//        this.works = works;
//    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


}
