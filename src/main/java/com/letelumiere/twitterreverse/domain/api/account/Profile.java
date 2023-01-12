package com.letelumiere.twitterreverse.domain.api.account;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;		
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "profile")
@NoArgsConstructor
@DiscriminatorValue("profile")
@PrimaryKeyJoinColumn(name="origin_id")
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
	
	
    //createdTime // ip포함.
    //country
    //gender
    //birth
    //age
    //languages = List<String>
}
