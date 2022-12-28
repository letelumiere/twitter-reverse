package com.letelumiere.twitterreverse.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letelumiere.twitterreverse.domain.api.model.entity.Account;
import com.letelumiere.twitterreverse.domain.api.services.AccountService;

@Controller
public class HomeController {
    @Autowired private AccountService accountService;


    @GetMapping("/home")
    public String home(){
        System.out.println("hi");
        return "Home";
    }


    @GetMapping("/{screenName}")
    public ResponseEntity<Account> user(@PathVariable String screenName){
        return ResponseEntity.ok(accountService.getScreenName(screenName));

    }

}
