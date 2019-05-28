package p3.model.library;

import p3.model.work.Work;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name="library")
//@XmlType(name = "Library")
public class Library implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "gen_library", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_library", sequenceName = "seq_library", allocationSize = 1)
	Integer id;
	
	
    private String name;

    private String city;

    @OneToMany
	private List<Work> works;
	
    public Library() {
    }

    public Library(String name, String city) {
    		this.name = name;
        this.city = city;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public List<Work> getWorks() {
		return works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

}
