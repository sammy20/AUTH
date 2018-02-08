package fmi.pserasmusip.service;

import java.util.List;

import fmi.pserasmusip.DTO.UserDTO;
import fmi.pserasmusip.dao.UserRepository;
import fmi.pserasmusip.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fmi.pserasmusip.entity.User;
import org.springframework.transaction.annotation.Transactional;


@Service
public interface UserService {

     User registerNewUserAccount(UserDTO accountDto) throws UserAlreadyExistException;

     User findByUsername(String username);

     User getUserById(int id);

     List<User> getAllUsers();


     void deleteUser(String username);

//    private UserRepository userDAO;
//
//    @Autowired
//    public UserService(UserRepository userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    public User getUserById(int id) {
//        return userDAO.findOne(id);
//    }
//
//    public User findUserByUsername(String username) {
//        return userDAO.findUserByUsername(username);
//    }
//
//    public List<User> getAllUsers(){
//        return this.userDAO.findAll();
//    }
//
//    public User addUser(User user) throws UserExists{
//
//        int id = user.getId();
//        if(getUserById(id) != null){
//            throw new UserExists("User already exists");
//        }
//        return this.userDAO.save(user);
//    }
//
////    public void updateUser(int userId) {
////        userDAO.updateUser(userI);
////    }
//
//    @Transactional
//    public void deleteUser(String username) {
//        userDAO.deleteUserByUsername(username);
//    }
////
////    public User userLogin(String username, String password){
////        return userDAO.credentialsValid(username, password);
////    }
}
