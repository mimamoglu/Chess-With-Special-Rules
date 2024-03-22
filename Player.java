
public class Player{

	public String playerType;
	public int playerPoints = 0;

	public Player(String k) {
		playerType = k;	
	}
	
	// Check if following player playing his/her chest pieces
	public boolean checkChestPiece(String o, Board b) {
		//System.out.println("checkpoint1");
		char c = b.gameBoard[o.charAt(0) - 97][Integer.parseInt(o.substring(1, 2))-1].charAt(0);
		boolean check2 = true;
		if (playerType.equals("BEYAZ")) {
			if (!(Character.isUpperCase(c))) {
				check2 = false;
			}
		}
		if (playerType.equals("SIYAH")) {
			if (!(Character.isLowerCase(c))) {
				check2 = false;
			}
		}
		return check2;
	}
	
	// Check if following player attacking enemy troops.
	public boolean attackEnemyPiece(String o, Board b) {
		boolean check3 = false;
		char m = b.gameBoard[o.charAt(3) - 97][Integer.parseInt(o.substring(4, 5))-1].charAt(0);
		if (this.playerType.equals("BEYAZ")) {
			if (Character.isUpperCase(m)) {
				check3 = false;
			}
			else 
				check3 = true;
		}
		if (this.playerType.equals("SIYAH")) {
			if (Character.isLowerCase(m)) {
				check3 = false;
			}
			else 
				check3 = true;
		}
		return check3;
	}
	//Add points to player depends on which chest piece he/she has eaten.
	public void addPoints(Player p, String cor, Board b) {
		int points = 0;
		if ((b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("p")) ||
			(b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("P"))	) {
			Piyon P = new Piyon();
			points = P.point;
		}
		if ((b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("k")) ||
			(b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("K"))) {
			Kale K = new Kale();
			points = K.point;
		}
			
		if ((b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("a")) ||
			(b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("A"))	) {
			At A = new At();
			points = A.point;	
		}
			
		if ((b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("f")) ||
			(b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("F"))	) {
			Fil F = new Fil();
			points = F.point;	
		}
			
		if ((b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("v")) ||
			(b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("V"))	) {
			Vezir V = new Vezir();
			points = V.point;	
		}
			
		if ((b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("s")) ||
			(b.gameBoard[cor.charAt(3)-97][Integer.parseInt(cor.substring(4, 5)) - 1].equals("S"))	) {
			points = 1000;
		}
		p.playerPoints += points;
	}
}