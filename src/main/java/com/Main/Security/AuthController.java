package com.Main.Security;

import antlr.Token;
import com.Main.Request.FindUserRequest;
import com.Main.Request.SaveUserRequest;
import com.Main.Response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = {"","/"})
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUserName(),signInRequest.getPassword())
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUserName());
        String token = tokenUtil.TokenGeneration(userDetails);
        JwtResponse response = new JwtResponse(token);
        return response;
    }

    @PostMapping(value = "/Save")
    public ResponseBase Save(@RequestBody SaveUserRequest saveUserRequest) throws Exception{
        ResponseBase response = new ResponseBase();
        try {
            if(saveUserRequest.isValid()){
                var result = this.userService.save(saveUserRequest);
                response.setValue(result);
                return response;
            }
            throw new Exception("Request is not valid");
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        }
    }

    @PostMapping(value = "/FindUser")
    public ResponseBase FindUser(@RequestBody FindUserRequest findUserRequest) {
        ResponseBase response = new ResponseBase();
        try {
            var result = this.userService.find(findUserRequest.getId());
            if (!result.isEmpty())
                response.setValue(result.get(0));
            return response;
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        }
    }

}
