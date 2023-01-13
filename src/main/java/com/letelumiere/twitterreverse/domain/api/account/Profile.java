package com.letelumiere.twitterreverse.domain.api.account;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Builder;
import lombok.Getter;		
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "profile")
@DiscriminatorValue("profile")
@PrimaryKeyJoinColumn(name = "origin_id")
@NoArgsConstructor
public class Profile extends Account{
	@Column(name = "header")
	String header;

	@Column(name = "nickname")
	String nickname;
	
	@Column(name = "photo")
	String photo;

	@Column(name = "location")
	String location;
	
	@Column(name = "website")
	String website;
	
	@Column(name = "birth")
	String birth;

	@Column(name = "introduce")
	String introduce;
	
	@Column(name = "modifiedTime")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	Date modifiedTime;

	public Profile(String screenName, String email, String password, Integer phone, String header, String nickname,
			String photo, String location, String website, String birth, String introduce, Date modifiedTime) {
		super(screenName, email, password, phone);
		this.header = header;
		this.nickname = nickname;
		this.photo = photo;
		this.location = location;
		this.website = website;
		this.birth = birth;
		this.introduce = introduce;
		this.modifiedTime = modifiedTime;
	}


	public static Profile from(String screenName, String email, String password, Integer phone, String header, String nickname,
			String photo, String location, String website, String birth, String introduce, Date modifiedTime) {
		return new Profile(screenName, email, password, phone, header, nickname, photo, location, website, birth, introduce, modifiedTime);
	}

}
