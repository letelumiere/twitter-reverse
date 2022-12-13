package com.letelumiere.twitterreverse.domain.ui.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {
    
    @GetMapping("/settings/profile")
    public void profile(){}

    @GetMapping("/settings/password")
    public void password(){}

    @GetMapping("/settings/notifications")
    public void notifications(){}

    @GetMapping("/settings/account")
    public void account(){}

    @GetMapping("/settings/data_account")
    public void data_account(){}

}
