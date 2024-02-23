package com.utils;

public class Queries {
	
	public final static String FIND_SESSION_BY_LINK="SELECT s FROM Session s Where s.link=?1";
	
	public final static String FIND_MEMBER_BY_NAME="SELECT o FROM Member o where o.name=:name";

}
