package p3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p3.model.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);
    User findFirstById(Integer id);

}
