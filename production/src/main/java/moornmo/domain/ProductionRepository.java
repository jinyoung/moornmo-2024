package moornmo.domain;

import moornmo.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "productions",
    path = "productions"
)
public interface ProductionRepository
    extends PagingAndSortingRepository<Production, Long> {}
