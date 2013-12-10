import java.awt.Color;
import java.awt.*;

public class Pawn extends Piece {
	public Pawn(int s) { super(s); }

	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		int col = y - newy;
		switch (col) {
		
		case 0: if(x + side == newx) return true;
			break;
		case 1: case -1:
			if(x == newx && (side == 1 && x > 4 || side == -1 && x < 5)) return true;
			break;
		default: break;
		}
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "P " : "p "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString(side == 1 ? "卒" : "兵", 4, 30);
	}
}