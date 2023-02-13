package com.letelumiere.twitterreverse.domain.api.model.profile;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;
import com.letelumiere.twitterreverse.domain.api.model.origin.Origin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Profile {
	
	@Id
	@Column(name = "origin_id")
	private Long id;

	@Column(name = "header")
	private String header;

	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "photo")
	private String photo;

	@Column(name = "location")
	private String location;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "birth")
	private String birth;

	@Column(name = "introduce")
	private String introduce;
	
	@Column(name = "modifiedTime")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedTime;
}