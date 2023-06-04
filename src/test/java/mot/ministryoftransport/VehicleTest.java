package mot.ministryoftransport;

import mot.ministryoftransport.controller.VehicleController;
import mot.ministryoftransport.entity.Vehicle;
import mot.ministryoftransport.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private VehicleService service;

    @Test
    public void getVehicles() throws Exception {
        Vehicle v = new Vehicle(1L, LocalDate.of(2022,11,10), "Kia", "ASD-123");
        List<Vehicle> vehicleList = Arrays.asList(v);
    }
}
