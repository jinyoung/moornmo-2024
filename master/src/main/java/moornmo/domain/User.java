package moornmo.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;
import moornmo.MasterApplication;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    private String id;

    private String email;

    private String name;

    @ElementCollection
    private List<Address> addresses;

    public static UserRepository repository() {
        UserRepository userRepository = MasterApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
}
//>>> DDD / Aggregate Root
