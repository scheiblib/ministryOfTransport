package mot.ministryoftransport.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import mot.ministryoftransport.entity.Station;
import mot.ministryoftransport.entity.Tester;

import java.io.Serializable;
import java.util.List;

@Data
public class StationDto implements Serializable {

    private final long id;
    @NotEmpty(message = "Name should be not empty")
    private final String name;
    @NotEmpty(message = "City should be not empty")
    private final String city;
    @NotEmpty(message = "Address should be not empty")
    private final String address;

    private final List<Tester> testers;

    public static StationDto makeDTO (Station s){
        StationDto dto = new StationDto(
                s.getId(),
                s.getName(),
                s.getCity(),
                s.getAddress(),
                s.getTesters()
        );
        return dto;
    }
}
