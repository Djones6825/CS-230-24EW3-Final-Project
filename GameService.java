package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	 /*
	   * Holds the next team identifier
	   */
	   private static long nextPlayerId = 1;

	/*
	* Holds the next player identifier
	*/
	private static long nextTeamId = 1;

	// Create private var to track existence of GameService
	private static GameService service;

	// Default constructor
	private GameService() {
	}

	/**
	* Check for existing instance of GameService
	* @return
	*/
	
	
	private static GameService instance = new GameService();
	
	/*
	 * a private constructor created to not instantiate any additional instances outside of this class
	 */
	private void GameService() {
	}
	
	/*
	 * a public accessor for the instance. Allows outside classes to access objects in this singleton class.
	 */
	   public static GameService getInstance() {

		// checks if GameService exists
		   if (service == null) {
		// If not, create a new instance in heap memory
		   service = new GameService();
		   System.out.println("New Game Service created.");
		} else {
		// If it already exists, just let us know
		System.out.println("Game Service already instantiated.");
		}

		// Return new or existing, but only the single instance
		return service;
		}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// if found, simply return the existing instance
		/*
		 * if Game with name already exists, simply return the existing instance
		 * without adding anything to the game's data structure.
		 */
		// Instance iterator of type Game
		Iterator<Game> gamesIterator = games.iterator();

		// Iterate over list of games
		while (gamesIterator.hasNext()) {

		// Sets local Game variable to next item in list
		Game gameInstance = gamesIterator.next();

		// checks if game name already exists
		if (gameInstance.getName().equalsIgnoreCase(name)) {
		// If game name already exists, return the game instance
		return gameInstance;
		}
		}
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		// Instance iterator
		Iterator <Game> gamesIterator = games.iterator();

		// Iterate over list of games
		while (gamesIterator.hasNext()) {

		// Sets local Game variable to next item in list
		Game gameInstance = gamesIterator.next();

		// checks if game id already exist?
		if (gameInstance.getId() == id) {
		// If game id already exists, return the game instance
		return gameInstance;
		}
		}



		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// if found, simply assign that instance to the local variable	
		/*
		 * with this name, returns that game's instance.
		 */
		for (Game currentGame : games) {
			if (currentGame.getName().equals(name)) {
				game = currentGame;
			}
		}
		
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	   public int getGameCount() {
	       return games.size();
	   }

	/**
	* Returns the player whose turn is next
	*
	* @return the player whose turn is next
	*/
	public long getNextPlayerId() {
	   return nextPlayerId;
	}

	/**
	* Returns the team whose turn is next
	*
	* @return the team whose turn is next
	*/
	public long getNextTeamId() {
	return nextTeamId;
	}
	}