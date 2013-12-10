import java.awt.Color;
import java.awt.*;

public class Knight extends Piece {
	public Knight(int s) { super(s); }
	
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		int i = Math.abs(x-newx), j = Math.abs(y-newy);
		if(i == 1 && j == 2) {
			if(b.getPiece(x, (y+newy)/2).isNil()) return true;
		} 
		else if (i == 2 && j == 1) {
			if(b.getPiece((x+newx)/2, y).isNil()) return true;
		}
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "K " : "k "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString("马", 4, 30);
	}
}