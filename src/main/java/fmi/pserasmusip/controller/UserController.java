package fmi.pserasmusip.controller;

import java.util.List;

import fmi.pserasmusip.DTO.UserDTO;
import fmi.pserasmusip.dao.UserRepository;
import fmi.pserasmusip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fmi.pserasmusip.entity.User;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
    public UserController(UserService userService,
                          UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody UserDTO userDTO) {
       userService.registerNewUserAccount(userDTO);
    }


    @GetMapping(value = "")
    public ResponseEntity<User> getUserById(@RequestParam("id") int id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<User> getUserByName(@RequestParam("username") String username){
       User user = userService.findByUsername(username);
       return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



//    @PostMapping("/login")
//    public ResponseEntity<User> userLogin(@RequestBody Map<String,String> credentials){
//        User user = userService.userLogin(credentials.get("username"), credentials.get("password"));
//        if(user == null){
//            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
//        }
//        else{
//            return new ResponseEntity<User>(user,HttpStatus.OK);
//        }
//    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam(value = "username") String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("User deleted",HttpStatus.OK);
    }


}