package mot.ministryoftransport.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "station")

public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private long id;

    private String name;
    private String city;
    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "stations_testers",
                joinColumns = @JoinColumn(name = "station_id"),
                inverseJoinColumns = @JoinColumn(name = "tester_id"))
    private List<Tester> testers = new ArrayList<>();

//    public void hireTester(Tester tester){
//        testers.add(tester);
//    }
//
//    public void fireTester(Tester tester){
//        testers.remove(tester);
//    }
}
