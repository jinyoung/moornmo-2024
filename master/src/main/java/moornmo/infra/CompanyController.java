package moornmo.infra;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moornmo.domain.*;
import moornmo.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/companies")
public class CompanyController {

    @Resource(name = "companyService")
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies() throws Exception {
        // Get all companies via CompanyService
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id)
        throws Exception {
        // Get a company by ID via CompanyService
        return companyService.getCompanyById(id);
    }

    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company company)
        throws Exception {
        // Create a new company via CompanyService
        return companyService.createCompany(company);
    }

    @PutMapping("/companies/{id}")
    public Company updateCompany(
        @PathVariable Long id,
        @RequestBody Company company
    ) throws Exception {
        // Update an existing company via CompanyService
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable Long id) throws Exception {
        // Delete a company via CompanyService
        companyService.deleteCompany(id);
    }
}
