package p3.service;

import org.springframework.context.annotation.ComponentScan;
import p3.model.borrowing.Borrowing;
import p3.model.user.User;
import p3.model.work.Work;

import java.util.List;

@ComponentScan
public interface UserService {

    public List<Borrowing> getBorrowingByUserId(Integer userId);
    public Borrowing extendBorrowing(Integer borrowingId);
    public Borrowing returnBorrowing(Integer borrowingId);
    public Borrowing borrowingBook(Integer id, Integer user);

    public List<Work> searchEngineByTitle(String title);
    public List<Work> searchEngineByAuthor(String author);
    public List<Work> searchEngineByTitleAndAuthor(String title, String author);

    public User getUserInfo(Integer userId);
    public User updateUserInfo(User user, Integer userId);
}
