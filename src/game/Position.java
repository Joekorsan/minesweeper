package game;

public class Position {
	
	private int x;
	private int y;
	
	public Position()
	{
		x = 0;
		y = 0;
	}
	
	public Position (int pX, int pY)
	{
		x = pX;
		y = pY;
	}

	public int getX() {
		return x;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		this.y = newY;
	}
	
	/* Returns true if this position's coordinates are within 
	 * the given bounds: 0 <= x < width and 0 <= y < height.
	 */
	public boolean inBounds(int width, int height) 
	{
		return 0 <= x && x < width && 0 <= y && y < height;
	}

}

