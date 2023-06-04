package mot.ministryoftransport.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "tester")
@Entity
public class Tester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tester_id", nullable = false)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

}
