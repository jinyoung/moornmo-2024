package moornmo.service;

import java.util.List;
import java.util.Optional;
import moornmo.domain.*;

public interface CompanyService {
    List<Company> getAllCompanies() throws Exception;
    Optional<Company> getCompanyById(Long id) throws Exception;
    Company createCompany(Company company) throws Exception;
    Company updateCompany(Company company) throws Exception;
    void deleteCompany(Long id) throws Exception;
}
