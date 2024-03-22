
public class At extends Item{

	public int point = 3;
	
	public boolean Moves(Board b, String cor, Player p) {
		boolean checkMove = false;
		//Check if knight making move 2 step forward/backward and then 1 step sideways or 2 step sideways and then 1 step forward/backward
		if (!(b.gameBoard[cor.charAt(3) - 97][Integer.parseInt(cor.substring(4, 5)) - 1]).equals("-")) {
			if ((Math.abs(cor.charAt(0) - cor.charAt(3)) == 1 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 2) ||
				(Math.abs(cor.charAt(0) - cor.charAt(3)) == 2 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1)) {
				if(p.attackEnemyPiece(cor, b)) {
					attackPoint(b, p, cor);
					checkMove = true;
				}
			}
		}else {
			if ((Math.abs(cor.charAt(0) - cor.charAt(3)) == 1 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 2) ||
				(Math.abs(cor.charAt(0) - cor.charAt(3)) == 2 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1))
				checkMove = true;
		}
		return checkMove;
	}
	
	
}
