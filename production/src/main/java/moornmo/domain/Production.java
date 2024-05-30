package moornmo.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import moornmo.ProductionApplication;
import moornmo.domain.ProductionScheduled;

@Entity
@Table(name = "Production_table")
@Data
//<<< DDD / Aggregate Root
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        ProductionScheduled productionScheduled = new ProductionScheduled(this);
        productionScheduled.publishAfterCommit();
    }

    public static ProductionRepository repository() {
        ProductionRepository productionRepository = ProductionApplication.applicationContext.getBean(
            ProductionRepository.class
        );
        return productionRepository;
    }

    //<<< Clean Arch / Port Method
    public void completeProduction() {
        //implement business logic here:

        ProductionCompleted productionCompleted = new ProductionCompleted(this);
        productionCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void addProductionSchedule(SalesRegistered salesRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Production production = new Production();
        repository().save(production);

        */

        /** Example 2:  finding and process
        
        repository().findById(salesRegistered.get???()).ifPresent(production->{
            
            production // do something
            repository().save(production);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
