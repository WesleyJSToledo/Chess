package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = ((ChessPiece) board.piece(i, j));
			}
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validadeSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		
		return (ChessPiece) capturedPiece;
		
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
 	private void validadeSourcePosition(Position position) {
 		if (!board.thereIsAPiece(position)) {
 			throw new ChessException("There is no piece on source position");
 		}
 		
 	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
			board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('E', 8, new King(board, Color.WHITE));
		placeNewPiece('D', 8, new Queen(board, Color.WHITE));
		
		placeNewPiece('C', 8, new Bishop(board, Color.WHITE));
		placeNewPiece('F', 8, new Bishop(board, Color.WHITE));
		
		placeNewPiece('A', 8, new Rook(board, Color.WHITE));
		placeNewPiece('H', 8, new Rook(board, Color.WHITE));
		
		placeNewPiece('B', 8, new Knight(board, Color.WHITE));
		placeNewPiece('G', 8, new Knight(board, Color.WHITE));
		
		placeNewPiece('A', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('B', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('C', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('D', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('E', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('F', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('G', 7, new Pawn(board, Color.WHITE));
		placeNewPiece('H', 7, new Pawn(board, Color.WHITE));
	
		
		
		placeNewPiece('E', 1, new King(board, Color.BLACK));
		placeNewPiece('D', 1, new Queen(board, Color.BLACK));
		
		placeNewPiece('C', 1, new Bishop(board, Color.BLACK));
		placeNewPiece('F', 1, new Bishop(board, Color.BLACK));
		
		placeNewPiece('A', 1, new Rook(board, Color.BLACK));
		placeNewPiece('H', 1, new Rook(board, Color.BLACK));
		
		placeNewPiece('B', 1, new Knight(board, Color.BLACK));
		placeNewPiece('G', 1, new Knight(board, Color.BLACK));
		
		placeNewPiece('A', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('B', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('C', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('D', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('E', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('F', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('G', 2, new Pawn(board, Color.BLACK));
		placeNewPiece('H', 2, new Pawn(board, Color.BLACK));
	

	}
}
