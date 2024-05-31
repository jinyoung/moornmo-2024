package moornmo.service;

import java.util.List;
import java.util.Optional;
import moornmo.domain.*;

public interface ProductionService {
    List<Production> getAllProductions() throws Exception;
    Optional<Production> getProductionById(Long id) throws Exception;
    Production createProduction(Production production) throws Exception;
    Production updateProduction(Production production) throws Exception;
    void deleteProduction(Long id) throws Exception;

    Production completeProduction(
        CompleteProductionCommand completeProductionCommand
    ) throws Exception;
}
