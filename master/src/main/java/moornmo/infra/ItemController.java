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
// @RequestMapping(value="/items")
public class ItemController {

    @Resource(name = "itemService")
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItems() throws Exception {
        // Get all items via ItemService
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) throws Exception {
        // Get a item by ID via ItemService
        return itemService.getItemById(id);
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) throws Exception {
        // Create a new item via ItemService
        return itemService.createItem(item);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item)
        throws Exception {
        // Update an existing item via ItemService
        return itemService.updateItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) throws Exception {
        // Delete a item via ItemService
        itemService.deleteItem(id);
    }
}
