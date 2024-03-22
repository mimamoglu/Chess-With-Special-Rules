
public class Game {

	public Board gameBoard;
	public int round = 1;
	public Item i;
	public Player beyazlar;
	public Player siyahlar;
	
	public Game() { //Create a game
		gameBoard = new Board();
		beyazlar = new Player("BEYAZ");
		siyahlar = new Player("SIYAH");
	}
	public void makeMove(String m) { // This method works
		i = new Item();
		if (round % 2 == 0) { // Blacks playing in double numbers
			//Piyon
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("p"))) {
				MoveChestPiece(m);
			}
			//Kale
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("k"))) {
				MoveChestPiece(m);
			}
			//At
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("a"))) {
				MoveChestPiece(m);
			}
			//Fil
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("f"))) {
				MoveChestPiece(m);
			}
			//Vezir
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("v"))) {
				MoveChestPiece(m);
			}
			//Sah
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("s"))) {
				MoveChestPiece(m);
			}
			
		}
		
		else { // Whites playing in double numbers
			//Piyon
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("P"))) {
				MoveChestPiece(m);
			}
			//Kale
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("K"))) {			
				MoveChestPiece(m);			
			}
			//At
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("A"))) {
				MoveChestPiece(m);				
			}
			//Fil
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("F"))) {
				MoveChestPiece(m);
			}
			//Vezir
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("V"))) {
				MoveChestPiece(m);
			}
			//Sah
			if ((gameBoard.gameBoard[m.charAt(0)-97][Integer.parseInt(m.substring(1, 2)) - 1].equals("S"))) {
				MoveChestPiece(m);
			}
		}
		round++;
	}
	public boolean checkMove(String cor, Player p) { //Check if following chest piece doing right move
		boolean check2 = false;
		
		if ((gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("p")) ||
		    (gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("P"))	) {
			Piyon P = new Piyon();
			check2 = P.Moves(gameBoard, cor, p);
		}
		
		if ((gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("k"))
			||(gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("K"))) {
			Kale K = new Kale();
			check2 = K.Moves(gameBoard, cor, p);
		}
		
		if ((gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("a")) ||
			(gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("A"))	) {
			At A = new At();
			check2 = A.Moves(gameBoard, cor, p);
		}
		
		if ((gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("f")) ||
			(gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("F"))	) {
			Fil F = new Fil();
			check2 = F.Moves(gameBoard, cor, p);
		}
		
		if ((gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("v")) ||
			(gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("V"))	) {
			Vezir V = new Vezir();
			check2 = V.Moves(gameBoard, cor, p);
		}
		
		if ((gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("s")) ||
			(gameBoard.gameBoard[cor.charAt(0)-97][Integer.parseInt(cor.substring(1, 2)) - 1].equals("S"))	) {
			Sah S = new Sah();
			check2 = S.Moves(gameBoard, cor, p);
		}
		return check2;
	}
	//Check if chestPiece belongs to right player.
	public boolean checkBoard(String k) {
		boolean check = false;
		if (round % 2 == 0) {
			check = siyahlar.checkChestPiece(k, gameBoard);
		}
		else
			check = beyazlar.checkChestPiece(k, gameBoard);
		return check;
	}
	
	public void MoveChestPiece(String m) { // This method moves the chest piece if all checks are passed
		
		gameBoard.gameBoard[m.charAt(3) - 97][Integer.parseInt(m.substring(4, 5)) - 1] = gameBoard.gameBoard[m.charAt(0) - 97][Integer.parseInt(m.substring(1, 2)) - 1]; 
		gameBoard.gameBoard[m.charAt(0) - 97][Integer.parseInt(m.substring(1, 2)) - 1] = "-";
	
	}
	//Move all chest pieces on the left side of board to right side. Move all chest pieces 1 step left (except the ones on the left side which already moved to right side)
	public void MoveBoard() {
		
		String[] temp = new String[8];
		for (int i = 0; i < 8; i++) {
			temp[i] = gameBoard.gameBoard[i][0];
		}
		for (int k = 1; k < 8; k++) {
			for (int m = 0; m < 8; m++) {
				gameBoard.gameBoard[m][k-1] = gameBoard.gameBoard[m][k];
			}
		}
		for (int l = 0; l < 8; l++) {
			gameBoard.gameBoard[l][7] = temp[l];
		}
	}
}