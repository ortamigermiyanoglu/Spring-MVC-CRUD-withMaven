package com.sumutella.departmentcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sumutella
 * @time 1:47 PM
 * @since 11/12/2019, Tue
 */
@Controller
public class MySpringSecurityDemoController {


    @GetMapping("/my-login")
    public String showLogin(){
        return "login";
    }
}
