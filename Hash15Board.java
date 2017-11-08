/**
 * Hash15Board.java -- hashable board to store positions in solution of
 * 15-puzzle, create lists of available moves, etc.
 * 	
 * @author Andrew Borzi
 * 10/11/17
 */

import java.util.*;

public class Hash15Board {
	public static final String solvedBd = "123456789ABCDEF0";
	public static final int[][] transitions = { { 1, 4 }, { 0, 5, 2 }, { 1, 6, 3 }, { 2, 7 }, { 0, 5, 8 },
			{ 1, 4, 6, 9 }, { 2, 5, 7, 10 }, { 3, 6, 11 }, { 4, 9, 12 }, { 5, 8, 10, 13 }, { 6, 9, 11, 14 },
			{ 7, 10, 15 }, { 8, 13 }, { 9, 12, 14 }, { 10, 13, 15 }, { 11, 14 } };

	public static void printBoard(String bd) {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				System.out.print(bd.charAt(r * 4 + c) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static String scrambleBoard(int depth) {
		int emptyCell = 15;
		Random rand = new Random();
		String bd = solvedBd;
		for (int i = 0; i < depth; i++) {
			int[] legalMoves = transitions[emptyCell];
			int cell = legalMoves[rand.nextInt(legalMoves.length)];
			bd = move(bd, cell, emptyCell);
			//printBoard(bd);
			emptyCell = cell;
		}
		return bd;
	}

	public static String move(String bd, int from, int empty) {
		String newBd;
		char fromChar = bd.charAt(from);
		newBd = bd.replace('0', 'X').replace(fromChar, '0').replace('X', fromChar);
		return newBd;
	}

	public static boolean solve(String bd, HashSet<String> bdHash, int depth) {
		if (bd.equals(solvedBd)) {
			printBoard(bd);
			return true;
		} else if (depth <= 0) {
			return false;
		}

		bdHash.add(bd);
		int zeroPos = bd.indexOf('0');
		for (int mv : transitions[zeroPos]) {
			String newbd = move(bd, mv, zeroPos);
			if (bdHash.contains(newbd)) {
				continue;
			} else {
				if (solve(newbd, bdHash, (depth - 1))) {
					printBoard(newbd);
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		HashSet<String> bdHash = new HashSet<String>();
		String newBD = scrambleBoard(10);
		if (solve(newBD, bdHash, 20))
			System.out.println("There exists a solution.");
	}
}

