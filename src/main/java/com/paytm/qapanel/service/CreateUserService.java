package com.paytm.qapanel.service;

import com.paytm.qapanel.dao.entity.User;
import com.paytm.qapanel.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.paytm.qapanel.dao.repo.UserRepo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by anjukumari on 04/12/18
 */

@Service
public class CreateUserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public String createUser(String email,String name, String password) {
        User user = userRepo.findByEmail(email);
        System.out.println(email);
        if(null != user && null !=user.getEmail()) {
            return "user already exist";
        }
        user = new User(email, name, password);
        user = userRepo.save(user);
        return "user registered successfully";
    }


    public String validateUser(UserDto userDto) {
        User user = userRepo.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if(null != user && null !=user.getEmail()) {
            return user.toString();
        }else {
            return "user does not exist";
        }
    }



    public String testLogin()
    {


        return null;
    }
}
