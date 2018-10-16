package com.yq.blueray.security.controller;


import com.yq.blueray.common.utils.Msg;
import com.yq.blueray.security.po.User;
import com.yq.blueray.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public Msg login(@AuthenticationPrincipal @RequestBody User loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        };
        return Msg.success();
    }
}
