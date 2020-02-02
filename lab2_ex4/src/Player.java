import java.io.*;
public class Player {

	private String name;
	private Board board;
	private Player opponent;
	private char mark;
	
	Player(String name, char mark)
	{
		this.name = name;
		this.mark = mark;
	}
	
	public void play() throws IOException
	{
		makeMove();
		board.display();
		if(board.xWins())
		{
			System.out.printf("Game Over. %s is the Winner!\n", name);
			return;
		}
		else if(board.oWins())
		{
			System.out.printf("Game Over. %s is the Winner!\n", name);
			return;
		}
		else if(board.isFull())
		{
			System.out.println("Game Over. It is a Tie");
			return;
		}
		opponent.play();
	}
	
	public void makeMove () throws IOException
	{
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.printf("\n%s, what row should your next %c be placed in?: ", name, mark);
		String row = stdin.readLine();
		while (row == null) {
			System.out.print("Please try again: ");
			row = stdin.readLine();
		}
		
		System.out.printf("\n%s, what column should your next %c be placed in?: ", name, mark);
		String col = stdin.readLine();
		while (col == null) {
			System.out.print("Please try again: ");
			col = stdin.readLine();
		}
		
		int rowInt = Integer.parseInt(row);
		int colInt = Integer.parseInt(col);
		
		board.addMark(rowInt, colInt, mark);
		
	}
	
	public void setOpponent(Player opponent)
	{
		this.opponent = opponent;
	}
	
	public void setBoard(Board theBoard)
	{
		this.board = theBoard;
	}
	
}
