package com.letelumiere.twitterreverse.domain.api.account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "twitter_data")
@NoArgsConstructor
@DiscriminatorValue(value = "twitter_data")
@PrimaryKeyJoinColumn(name = "origin_id")
public class Twitter_data extends Account {

	@Column(name = "verifications")
	@ColumnDefault(value = "FALSE")
	private Boolean verifications;

	@Column(name = "premium_verifications")
	@ColumnDefault(value = "FALSE")
	private Boolean premium_verifications;

	@Column(name = "nationality")
	private String nationality;

	@Column(name = "languages")
	private ArrayList<String> languages;
}
