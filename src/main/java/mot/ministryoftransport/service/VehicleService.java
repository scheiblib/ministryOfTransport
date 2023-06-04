package mot.ministryoftransport.service;

import mot.ministryoftransport.dto.VehicleDto;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }

    public Vehicle findById(long id) throws Exception {
        Vehicle v = vehicleRepository.findById(id);
        if(v == null){
            throw new Exception("Vehicle with " + id + " does not exist.");
        }
        return v;
    }

    public Vehicle findByPlate(String plate) throws Exception {
        Vehicle v = vehicleRepository.findVehicleByPlate(plate);
        if(v == null){
            throw new Exception("Vehicle with " + plate + " does not exist.");
        }
        return v;
    }

    public Vehicle createVehicle(VehicleDto vehicleDto) throws Exception {
        Vehicle v = new Vehicle();
        v.setType(vehicleDto.getType());
        try{
            v.setPlate(vehicleDto.getPlate());
        } catch (Exception e){
            System.err.println("There is already a vehicle with " + vehicleDto.getPlate() + " plate.");
        }
        v.setExpiry(vehicleDto.getExpiry());
        Vehicle res = vehicleRepository.save(v);
        return res;
    }

    public Vehicle updateVehicle (VehicleDto dto, long id) throws Exception {
        Vehicle v = vehicleRepository.findById(id);
        if(v == null){
            throw new Exception("Vehicle with " + id + " does not exist.");
        }
        v.setType(dto.getType());
        v.setPlate(dto.getPlate());
        Vehicle res = vehicleRepository.save(v);
        return res;
    }

    public void deleteVehicleById(long id) throws Exception {
        Vehicle v = vehicleRepository.findById(id);
        if(v == null){
            throw new Exception("vehicle with \" + id + \" does not exist.");
        }
        vehicleRepository.deleteById(id);
    }

    public void updateExpiry(long id) throws Exception {
        Vehicle v = vehicleRepository.findById(id);
        if(v == null) {
            throw new Exception("There is no vehicle with " + id + " id");
        }
        v.setExpiry(LocalDate.now().plusYears(2));
        vehicleRepository.save(v);
    }
}
