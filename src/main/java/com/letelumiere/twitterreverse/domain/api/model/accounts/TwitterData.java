package com.letelumiere.twitterreverse.domain.api.model.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ColumnDefault;

import lombok.NoArgsConstructor;

@Entity(name = "twitter_data")
@NoArgsConstructor
@DiscriminatorValue(value = "twitter_data")
@PrimaryKeyJoinColumn(name = "origin_id")
public class TwitterData extends Origin {

	@Column(name = "verifications")
	@ColumnDefault(value = "FALSE")
	private Boolean verifications;

	@Column(name = "premium_verifications")
	@ColumnDefault(value = "FALSE")
	private Boolean premiumVerifications;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "role")
	private String role;

	@Column(name = "languages")
	private ArrayList<String> languages;

	
}
