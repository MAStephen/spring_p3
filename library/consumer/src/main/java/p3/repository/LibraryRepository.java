package p3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import p3.model.library.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

    Library findByCity(String cityName);

}
