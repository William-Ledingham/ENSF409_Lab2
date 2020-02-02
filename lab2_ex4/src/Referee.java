import java.io.IOException;

public class Referee {

	private Player xPlayer;
	private Player oPlayer;
	private Board board;
	
	Referee(){}
	
	public void runTheGame() throws IOException
	{
		System.out.printf("\nReferee started the game...\n\n");
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}
	
	public void setBoard(Board board)
	{
		this.board = board;
	}
	
	public void setoPlayer(Player oPlayer)
	{
		this.oPlayer = oPlayer;
	}
	
	public void setxPlayer(Player xPlayer)
	{
		this.xPlayer = xPlayer;
	}
	
}
