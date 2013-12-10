import java.awt.*;

public class Canon extends Piece {
	public Canon(int s) { super(s); }
	
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		if(b.getPiece(newx, newy).getSide() == side) return false;
		if(b.getPiece(newx, newy).isNil()) {
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
		}
		else {
			int count = 0;
			if(x == newx) {
				int dir = y > newy ? -1 : 1;
				for(int i = y + dir; i != newy; i += dir) {
					if(!b.getPiece(x, i).isNil()) count++;
				}
			}
			else if (y == newy) {
				int dir = x > newx ? -1 : 1;
				for(int i = x + dir; i != newx; i += dir) {
					if(!b.getPiece(i, y).isNil()) count++;
				}
			}
			if(count == 1) return true;
		}
		return false;
	}
	
	public void draw() { System.out.print(side == 1 ? "C " : "c "); }
	public void paint(Graphics g) {
		Color woodcolor = new Color(246, 246, 204);
		g.setColor(woodcolor);
		g.fillOval(0, 10, 30, 30);
		g.setColor(side == 1 ? Color.BLACK : Color.RED);
		g.drawString(side == 1 ? "砲" : "炮", 4, 30);
	}
}