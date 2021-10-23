package backend.gym.gymmanager.controllers;

import backend.gym.gymmanager.model.Role;
import backend.gym.gymmanager.model.User;
import backend.gym.gymmanager.services.RoleService;
import backend.gym.gymmanager.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;
    private RoleService roleService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.save(user));
    }

    @PostMapping("/userrole/save")
    public ResponseEntity<?>addRoleToUser(@RequestBody User user, Role role){
        userService.addRoleToUser(user,role);
        return ResponseEntity.ok().build();
    }

}
