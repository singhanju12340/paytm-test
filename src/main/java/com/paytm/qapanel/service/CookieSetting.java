package com.paytm.qapanel.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class CookieSetting {

    public boolean checkForCookie(HttpServletRequest request, String cookieName){
        String cookiePresent = null;
        Cookie[] cookies = request.getCookies();
        try {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(cookieName))
                        cookiePresent = cookie.getValue();
                }
                    return !cookiePresent.isEmpty();
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("cookie not found");
            return false;
        }
    }
}
