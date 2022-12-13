package com.letelumiere.twitterreverse.domain.ui.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class InterfaceController {
    
    @GetMapping("/explore")
    public void explore(){}
    
    @GetMapping("/notifications")
    public void notifications(){}

    @GetMapping("/messages")
    public void messages(){}

    @GetMapping("/i/bookmarks")
    public void bookmarks(){}

    @GetMapping("/origin_id/lists")
    public void lists(){}

    @GetMapping("/settings")
    public void settings(){}

    @GetMapping("/account/switch")
    public void acccount_switch(){}
}
