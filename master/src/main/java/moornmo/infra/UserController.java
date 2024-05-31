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
// @RequestMapping(value="/users")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception {
        // Get all users via UserService
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) throws Exception {
        // Get a user by ID via UserService
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {
        // Create a new user via UserService
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user)
        throws Exception {
        // Update an existing user via UserService
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) throws Exception {
        // Delete a user via UserService
        userService.deleteUser(id);
    }
}
