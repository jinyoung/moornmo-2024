package moornmo.domain;

import moornmo.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "sales", path = "sales")
public interface SalesRepository extends JpaRepository<Sales, Long> {}
