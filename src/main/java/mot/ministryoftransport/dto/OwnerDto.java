package mot.ministryoftransport.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import mot.ministryoftransport.entity.Owner;
import mot.ministryoftransport.entity.Vehicle;

import java.io.Serializable;
import java.util.List;

@Data
public class OwnerDto implements Serializable {

    private final long id;
    @NotEmpty(message = "First name should be not empty")
    private final String firstName;

    @NotEmpty(message = "Last name should be not empty")
    private final String lastName;
    private final List<Vehicle> ownVehicles;

    public static OwnerDto makeDTO (Owner o) {
        OwnerDto dto = new OwnerDto (
            o.getId(),
            o.getFirstName(),
            o.getLastName(),
            o.getOwnVehicles()
        );
        return dto;
    }
}
