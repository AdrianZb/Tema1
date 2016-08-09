package service.impl;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserRepository;
import service.UserService;

import java.util.List;

/**
 * Created by azburatura on 8/2/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Transactional
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Transactional
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    @Transactional
    public User findUser(long id) {
        return userRepository.findUser(id);
    }
}
