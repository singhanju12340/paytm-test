package com.paytm.qapanel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paytm.qapanel.model.Permission;
import com.paytm.qapanel.model.UserDto;
import com.paytm.qapanel.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by anjukumari on 05/12/18
 */
@RestController
public class UserServiceControler {
    @Autowired
    private CreateUserService createUserService;

    @PostMapping(value = "/login")
    public void login(final HttpServletRequest request, final HttpServletResponse response) throws IOException,ServletException
    {
        RequestDispatcher dispatcher;
        UserDto userDto = createUserService.UserBeanCreator(request);
        if(createUserService.validateUser(userDto)) {
             dispatcher = request.getRequestDispatcher("/dashboard");

        }else{
             dispatcher = request.getRequestDispatcher("/newUserSignup");

        }
        dispatcher.include(request, response);
    }

    @RequestMapping(
            value = "/signup",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE
    )
    public String addUser(final HttpServletRequest request) throws JsonProcessingException {
        System.out.println("signup request is: "+request.toString());
        UserDto userDto = createUserService.UserBeanCreator(request);
        return createUserService.createUser(userDto.getEmail(), userDto.getName(),userDto.getPassword());
    }

    @RequestMapping(
            value = "/changePermission",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE
    )
    public String changePermission(final HttpServletRequest request) throws JsonProcessingException {
        System.out.println("signup request is: "+request.toString());
        UserDto userDto = createUserService.UserBeanCreator(request);
        return createUserService.createUser(userDto.getEmail(), userDto.getName(),userDto.getPassword());
    }

    @RequestMapping(
            value = "/getPermission",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE
    )
    public String getPermission(final HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println(name);
        Permission permission = createUserService.getUserPermission(name);
        String panel = permission.getPanelPermission();
        String db = permission.getDbPermission();
       // env = permission.getEnvironment();


        return "hello"+name;
    }


}
