package fmi.pserasmusip.dao;

import fmi.pserasmusip.entity.User;
import java.util.List;

public interface UserDAOInterface {
    User getUserById(int id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
