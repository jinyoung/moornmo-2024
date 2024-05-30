package moornmo.infra;

import moornmo.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProductionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Production>> {

    @Override
    public EntityModel<Production> process(EntityModel<Production> model) {
        return model;
    }
}
