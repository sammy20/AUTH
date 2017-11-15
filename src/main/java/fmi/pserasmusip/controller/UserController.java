package fmi.pserasmusip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import fmi.pserasmusip.entity.User;
import fmi.pserasmusip.service.UserServiceInterface;

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
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        userService.addUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
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