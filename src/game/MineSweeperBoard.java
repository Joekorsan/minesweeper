package game;
import java.util.*;

public class MineSweeperBoard {

	//size of the board
	private int width;
	private int height;
	private int mineCount;
	private boolean givenUp;
	private boolean hitMine;
	
	// Use 2D arrays for indicating which squares are
	// revealed, which are mined, and which are flagged.
	private boolean[][] revealed;
	private boolean[][] mined;
	private boolean[][] flagged;
	
	static Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	/* Initialize a board with a given width and height, containing the
	 * given number of randomly-placed mines.  Nothing should be revealed
	 * or flagged.  If there are more mines than spaces for them, fill
	 * the entire board with mines.
	 */

	public MineSweeperBoard() {
		//Initialize board size and 2D arrays,
		//then randomly place the mines
		this.givenUp = false;
		this.hitMine = false;

		System.out.print("Enter a positive integer for width followed by the height for your minesweeper board("
			+ "both numbers being between 5 and 20): ");
		this.width = scanner.nextInt();
		this.height = scanner.nextInt();
		checkBoardDimensions(this.width, this.height);
		System.out.print("Enter a number of mines you want in your board: ");
		this.mineCount = scanner.nextInt();
		checkMineCount(this.mineCount);
		
		System.out.println("this is before the board is made");
		// Initialize board size and 2D arrays,
		//this.mineCount = mineCount;
		revealed = new boolean [width][height];
		mined = new boolean [width][height];
		flagged = new boolean [width][height];
		
		placeRandomMines();
	}
	
	public void placeRandomMines() {
		int minesPlaced = 0;
	    random = new Random(); // this generates random numbers for us
	    while(minesPlaced < mineCount) {
	    	int x = random.nextInt(this.width); //5 a number between 0 and mWidth - 1
	    	int y = random.nextInt(this.height); //6
	    	// make sure we don't place a mine on top of another
	    	if(mined[x][y] != true) {
	    		mined[x][y] = true;
	    		minesPlaced ++;
	    	}
	    }
	}

	
	public boolean checkBoardDimensions(int width, int height) {
		boolean checkB = false;
		// Scanner reader = new Scanner(System.in);
		if (width >= 5 && width <= 20 && height >= 5 && height <= 20) {
			checkB = true;
		} else {
			while (!checkB) {
				System.out.print("Error not a valid width and height: "
						+ "please enter the CORRECT Width and Height(between 5 and 20): ");
				this.width = scanner.nextInt();
				this.height = scanner.nextInt();
				if (this.width >= 5 && this.width <= 20 && this.height >= 5 && this.height <= 20) {
					checkB = true;
					break;
				}
			}
		}
		return checkB;
	}

	public boolean checkMineCount(int mineCount){
		boolean isTrue = false;
		if (mineCount >= 0 && mineCount <= this.width*this.height)
		{
			this.mineCount = mineCount;
			isTrue = true;
		}// end of if statement
		else
		{
			while (!isTrue) 
			{
				System.out.print("Error not a valid mine count: "
						+ "please enter the CORRECT mine count must be between 0 and "+ this.height*this.width+":");
				this.mineCount = scanner.nextInt();
				if (this.mineCount >= 0 && this.mineCount <= this.width*this.height) 
				{
					isTrue = true;
					break;
				}// end of if statement
			}// end of while loop
		
		}// end of else
		return isTrue;
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// Return the appearance of the square (what will be
	// displayed to the player) as a single character.
	public char appearance(Position p) {
		int x = p.getX();
		int y = p.getY();
		//System.out.println("x: " +x +"y: "+y);

		if (flagged[x][y]) {
			return '/';
		} else if (revealed[x][y]) {
			if (mined[x][y]) {
				// Boom!
				return '*';
			} else {
				// At most 8 adjacent mines, so one digit.
				int adjmines = adjacentMines(p);
				String out = adjmines + "0";
				// Convert a number to a digit character.
				return out.charAt(0);
			}
		} else {
			// Unrevealed, unflagged.
			return '.';
		}
	}

	public boolean won() {
		// Check every square. If we see a square that is mined but
		// not flagged, or unmined but not revealed, return false
		// immediately. If we get to the end, every square is correct,
		// so the user won and we return true.
		
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				if(mined[i][j] && !flagged[i][j]){
					return false;
				}else if(!mined[i][j] && !revealed[i][j]){
					return false;
				}//end of else statement
				
			}//end of inner for loop.
		
		}//end of for loop
		
		System.out.println("yay!!!!!! you've dodged all the mines and WON!!!");

		// TODO
		return true;
	}// end of won method

	public boolean lost() {
		if(this.givenUp || this.hitMine) {
			System.out.println("sorry, you LOST :-(");
			return true;
		}// end of if statement

		// Check every square. If we see a square that is mined and revealed,
		// return true immediately. The user lost the game.
		// If we get to the end, every square is correct, we return false.

		// TODO
		return false;
	}//end of lost method

	public void giveUp() {
		// Mark every square as revealed.
		this.givenUp = true;
	}

	public void display() {
		// Display the entire board to the console.
		// Prints a header with the column numbers,
		// and prints the row number on each line.
		// For example,
		// | 0 1 2 3 4
		// ---+---------------
		// 0 | 1 / . . .
		// 1 | 1 2 . . .
		// 2 | 0 1 . . .
		// 3 | 0 1 2 1 1
		// 4 | 0 0 0 0 0

		// TODO
		System.out.println("height: "+this.height);
		System.out.println("width: "+this.width);
		System.out.println("| ");
		System.out.print("  ");
		for(int i = 0; i < width; i++){
		  System.out.print(i + " ");
		}
		System.out.println();

		for(int i = 0; i < width; i++){
		  System.out.print(i + " ");
		  for(int j = 0; j < height; j++){
		    System.out.print(appearance(new Position(i, j)) + " ");
		  }
		  System.out.println();
		}
		
		
	}//end of display board

	public boolean flag(Position p) {
		// Put a flag on a square, or remove a flag that is
		// already there. Returns true if we placed a flag, false if
		// we removed one.
		int x = p.getX();
		int y = p.getY();
		
		flagged[y][x] = !flagged[y][x];
		return flagged[y][x];
	}

	public void reveal(Position p) {
		int x = p.getX();
		int y = p.getY();
		flagged[y][x] = false;
		revealed[y][x] = true;
		this.hitMine = mined[y][x];
		/*
		 * Base case 1: if P already revealed, return; mark P as revealed and
		 * mark P as not flagged, Base case 2: if P hits a mine, return;
		 */

		/*
		 * Recursive case:
		 * 
		 * a) check if adjacent mines == adjacent flag b) if yes, get all
		 * adjacent nodes, adjacent(p), already implemented, c) for each
		 * adjacent node at position adj, if it is not flagged, we recursively
		 * call reveal(adj)
		 */

	}

	public PositionList adjacent(Position p) {
		PositionList result = new PositionList();

		// Loop over the 3x3 block centered around p.
		for (int adjY = p.getY() - 1; adjY <= p.getY() + 1; adjY++) {
			for (int adjX = p.getX() - 1; adjX <= p.getX() + 1; adjX++) {
				// Make a position out of the new coordinates.
				Position adj = new Position(adjX, adjY);
				// Skip out-of-bounds squares
				if (!adj.inBounds(this.width, this.height))
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

	public int adjacentMines(Position p) {
		int minesNearby = 0;
		PositionList pos = adjacent(p);
		
		while (!pos.isEmpty()) {
			Position position = pos.get(0);
			
			int x = position.getX();
			int y = position.getY();
			
			
			if (mined[y][x]) {
				minesNearby++;
			}
			
			pos.popFront();
		}
		
		// Loop over the neighbors of position p.
		// If it's mined, increase the count of mines.
		
		

		// TODO
		return minesNearby;

	}

	public int adjacentFlags(Position p) {
		// Loop over the neighbors of position p.
		// If it's flagged, increase the count of flags.

		
		// TODO
		return -1;
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		MineSweeperBoard.scanner = scanner;
	}

	public boolean[][] getRevealed() {
		return revealed;
	}

	public void setRevealed(boolean[][] revealed) {
		this.revealed = revealed;
	}

	public boolean[][] getMined() {
		return mined;
	}

	public void setMined(boolean[][] mined) {
		this.mined = mined;
	}

	public boolean[][] getFlagged() {
		return flagged;
	}

	public void setFlagged() {
		
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMineCount() {
		return mineCount;
	}

	public void setMineCount(int mineCount) {
		this.mineCount = mineCount;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

}//end of mineSweeperBoard class