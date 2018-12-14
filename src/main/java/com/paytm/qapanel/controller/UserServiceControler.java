package com.paytm.qapanel.controller;

import com.paytm.qapanel.model.UserDto;
import com.paytm.qapanel.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by anjukumari on 05/12/18
 */
@RestController
public class UserServiceControler {
    @Autowired
    private CreateUserService createUserService;

    @PostMapping(value = "/login")
    public void login(@RequestBody UserDto userDto) {
        createUserService.validateUser(userDto);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@RequestBody UserDto userDto) {
        System.out.print("new user for signup");
        return createUserService.createUser(userDto.getEmail(), userDto.getName(),userDto.getPassword());
    }




}
