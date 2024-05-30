package moornmo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import moornmo.SalesApplication;
import moornmo.domain.SalesRegistered;

@Entity
@Table(name = "Sales_table")
@Data
//<<< DDD / Aggregate Root
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String productId;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        SalesRegistered salesRegistered = new SalesRegistered(this);
        salesRegistered.publishAfterCommit();
    }

    public static SalesRepository repository() {
        SalesRepository salesRepository = SalesApplication.applicationContext.getBean(
            SalesRepository.class
        );
        return salesRepository;
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(ProductionCompleted productionCompleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Sales sales = new Sales();
        repository().save(sales);

        */

        /** Example 2:  finding and process
        
        repository().findById(productionCompleted.get???()).ifPresent(sales->{
            
            sales // do something
            repository().save(sales);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
