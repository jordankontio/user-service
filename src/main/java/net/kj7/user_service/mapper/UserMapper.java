package net.kj7.user_service.mapper;

import net.kj7.user_service.dto.UserRequest;
import net.kj7.user_service.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper mapper = new ModelMapper();

    public User from(UserRequest userRequest) {
        return mapper.map(userRequest, User.class);
    }
}
