
public class Fil extends Item{

	public int point = 3;
	
	public boolean Moves(Board b, String cor, Player p) {
		boolean checkMove = false;
		int index_sideway = 0;
		//Check if bishop's move has slope 1
		if (Math.abs(cor.charAt(0) - cor.charAt(3)) / Math.abs(Integer.parseInt(cor.substring(1, 2)) - Integer.parseInt(cor.substring(4, 5))) == 1) {
			if ((cor.charAt(0) > cor.charAt(3)) && (Integer.parseInt(cor.substring(1, 2)) < Integer.parseInt(cor.substring(4, 5)))) { // Kuzey Dogu Yonu
				index_sideway = Integer.parseInt(cor.substring(1, 2));
				for(int i = cor.charAt(0) - 98; i >= cor.charAt(3) - 97; i--) {
					if (!(b.gameBoard[i][index_sideway].equals("-"))) {
						if (i == cor.charAt(3) - 97){ 						 // If end of the road not
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
						if (i == cor.charAt(3) - 97){ 						 // If end of the road not
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
						if (i == cor.charAt(3) - 97){ 						 // If end of the road not
							if (p.attackEnemyPiece(cor, b)) {					 // empty, check if player can
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
						if (i == cor.charAt(3) - 97){ 						 // If end of the road not
							if (p.attackEnemyPiece(cor, b))	 {				 // empty, check if player can
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
		
		return checkMove;
	}
	
}
