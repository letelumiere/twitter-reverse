package com.letelumiere.twitterreverse.domain.ui.composes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComposeController {
    
    @GetMapping("/compose/tweet")
    public void tweet(){}
    
    @GetMapping("/compose/message")
    public void message(){}

    @GetMapping("/compose/notifications")
    public void notifications(){}

    @GetMapping("/compose/bookmarks")
    public void bookmarks(){}

    @GetMapping("/compose/retweets")
    public void retweets(){}

    @GetMapping("/compose/replies")
    public void replies(){}

    @GetMapping("/compose/likes")
    public void likes(){}

    @GetMapping("/compose/favorites")
    public void favorites(){}
    
}
