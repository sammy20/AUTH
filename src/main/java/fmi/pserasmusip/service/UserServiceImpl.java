package fmi.pserasmusip.service;

import fmi.pserasmusip.DTO.UserDTO;
import fmi.pserasmusip.dao.RoleRepository;
import fmi.pserasmusip.dao.UserRepository;
import fmi.pserasmusip.entity.Role;
import fmi.pserasmusip.entity.User;
import fmi.pserasmusip.exceptions.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUserAccount(UserDTO accountDto) throws UserAlreadyExistException {
        if(userRepository.findByUsername(accountDto.getUsername()) != null) {
            throw new UserAlreadyExistException("There is already an account with username: "+ accountDto.getUsername());
        }
        final User user = new User();

        String role1 = "Student";
        String role2 = "Organization";

        user.setUsername(accountDto.getUsername());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        if(accountDto.getRole().equals(role1)) {
            user.setRoles(Arrays.asList(roleRepository.findByRole(role1)));
        }
        else
            if (accountDto.getRole().equals(role2)) {
            user.setRoles(Arrays.asList(roleRepository.findByRole(role2)));
            }

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteUserByUsername(username);
    }
}
