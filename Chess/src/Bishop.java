import java.awt.*;

public class Bishop extends Piece {

	public Bishop(int s) { super(s); }
	
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		if(side == 1 && newx > 4 || side == -1 && newx < 5) return false;
		if(Math.abs(x-newx) == 2 && Math.abs(y-newy) == 2) {
			if(b.getPiece((x+newx)/2, (y+newy)/2).isNil()) return true;
		}
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "B " : "b "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString(side == 1 ? "象" : "相", 4, 30);
	}
}