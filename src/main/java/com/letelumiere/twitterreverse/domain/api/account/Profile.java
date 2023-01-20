package com.letelumiere.twitterreverse.domain.api.account;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "profile")
@DiscriminatorValue(value = "DTYPE")
@PrimaryKeyJoinColumn(name = "origin_id")
@NoArgsConstructor
public class Profile extends Account {

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
		
	public Profile(Long id, String screenName, String email, String password, Integer phone, Date createdTime,
			String header, String nickname, String photo, String location, String website, String birth,
			String introduce, Date modifiedTime) {
		super(id, screenName, email, password, phone, createdTime);
		this.header = header;
		this.nickname = nickname;
		this.photo = photo;
		this.location = location;
		this.website = website;
		this.birth = birth;
		this.introduce = introduce;
		this.modifiedTime = modifiedTime;
	}
	
	public static Profile superFrom(){
		return new Profile(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}
}