
public class Item{

	public int points = 0;
	
	public Item() {}
	public boolean Moves(Board b, String cor, Player p) {
		return false;
	}
	public void attackPoint(Board b, Player p, String cor) {
		p.addPoints(p, cor, b);
	}
}