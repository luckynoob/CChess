import java.awt.*;
public class Piece {
	int side;
	
	public Piece(int s) { side = s; }
	public Piece() { this(0); }
	public boolean canMoveTo(Board b, int x, int y, int newx, int newy) {
		return false;
	}
	
	public void draw() { System.out.print("  "); }
	public void paint(Graphics graphics) {
		return;
	}
	
	public boolean isNil() { return (side == 0); }
	public int getSide() { return side; }
}