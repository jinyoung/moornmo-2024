package moornmo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import moornmo.domain.Company;
import moornmo.domain.CompanyRepository;
import moornmo.service.CompanyService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("companyService")
@Transactional
public class CompanyServiceImpl
    extends EgovAbstractServiceImpl
    implements CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        CompanyServiceImpl.class
    );

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() throws Exception {
        // Get all companies
        return StreamSupport
            .stream(companyRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Company> getCompanyById(Long id) throws Exception {
        // Get a company by ID
        return companyRepository.findById(id);
    }

    @Override
    public Company createCompany(Company company) throws Exception {
        // Create a new company
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) throws Exception {
        // Update an existing company via CompanyService
        if (companyRepository.existsById(company.getId())) {
            return companyRepository.save(company);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteCompany(Long id) throws Exception {
        // Delete a company
        companyRepository.deleteById(id);
    }
}
