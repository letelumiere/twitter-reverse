package com.letelumiere.twitterreverse.domain.api.accounts;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "profile")
@DiscriminatorValue(value = "profile")
@PrimaryKeyJoinColumn(name = "origin_id")
@NoArgsConstructor
public class Profile extends Account {

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
		

	@Builder
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