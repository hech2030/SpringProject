package com.Main.Security;

import com.Main.Request.SaveUserRequest;
import com.Main.Utils.Extensions;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public AppUser loadUserByUsername(String username) throws UsernameNotFoundException{
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

    public AppUser save(SaveUserRequest saveUserRequest) throws Exception{
        AppUser user = saveUserRequest.getValue();
        if(user.getId() == 0 ){
            var check = loadUserByUsername(user.getUsername());
            if(check == null)
                user.setPassword(passwordEncoder().encode(user.getPassword()));
            else
                throw  new Exception("user exist already");
        }
        else if(saveUserRequest.getIsNewPassword() && !saveUserRequest.getNewPassword().isEmpty()){
            //We need to get the Password from the user(by default we don't send the password to client side)
            var currentPassword = findCredential(user.getId()).getPassword();
            if(passwordEncoder().matches(saveUserRequest.getOldPassword(), currentPassword)){
                user.setPassword(passwordEncoder().encode(saveUserRequest.getNewPassword()));
            }
            else{
                throw new Exception("Old Password is incorrect");
            }
        }
        if(isComplete(user))
            return this.saveUser(user);
        throw new Exception("Error while trying to save user (incomplete model)");
    }

    public List<AppUser> find(Long id){
        if(id > 0){
            var result = userRepository.findById(id);
            if(result.isPresent() && !result.isEmpty() && result.get() != null) {
                //Important : Don't give the client the hashed password
                result.get().setPassword(null);
                return Arrays.asList(result.get());
            }
            return  null;
        }
        var result = userRepository.findAll();
        //Important : Don't give the client the hashed password
        result.forEach((item)-> item.setPassword(null));
        return result;
    }


    public UserDetails findCredential(Long id){
        if(id > 0){
            var result = userRepository.findById(id);
            if(result.isPresent() && !result.isEmpty())
                return result.get();
        }
        return null;
    }

    private AppUser saveUser(AppUser user) throws Exception{
        try{
            return this.userRepository.save(user);
        }catch(Exception ex){
            throw  new Exception("Error while trying to save the user");
        }
    }

    private boolean isComplete(AppUser user){
        if(Extensions.isNullOrEmpty(user.getName()) || Extensions.isNullOrEmpty(user.getLastName()) || Extensions.isNullOrEmpty(user.getEmail()) || Extensions.isNullOrEmpty(user.getPassword()) || Extensions.isNullOrEmpty(user.getLocation()))
            return false;
        return true;
    }
}
