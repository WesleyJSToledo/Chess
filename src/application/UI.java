package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			s = s.toUpperCase();
			
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			
			return new ChessPosition (column, row);
			
		} catch(RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from A1 to H8");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		System.out.println(Colors.ANSI_RED + " \t    A B C D E F G H       \t" +Colors.ANSI_RESET);
		System.out.println("\t                             \t");

		for(int i = 0; i < pieces.length; i++) {
			System.out.print(Colors.ANSI_RED+" \t " + (8 - i) + "  ");
			for(int j = 0; j < pieces[i].length; j++) {
				printPiece(pieces[i][j], i + j);
			}
			System.out.print(Colors.ANSI_RED +" " + (8 - i) + "  \t" +Colors.ANSI_RESET);
			
			System.out.println();
		}
		System.out.println("\t                             \t");
		System.out.println(Colors.ANSI_RED + " \t    A B C D E F G H       \t" +Colors.ANSI_RESET);

	}
	
	private static void printPiece (ChessPiece piece, int i) {
		
		if(piece == null) {
			if(i % 2 == 0 ) {
				System.out.print(Colors.ANSI_WHITE + "-" + Colors.ANSI_RESET) ;
			} else {
				System.out.print(Colors.ANSI_GREEN + "-" + Colors.ANSI_RESET);
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
	
	
	public static void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
}
