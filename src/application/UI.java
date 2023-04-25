package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
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
	
	public static void printMatch(ChessMatch chessMatch, List <ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
		
		if(chessMatch.getCheck()) {
			System.out.println("CHECK!");
		}
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		System.out.println(Colors.ANSI_RED + " \t    A B C D E F G H       \t" +Colors.ANSI_RESET);
		System.out.println("\t                             \t");

		for(int i = 0; i < pieces.length; i++) {
			System.out.print(Colors.ANSI_RED+" \t " + (8 - i) + "  ");
			for(int j = 0; j < pieces[i].length; j++) {
				printPiece(pieces[i][j], i + j, false);
			}
			System.out.print(Colors.ANSI_RED +" " + (8 - i) + "  \t" +Colors.ANSI_RESET);
			
			System.out.println();
		}
		System.out.println("\t                             \t");
		System.out.println(Colors.ANSI_RED + " \t    A B C D E F G H       \t" +Colors.ANSI_RESET);

	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		System.out.println(Colors.ANSI_RED + " \t    A B C D E F G H       \t" +Colors.ANSI_RESET);
		System.out.println("\t                             \t");

		for(int i = 0; i < pieces.length; i++) {
			System.out.print(Colors.ANSI_RED+" \t " + (8 - i) + "  ");
			for(int j = 0; j < pieces[i].length; j++) {
				printPiece(pieces[i][j], i + j, possibleMoves[i][j]);
			}
			System.out.print(Colors.ANSI_RED +" " + (8 - i) + "  \t" +Colors.ANSI_RESET);
			
			System.out.println();
		}
		System.out.println("\t                             \t");
		System.out.println(Colors.ANSI_RED + " \t    A B C D E F G H       \t" +Colors.ANSI_RESET);

	}
	
	private static void printPiece (ChessPiece piece, int i, boolean background) {
		if (background) {
			System.out.print(Colors.ANSI_BLUE_BACKGROUND);
		}
		if(piece == null) {
			if(i % 2 == 0 ) {
				System.out.print(Colors.ANSI_WHITE + "-" + Colors.ANSI_RESET) ;
			} else {
				System.out.print(Colors.ANSI_GREEN + "-" + Colors.ANSI_RESET);
			}
		} else {
			if(piece.getColor() == Color.WHITE) {
				System.out.print(Colors.ANSI_WHITE + piece + Colors.ANSI_RESET);
			} else {
				System.out.print(Colors.ANSI_YELLOW + piece + Colors.ANSI_RESET);
			}
		}
		System.out.print(" ");
	}

	
	public static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		
		System.out.println("Captured Pieces: ");
		
		System.out.print("White: ");
		System.out.print(Colors.ANSI_WHITE);
		System.out.print(Arrays.toString(white.toArray()));
		System.out.println(Colors.ANSI_RESET);
		
		System.out.print("Black: ");
		System.out.print(Colors.ANSI_YELLOW);
		System.out.print(Arrays.toString(black.toArray()));
		System.out.println(Colors.ANSI_RESET);
	}
	
	public static void clearScreen() {
		System.out.println("\033[H\033[2J");
		System.out.flush();
	}
}
