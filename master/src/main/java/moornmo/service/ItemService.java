package moornmo.service;

import java.util.List;
import java.util.Optional;
import moornmo.domain.*;

public interface ItemService {
    List<Item> getAllItems() throws Exception;
    Optional<Item> getItemById(Long id) throws Exception;
    Item createItem(Item item) throws Exception;
    Item updateItem(Item item) throws Exception;
    void deleteItem(Long id) throws Exception;
}
