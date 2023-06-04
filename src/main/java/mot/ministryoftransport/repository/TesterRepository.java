package mot.ministryoftransport.repository;

import mot.ministryoftransport.entity.Tester;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TesterRepository extends CrudRepository<Tester, Long> {
    List<Tester> findAll();
    Tester findById(long id);
}
