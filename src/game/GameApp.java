package game;


public class GameApp {

	public static void main(String[] args) {
		
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				System.out.print(".  ");
			}
			System.out.println();
		}
		
		
		MineSweeperBoard board = new MineSweeperBoard();
		System.out.println("width: "+board.getWidth()+" height: "+board.getHeight() +" mine count: "+ board.getMineCount());
	}
}

