package moornmo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import moornmo.domain.User;
import moornmo.domain.UserRepository;
import moornmo.service.UserService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl
    extends EgovAbstractServiceImpl
    implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        UserServiceImpl.class
    );

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws Exception {
        // Get all users
        return StreamSupport
            .stream(userRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUserById(Long id) throws Exception {
        // Get a user by ID
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) throws Exception {
        // Create a new user
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        // Update an existing user via UserService
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        // Delete a user
        userRepository.deleteById(id);
    }
}
