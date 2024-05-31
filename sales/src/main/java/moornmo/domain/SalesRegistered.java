package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SalesRegistered extends AbstractEvent {

    private Long id;
    private String companyId;
    private String productId;
    private Integer qty;
    private String customerId;

    public SalesRegistered(Sales aggregate) {
        super(aggregate);
    }

    public SalesRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
