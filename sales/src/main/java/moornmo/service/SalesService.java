package moornmo.service;

import java.util.List;
import java.util.Optional;
import moornmo.domain.*;

public interface SalesService {
    List<Sales> getAllSales() throws Exception;
    Optional<Sales> getSalesById(Long id) throws Exception;
    Sales createSales(Sales sales) throws Exception;
    Sales updateSales(Sales sales) throws Exception;
    void deleteSales(Long id) throws Exception;
}
