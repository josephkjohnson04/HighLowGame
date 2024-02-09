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

    private java.lang.String name;

    private static int lastNumber = 0;

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