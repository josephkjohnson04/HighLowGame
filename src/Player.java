import java.util.Scanner;

/**
 * @author Joe Johnson and Jaylen Kile
 * @version 1.0
 * @since 2/7/2024
 * @see <a href="https://github.com/josephkjohnson04/HighLowGame.git">...</a>
 * The Player logic for the High/Low App that allows for two players to play the game
 * Each player will enter their name and begin guessing as to the correct number in the game.
 * Their total wins, max attempts, and lowest attempts for each question are stored to be later displayed.
 */

public class Player {

    /**
     * The player's name
     */
    private java.lang.String name;


    /**
     * Class field that is shared across all player objects that tracks the last unique player id used. It is increased
     * by one and assigned as the player's unique id by the default constructor.
     */
    private static int lastNumber = 0;

    /**
     * Player's unique id that is automatically assigned by rhe default constructor.
     */
    private int id;


    public Player() {
        this.id = ++Player.lastNumber;
        this.name = "Unknown";
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getLastNumber() {
        return Player.lastNumber;
    }

    private int highestAttempts;        // Player's highest attempts to guess the correct number

    private int lowestAttempts;

    private int wins;

}

