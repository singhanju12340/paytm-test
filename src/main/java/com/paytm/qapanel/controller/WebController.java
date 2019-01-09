package com.paytm.qapanel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by anjukumari on 14/12/18
 */

@Controller
public class WebController {

    @RequestMapping(value = "welcome")
    public String start() {
        return "welcome";
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        return "signUp";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashbord() {
        return "/dashboard/dashbord";
    }

    @RequestMapping(value = "/permission")
    public String permission() {
        return "/permission";
    }

    @RequestMapping(value = "/userstatus")
    public String userStatus(HttpServletRequest request) {
        System.out.println(request.toString());
        return "/userStatus";
    }



}

