
public class Vezir extends Item{

	public int point = 9;
	
	public boolean Moves(Board b, String cor, Player p) {
		boolean checkMove = false;
		int index_sideway = 0;
		//If queen going sideways check if there is a chest piece on his road (not end of the road)
		if (cor.charAt(0) == cor.charAt(3)) {
			if (Integer.parseInt(cor.substring(1, 2)) < Integer.parseInt(cor.substring(4, 5))) {
				for(int i = Integer.parseInt(cor.substring(1, 2)); i <= Integer.parseInt(cor.substring(4, 5)) - 1; i++) {
					if (!(b.gameBoard[cor.charAt(0) - 97][i].equals("-"))) {
						if (i == Integer.parseInt(cor.substring(4, 5)) - 1){ // If end of the road not
							if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
			}else {
				for(int i = Integer.parseInt(cor.substring(1, 2)) - 2; i >= Integer.parseInt(cor.substring(4, 5)) - 1; i--) {
					if (!(b.gameBoard[cor.charAt(0) - 97][i].equals("-"))) {
						if (i == Integer.parseInt(cor.substring(4, 5)) - 1){ // If end of the road not
							if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
		//If queen going forward and backward check if there is a chest piece on his road (not end of the road)
		if (Integer.parseInt(cor.substring(1, 2)) == Integer.parseInt(cor.substring(4, 5))) {
			if (cor.charAt(0) > cor.charAt(3)) {
				for(int k = cor.charAt(0) - 98; k >= cor.charAt(3) - 97; k--) {
					if (!(b.gameBoard[k][Integer.parseInt(cor.substring(1, 2))-1].equals("-"))) {
						if (k == cor.charAt(3) - 97){ 							 // If end of the road not
							if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
			}else {
				for(int l = cor.charAt(0) - 96; l <= cor.charAt(3) - 97; l++) {
					if (!(b.gameBoard[l][Integer.parseInt(cor.substring(1, 2))-1].equals("-"))) {
						if (l == cor.charAt(3) - 97){ 					     // If end of the road not
							if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
		//Cross movement of queen
		if (Math.abs(cor.charAt(0) - cor.charAt(3)) != 0 && Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) != 0) {
			if (Math.abs(cor.charAt(0) - cor.charAt(3)) / Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1) {
				if ((cor.charAt(0) > cor.charAt(3)) && (Integer.parseInt(cor.substring(1, 2)) < Integer.parseInt(cor.substring(4, 5)))) { // Kuzey Dogu Yonu
					index_sideway = Integer.parseInt(cor.substring(1, 2));
					for(int i = cor.charAt(0) - 98; i >= cor.charAt(3) - 97; i--) {
						if (!(b.gameBoard[i][index_sideway].equals("-"))) {
							if (i == cor.charAt(3) - 97){ 							// If end of the road not
								if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
						index_sideway++;
					}
				}
			    else if ((cor.charAt(0) > cor.charAt(3)) && (Integer.parseInt(cor.substring(1, 2)) > Integer.parseInt(cor.substring(4, 5)))) { // Kuzey Batý Yonu
			    	index_sideway = Integer.parseInt(cor.substring(1, 2)) - 2;
					for(int i = cor.charAt(0) - 98; i >= cor.charAt(3) - 97; i--) {
						if (!(b.gameBoard[i][index_sideway].equals("-"))){
							if (i == cor.charAt(3) - 97){ 							 // If end of the road not
								if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
						index_sideway--;
					}
				}
				else if ((cor.charAt(0) < cor.charAt(3)) && (Integer.parseInt(cor.substring(1, 2)) < Integer.parseInt(cor.substring(4, 5)))) { // Guney Dogu Yonu
					index_sideway = Integer.parseInt(cor.substring(1, 2));
					for(int i = cor.charAt(0) - 96; i <= cor.charAt(3) - 97; i++) {
						if (!(b.gameBoard[i][index_sideway].equals("-"))){
							if (i == cor.charAt(3) - 97){ 							 // If end of the road not
								if (p.attackEnemyPiece(cor, b))	{				 // empty, check if player can
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
						index_sideway++;
					}
				}
					
				else { //if ((cor.charAt(0) < cor.charAt(3)) && (Integer.parseInt(cor.substring(1, 2)) > Integer.parseInt(cor.substring(4, 5)))) // Guney Batý Yonu
					index_sideway = Integer.parseInt(cor.substring(1, 2)) - 2;
					for(int i = cor.charAt(0) - 96; i <= cor.charAt(3) - 97; i++) {
						if (!(b.gameBoard[i][index_sideway].equals("-"))){
							if (i == cor.charAt(3) - 97){ 							 // If end of the road not
								if (p.attackEnemyPiece(cor, b))	{			 // empty, check if player can
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
						index_sideway--;
					}
				}
			}
		}
		return checkMove;
	}
}