package repository;

import model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by azburatura on 8/2/2016.
 */
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public List<User> findAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    public User findUser(long id){
        return entityManager.find(User.class, id);
    }

    public void deleteUser(User user) {
        entityManager.remove(entityManager.merge(user));
    }

}
