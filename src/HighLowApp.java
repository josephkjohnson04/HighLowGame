import java.util.Random;
import java.util.Scanner;

/**
 * The High/Low App that allows two players to compete guessing a random computer generated number.
 * Each player will take turns guessing the correct number.
 * The player will be told if they are getting warmer or colder based on how close or far away they are from the number.
 * The game keeps track of each player's lowest and highest number of attempts to guess the number, plus total wins.
 */
public class HighLowApp {

	/**
	 * Input scanner for all user's input.
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * A standard length single dash line.
	 */
	private static final String SINGLE_LINE = "-------------------------------------------------------";

	/**
	 * A standard length double dash line.
	 */
	private static final String DOUBLE_LINE = "=======================================================";

	/**
	 * The first player of the game.
	 */
	private static Player player1 = new Player();

	/**
	 * The second player of the game.
	 */
	private static Player player2 = new Player();

	/**
	 * The number of attempts required to guess the correct number per round for both players.
	 */
	private static int attempts = 0;

	/**
	 * The correct answer that is randomly generated between 1 - 100 inclusively.
	 */
	private static int correctAnswer = 0;

	/**
	 * Number of rounds played.
	 */
	private static int roundsPlayed = 1;

	/**
	 * Display the game's header and rules.
	 */
	public static void displayHeader() {

		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println("||          Welcome to the High/Low Game             ||");
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println("Game Rules:");
		System.out.println();
		System.out.println("1) Players will take turns guessing a number"); 
		System.out.println("   between 1 - 100");
		System.out.println("2) At the start of each round, the players will"); 
		System.out.println("   take turns going first");
		System.out.println("3) After each quess, the player will get a hint"); 
		System.out.println("   if they are getting warmer or colder");
		System.out.println("4) The game will track each player's lowest and highest"); 
		System.out.println("   attempts plus the number of wins");
		System.out.println("5) At the end of each round, the players can decide"); 
		System.out.println("   if they want to continue or quit the game");
		System.out.println();
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println();

	}

	/**
	 * Used to set each player's name. It keeps looping until a non-blank name is entered.
	 *
	 * @param player The current player who's name is being set.
	 */
	public static void setName(Player player) {
		String userInput = "?";

		System.out.println("Setting up the #" + player.getId() + " player");

		while (true) {
			System.out.print("\tPlease enter the player's name: ");
			userInput = HighLowApp.sc.nextLine();
		
			try {
				player.setName(userInput);
				break;
			} catch (Exception e){
				System.out.println("\tERROR! " + e.getMessage());
			}
		}
		
		System.out.println();
		System.out.println(HighLowApp.SINGLE_LINE);
		System.out.println();

	}

	/**
	 * Allows setting each game player's name. Plus, displays the computer's name and prompts them to start guessing.
	 */
	public static void setupPlayers() {

		HighLowApp.setName(HighLowApp.player1);
		HighLowApp.setName(HighLowApp.player2);
		
		System.out.println("Welcome " + HighLowApp.player1.getName() + " and " + HighLowApp.player2.getName() + "! Let's get this game started!");
		System.out.println();
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println();
		System.out.println("My name is Chuck. I'm a computer.");
		System.out.println("Can you guess the number I'm thining of between 1 - 100?");
		System.out.println();
	}


	/**
	 * Allows the current player to guess the number.
	 * It will keep looping until the user enters a valid number between 1- 100.
	 * If will let the current player know if they guessed it correctly
	 * and then update the total wins, plus highest or lowest attempts.
	 * If the player did NOT answer it correctly it will tell them if they are getting warmer or colder
	 * based on the absolute distance from the correct answer.
	 *
	 * @param player The current player.
	 * @return True if the user guessed it correctly, else return false.
	 */
	public static boolean guess(Player player) {
		int playerGuess = 0;
		int distance = 0;
		String playerName = player.getName();
		
	    attempts++;
		
		while (true) {
			System.out.print("What's your guess, " + playerName + ": ");
			
		    while (!HighLowApp.sc.hasNextInt()) {
		        System.out.println("That's not a number!");
		        HighLowApp.sc.next(); // clear the invalid data
		    }
		    playerGuess = HighLowApp.sc.nextInt();
		    
		    if (playerGuess >= 1 && playerGuess <= 100)
		    	break;
		    else
		    	System.out.println("ERROR: Please enter a number between 1 - 100!");
		}

		if (playerGuess == HighLowApp.correctAnswer) {
			System.out.println("WooHoo!!! " + playerName + " just won this round!");
			player.addWin();
			player.setAttempts(HighLowApp.attempts);
			return true;
		} 
			
		distance = Math.abs(playerGuess - HighLowApp.correctAnswer);

		if (distance < 5)
			System.out.println(playerName + ", you are boiling!");
		else if (distance < 10)
			System.out.println(playerName + ", you are hot!");
		else if (distance < 20)
			System.out.println(playerName + ", you are warm!");
		else if (distance < 50)
			System.out.println(playerName + ", you are cold!");
		else
			System.out.println(playerName + ", you are freezing!");
		
		System.out.println();
		
		return false;
		
	}

	/**
	 * Display the player's stats (wins, highest and lowest attempts.
	 *
	 * @param player The selected game player to display.
	 */
	public static void displayPlayer(Player player) {
		
        String playerName = String.format("%-10s", player.getName()).replace(' ', '.');
        
        System.out.printf("%-10s: %4d    %4d  %4d\n", 
        		playerName, 
        		player.getWins(), 
        		player.getHighestAttempts(), 
        		player.getLowestAttempts()
	);
	}

	/**
	 * Display each player's games stats which calls displayPlayer once for each player.
	 */
	public static void displayStats() {
		
		System.out.println();
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println();
		
        System.out.println("                  # of Attempts");
        System.out.println("Name        Wins    High   Low");
        System.out.println("----------- ----    ----  ----");
        

        HighLowApp.displayPlayer(HighLowApp.player1);
        HighLowApp.displayPlayer(HighLowApp.player2);
        
		System.out.println();
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println();

	}

	/**
	 * Play game by keeping the game looping until they want to quit the game.
	 */
	public static void playGame() {
		Random random = new Random(); // random number generator that is used to generate random numbers
		
		String cont = "yes"; // used to get the user's answer if they want to keep playing
		boolean correct = false; // use to keep looping until the correct answer is guessed

		// keep looping while the players want to keep playing the game
		while (cont.equals("y") || cont.equals("yes")) {
			
			HighLowApp.attempts = 0; // at the same of a new round reset the attempts counter

			// at the start of each round, generate a new random number
		    HighLowApp.correctAnswer = random.nextInt(100) + 1; // generate a number between 1 & 100 inclusively
		    

		    
		    correct = false; // at the start of each round reset correct answer to false used to keep looping
		    
		    while (!correct) {
				// if odd number of rounds played, then the first player guesses first
				if (HighLowApp.roundsPlayed % 2 == 0)
					if (HighLowApp.attempts % 2 == 0)
						correct = HighLowApp.guess(HighLowApp.player1);
					else
						correct = HighLowApp.guess(HighLowApp.player2);
			    else // if even number of rounds played, then the second player guesses first
					if (HighLowApp.attempts % 2 == 0)
						correct = HighLowApp.guess(HighLowApp.player2);
					else
						correct = HighLowApp.guess(HighLowApp.player1);
		    }
		    
		    HighLowApp.sc.nextLine();
		    System.out.println();
		    
		    System.out.print("Press the Enter key to display the game stats...");
		    HighLowApp.sc.nextLine();
		    
		    HighLowApp.displayStats();

			// keep looping until the user answers the yes/no question correctly
		    while (true) {
		    	System.out.print("Do you want to play again (y=yes, n=no): ");
		    	cont = HighLowApp.sc.nextLine();
		    	
		    	if (cont.equals("y") || cont.equals("yes") || cont.equals("n") || cont.equals("no"))
		    		break;
		    	else
		    		System.out.println("Invalid input! Please try again..");
		    }
		    
		}
	}

	/**
	 * Display the closing message when the player's end the game.
	 */
	public static void displayClosing() {
		System.out.println();
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println();
		System.out.println("It was fun while it lasted. Please come again soon!");
		System.out.println();
		System.out.println("Good bye " + HighLowApp.player1.getName() + " and " + HighLowApp.player2.getName());
		System.out.println("Best regards,");
		System.out.println("Chuck");
		System.out.println();
		System.out.println(HighLowApp.DOUBLE_LINE);
		System.out.println();
	}

	/**
	 * The entry point of application. Displays the game header andrules, then gets the player's name,
	 * and allows the players to keep playing multiple rounds until they want to quit the game.
	 *
	 * @param args There are no input arguments used for this program.
	 */
	public static void main(String[] args) {

		HighLowApp.displayHeader();

		HighLowApp.setupPlayers();

		HighLowApp.playGame();
		
		HighLowApp.displayClosing();

		HighLowApp.sc.close();

	}

}
