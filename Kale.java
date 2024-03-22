
public class Kale extends Item{

	public int point = 5;
	
	public boolean Moves(Board b, String cor, Player p) {
		boolean checkMove = false;
		//If rook going sideways check if there is a chest piece on his road (not end of the road)
		if (cor.charAt(0) == cor.charAt(3)) {
			if (Integer.parseInt(cor.substring(1, 2)) < Integer.parseInt(cor.substring(4, 5))) {
				for(int i = Integer.parseInt(cor.substring(1, 2)); i <= Integer.parseInt(cor.substring(4, 5)) - 1; i++) {
					if (!(b.gameBoard[cor.charAt(0) - 97][i].equals("-"))) {
							if (i == Integer.parseInt(cor.substring(4, 5)) - 1) { // If end of the road not
								if (p.attackEnemyPiece(cor, b)) {				  // empty, check if player can
									attackPoint(b, p, cor);
									checkMove = true;							  // attack chest piece (not his/her)
								}
							}
							else {
								checkMove = false;
								break;
							}
					}else 
						checkMove = true;
					
				}
			}else {
				for(int i = Integer.parseInt(cor.substring(1, 2)) - 2; i >= Integer.parseInt(cor.substring(4, 5)) - 1; i--) {
					if (!(b.gameBoard[cor.charAt(0) - 97][i].equals("-"))) {
						if (i == Integer.parseInt(cor.substring(4, 5)) - 1){ // If end of the road not
							if (p.attackEnemyPiece(cor, b)) {				 // empty, check if player can
								attackPoint(b, p, cor);
								checkMove = true;							 // attack chest piece (not his/her)
							}
						}
						else {
							checkMove = false;
							break;
						}
					}
					else 
						checkMove = true;
					
				}
			}
		}
		//If rook going forward and backward check if there is a chest piece on his road (not end of the road)
		if (Integer.parseInt(cor.substring(1, 2)) == Integer.parseInt(cor.substring(4, 5))) {
			if (cor.charAt(0) > cor.charAt(3)) {
				for(int k = cor.charAt(0) - 98; k >= cor.charAt(3) - 97; k--) {
					if (!(b.gameBoard[k][Integer.parseInt(cor.substring(1, 2))-1].equals("-"))) {
						if (k == cor.charAt(3) - 97){			// If end of the road not
							if (p.attackEnemyPiece(cor, b))	{	// empty, check if player can
								attackPoint(b, p, cor);
								checkMove = true;				// attack chest piece (not his/her)
							}
						}
						else {
							checkMove = false;
							break;
							}
					}
					else
						checkMove = true;
					
				}
			}else {
				//System.out.println("checkpoint5");
				for(int l = cor.charAt(0) - 96; l <= cor.charAt(3) - 97; l++) {
					if (!(b.gameBoard[l][Integer.parseInt(cor.substring(1, 2))-1].equals("-"))) {
						if (l == cor.charAt(3) - 97){		// If end of the road not
							if (p.attackEnemyPiece(cor, b)) { // empty, check if player can
								attackPoint(b, p, cor);
								checkMove = true;			// attack chest piece (not his/her)
							}
						}
						else {
							checkMove = false;
							break;
						}
					}
					else
						checkMove = true;
				}
			}
		}
		return checkMove;
	}
}