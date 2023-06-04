package mot.ministryoftransport.repository;

import mot.ministryoftransport.entity.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends CrudRepository<Station, Long> {
    Station findById(long id);
    List<Station> findAll();
}
