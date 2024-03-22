
public class Board {

	public String gameBoard[][];
	
	//Creates a 8x8 chestboard
	public Board() {
		gameBoard = new String[8][8];
		
		for(int i = 2; i < 6; i++) {
			for(int k = 0; k < 8; k++) {
			gameBoard[i][k] = "-";
			}
		}
		for (int l = 0; l < 8; l = l + 7) {
			for (int m = 0; m < 8; m++) {
				if (l == 0)
					gameBoard[l][m] = "P";
				else 
					gameBoard[l][m] = "p";
			}
		}
		for (int y = 1; y < 8; y = y + 5) {
			for (int x = 0; x < 8; x++) {
				if (y == 1) {
					if (x == 0 || x == 7)
						gameBoard[y][x] = "K";
					else if (x == 1 || x == 6)
						gameBoard[y][x] = "A";
					else if (x == 2 || x == 5)
						gameBoard[y][x] = "F";
					else if (x == 4)
						gameBoard[y][x] = "V";
					else
						gameBoard[y][x] = "S";
				}
				else {
					if (x == 0 || x == 7)
						gameBoard[y][x] = "k";
					else if (x == 1 || x == 6)
						gameBoard[y][x] = "a";
					else if (x == 2 || x == 5)
						gameBoard[y][x] = "f";
					else if (x == 4)
						gameBoard[y][x] = "v";
					else
						gameBoard[y][x] = "s";
				}
			}
		}
	}
	//Prints the chestboard
	public void printBoard() {
		
		String verticalBoard = "abcdefgh";
		System.out.println(" \t1\t2\t3\t4\t5\t6\t7\t8");
		
		for(int i = 0; i < 8; i++) {
			System.out.print(verticalBoard.charAt(i) + "\t");
			for(int k = 0; k < 8; k++) {
				if (k == 7 )
					System.out.print(gameBoard[i][k]);
				else
					System.out.print(gameBoard[i][k] + "\t");
			}
			System.out.println();
		}
		
	}
}
