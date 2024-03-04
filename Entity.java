package com.gamingroom;
/*
 * A simple class to hold the required attributes
 * for children classes
 * 
 * @author Daniel Jones
 *
 */

public class Entity {
	// Private attributes
	private long id;
	private String name;

	// Default constructor
	private Entity() {
	}

	// Custom constructor with id & name parameters
	public Entity(long id, String name) {
	this(); // Call default constructor
	this.id = id;
	this.name = name;
	}

	public long getId() {
	return id;
	}

	public String getName() {
	return name;
	}

	public String toString() {
	return "Entity [id=" + id + ", name=" + name + "]";
	}
}
