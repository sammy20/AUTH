package fmi.pserasmusip.service;

import java.util.List;
import fmi.pserasmusip.entity.User;

public interface UserServiceInterface {
    User getUserById(int id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}