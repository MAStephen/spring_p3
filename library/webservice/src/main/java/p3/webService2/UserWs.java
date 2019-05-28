package p3.webService2;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import p3.model.borrowing.Borrowing;
import p3.model.user.User;
import p3.model.work.Work;
import p3.service.UserService;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "userWeb", name = "userWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class UserWs {
	@Autowired
	UserService userService;

	@WebMethod // fonctionne
	public List<Work> searchEngineWorkByTitle(String title) {
		if (userService == null) {
			init();
		}
		System.out.println(title);

		List<Work> workList = userService.searchEngineByTitle(title);

		return workList;

	}

	@WebMethod // fonctionne
	public List<Work> searchEngineWorkByAuthor(String author) {
		if (userService == null) {
			init();
		}
		List<Work> workList = userService.searchEngineByAuthor(author);
		return workList;
	}

	@WebMethod // fonctionne
	public List<Work> searchEngineWorkByTitleAndAuthor(String title, String author) {
		if (userService == null) {
			init();
		}
		return userService.searchEngineByTitleAndAuthor(title, author);
	}

	@WebMethod // fonctionne
	public List<Borrowing> getBorrowingByUserId(Integer userId) {
		if (userService == null) {
			init();
		}
		return userService.getBorrowingByUserId(userId);
	}

	@WebMethod // fonctionne
	public Borrowing extendBorrowing(Integer borrowingId) {
		if (userService == null) {
			init();
		}
		return userService.extendBorrowing(borrowingId);
	}

	@WebMethod // fonctionne
	public Borrowing returnBorrowing(Integer borrowingId) {
		if (userService == null) {
			init();
		}
		return userService.returnBorrowing(borrowingId);
	}

	@WebMethod // fonctionne
	public Borrowing borrowingBook(Integer id, Integer user) {
		if (userService == null) {
			init();
		}
		Borrowing borrowing = userService.borrowingBook(id, user);
		return borrowing;
	}

	@WebMethod // fonctionne
	public User getUserInfo(Integer userId) {
		if (userService == null) {
			init();
		}
		return userService.getUserInfo(userId);
	}

	@WebMethod // fonctionne
	public User updateUserInfo(User user, Integer userId) {
		if (userService == null) {
			init();
		}
		return userService.updateUserInfo(user, userId);
	}

	@WebMethod
	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
