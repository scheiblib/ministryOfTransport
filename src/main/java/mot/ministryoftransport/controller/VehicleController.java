package mot.ministryoftransport.controller;

import jakarta.validation.Valid;
import mot.ministryoftransport.dto.VehicleDto;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/findById/{id}")
    public Vehicle findVehicleById(@PathVariable("id") long id) throws Exception {
        return vehicleService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Vehicle> findALl(){
        return vehicleService.findAll();
    }

    @GetMapping("/findByPlate/{plate}")
    public Vehicle findByPlate(@PathVariable("plate") String plate) throws Exception {
        return vehicleService.findByPlate(plate);
    }
    
    @PostMapping("/create")
    public Vehicle createVehicle (@RequestBody @Valid VehicleDto vehicleDto) throws Exception{
        Vehicle v = vehicleService.createVehicle(vehicleDto);
        return v;
    }

    @PutMapping("/update/{id}")
    public Vehicle updateVehicle(@PathVariable("id") long id, @RequestBody VehicleDto dto) throws Exception {
        return vehicleService.updateVehicle(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicleById(@PathVariable("id") long id) throws Exception {
        vehicleService.deleteVehicleById(id);
    }
}
