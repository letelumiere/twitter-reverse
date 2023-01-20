package com.letelumiere.twitterreverse.domain.api.account;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.CreatedDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static javax.persistence.GenerationType.SEQUENCE;
@Getter
@Setter
@Entity(name = "Account")
@Table(
		name = "Account", 
		uniqueConstraints = {
				@UniqueConstraint(name = "account_email_unique", columnNames = "email")
		}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
public class Account {
    @Id 
	@SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_sequence")
	@Column(name ="id", updatable = false)
	private Long id;

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

	public Account(Long id, String screenName, String email, String password, Integer phone, Date createdTime) {
		this.id = id;
		this.screenName = screenName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createdTime = createdTime;
	}
}
