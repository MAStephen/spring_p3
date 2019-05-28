package p3.model.user;

import p3.model.borrowing.Borrowing;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name="user")
//@XmlType(name = "User")
public class User implements Serializable{

	@Id
	@GeneratedValue(generator = "gen_user", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "gen_user", sequenceName = "seq_user", allocationSize = 1)
	Integer id;
	
    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String address;
    
//	@OneToMany
//	private List<Borrowing> borrowing;
	
    public User(int memberId, String firstName, String lastName, String username, String email, String password,
			String address//, List<Borrowing> borrowing
				) {
		super();

		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
//		this.borrowing = borrowing;
	}

    public User() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public List<Borrowing> getBorrowing() {
//		return borrowing;
//	}
//
//	public void setBorrowing(List<Borrowing> borrowing) {
//		this.borrowing = borrowing;
//	}

}
