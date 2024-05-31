package moornmo.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import moornmo.infra.AbstractEvent;

@Data
public class ProductionScheduled extends AbstractEvent {

    private Long id;
    private String productId;
    private Integer qty;
    private Long orderId;
}
