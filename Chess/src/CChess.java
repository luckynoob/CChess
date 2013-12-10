import java.util.Scanner;

class CChess {
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
		testboard.draw();
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int newx = sc.nextInt();
			int newy = sc.nextInt();
			testboard.movePiece(x,y,newx,newy);
			testboard.draw();
		}
		sc.close();
	}
}