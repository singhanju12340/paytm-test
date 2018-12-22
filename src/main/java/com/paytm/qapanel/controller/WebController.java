package com.paytm.qapanel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

