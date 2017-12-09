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
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    @Override
    public synchronized boolean addUser(User user){
        if(userDAO.userExists(user.getUsername())){
            return false;
        }
        else{
            userDAO.addUser(user);
            return true;
        }
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }

    @Override
    public User userLogin(String username, String password){
        return userDAO.credentialsValid(username, password);
    }
}