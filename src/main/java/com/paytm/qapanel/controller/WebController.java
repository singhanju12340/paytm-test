package com.paytm.qapanel.controller;

import com.paytm.qapanel.service.CookieSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by anjukumari on 14/12/18
 */

@Controller
public class WebController {
    @Autowired
    CookieSetting cookieSetting;

    @RequestMapping(value = "welcome")
    public String start() {
        return "welcome";
    }


    @RequestMapping(value = "/signup")
    public String signup() {
        return "signUp";
    }

    @RequestMapping(value = "/newUserSignup")
    public String signup1() {
        return "signUp";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }


    //@RequestMapping(value = "/dashboard")
    //public String users() {
        //return "/dashboard/environment";}

    @RequestMapping(value = "/permission")
    public String permission() {
        return "/permission";
    }

    @RequestMapping(value = "/userstatus")
    public String userStatus(HttpServletRequest request) {
        System.out.println(request.toString());
        return "/userStatus";
    }

    @RequestMapping(value = "/try")
    public String test()
    {
        return "/TryPermission";
    }


    @RequestMapping(value = "/dash")
    public String test1()
    {
        return "/dashboard/dash";
    }

    @RequestMapping(value = "/dashboard")
    public String test3( HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(cookieSetting.checkForCookie(request, "user"))
            return "dashboard/dashbord";
        else
            return "/login";
    }


}

