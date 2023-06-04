package mot.ministryoftransport.controller;

import jakarta.validation.Valid;
import mot.ministryoftransport.dto.OwnerDto;
import mot.ministryoftransport.entity.Owner;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/findById/{id}")
    public Owner findById(@PathVariable("id") long id) throws Exception {
        return ownerService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Owner> findALl(){
        return ownerService.findAll();
    }
    @PostMapping("/create")
    public Owner createOwner(@RequestBody @Valid OwnerDto ownerDto) {
        Owner o = ownerService.createNewOwner(ownerDto);
        return o;
    }

    @PutMapping("/update/{id}")
    public Owner updateOwner(@PathVariable("id") long id, @RequestBody OwnerDto dto) throws Exception {
        return ownerService.updateOwner(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOwnerById(@PathVariable("id") long id) throws Exception {
        ownerService.deleteOwnerById(id);
    }

    @PutMapping("/buy/{ownerid}/{vehicleid}")
    public void buyVehicle(@PathVariable("ownerid") long ownerId, @PathVariable("vehicleid") long vehicleId) throws Exception {
        ownerService.buyVehicle(ownerId, vehicleId);
    }

    @GetMapping("/vehicles/{ownerid}")
    public List<Vehicle> ownVehicles(@PathVariable("ownerid") Long ownerId) throws Exception{
        return ownerService.ownVehicles(ownerId);
    }
}
