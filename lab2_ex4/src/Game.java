
import java.io.*;


/**
 * Provides Board and Referee objects for setup of the Game and allows the game to be run.
 * @author Given file for exercise 4
 * @version 1.0
 * @since 2020-02-02
 *
 */
public class Game implements Constants {

	/**
	 * Board object for the game.
	 */
	private Board theBoard;
	/**
	 * Referee object for the game.
	 */
	private Referee theRef;
	
	/**
	 * Constructs a Game object.
	 * Calls constructor for new Board and assigns to member variable theBoard.
	 * 
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    /**
     * Assigns Referee object and runs the game.
     * @param r The Referee object.
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
     * Main that setups up player names and initializes game components.
     * @param args
     * @throws IOException
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
