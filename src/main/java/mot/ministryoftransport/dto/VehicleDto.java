package mot.ministryoftransport.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import mot.ministryoftransport.entity.Vehicle;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class VehicleDto implements Serializable {

    private final long id;

    private final LocalDate expiry;
    @NotEmpty(message = "Type should be not empty")
    private final String type;
    @NotEmpty(message = "Plate should be not empty")
    @Pattern(regexp = "^[a-zA-Z]{3}[0-9]{3}")

    private final String plate;
   // private final Owner owner;

    public static VehicleDto makeDTO (Vehicle v) {
        VehicleDto dto = new VehicleDto(
                v.getId(),
                v.getExpiry(),
                v.getType(),
                v.getPlate()
               // v.getOwner()
        );
        return dto;
    }
}
