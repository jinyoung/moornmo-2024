package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductionCompleted extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private Long orderId;

    public ProductionCompleted(Production aggregate) {
        super(aggregate);
    }

    public ProductionCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
