package Mine_sweeper_student.src.game;



public class MineSweeperBoard {

	//size of the board
	
	private int height;
	private int width;
	// Use 2D arrays for indicating which squares are
	// revealed, which are mined, and which are flagged.
	private boolean[][] revealed;
	private boolean[][] mined;
	private boolean[][] flagged;
	
	/* Initialize a board with a given width and height, containing the
	 * given number of randomly-placed mines.  Nothing should be revealed
	 * or flagged.  If there are more mines than spaces for them, fill
	 * the entire board with mines.
	 */

	public MineSweeperBoard(int boardWidth,
			int boardHeight, int mineCount)
			{
				//Initialize board size and 2D arrays,
				//then randomly place the mines
				
				//TODO
		
			}
	
//	public void createSweeperBoard( int )
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	// Return the appearance of the square (what will be 
	//   displayed to the player) as a single character.
	public char appearance(Position p)
	{
		int x = p.getX();
		int y = p.getY();

		if (flagged[y][x]) {
			return '/';
		}
		else if (revealed[y][x]) {
			if (mined[y][x]) {
				// Boom!
				return '*';
			}
			else {
				// At most 8 adjacent mines, so one digit.
				int adjmines = adjacentMines(p);
				String out =  adjmines + "0";
				// Convert a number to a digit character.
				return out.charAt(0);
			}
		}
		else {
			// Unrevealed, unflagged.
			return '.';
		}
	}
	
	
	public boolean won()
	{
		// Check every square.  If we see a square that is mined but
		// not flagged, or unmined but not revealed, return false
		// immediately.  If we get to the end, every square is correct,
		// so the user won and we return true.
		
		//TODO
		return false;
	}
	
	public boolean lost()
	{
		
		// Check every square.  If we see a square that is mined and revealed, 
		// return true immediately. The user lost the game.
		// If we get to the end, every square is correct, we return false.
		
		//TODO
		return false;
	}
	
	public void giveUp()
	{
		// Mark every square as revealed.
		
		//TODO
	}

	public void display()
	{
		// Display the entire board to the console. 
		// Prints a header with the column numbers, 
		// and prints the row number on each line.  
		//For example,
		//     |  0  1  2  3  4
		//  ---+---------------
		//   0 |  1  /  .  .  .
		//   1 |  1  2  .  .  .
		//   2 |  0  1  .  .  .
		//   3 |  0  1  2  1  1
		//   4 |  0  0  0  0  0
		
		//TODO
	}
	
	public boolean flag(Position p)
	{
		// Put a flag on a square, or remove a flag that is
		// already there.  Returns true if we placed a flag, false if
		// we removed one.
		
		//TODO
		return false;
	}
	public void reveal(Position p)
	{
		
		//TODO
		/*
		Base case 1: if P already revealed, return;
					 mark P as revealed and mark P as not flagged,
		Base case 2: if P hits a mine, return;
		*/
		
		
		/*
		Recursive case: 
			
			a) check if adjacent mines == adjacent flag
			b) if yes, get all adjacent nodes, adjacent(p), already implemented,
			c) for each adjacent node at position adj, if it is not flagged, we recursively call reveal(adj)
		*/
		
	
	}

	public PositionList adjacent(Position p)
	{
		PositionList result = new PositionList();

		// Loop over the 3x3 block centered around p.
		for (int adjY = p.getY() - 1; adjY <= p.getY() + 1; adjY++) {
			for (int adjX = p.getX() - 1; adjX <= p.getX() + 1; adjX++) 
			{
				// Make a position out of the new coordinates.
				Position adj = new Position(adjX, adjY);
				// Skip out-of-bounds squares
				if (!adj.inBounds(width, height))
					continue;
				// Also skip the center.
				if (adj.getX() == p.getX() && adj.getY() == p.getY())
					continue;

				// If we get here, it's really adjacent, so add it to the list.
				result.pushFront(adj);
			}
		}
		return result;
	}

	public int adjacentMines(Position p)
	{

		// Loop over the neighbors of position p.
		// If it's mined, increase the count of mines.
		
		//TODO
		return -1;
			
	}

	public int adjacentFlags(Position p)
	{
		// Loop over the neighbors of position p.
		// If it's flagged, increase the count of flags.
		
		//TODO
		return -1;
	}

}
