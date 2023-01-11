package com.letelumiere.twitterreverse.domain.api.model.dto;

import com.letelumiere.twitterreverse.domain.api.account.Account;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class AccountDTO {
	private String screenName; 
	private String email;
	private String password;
	private Integer phone;

    
    @Builder
    public AccountDTO(String screenName, String email, String password, Integer phone) {
        this.screenName = screenName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }


    public Account toEntity(){
        return Account.builder()
                .screenName(screenName)
                .email(email)
                .password(password)
                .phone(phone)
                .build();
    }
}
