import java.awt.*;

public class Guard extends Piece {

	public Guard(int s) { super(s); }
	
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		if(newy < 3 || newy > 5) return false;
		if(side == 1 && newx > 2 || side == -1 && newx < 7) return false;
		if(Math.abs(x-newx) == 1 && Math.abs(y-newy) == 1) return true;
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "G " : "g "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString(side == 1 ? "仕" : "士", 4, 30);
	}
}