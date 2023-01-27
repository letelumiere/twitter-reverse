package com.letelumiere.twitterreverse.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //여기는 트위터 메인 화면이 떠야 함 -> view에서의 UI만 담당하는 듯
    @GetMapping("/home")
    public String home(){
        return "Home";
    }

}
