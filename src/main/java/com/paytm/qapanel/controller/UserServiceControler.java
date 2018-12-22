package com.paytm.qapanel.controller;

import com.paytm.qapanel.model.UserDto;
import com.paytm.qapanel.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by anjukumari on 05/12/18
 */
@RestController
public class UserServiceControler {
    @Autowired
    private CreateUserService createUserService;

    @PostMapping(value = "/login")
    public String login(final HttpServletRequest request)
    {
        System.out.println("login request is: "+request.toString());
        UserDto userDto = createUserService.UserBeanCreator(request);
        return  createUserService.validateUser(userDto);
    }

    @RequestMapping(
            value = "/signup",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE
    )
    public String addUser(final HttpServletRequest request) {
        System.out.println("signup request is: "+request.toString());
        UserDto userDto = createUserService.UserBeanCreator(request);
        return createUserService.createUser(userDto.getEmail(), userDto.getName(),userDto.getPassword());
    }




}
