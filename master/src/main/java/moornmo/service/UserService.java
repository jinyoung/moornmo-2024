package moornmo.service;

import java.util.List;
import java.util.Optional;
import moornmo.domain.*;

public interface UserService {
    List<User> getAllUsers() throws Exception;
    Optional<User> getUserById(Long id) throws Exception;
    User createUser(User user) throws Exception;
    User updateUser(User user) throws Exception;
    void deleteUser(Long id) throws Exception;
}
