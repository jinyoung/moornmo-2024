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
// @RequestMapping(value="/productions")
public class ProductionController {

    @Resource(name = "productionService")
    private ProductionService productionService;

    @GetMapping("/productions")
    public List<Production> getAllProductions() throws Exception {
        // Get all productions via ProductionService
        return productionService.getAllProductions();
    }

    @GetMapping("/productions/{id}")
    public Optional<Production> getProductionById(@PathVariable Long id)
        throws Exception {
        // Get a production by ID via ProductionService
        return productionService.getProductionById(id);
    }

    @PostMapping("/productions")
    public Production createProduction(@RequestBody Production production)
        throws Exception {
        // Create a new production via ProductionService
        return productionService.createProduction(production);
    }

    @PutMapping("/productions/{id}")
    public Production updateProduction(
        @PathVariable Long id,
        @RequestBody Production production
    ) throws Exception {
        // Update an existing production via ProductionService
        return productionService.updateProduction(production);
    }

    @DeleteMapping("/productions/{id}")
    public void deleteProduction(@PathVariable Long id) throws Exception {
        // Delete a production via ProductionService
        productionService.deleteProduction(id);
    }

    @RequestMapping(
        value = "/productions/{id}/complete-production",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Production completeProduction(
        @PathVariable(value = "id") Long id,
        @RequestBody CompleteProductionCommand completeProductionCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return productionService.completeProduction(completeProductionCommand);
    }
}
