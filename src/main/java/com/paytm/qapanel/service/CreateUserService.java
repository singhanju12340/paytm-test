package com.paytm.qapanel.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.qapanel.dao.entity.User;
import com.paytm.qapanel.dao.entity.UserPermission;
import com.paytm.qapanel.dao.repo.PermissionRepo;
import com.paytm.qapanel.model.Permission;
import com.paytm.qapanel.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.paytm.qapanel.dao.repo.UserRepo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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
    public String createUser(String email,String name, String password) {
        User user = userRepo.findByEmail(email);
        System.out.println(email);
        if(null != user && null !=user.getEmail()) {
            return "user already exist";
        }
        user = new User(email, name, password);
        user = userRepo.save(user);
        UserPermission userPermission = new UserPermission(user.getId(),new Permission());
        permissionRepo.save(userPermission);

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

    public UserDto UserBeanCreator(HttpServletRequest request){
        UserDto userDto = new UserDto();
        userDto.setName(request.getParameter("name"));
        userDto.setEmail(request.getParameter("email"));
        userDto.setPassword(request.getParameter("password"));
        return userDto;
    }

    public void changeUserPermission(Permission permission, String name){
        User user = userRepo.findByName(name);
        UserPermission userPermission = new UserPermission(user.getId(),permission);
        permissionRepo.save(userPermission);
    }

    public Permission getUserPermission(String name){
        User user = userRepo.findByName(name);
        UserPermission currentPermission = permissionRepo.findByuserId(String.valueOf(user.getId()));
        ObjectMapper mapper = new ObjectMapper();
        Permission permission = mapper.convertValue(currentPermission.getPermission(), Permission.class);
        return permission;
    }


}
