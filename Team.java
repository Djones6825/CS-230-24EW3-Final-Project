package com.gamingroom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	/*
	 * a list of active teams
	 */
	private List<Player> players = new ArrayList<Player>();
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id,name);
	}
	
	 /**
	   * Uses iterator pattern to find existing player with same name or
	   * adds unique named player to list
	   *
	   * @param name
	   * @return Player instance
	   */
	
	/**
	 * @return the id
	 */
	 public Player addPlayer(String name) {

	       // a local teams instance
	       Player player = null;

	       // Instance iterator
	       Iterator<Player> playersIterator = players.iterator();

	       // Iterate over players list
	       while (playersIterator.hasNext()) {

	           // Sets local Player variable to next item in list
	           Player playerInstance = playersIterator.next();

	           // checks if player name already exists
	           if (playerInstance.getName().equalsIgnoreCase(name)) {
	               // If player name already exists, return the player instance
	               player = playerInstance;
	           } else {
	               // else add the player to the players list
	               players.add(player);
	           }
	       }

	       return player;
	   }

	   @Override
	   public String toString() {
	       return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	   }
	}
