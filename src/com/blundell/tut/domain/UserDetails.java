package com.blundell.tut.domain;

public class UserDetails {

	private final int id;
	private final String name;

	public UserDetails(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}