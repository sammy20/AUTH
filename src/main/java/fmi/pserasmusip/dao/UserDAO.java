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

    @Override
    public boolean userExists(String username){
        String hql = "FROM User as usr WHERE BINARY usr.username = ?";
        int count =  entityManager.createQuery(hql)
                .setParameter(1,username)
                .getResultList()
                .size();
        return count > 0;
    }

    @Override
    public User credentialsValid(String username, String password){
        String hql = "FROM User as usr WHERE usr.username LIKE CAST(? as binary) AND usr.password LIKE CAST(? as binary)";
        User user = null;
        List<User> list = entityManager.createQuery(hql)
                .setParameter(1, username)
                .setParameter(2,password)
                .getResultList();
        if(list.size() > 0){
            user = list.get(0);
        }
        return user;
    }
}
