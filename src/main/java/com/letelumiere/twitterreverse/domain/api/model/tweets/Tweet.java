package com.letelumiere.twitterreverse.domain.api.model.tweets;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;

import com.letelumiere.twitterreverse.domain.api.model.accounts.Account;
import com.letelumiere.twitterreverse.domain.api.model.origin.Origin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tweet")
@SequenceGenerator(
	name = "tweet_sequence", 
	sequenceName = "tweet_sequence",
	initialValue = 1, 
	allocationSize = 1
) 
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tweet { 

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator = "tweet_sequence")
	@Column(name = "twit_id")
	private Long twitId;
	
	@Column(name = "origin_id")
	private Long originId;

	@Column(name = "circle")
	private Boolean circle;

	@Column(name = "content")
	private String content; 
	
	@Column(name = "created_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date createdTime;

	@OneToOne
	@JoinTable(name = "mention", 
				joinColumns = @JoinColumn(name = "twit_id"),
				inverseJoinColumns = @JoinColumn(name = "twit_id"))
	private Mention mention;

	@ElementCollection
    @CollectionTable(name="retweet", 
						joinColumns = @JoinColumn(name= "twit_id", referencedColumnName = "twit_id"))
	private Set<Retweet> retweet;

	@ElementCollection
    @CollectionTable(name="media", 
						joinColumns = @JoinColumn(name= "twit_id", referencedColumnName = "twit_id"))
	private Set<Retweet> media;

	@Entity(name = "mention")
	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	public class Mention {

		@Id
		@Column(name = "twit_id")
		private Long id;

		@Column(name = "from_user")
		private Long fromUser;

		@ElementCollection
		private List<Long> toUser;
	}

	@Embeddable
	public class Retweet {
		@Column(name = "created_time")
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate
		private Date createdTime;
	
		@Column(name = "referenced")
		boolean referenced;
	}

	public class Favorite{
		//@Id
        //private Long id;
        //ArrayList<Long> twit_id;
    }
		
	@Embeddable
	public class Media {

		@Id
		@Column(name = "twit_id")
		private Long id;

		@Column(name = "fileName")
		String filename;

		@Column(name = "format")
		String format;	

		@Column(name = "created_time")
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate
		String createTime;
	}

}
