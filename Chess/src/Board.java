import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Board extends JPanel implements MouseListener {
	Piece[][] board;
	int turn = -1; // red first
	
	public Board() {
		board = new Piece[10][9];
		for(int i = 0; i < 10; i++) 
			for(int j = 0; j < 9; j++)
				board[i][j] = new Piece();
		addMouseListener(this);
	}
	
	public void movePiece(int x, int y, int newx, int newy) {
		if(board[x][y].canMoveTo(this, x, y, newx, newy)) {
			turn = turn * (-1);
			board[newx][newy] = board[x][y];
			board[x][y] = new Piece();
		}
	}
	
	public Piece getPiece(int x, int y) { return board[x][y]; }
	
	public void placePiece(int side, int type, int x, int y) {
		board[x][y]	= newPieceOnType(side, type);
	}
	
	Piece newPieceOnType(int side, int type) {
		switch(type) {
		
		case 1: return new Marshal(side);
		case 2: return new Guard(side);
		case 3: return new Bishop(side);
		case 4: return new Knight(side);
		case 5: return new Chariot(side);
		case 6: return new Canon(side);
		case 7: return new Pawn(side);
		default: return new Piece();
		}
	}
	
	public void initialization(int[][] matrix) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 9; j++) {
				int side = 0;
				if(matrix[i][j] > 0) side = 1;
				else if(matrix[i][j] < 0) side = -1;
				int type = matrix[i][j] * side;
				board[i][j] = newPieceOnType(side, type);
			}
		}
	}
	
	public void draw() {
		System.out.println("  0 1 2 3 4 5 6 7 8");
		for(int i = 0; i < 10; i++) {
			System.out.print(i);
			System.out.print(" ");
			for(int j = 0; j < 9; j++) {
				board[i][j].draw();
			}
			System.out.print('\n');
		}
		System.out.print('\n');
	}
	
	public void paintComponent(Graphics g){
		g.clearRect(0,  0,  getWidth(),  getHeight());
		Graphics bg = g.create(20, 20, 500, 800);
		bg.setColor(Color.DARK_GRAY);
		for(int i = 0; i < 10; i++) {
			bg.drawLine(14, i*80+25, 494, i*80+25);
		}
		bg.drawLine(14, 25, 14, 745);
		bg.drawLine(494, 25, 494, 745);
		for(int j = 1; j < 8; j++) {
			bg.drawLine(14+60*j, 25, 14+60*j, 345);
			bg.drawLine(14+60*j, 425, 14+60*j, 745);
		}
		Font font = new Font("simkai", Font.BOLD, 20);
		g.setFont(font);
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 9; j++)
				board[i][j].paint(g.create(j*60+20, i*80+20, 40,40));
	}
	
	
	boolean piece_selected = false;
	int select_x, select_y;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked");
		System.out.println(e.getX());
		System.out.println(e.getY());
		
		int xpos = e.getX(), ypos = e.getY();
		if(xpos < 20 || xpos > 530 || ypos < 30 || ypos > 790) {
			System.out.println("outside");
			piece_selected = false;
		}
		else {
			xpos = (xpos - 20)/60;
			ypos = (ypos - 30)/77;
			System.out.println(xpos);
			System.out.println(ypos);
			if(piece_selected) {
				movePiece(select_x, select_y, ypos, xpos);
				piece_selected = false;
				this.repaint();
			}
			else if(board[ypos][xpos].getSide() == turn) {
					select_x = ypos;
					select_y = xpos;
					piece_selected = true;
					System.out.println("selected");
					System.out.println(select_x);
					System.out.println(select_y);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Entered");
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Exited");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Released");
		
	}
}