package com.Main.Init;

import com.Main.Security.AppUser;
import com.Main.Security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Initializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(Initializer.class);

    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        if(userService.find().isEmpty()){
            logger.info("No user found");
            AppUser user = new AppUser("hichem","Fakhfakh","53033545","Sfax",false,
                    false,true,new Date(),"hichemfakhfakh@hotmail.fr","password");
            userService.save(user);
        }
    }
}
