package moornmo.infra;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import java.util.Optional;
import moornmo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/productions")
@Transactional
public class ProductionController {

    @Autowired
    ProductionRepository productionRepository;

    @RequestMapping(
        value = "productions/{id}/complete-production",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Production completeProduction(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /production/completeProduction  called #####"
        );
        Optional<Production> optionalProduction = productionRepository.findById(
            id
        );

        optionalProduction.orElseThrow(() -> new Exception("No Entity Found"));
        Production production = optionalProduction.get();
        production.completeProduction();

        productionRepository.save(production);
        return production;
    }
}
//>>> Clean Arch / Inbound Adaptor
