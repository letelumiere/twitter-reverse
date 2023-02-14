package com.letelumiere.twitterreverse.domain.api.model.origin;

import java.util.ArrayList;
import java.util.List;

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

@Entity(name = "origin")
@Table(
		name = "origin", 
		uniqueConstraints = {
				@UniqueConstraint(name = "origin_id_unique", columnNames = {"id"})
		}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor
public class Origin {
	
    @Id 
	@SequenceGenerator(name = "origin_id_sequence", sequenceName = "origin_id_sequence", allocationSize = 8) 
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "origin_id_sequence")
	@Column(name ="id", updatable = false)
	private Long id;
}
