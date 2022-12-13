package com.letelumiere.twitterreverse.domain.api.model;
import javax.persistence.Entity;

public class Follows{
	long origin_id;
	long follow_id;
	boolean friend;
}
