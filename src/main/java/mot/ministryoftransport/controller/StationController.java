package mot.ministryoftransport.controller;

import jakarta.validation.Valid;
import mot.ministryoftransport.dto.StationDto;
import mot.ministryoftransport.entity.Station;
import mot.ministryoftransport.entity.Tester;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService stationService;
    @GetMapping("/findById/{id}")
    public Station findStationById(@PathVariable("id") long id) throws Exception {
        return stationService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Station> findALl(){
        return stationService.findAll();
    }

    @PostMapping("/create")
    public Station createStation(@RequestBody @Valid StationDto stationDto){
        Station s = stationService.create(stationDto);
        return s;
    }

    @PutMapping("/update/{id}")
    public Station updateStation(@PathVariable("id") long id, @RequestBody StationDto dto) throws Exception {
        return stationService.update(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStationById(@PathVariable("id") long id) throws Exception {
        stationService.deleteById(id);
    }

    @PutMapping("/hire/{stationid}/{testerid}")
    public void hireTester(@PathVariable("stationid") long stationId, @PathVariable("testerid") long testerId) throws Exception {
        stationService.hireTester(stationId, testerId);
    }

    @PutMapping("/fire/{stationid}/{testerid}")
    public void fireTester(@PathVariable("stationid") long stationId, @PathVariable("testerid") long testerId) throws Exception {
        stationService.fireTester(stationId, testerId);
    }

    @GetMapping("/employees/{id}")
    public List<Tester> listTesters (@PathVariable("id") long id) throws Exception {
        return stationService.listTesters(id);
    }
    @PutMapping("/test/{stationid}/{vehicleid}")
    public Vehicle test(@PathVariable("stationid") long stationId, @PathVariable("vehicleid") long vehicleId) throws Exception {
        return stationService.testVehicle(stationId, vehicleId);
    }
}
