package com.letelumiere.twitterreverse.domain.api.model;

import java.util.Date;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Account")
@Table(
		name = "Account", 
		uniqueConstraints = {
				@UniqueConstraint(name = "account_email_unique", columnNames = "email")
		}
)
public class Account {
    @Id 
	@SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1) 
	@GeneratedValue(strategy = SEQUENCE, generator = "account_sequence")
	@Column(name ="id", updatable = false)
	private Long id;

	@Column(name = "screen_name", nullable = false, columnDefinition = "TEXT")
	private String screen_name; 

	@Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true, length = 30)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private Integer phone;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date created_at;


	public Account(String screen_name, String email, String password, Integer phone) {
		this.screen_name = screen_name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.created_at = new Date();
	}
}

