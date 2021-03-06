package com.yq.blueray.security.controller;


import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.security.po.User;
import com.yq.blueray.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.security.Principal;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check")
    @ResponseBody
    public Msg login(Principal loginedUser, @RequestParam(name = "logout", required = false) String logout) throws Exception{
       throw new NoHandlerFoundException("GET","/check",new HttpHeaders());
    }
}
