package net.kj7.user_service.web;

import lombok.AllArgsConstructor;
import net.kj7.user_service.entity.User;
import net.kj7.user_service.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserRestController {
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User userById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
          userRepository.save(user);
        return user;
    }
}
