package fmi.pserasmusip.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fmi.pserasmusip.dao.UserDAOInterface;
import fmi.pserasmusip.entity.User;

@Service
public class UserService implements UserServiceInterface {
    
    @Autowired
    private UserDAOInterface userDAO;
    @Override
    public User getUserById(int id) {
        User user = userDAO.getUserById(id);
        return user;
    }
    @Override
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
    @Override
    public synchronized void addUser(User user){
        userDAO.addUser(user);
    }
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}