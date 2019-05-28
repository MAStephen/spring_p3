package p3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p3.model.work.Work;

import java.util.List;

@Repository
public interface WorkRepository extends CrudRepository<Work, Integer> {

    List<Work> findByTitleLike(String title);
    List<Work> findByAuthorLike(String author);
    List<Work> findByTitleLikeAndAuthorLike(String title, String author);
    Work findFirstById(Integer id);
    Work findByTitleAndAuthor(String title, String author);

}
