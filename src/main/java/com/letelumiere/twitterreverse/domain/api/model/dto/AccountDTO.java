package com.letelumiere.twitterreverse.domain.api.model.dto;

import com.letelumiere.twitterreverse.domain.api.model.entity.Account;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
public class AccountDTO {
	private Long id;
	private String screenName; 
	private String email;
	private String password;
	private Integer phone;

    @Builder
    public AccountDTO(Account entity){
        this.id = entity.getId();
        this.screenName = entity.getScreenName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.phone = entity.getPhone();
    } 

    public Account toEntity(){
        return Account.builder().screenName(screenName).email(email).password(password).phone(phone).build();
    }
}
