package com.letelumiere.twitterreverse.domain.api;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.letelumiere.twitterreverse.domain.api.services.SettingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    
    @Autowired private final AccountService accountService;
    @Autowired private final SettingService settingService;

    //이상 없음
    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAccount(){
        return ResponseEntity.ok(accountService.getAccountAll());
    }

    //로그인 혹은 회원 가입 시 중복되는 이메일, 전화번호, screenName, 조회.
    @GetMapping("/account/check/{text}")
    public ResponseEntity<Account> getAccountInfo(@PathVariable String text){
        if(text.contains("@")) return ResponseEntity.ok(accountService.getEmail(text));
        
        return text.matches("^[a-zA-z]*$") ?
            ResponseEntity.ok(accountService.getScreenName(text)) 
            : ResponseEntity.ok(accountService.getPhone(Integer.parseInt(text)));
    }

    //이상 없음 - profile의 entity 혹은 data로 해야 함. join 관계 필요
    @GetMapping("/{screenName}")
    public ResponseEntity<Account> getAccountByScreenName(@PathVariable String screenName){
        return ResponseEntity.ok(accountService.getScreenName(screenName));
    }

    @PostMapping("/signin")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/account/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.signUpAccount(account));
    }

    //계정 정보 update 서비스 로직. 추후에 보완할 예정
    //view에서의 uri는 %domain%/settings/your_twitter_data/account 임
    //해당 view에서 각각의 컨트롤러 객체를 가져오는 듯  
    @PutMapping("/settings/screen_name/{screen_name}")
    public ResponseEntity<Account> findAndUpdateScreenName(@PathVariable String ScreenName, @RequestBody Account account){
        settingService.findAndUpdateScreenName(ScreenName, account);
        return ResponseEntity.ok().build();
    }
    
    //front-end에서 fetch로 reponse하는 듯? 
    @PutMapping("/settings/password/")
    public ResponseEntity<Account> findAndUpdatePassword(@PathVariable String password, @RequestBody Account account){
        settingService.findAndUpdatePassword(password, account);
        return ResponseEntity.ok().build();
    }

    //
    @DeleteMapping("/signout/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable long id){    //추후에 requestBody 넣을 것
        Account account = accountService.getReferenceId(id);
        accountService.signOutAccount(account);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    
}
