import java.awt.*;

public class Chariot extends Piece {
	public Chariot(int s) { super(s); }
	
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		if(x == newx) {
			int dir = y > newy ? -1 : 1;
			for(int i = y + dir; i != newy; i += dir) {
				if(!b.getPiece(x, i).isNil()) return false;
			}
			return true;
		}
		else if (y == newy) {
			int dir = x > newx ? -1 : 1;
			for(int i = x + dir; i != newx; i += dir) {
				if(!b.getPiece(i, y).isNil()) return false;
			}
			return true;
		}
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "Z " : "z "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString(side == 1? "車" : "车", 4, 30);
	}
}