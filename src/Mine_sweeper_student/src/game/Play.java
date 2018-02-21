package Mine_sweeper_student.src.game;

import java.util.Scanner;


public class Play {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		// TODO: Ask for the board size (between 5 and 20 in each direction)
		// and the number of mines.

		
		
		// Create a board of that size.
		// TODO: change these numbers.
		//MineSweeperBoard board(10, 10, 10);
		MineSweeperBoard board = new MineSweeperBoard (10, 10, 10);

		while (!board.lost() && !board.won())
		{
			board.display();
			
			// TODO: Ask the user to [R]eveal, [F]lag, or [G]ive up.
			// The first two commands also require a Position, so
			// you may need to ask for x and y coordinates as well.

			// TODO: Then perform that command by calling the appropriate
			// method.
			
		}

		// TODO: Tell the user whether they won or lost.

		// TODO: Compute and display how much time the game took.

	}
	
	public static Position readPosition(int maxX, int maxY)
	{
		// Repeat forever, until we break or return.
		while (true) {
			
			int x, y;
			System.out.print("What position (x y)? ");
			x = console.nextInt();
			y = console.nextInt();

			if (x < 0 || x > maxX) {
				System.out.println ( "column " + x + " is out of bounds!" );
			}
			else if (y < 0 || y > maxY) {
				System.out.println( "row " + y + " is out of bounds!" );
			}
			else {
				// It passed the tests, return it.
				return new Position(x, y);
			}
		}

	}

}
