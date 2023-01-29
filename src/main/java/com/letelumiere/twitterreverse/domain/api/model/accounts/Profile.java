package com.letelumiere.twitterreverse.domain.api.model.accounts;

import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity(name = "profile")
@DiscriminatorValue(value = "profile")
@PrimaryKeyJoinColumn(name = "origin_id")
@AllArgsConstructor
@Builder
public class Profile extends Origin {

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