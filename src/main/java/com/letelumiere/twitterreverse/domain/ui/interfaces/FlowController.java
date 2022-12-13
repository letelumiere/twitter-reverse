package com.letelumiere.twitterreverse.domain.ui.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/i/flows")
public class FlowController {
    
    @GetMapping("/login")
    public void login(){}

    @GetMapping("/password_reset")
    public void password_reset(){}

    @GetMapping("/single_log_on")
    public void logOn(){}
    
}
