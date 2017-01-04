package nineQueenPuzzle;

public class TestQueen {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 9;
		Queen puzzle = new Queen();
	    puzzle.enumerate(N);
	    System.out.print("There are " + puzzle.getCount());
	    System.out.println(" solutions.");
	    }
}
