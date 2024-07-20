package net.kj7.user_service;

import net.kj7.user_service.entity.User;
import net.kj7.user_service.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository){
        return args -> {
          userRepository.save(User.builder().name("Mathis").email("mathis@gmail.com").build());
          userRepository.save(User.builder().name("Mewen").email("mewen@gmail.com").build());
          userRepository.save(User.builder().name("Carmelle").email("carmelle@gmail.com").build());
          userRepository.save(User.builder().name("Princesse").email("princesse@gmail.com").build());
          userRepository.save(User.builder().name("Jordan").email("jordan@gmail.com").build());
        };
    }
}
