
public class Sah extends Item{

	public boolean Moves(Board b, String cor, Player p) {
		boolean checkMove = false;
		
		//Check if king moves 1 step forward/backward
		if (Integer.parseInt(cor.substring(1, 2)) == Integer.parseInt(cor.substring(4, 5))) {
			if (Math.abs(cor.charAt(0) - cor.charAt(3)) == 1) {
				if (b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("-")) {
					checkMove = true;
				}
				else {
					if (p.attackEnemyPiece(cor, b)) {
						attackPoint(b, p, cor);
						checkMove = true;
					}
				}
					
			}
		}
		//Check if king moves 1 step sideways
		if (cor.charAt(0) == cor.charAt(3)) {
			if (Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1) {
				if (b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("-")) {
					checkMove = true;
				}else {
					if (p.attackEnemyPiece(cor, b)) {
						attackPoint(b, p, cor);
						checkMove = true;
					}
				}	
			}
		}
		//Check if king moves 1 step cross
		if ((Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1) && (Math.abs(cor.charAt(0) - cor.charAt(3)) == 1)) {
			if (b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("-")) {
				checkMove = true;
			}else {
				if (p.attackEnemyPiece(cor, b)) {
					attackPoint(b, p, cor);
					checkMove = true;
				}
			}	
		}
		return checkMove;
	}
}