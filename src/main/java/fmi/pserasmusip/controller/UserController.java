package fmi.pserasmusip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import fmi.pserasmusip.entity.User;
import fmi.pserasmusip.service.UserServiceInterface;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody Map<String,String> credentials){
        User user = userService.userLogin(credentials.get("username"), credentials.get("password"));
        if(user == null){
            return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<User>(user,HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Boolean> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        if(!userService.addUser(user)){
            return new ResponseEntity<Boolean>(false,HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}  