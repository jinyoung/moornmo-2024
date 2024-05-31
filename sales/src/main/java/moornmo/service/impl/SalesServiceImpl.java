package moornmo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import moornmo.domain.Sales;
import moornmo.domain.SalesRepository;
import moornmo.service.SalesService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("salesService")
@Transactional
public class SalesServiceImpl
    extends EgovAbstractServiceImpl
    implements SalesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        SalesServiceImpl.class
    );

    @Autowired
    SalesRepository salesRepository;

    @Override
    public List<Sales> getAllSales() throws Exception {
        // Get all sales
        return StreamSupport
            .stream(salesRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Sales> getSalesById(Long id) throws Exception {
        // Get a sales by ID
        return salesRepository.findById(id);
    }

    @Override
    public Sales createSales(Sales sales) throws Exception {
        // Create a new sales
        return salesRepository.save(sales);
    }

    @Override
    public Sales updateSales(Sales sales) throws Exception {
        // Update an existing sales via SalesService
        if (salesRepository.existsById(sales.getId())) {
            return salesRepository.save(sales);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteSales(Long id) throws Exception {
        // Delete a sales
        salesRepository.deleteById(id);
    }
}
