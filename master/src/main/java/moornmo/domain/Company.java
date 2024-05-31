package moornmo.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;
import moornmo.MasterApplication;

@Entity
@Table(name = "Company_table")
@Data
//<<< DDD / Aggregate Root
public class Company {

    @Id
    private String id;

    private String name;

    @ElementCollection
    private List<Address> addresses;

    public static CompanyRepository repository() {
        CompanyRepository companyRepository = MasterApplication.applicationContext.getBean(
            CompanyRepository.class
        );
        return companyRepository;
    }
}
//>>> DDD / Aggregate Root
