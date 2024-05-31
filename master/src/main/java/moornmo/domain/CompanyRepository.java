package moornmo.domain;

import moornmo.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "companies", path = "companies")
public interface CompanyRepository
    extends PagingAndSortingRepository<Company, String> {}
