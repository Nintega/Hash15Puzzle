/**
 * Hash15Board.java -- hashable board to store positions in solution of
 * 15-puzzle, create lists of available moves, etc.
 * 	
 * @author Andrew Borzi
 * 9/29/17
 */
public class Hash15Board {

	/**
	 * @param args
	 */
	public static final int [][]transitions = {{1, 4}, {0, 5, 2}, {1, 6, 3}, {2, 7},
											  {0, 5, 8}, {1, 4, 6, 9}, {2, 5, 7, 10}, {3, 6, 11},
											  {4, 9, 12}, {5, 10, 13, 8}, {6, 11, 14, 9}, {7, 10, 15},
											  {8, 13}, {12, 9, 14}, {13, 10, 15}, {11, 14}};
	private String bd;
	private int depth;
	
	public Hash15Board() {
		bd = "123456789ABCDEF0";
		depth = 0;
	}
	
	// instead do  makeMove and undoMove methods
	public Hash15Board(Hash15Board oldBd, int legalMove) {
		char oldChar = oldBd.bd.charAt(legalMove);
		bd = oldBd.bd.replace('0', 'X')
					 .replace(oldChar, '0')
					 .replace('X', oldChar);
		depth += 1;
	}
	
	public static int[] legalMoves(int zeroPos) {
		return transitions[zeroPos];
	}
	
	public int[] legalMoves() {
		int zeroPos = bd.indexOf('0');
		return legalMoves(zeroPos);
	}
	public int hashable() {
		return this.hashCode();
	}
	public static void printBoard(String bd) {
		 for (int r = 0; r < 4; r++)
			 for (int c = 0; c < 4; c++)
				 System.out.print(bd.charAt(r*4 + c) + " ");
			 System.out.println();
		 System.out.println();
		 }
	
	/**public static String move(String bd, int from, int empty) {
		 String newBd;
		 char fromChar = bd.charAt(from);
		 newBd = bd.replace('0', 'X').replace(fromChar, '0').replace('X', fromChar);
		 return newBd;
		 }*/
	
	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		System.out.println("Kill me");

	}

}
