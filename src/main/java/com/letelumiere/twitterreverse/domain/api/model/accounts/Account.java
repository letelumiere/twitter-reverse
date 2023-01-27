package com.letelumiere.twitterreverse.domain.api.model.accounts;

import java.util.Date;
import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "account")
@Table(
		name = "account", 
		uniqueConstraints = {
				@UniqueConstraint(name = "account_email_unique", columnNames = "email")
		}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
public class Account extends Origin {

	@Column(name = "screenName", unique = true)
	private String screenName; 

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "createdTime")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date createdTime;

	public Account(String screenName, String email, String password, Integer phone, Date createdTime) {
		this.screenName = screenName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createdTime = createdTime;
	}
}
