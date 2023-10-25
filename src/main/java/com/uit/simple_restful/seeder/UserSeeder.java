package com.uit.simple_restful.seeder;

import com.uit.simple_restful.entity.User;
import com.uit.simple_restful.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class UserSeeder {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @EventListener
    public void seedUser(ContextRefreshedEvent e){

        User user=userRepository.findByUsername("admin");
        if(user==null){
            user=new User();
            user.setUsername("admin");
            user.setRole("ADMIN");
            user.setPassword(passwordEncoder.encode("1234"));
            userRepository.save(user);
        }

    }
}
