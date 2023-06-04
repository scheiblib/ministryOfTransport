package mot.ministryoftransport.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import mot.ministryoftransport.entity.Tester;

import java.io.Serializable;

@Data
public class TesterDto implements Serializable {

    private final long id;
    @NotEmpty(message = "First name should be not empty")
    private final String firstName;
    @NotEmpty(message = "Last name should be not empty")
    private final String lastName;

    public static TesterDto makeDTO (Tester t) {
        TesterDto dto = new TesterDto(
                t.getId(),
                t.getFirstName(),
                t.getLastName()
        );
        return dto;
    }
}
