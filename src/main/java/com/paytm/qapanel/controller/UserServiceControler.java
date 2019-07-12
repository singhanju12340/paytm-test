package com.paytm.qapanel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.qapanel.dao.entity.User;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        UserDto userDto          = createUserService.UserBeanCreator(request);
        if(createUserService.validateUser(userDto)) {
            User user = createUserService.getUserByMail(userDto);
            Cookie loginCookie = new Cookie("user",user.getName());
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            response.sendRedirect("/dashboard");
        }else{
             dispatcher = request.getRequestDispatcher("/newUserSignup");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            dispatcher.include(request, response);
        }

    }

    @RequestMapping(
            value = "/signup",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE
    )
    public String addUser(final HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        System.out.println("signup request is: "+request.toString());
        UserDto userDto = createUserService.UserBeanCreator(request);
        return createUserService.createUser(userDto.getEmail(), userDto.getName(),userDto.getPassword());
    }



    @RequestMapping(
            value = "/logout",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE
    )
    public void logOutUser(final HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("signup request is: "+request.toString());
        Cookie[] allCookie = request.getCookies();
        Cookie loginCookie = null;
        if(allCookie != null){
            for(Cookie cookie : allCookie){
                if(cookie.getName().equals("user")){
                    loginCookie = cookie;
                    break;
                }
            }
            if(loginCookie != null){
                loginCookie.setMaxAge(0);
                response.addCookie(loginCookie);
            }
        }
        response.sendRedirect("/login");

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
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Permission getPermission(final HttpServletRequest request) {
        try {

        String name = request.getParameter("name");
            System.out.print(name);
        return createUserService.getUserPermission(name);
//        String panel = permission.getPanelPermission();
//        String db = permission.getDbPermission();
//        ObjectMapper mapper = new ObjectMapper();
//
//            String res = mapper.writeValueAsString(permission);
//            System.out.println(panel);
//            System.out.println(db);
//            //return "hello"+name;
//            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Permission();
        }
    }

    @RequestMapping(
            value = "/getPermissionPanel",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE
    )
    public String getPermissionPanel(final HttpServletRequest request) {
            String name = request.getParameter("name");
            Permission permission = createUserService.getUserPermission(name);
            String panel = permission.getPanelPermission();

            System.out.println(panel);
            //return "hello"+name;
            return panel;
    }

    @RequestMapping(
            value = "/getPermissionEnv",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE
    )
    public String getPermissionEnv(final HttpServletRequest request) {
            String name = request.getParameter("name");
            Permission permission = createUserService.getUserPermission(name);
            String env = permission.getEnvironment().get(0);
            //return "hello"+name;
            return env;

    }

    @RequestMapping(
            value = "/getPermissionDB",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE
    )
    public String getPermissionDB(final HttpServletRequest request) {
            String name = request.getParameter("name");
            Permission permission = createUserService.getUserPermission(name);
            String db = permission.getDbPermission();
            System.out.println(db);
            //return "hello"+name;
            return db;

    }





}
