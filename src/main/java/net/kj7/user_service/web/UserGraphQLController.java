package net.kj7.user_service.web;

import lombok.AllArgsConstructor;
import net.kj7.user_service.dto.UserRequest;
import net.kj7.user_service.entity.User;
import net.kj7.user_service.mapper.UserMapper;
import net.kj7.user_service.repository.UserRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserGraphQLController {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @QueryMapping
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @QueryMapping
    public User userById(@Argument Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) throw new RuntimeException(String.format("User with id= %s not found ", id));
        return user;
    }

    @MutationMapping
    public User saveUser(@Argument UserRequest userRequest) {
        User user = userMapper.from(userRequest);
        return userRepository.save(user);
    }

}
