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
// @RequestMapping(value="/sales")
public class SalesController {

    @Resource(name = "salesService")
    private SalesService salesService;

    @GetMapping("/sales")
    public List<Sales> getAllSales() throws Exception {
        // Get all sales via SalesService
        return salesService.getAllSales();
    }

    @GetMapping("/sales/{id}")
    public Optional<Sales> getSalesById(@PathVariable Long id)
        throws Exception {
        // Get a sales by ID via SalesService
        return salesService.getSalesById(id);
    }

    @PostMapping("/sales")
    public Sales createSales(@RequestBody Sales sales) throws Exception {
        // Create a new sales via SalesService
        return salesService.createSales(sales);
    }

    @PutMapping("/sales/{id}")
    public Sales updateSales(@PathVariable Long id, @RequestBody Sales sales)
        throws Exception {
        // Update an existing sales via SalesService
        return salesService.updateSales(sales);
    }

    @DeleteMapping("/sales/{id}")
    public void deleteSales(@PathVariable Long id) throws Exception {
        // Delete a sales via SalesService
        salesService.deleteSales(id);
    }
}
