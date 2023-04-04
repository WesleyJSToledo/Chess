package application;

import chess.ChessPiece;
import chess.Color;

public class UI {
	
	
	public static void printBoard(ChessPiece[][] pieces) {
		System.out.println(Colors.ANSI_RED + " \t   A B C D E F G H       \t" +Colors.ANSI_RESET);
		System.out.println("\t                             \t");

		for(int i = 0; i < pieces.length; i++) {
			System.out.print("\t" + (8 - i) + "  ");
			for(int j = 0; j < pieces[i].length; j++) {
				printPiece(pieces[i][j], i + j);
			}
			System.out.print(Colors.ANSI_RED +"  " + (8 - i) + "  \t" +Colors.ANSI_RESET);
			
			System.out.println();
		}
		System.out.println("\t                             \t");
		System.out.println(Colors.ANSI_RED + " \t   A B C D E F G H       \t" +Colors.ANSI_RESET);

	}
	
	private static void printPiece (ChessPiece piece, int i) {
		
		if(piece == null) {
			if(i % 2 == 0 ) {
				System.out.print(Colors.ANSI_WHITE + "\u25A0" + Colors.ANSI_RESET) ;
			} else {
				System.out.print(Colors.ANSI_GREEN + "\u25A0" + Colors.ANSI_RESET);
			}
		} else {
			if(piece.getColor() == Color.WHITE) {
				System.out.print(Colors.ANSI_WHITE + piece);
			} else {
				System.out.print(Colors.ANSI_YELLOW + piece);
			}
		}
		System.out.print(" ");
	}
}
