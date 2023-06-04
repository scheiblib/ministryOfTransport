package mot.ministryoftransport.repository;

import mot.ministryoftransport.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findById(long id);
    List<Owner> findAll();
}
