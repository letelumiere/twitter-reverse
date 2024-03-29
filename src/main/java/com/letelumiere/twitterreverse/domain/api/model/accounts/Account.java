package com.letelumiere.twitterreverse.domain.api.model.accounts;

import java.util.*;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import com.letelumiere.twitterreverse.domain.api.model.origin.Origin;
import com.letelumiere.twitterreverse.domain.api.model.tweets.Tweet;

import lombok.*;

@Entity(name = "account")
@Table(
		name = "account", 
		uniqueConstraints = {
				@UniqueConstraint(name = "account_email_unique", columnNames = "email")
		}
)
@DiscriminatorValue(value = "account")
@PrimaryKeyJoinColumn(name = "origin_id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account extends Origin {

	@OneToOne(mappedBy ="origin_id")
	private Long id;

	@Column(name = "screenName", unique = true)
	private String screenName; 

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date createdTime;
	
	@ElementCollection
	private List<Tweet> tweet;
	
}
