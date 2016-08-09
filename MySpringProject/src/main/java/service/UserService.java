package service;

import model.User;

import java.util.List;

/**
 * Created by azburatura on 8/2/2016.
 */
public interface UserService {

    void saveUser(User user);

    List<User> findAllUsers();

    void deleteUser(User user);

    User findUser(long id);

}
