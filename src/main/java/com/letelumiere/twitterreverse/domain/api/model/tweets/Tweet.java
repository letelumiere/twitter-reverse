package com.letelumiere.twitterreverse.domain.api.model.tweets;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Origin;

import lombok.Builder;

@Entity
@Table(name = "tweet")
@SequenceGenerator(
	name = "tweet_sequence", 
	sequenceName = "tweet_sequence",
	initialValue = 1, 
	allocationSize = 1
) 
@Builder
public class Tweet { 
	
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tweet_sequence")
	private Long twitId;
	
	@Column(name = " circle")
	private Boolean circle;

	@Column(name = "content")
	private String content; 
	
	@Column(name = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date createdTime;

	@ManyToOne
	@JoinColumn(name = "origin")
	private Origin origin;
}
