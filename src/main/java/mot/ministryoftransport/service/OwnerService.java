package mot.ministryoftransport.service;

import mot.ministryoftransport.dto.OwnerDto;
import mot.ministryoftransport.entity.Owner;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.repository.OwnerRepository;
import mot.ministryoftransport.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public Owner findById(long id){
        return ownerRepository.findById(id);
    }

    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    public Owner createNewOwner(OwnerDto dto) {
        Owner o = new Owner();
        o.setFirstName(dto.getFirstName());
        o.setLastName(dto.getLastName());
        Owner res = ownerRepository.save(o);
        return res;
    }

    public Owner updateOwner (OwnerDto dto, long id) throws Exception {
        Owner o = ownerRepository.findById(id);
        if(o == null){
            throw new Exception("Owner with " + id + " does not exist.");
        }
        o.setFirstName(dto.getFirstName());
        o.setLastName(dto.getLastName());

        Owner res = ownerRepository.save(o);
        return res;
    }

    public void deleteOwnerById(long id) throws Exception {
        Owner o = ownerRepository.findById(id);
        if(o == null){
            throw new Exception("Owner with \" + id + \" does not exist.");
        }
        ownerRepository.deleteById(id);
    }

    public void buyVehicle(long ownerId, long vehicleId) throws Exception {
        Owner o = findById(ownerId);
        if(o == null){
            throw new Exception("Owner with " + ownerId + " id does not exist.");
        }
        Vehicle v = vehicleRepository.findById(vehicleId);
        if(v == null){
            throw new Exception("Vehicle with " + vehicleId + " id does not exist.");
        }
        if(o.getOwnVehicles().contains(v)){
            throw new Exception("This owner has already bought car with " + vehicleId + " id");
        }
        o.getOwnVehicles().add(v);
        ownerRepository.save(o);
    }

    public List<Vehicle> ownVehicles (Long ownerId) throws Exception {
        Owner o = findById(ownerId);
        if(o == null){
            throw new Exception("Owner with " + ownerId + " id does not exist.");
        }
        return o.getOwnVehicles();
    }
}
