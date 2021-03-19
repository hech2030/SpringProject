package com.Main.Security;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //return new User("hichem",passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
        AppUser user = userRepository.findByEmail(username);
        if(user == null){
            try {
                throw new NotFoundException("user not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public void save(AppUser user){
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public List<AppUser> find(){
        return userRepository.findAll();
    }
}
