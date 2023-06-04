package mot.ministryoftransport.controller;

import jakarta.validation.Valid;
import mot.ministryoftransport.dto.TesterDto;
import mot.ministryoftransport.entity.Tester;
import mot.ministryoftransport.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tester")
public class TesterController {

    @Autowired
    private TesterService testerService;

    @GetMapping("/findById/{id}")
    public Tester findById(@PathVariable("id") long id) throws Exception {
        return testerService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Tester> findALl(){
        return testerService.findAll();
    }
    @PostMapping("/create")
    public Tester createTester(@RequestBody @Valid TesterDto testerDto) {
        Tester o = testerService.create(testerDto);
        return o;
    }

    @PutMapping("/update/{id}")
    public Tester updateTester(@PathVariable("id") long id, @RequestBody TesterDto dto) throws Exception {
        return testerService.update(dto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTesterById(@PathVariable("id") long id) throws Exception {
        testerService.deleteById(id);
    }
}
