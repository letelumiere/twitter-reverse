package com.letelumiere.twitterreverse.domain.api.model.tweets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder
@Table(name = "tweet")
public class Tweet {

    @Id
	@SequenceGenerator(name = "tweet_sequence", sequenceName = "tweet_sequence", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tweet_sequence")
	private Long twitId;
	
	@Column(name = " circle")
	private Boolean circle;

	@Column(name = "content")
	private String content; 
	
	@Column(name = "created_at")
	private String createdAt;

}
