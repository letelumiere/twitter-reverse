package com.letelumiere.twitterreverse.domain.api;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.letelumiere.twitterreverse.domain.api.account.Account;
import com.letelumiere.twitterreverse.domain.api.services.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    
    @Autowired
    private final AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAccount(){
        return ResponseEntity.ok(accountService.getAccountAll());
    }

    @GetMapping("/{screenName}")
    public ResponseEntity<Account> getAccountByScreenName(@PathVariable String screenName){
        return ResponseEntity.ok(accountService.getScreenName(screenName));
    }

    @PostMapping("/signin")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/account/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.signUpAccount(account));
    }

    /*계정 정보 update 서비스 로직. 추후에 보완할 예정
    @PutMapping
    public ResponseEntity<Account> modifyAccount(@PathVariable long id, @RequestBody Account account){
        accountService.findAndUpdateAccount(long id);
        return ResponseEntity.ok().build();
    }
    */

    
    //
    @DeleteMapping("/signout/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable long id){    //추후에 requestBody 넣을 것
        Account account = accountService.getReferenceId(id);
        accountService.signOutAccount(account);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    
}
