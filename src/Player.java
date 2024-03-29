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
     * The player's name.
     */
    private String name;

    /**
     * Class field that is shared across all player objects that tracks the last unique player id used. It is
     * increased by one and assigned as the player's unique id by the default constructor.
     */
    private static int lastNumber = 0;

    /**
     * Player's unique id that is automatically assigned by the default constructor.
     */
    private int id;

    /**
     * The player's highest attempt to guess the correct number across all rounds.
     */
    private int highestAttempts;

    /**
     * The player's lowest attempt to guess the correct number across all rounds.
     */
    private int lowestAttempts;

    /**
     * The player's total wins across all games played.
     */
    private int wins;

    /**
     * Default constructor that creates a new player. The field lastNumber is incremented by one and unique ids are
     * assigned. Integers are set to zero and the name is set to Unknown.
     */
    public Player() {
        this.id = ++Player.lastNumber;
        this.name = "Unknown";
        this.wins = 0;
        this.highestAttempts = 0;
        this.lowestAttempts = 0;
    }

    /**
     *  Sets the name of the player and throws error if it is invalid.
     * @param The players name.
     * @throws Name can not be empty.
     *
     */
    public void setName (String name) {
        if (name == "")
            System.out.println("Invalid name! Name can't be blank");
        else
            this.name = name;
    }

    /**
     * Overload constructor creates a new player and calls the default constructor, then sets name.
     * @param the players name.
     */
    public Player(String name) {
        this();
        this.name = name;
    }

    /**
     * Gets the player's name.
     * @return The player's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the players last number.
     * @return The last number.
     */
    public static int getLastNumber() {
        return Player.lastNumber;
    }

    /**
     * Gets the number of wins.
     * @return The number of wins.
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Increments the player's number of wins.
     */
    public void addWin() {
        this.wins++;
    }

    /**
     * Sets the player's highest and lowest attempts
     * @param The players highest and lowest attempts.
     */
    public void setAttempts(int attempts) {
        if (attempts > this.highestAttempts) {
            this.highestAttempts = attempts;
        }

         if (attempts < this.lowestAttempts || this.lowestAttempts == 0){
             this.lowestAttempts = attempts;
        }
    }

    /**
     * Gets the players lowest attempts.
     * @return The players lowest attempts.
     */
    public int getLowestAttempts(){
        return this.lowestAttempts;
    }

    /**
     * Gets highest attempts of the player.
     * @return The players highest attempts.
     */
    public int getHighestAttempts(){
        return this.highestAttempts;
    }

    /**
     * Gets the players id.
     * @return The player id.
     */
    public int getId(){
        return this.id;
    }

}

