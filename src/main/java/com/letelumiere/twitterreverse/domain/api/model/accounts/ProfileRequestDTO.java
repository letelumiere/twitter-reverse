package com.letelumiere.twitterreverse.domain.api.model.accounts;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//DTO for Profile Entity

@Data
@AllArgsConstructor
public class ProfileRequestDTO {
	private String header;
	private String nickname;
	private String photo;
	private String location;
	private String website;
	private String birth;
	private String introduce;
	private Date modifiedTime;
}
