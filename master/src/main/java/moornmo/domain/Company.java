package moornmo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;
import moornmo.MasterApplication;

@Entity
@Table(name = "Company_table")
@Data
//<<< DDD / Aggregate Root
public class Company {

    @Id
    @RestResource(exported = true)
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
