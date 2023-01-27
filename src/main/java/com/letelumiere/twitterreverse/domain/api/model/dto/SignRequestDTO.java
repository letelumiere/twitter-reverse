package com.letelumiere.twitterreverse.domain.api.model.dto;

import lombok.*;



//DTO for Account Entity

@Data
@AllArgsConstructor
public class SignRequestDTO {
	private String screenName; 
	private String email;
	private String password;
	private Integer phone;
}
