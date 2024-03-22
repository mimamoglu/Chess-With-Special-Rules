
public class Piyon extends Item{

	public int point = 1;
	
	public void Points() {
		super.points = point;
	}
	
	public boolean Moves(Board b, String cor, Player p) {
		boolean checkMove = false;
		
		//Blacks move (upside)
		if (p.playerType.equals("SIYAH")) {
			//Normal pawn move 1 step forward
			if (cor.charAt(0) - cor.charAt(3) == 1 && Integer.parseInt(cor.substring(1, 2)) == Integer.parseInt(cor.substring(4, 5))) {
				if (!(b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5))-1].equals("-")))
					checkMove = false; 
				else
					checkMove = true;
			}
			//1 step cross pawn attack move
			if (cor.charAt(0) - cor.charAt(3) == 1 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1) {
				if (!(b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5))-1].equals("-"))) {
					if (p.attackEnemyPiece(cor, b)) { //Check if player attacking enemy troops.
						attackPoint(b, p, cor);
						checkMove = true;
					}else
						checkMove = false;
				}else
					checkMove = false; 
			}
		}
		
		//Whites move (downside)
		if (p.playerType.equals("BEYAZ")) {
			//Normal pawn move 1 step forward
			if (cor.charAt(3) - cor.charAt(0) == 1 && Integer.parseInt(cor.substring(1, 2)) == Integer.parseInt(cor.substring(4, 5))) {
				if (!(b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5))-1].equals("-")))
					checkMove = false;
				else
					checkMove = true;
			}
			//1 step cross pawn attack move
			if (cor.charAt(3) - cor.charAt(0) == 1 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1) {
				if (!(b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5))-1].equals("-"))){
					if (p.attackEnemyPiece(cor, b)) { //Check if player attacking enemy troops.
						attackPoint(b, p, cor);
						checkMove = true;
					}else
						checkMove = false;
				}else
					checkMove = false;
			}
		}
		return checkMove;
	}
}