package com.letelumiere.twitterreverse.domain.api.model.twitterData;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ColumnDefault;

import com.letelumiere.twitterreverse.domain.api.model.origin.Origin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "twitter_data")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TwitterData {

	@Id
	@Column(name = "origin_id")
	private Long id;

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
