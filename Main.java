import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		Game new_game = new Game();
		new_game.gameBoard.printBoard();
		exit:
		while (!(new_game.beyazlar.playerPoints >= 1000) || !(new_game.siyahlar.playerPoints >= 1000)) {
			System.out.println("Sira Beyazda. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
			while(true) {
				String move1 = key.nextLine();
				if (move1.equals("exit")) {
					break exit;
				}
				if (new_game.checkBoard(move1) && new_game.checkMove(move1, new_game.beyazlar)) {
					new_game.makeMove(move1);
					break;
				}
				else {
					System.out.println("hatali hamle");
					System.out.println("Beyazlar tekrar oynayacak");
				}
			}
			new_game.MoveBoard();
			new_game.gameBoard.printBoard();
			System.out.println("Sira Siyahlarda. Oynamak istediginiz tasin koordinatini ve tasi koymak istediginiz koordinati giriniz");
			while(true) {
				String move2 = key.nextLine();
				if (move2.equals("exit")) {
					break exit;
				}
				if (new_game.checkBoard(move2) && new_game.checkMove(move2, new_game.siyahlar)) {
					new_game.makeMove(move2);
					break;
				}
				else {
					System.out.println("hatali hamle");
					System.out.println("Siyahlar tekrar oynayacak");
				}
			}
			new_game.MoveBoard();
			new_game.gameBoard.printBoard();
		}
		System.out.println("Beyazlarýn Puaný: " + new_game.beyazlar.playerPoints);
		System.out.println("Siyahlarýn Puaný: " + new_game.siyahlar.playerPoints);
		
		if (new_game.beyazlar.playerPoints > new_game.siyahlar.playerPoints) 
			System.out.println("Kazanan: Beyazlar");
		else if (new_game.beyazlar.playerPoints < new_game.siyahlar.playerPoints)
			System.out.println("Kazanan: Siyahlar");
		else // equal
			System.out.println("Berabere");
	}
}