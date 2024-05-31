package moornmo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import moornmo.domain.Item;
import moornmo.domain.ItemRepository;
import moornmo.service.ItemService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("itemService")
@Transactional
public class ItemServiceImpl
    extends EgovAbstractServiceImpl
    implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        ItemServiceImpl.class
    );

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() throws Exception {
        // Get all items
        return StreamSupport
            .stream(itemRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> getItemById(Long id) throws Exception {
        // Get a item by ID
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) throws Exception {
        // Create a new item
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) throws Exception {
        // Update an existing item via ItemService
        if (itemRepository.existsById(item.getId())) {
            return itemRepository.save(item);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteItem(Long id) throws Exception {
        // Delete a item
        itemRepository.deleteById(id);
    }
}
