package com.letelumiere.twitterreverse.domain.api.model.accounts;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.*;


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
public class Origin {
	
    @Id 
	@SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_sequence")
	@Column(name ="id", updatable = false)
	private Long id;
}
