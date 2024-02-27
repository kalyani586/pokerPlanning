package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storyId;
	private String storyDescription;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "session_fk") 
	 * private List<Member> members;
	 */	
	/*
	 * @OneToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "vote_fk", referencedColumnName = "voteId") private
	 * List<Vote> vote;
	 */
	/*
	 * @OneToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "vote_fk") private List<Vote> vote;
	 */
}
