package net.kj7.user_service.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.kj7.user_service.dto.UserRequest;
import net.kj7.user_service.entity.User;
import net.kj7.user_service.mapper.UserMapper;
import net.kj7.user_service.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(serviceName = "UserWS")
public class UserSoapService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @WebMethod
    public List<User> userList() {
        return userRepository.findAll();
    }

    @WebMethod
    public User userById(@WebParam(name = "id") Long id){
        return userRepository.findById(id).get();
    }

    public User saveUser(@WebParam UserRequest userRequest){
        User user = userMapper.from(userRequest);
        return  userRepository.save(user);
    }
}
