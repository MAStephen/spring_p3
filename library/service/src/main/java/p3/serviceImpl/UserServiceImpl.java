package p3.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p3.model.book.Book;
import p3.model.borrowing.Borrowing;
import p3.model.user.User;
import p3.model.work.Work;
import p3.repository.*;
import p3.service.UserService;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    WorkRepository workRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BorrowingRepository borrowingRepository;

    public Borrowing borrowingBook(Integer workId, Integer userId) {
        User user = userRepository.findFirstById(userId);
        Work work = workRepository.findFirstById(workId);
        Integer bookId = null;
        System.out.println("UserServiceImpl, borrowingBook, user => " + user);
        if(work.getBooks() == null) {

            return null;
        }
        for(Book book : work.getBooks()) {
            if(book.isAvailable()) {
                bookId = book.getId();
                break;
            }
        }
        if(bookId == null) {

            return null;
        }
        Book book = bookRepository.findBookById(bookId);
        book.setAvailable(false);
        Borrowing borrowing = new Borrowing();
        System.out.println("userServiceImpl, borrowingBook => utilisateur : " + user);
        borrowing.setUser(user);
        borrowing.setBook(book);
        borrowing.setStatus("ENCOURS");
        borrowing.setExtended(false);
        borrowing.setTitle(work.getTitle());
        borrowing.setAuthor(work.getAuthor());
        borrowing.setDescription(work.getDescription());
        Calendar date = Calendar.getInstance();
        borrowing.setIssueDate(date.getTime());
        try{

            bookRepository.save(book);
            System.out.println("testsdsd ");
            borrowing = borrowingRepository.save(borrowing);

            Integer bookAvailable = 0;
            for(Book bookEmpty : work.getBooks()) {
                if(bookEmpty.isAvailable()) {
                    bookAvailable++;
                }
            }
            if( bookAvailable == 0 ) {
                work.setAvailable(false);
                workRepository.save(work);
            }
            System.out.println("test save borrowing ");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("test1 ");
        return borrowing;
    }

    @Transactional
    public List<Work> searchEngineByTitle(String title) {
        title = "%"+title+"%";

        return workRepository.findByTitleLike(title);
    }

    public List<Work> searchEngineByAuthor(String author) {
        author = "%"+author+"%";

        return workRepository.findByAuthorLike(author);
    }

    public List<Work> searchEngineByTitleAndAuthor(String title, String author) {
        title = "%" + title + "%";
        author = "%" + author + "%";

        return workRepository.findByTitleLikeAndAuthorLike(title, author);
    }

    public List<Borrowing> getBorrowingByUserId(Integer userId) {
        User user = userRepository.findFirstById(userId);
        List<Borrowing> borrowingList = borrowingRepository.findBorrowingByUser(user);

        return borrowingList;
    }

    public Borrowing extendBorrowing(Integer borrowingId) {
        Borrowing borrowing = borrowingRepository.findFirstById(borrowingId);
        borrowing.setExtended(true);

        return borrowingRepository.save(borrowing);
    }

    public Borrowing returnBorrowing(Integer borrowingId) {
        Borrowing borrowing = borrowingRepository.findFirstById(borrowingId);

        if(borrowing.getReturnDate() != null || borrowing.getStatus().equals("TERMINE")) {
            return null;
        }
        Calendar date = Calendar.getInstance();
        borrowing.setReturnDate(date.getTime());
        borrowing.setStatus("TERMINE");
        String error = "";
        Book book = bookRepository.findBookById(borrowing.getBook().getId());
        book.setAvailable(true);

        Work work = workRepository.findByTitleAndAuthor(borrowing.getTitle(), borrowing.getAuthor());
        Borrowing borrowing1 = null;

        try {
            bookRepository.save(book);
            System.out.println("book sauvé");
            borrowing1 = borrowingRepository.save(borrowing);
            work.setAvailable(true);
            workRepository.save(work);
        } catch (Exception e) {
            error = "Le livre n'a pas été remis à la disposition des utilisateurs";
        }

        if(error.equals("")) {

            return borrowing1;
        } else {
            return null;
        }
    }

    public User getUserInfo(Integer userId) {
        User user = userRepository.findFirstById(userId);
        return user;
    }

    public User updateUserInfo(User user, Integer userId) {
        User userInBaseByUserId = userRepository.findFirstById(userId);
        User userToSave = new User();

        if( !user.getPassword().equals(userInBaseByUserId.getPassword()) &&
                !user.getPassword().equals("?") &&
                !user.getPassword().equals("") ) {
            userInBaseByUserId.setPassword(user.getPassword());
        }

        if( !user.getAddress().equals(userInBaseByUserId.getAddress()) &&
                !user.getAddress().equals("?") &&
                !user.getAddress().equals("") ) {
            userInBaseByUserId.setAddress(user.getAddress());
        }

        if( !user.getFirstName().equals(userInBaseByUserId.getFirstName()) &&
                !user.getFirstName().equals("?") &&
                !user.getFirstName().equals("") ) {
            userInBaseByUserId.setFirstName(user.getFirstName());
        }

        if( !user.getLastName().equals(userInBaseByUserId.getLastName()) &&
                !user.getLastName().equals("?") &&
                !user.getLastName().equals("") ) {
            userInBaseByUserId.setLastName(user.getLastName());
        }

        if( !user.getUsername().equals(userInBaseByUserId.getUsername()) &&
                !user.getUsername().equals("?") &&
                !user.getUsername().equals("") ) {
            userInBaseByUserId.setUsername(user.getUsername());
        }

        if( !user.getEmail().equals(userInBaseByUserId.getEmail()) &&
                !user.getEmail().equals("?") &&
                !user.getEmail().equals("") ) {
            userInBaseByUserId.setEmail(user.getEmail());
        }

        User userToRet = userRepository.save(userInBaseByUserId);
        return userToRet;
    }

}
