package moornmo.infra;

import moornmo.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class SalesHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Sales>> {

    @Override
    public EntityModel<Sales> process(EntityModel<Sales> model) {
        return model;
    }
}
