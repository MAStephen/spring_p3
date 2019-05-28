package p3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p3.model.book.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findBookById(int id);

}
