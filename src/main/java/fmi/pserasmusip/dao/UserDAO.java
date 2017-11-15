package fmi.pserasmusip.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fmi.pserasmusip.entity.User;

@Transactional
@Repository
public class UserDAO implements UserDAOInterface {
    
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        String hql = "FROM User as usr ORDER BY usr.id";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(User user) {
        User usr = getUserById(user.getId());
        usr.setUsername(user.getUsername());
        usr.setPassword(user.getPassword());
        usr.setRole(user.getRole());
        usr.setEmail(user.getEmail());
        entityManager.flush();
    }
    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserById(id));
    }
}
