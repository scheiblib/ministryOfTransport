package mot.ministryoftransport.repository;

import mot.ministryoftransport.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    List<Vehicle> findAll();
    Vehicle findById(long id);
    @Query("select v from Vehicle v where v.plate = ?1")
    Vehicle findVehicleByPlate(String plate);
}
