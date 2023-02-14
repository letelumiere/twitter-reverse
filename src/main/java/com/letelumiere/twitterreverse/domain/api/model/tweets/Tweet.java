package com.letelumiere.twitterreverse.domain.api.model.tweets;

import java.util.*;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import lombok.*;

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
