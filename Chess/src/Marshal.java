import java.awt.Color;
import java.awt.*;

public class Marshal extends Piece {

	public Marshal(int s) { super(s); }
	
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		if(newy < 3 || newy > 5) return false;
		if(side == 1 && newx > 2 || side == -1 && newx < 7) return false;
		if(Math.abs(x-newx) + Math.abs(y-newy) == 1) return true;
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "M " : "m "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString(side == 1 ? "将" : "帅", 4, 30);
	}
}