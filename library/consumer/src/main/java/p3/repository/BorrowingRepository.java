package p3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p3.model.borrowing.Borrowing;
import p3.model.user.User;

import java.util.List;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Integer> {

    List<Borrowing> findBorrowingByUser(User user);
    Borrowing findFirstById(Integer borrowingId);

}
