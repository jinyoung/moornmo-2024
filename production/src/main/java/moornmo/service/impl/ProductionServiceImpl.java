package moornmo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import moornmo.domain.CompleteProductionCommand;
import moornmo.domain.Production;
import moornmo.domain.ProductionRepository;
import moornmo.service.ProductionService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productionService")
@Transactional
public class ProductionServiceImpl
    extends EgovAbstractServiceImpl
    implements ProductionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        ProductionServiceImpl.class
    );

    @Autowired
    ProductionRepository productionRepository;

    @Override
    public List<Production> getAllProductions() throws Exception {
        // Get all productions
        return StreamSupport
            .stream(productionRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Production> getProductionById(Long id) throws Exception {
        // Get a production by ID
        return productionRepository.findById(id);
    }

    @Override
    public Production createProduction(Production production) throws Exception {
        // Create a new production
        return productionRepository.save(production);
    }

    @Override
    public Production updateProduction(Production production) throws Exception {
        // Update an existing production via ProductionService
        if (productionRepository.existsById(production.getId())) {
            return productionRepository.save(production);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteProduction(Long id) throws Exception {
        // Delete a production
        productionRepository.deleteById(id);
    }

    @Override
    public Production completeProduction(
        CompleteProductionCommand completeProductionCommand
    ) throws Exception {
        // You can implement logic here, or call the domain method of the Production.

        /** Option 1-1:  implement logic here     
            Production production = new Production();
            production.completeProduction(completeProductionCommand);
            productionRepository.save(production);   
        */

        Optional<Production> optionalProduction = productionRepository.findById(
            completeProductionCommand.getProductionId()
        );

        if (optionalProduction.isPresent()) {
            Production production = optionalProduction.get();
            production.completeProduction(completeProductionCommand);
            return productionRepository.save(production);
        } else {
            throw processException("info.nodata.msg");
        }
    }
}
