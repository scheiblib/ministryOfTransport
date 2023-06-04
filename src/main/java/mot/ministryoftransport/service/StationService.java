package mot.ministryoftransport.service;

import mot.ministryoftransport.dto.StationDto;
import mot.ministryoftransport.entity.Station;
import mot.ministryoftransport.entity.Tester;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private TesterService testerService;
    @Autowired
    private VehicleService vehicleService;

    public List<Station> findAll(){
        return stationRepository.findAll();
    }

    public Station findById(long id){
        return stationRepository.findById(id);
    }

    public Station create(StationDto stationDto) {
        Station s = new Station();
        s.setName(stationDto.getName());
        s.setCity(stationDto.getCity());
        s.setAddress(stationDto.getAddress());
        Station res = stationRepository.save(s);
        return res;
    }

    public Station update(StationDto dto, long id) throws Exception {
        Station s = findById(id);
        if(s == null){
            throw new Exception("station with " + id + " does not exist.");
        }
        s.setName(dto.getName());
        s.setCity(dto.getCity());
        s.setAddress(dto.getAddress());

        Station res = stationRepository.save(s);
        return res;
    }

    public void deleteById(long id) throws Exception {
        Station s = findById(id);
        if(s == null){
            throw new Exception("station with \" + id + \" does not exist.");
        }
        stationRepository.deleteById(id);
    }
    public void hireTester(long stationId, long testerId) throws Exception{
        Station s = findById(stationId);
        if(s == null){
            throw new Exception("Station with " + stationId + " id does not exist.");
        }
        Tester t = testerService.findById(testerId);
        if(t == null) {
            throw new Exception("Tester with " + testerId + " id doest not exist.");
        }
        if(s.getTesters().contains(t)){
                throw new Exception("Tester with " + testerId + " id already working for this station.");
            }
        s.getTesters().add(t);
        stationRepository.save(s);
    }

    public void fireTester(long stationId, long testerId) throws Exception{
        Station s = findById(stationId);
        if(s == null){
            throw new Exception("Station with " + stationId + " id does not exist.");
        }
        Tester t = testerService.findById(testerId);
        if(t == null) {
            throw new Exception("Tester with " + testerId + " id does not exist.");
        }
        if(s.getTesters().isEmpty()){
            throw new Exception("There are no emplyees working for this station");
        }
        if(s.getTesters().contains(t)){
            s.getTesters().remove(t);
            stationRepository.save(s);
        } else{
            throw new Exception("Tester with " + testerId + " id is not working for this station");
        }
    }

    public List<Tester> listTesters(long id) throws Exception {
        Station s = stationRepository.findById(id);
        if(s == null){
            throw new Exception("The station with " + id + " id does not exist.");
        }
        if(s.getTesters().isEmpty()){
            throw new Exception("There are no employees.");
        } else {
            return s.getTesters();
        }
    }

    public Vehicle testVehicle(long stationId, long vehicleId) throws Exception {
        Station s = stationRepository.findById(stationId);
        if(s == null){
            throw new Exception("Station with " + stationId + " id does not exist");
        }
        vehicleService.updateExpiry(vehicleId);
        return vehicleService.findById(vehicleId);
    }
}
