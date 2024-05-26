package ma.crud.crudangularspringboot.controller;

import ma.crud.crudangularspringboot.exception.ProductNotFoundException;
import ma.crud.crudangularspringboot.exception.UserNotFoundException;

import ma.crud.crudangularspringboot.model.Product;
import ma.crud.crudangularspringboot.model.User;
import ma.crud.crudangularspringboot.repesitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getAllEmployers(){
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User createEmployer(@RequestBody User user){

        return userRepository.save(user);
    }
    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException("User not found with email: " + email);
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user1=userRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Employer not exit with ID = "+id));
        return ResponseEntity.ok(user1);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity <Map<String,Boolean>> deleteEmployer(@PathVariable Long id){
        System.out.println("Deleted declared 👌👌👌👌");
        User user1=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not exit with ID = "+id));
        userRepository.delete(user1);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
//    @PostMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
//        User user1 =userRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Employer not exit with ID = "+id));
//
//        user1.setUserId(user.getUserId());
//        user1.setUsername(user.getUsername());
//        user1.setPassword(user.getPassword());
//        user1.setRoles(user.getRoles());
//
//        User userUpd=userRepository.save(user1);
//
//        return ResponseEntity.ok(userUpd);
//    }

//    @DeleteMapping("/employers/{id}")
//    public ResponseEntity <Map<String,Boolean>> deleteUser(@PathVariable Long id){
//        User user1=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not exit with ID = "+id));
//        userRepository.delete(user1);
//        Map<String,Boolean> response=new HashMap<>();
//        response.put("deleted",Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }



}
