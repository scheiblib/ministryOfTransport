package mot.ministryoftransport.service;

import mot.ministryoftransport.dto.TesterDto;
import mot.ministryoftransport.entity.Tester;
import mot.ministryoftransport.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterService {

    @Autowired
    private TesterRepository testerRepository;

    public Tester create(TesterDto testerDto) {
        Tester t = new Tester();
        t.setFirstName(testerDto.getFirstName());
        t.setLastName(testerDto.getLastName());
        Tester res = testerRepository.save(t);
        return res;
    }

    public List<Tester> findAll(){
        return testerRepository.findAll();
    }

    public Tester findById(long id){
        return testerRepository.findById(id);
    }

    public Tester update(TesterDto dto, long id) throws Exception {
        Tester t = testerRepository.findById(id);
        if(t == null){
            throw new Exception("Tester with " + id + " id does not exist.");
        }
        t.setFirstName(dto.getFirstName());
        t.setLastName(dto.getLastName());

        Tester res = testerRepository.save(t);
        return res;
    }

    public void deleteById(long id) throws Exception {
        Tester t = testerRepository.findById(id);
        if(t == null){
            throw new Exception("Tester with " + id + " id does not exist.");
        }
        testerRepository.deleteById(id);
    }
}
