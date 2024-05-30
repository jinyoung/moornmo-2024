package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductionScheduled extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private Long orderId;

    public ProductionScheduled(Production aggregate) {
        super(aggregate);
    }

    public ProductionScheduled() {
        super();
    }
}
//>>> DDD / Domain Event
