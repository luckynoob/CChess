import java.util.Scanner;

import javax.swing.*;

class GUIchess {
	public static void main(String[] args) {
		System.out.println("Welcome !");
		Board testboard = new Board();
		int[][] positions = {{ 5, 4, 3, 2, 1, 2, 3, 4, 5},
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 { 0, 6, 0, 0, 0, 0, 0, 6, 0},
							 { 7, 0, 7, 0, 7, 0, 7, 0, 7},
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {-7, 0,-7, 0,-7, 0,-7, 0,-7},
							 { 0,-6, 0, 0, 0, 0, 0,-6, 0},
							 { 0, 0, 0, 0, 0, 0, 0, 0, 0},
							 {-5,-4,-3,-2,-1,-2,-3,-4,-5},};
		testboard.initialization(positions);
		
		JFrame f = new JFrame("Chiness Chess");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(testboard);
		f.setSize(700,850);
		f.setVisible(true);
	}
	
}