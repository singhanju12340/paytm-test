package com.paytm.qapanel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.qapanel.dao.entity.User;
import com.paytm.qapanel.dao.entity.UserPermission;
import com.paytm.qapanel.dao.repo.PermissionRepo;
import com.paytm.qapanel.model.Permission;
import com.paytm.qapanel.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.paytm.qapanel.dao.repo.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by anjukumari on 04/12/18
 */

@Service
public class CreateUserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PermissionRepo permissionRepo;


    @Transactional
    public String createUser(String email,String name, String password) throws JsonProcessingException {
        User user = userRepo.findByEmail(email);
        System.out.println(email);
        if(null != user && null !=user.getEmail()) {
            return "user already exist";
        }
        user = new User(email, name, password);
        user = userRepo.save(user);
        ObjectMapper mapper = new ObjectMapper();
        String permission = mapper.writeValueAsString(new Permission());
        UserPermission userPermission = new UserPermission(String.valueOf(user.getId()),permission);

        permissionRepo.save(userPermission);

        return "user registered successfully";
    }


    public Boolean validateUser(UserDto userDto) {
        User user = userRepo.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
        if(null != user && null !=user.getEmail()) {
            return true;
        }else {
            return false;
        }
    }

    public UserDto UserBeanCreator(HttpServletRequest request){
        UserDto userDto = new UserDto();
        userDto.setName(request.getParameter("name"));
        userDto.setEmail(request.getParameter("email"));
        userDto.setPassword(request.getParameter("password"));
        return userDto;
    }

    /*public void changeUserPermission(Permission permission, String name){
        User user = userRepo.findByName(name);
        UserPermission userPermission = new UserPermission(String.valueOf(user.getId()),permission);
        permissionRepo.save(userPermission);
    }*/

    public Permission getUserPermission(String name){
        User user = userRepo.findByName(name);
        UserPermission currentPermission = permissionRepo.findByuserId(String.valueOf(user.getId()));
        ObjectMapper mapper = new ObjectMapper();
        Permission permission = null;
        try {
            permission = mapper.readValue(currentPermission.getPermission(), Permission.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return permission;
    }


}
