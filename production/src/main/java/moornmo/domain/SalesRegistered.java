package moornmo.domain;

import java.util.*;
import lombok.*;
import moornmo.domain.*;
import moornmo.infra.AbstractEvent;

@Data
@ToString
public class SalesRegistered extends AbstractEvent {

    private Long id;
    private String companyId;
    private String productId;
    private Integer qty;
}
