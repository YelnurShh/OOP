package Lab2.problem2;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private Piece[][] grid;

	public Board() {
		grid = new Piece[8][8];
	}

	public Piece getPiece(Position pos) {
		if (!pos.isValid())
			return null;
		return grid[pos.getRow()][pos.getCol()];
	}

	public void setPiece(Piece piece, Position pos) {
		grid[pos.getRow()][pos.getCol()] = piece;
		if (piece != null)
			piece.setPosition(pos);
	}

	public void removePiece(Position pos) {
		grid[pos.getRow()][pos.getCol()] = null;
	}

	public boolean isOccupied(Position pos) {
		return getPiece(pos) != null;
	}

	public boolean isOccupiedByEnemy(Position pos, boolean byWhite) {
		Piece p = getPiece(pos);
		return p != null && p.isWhite() != byWhite;
	}

	public boolean isPathClear(Position from, Position to) {
		int rowDir = Integer.signum(to.getRow() - from.getRow());
		int colDir = Integer.signum(to.getCol() - from.getCol());
		int r = from.getRow() + rowDir;
		int c = from.getCol() + colDir;
		while (r != to.getRow() || c != to.getCol()) {
			if (grid[r][c] != null)
				return false;
			r += rowDir;
			c += colDir;
		}
		return true;
	}

	/** Move a piece; returns captured piece or null */
	public Piece movePiece(Position from, Position to) {
		Piece moving = getPiece(from);
		Piece captured = getPiece(to);
		removePiece(from);
		setPiece(moving, to);
		return captured;
	}

	/** Find king position for given color */
	public Position findKing(boolean white) {
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++) {
				Piece p = grid[r][c];
				if (p instanceof King && p.isWhite() == white)
					return new Position(r, c);
			}
		return null;
	}

	/** Check if the given color's king is in check */
	public boolean isInCheck(boolean white) {
		Position kingPos = findKing(white);
		if (kingPos == null)
			return false;
		for (int r = 0; r < 8; r++)
			for (int c = 0; c < 8; c++) {
				Piece p = grid[r][c];
				if (p != null && p.isWhite() != white) {
					if (p.isLegalMove(kingPos, this))
						return true;
				}
			}
		return false;
	}

	/** Returns all legal moves for a piece (that don't leave own king in check) */
	public List<Position> getLegalMoves(Piece piece) {
		List<Position> moves = new ArrayList<>();
		Position from = piece.getPosition();
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				Position to = new Position(r, c);
				if (piece.isLegalMove(to, this)) {
					// Simulate move
					Piece captured = movePiece(from, to);
					boolean inCheck = isInCheck(piece.isWhite());
					// Undo
					movePiece(to, from);
					setPiece(captured, to);
					if (!inCheck)
						moves.add(to);
				}
			}
		}
		return moves;
	}

	/** Check if color has any legal moves (for checkmate/stalemate) */
	public boolean hasLegalMoves(boolean white) {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				Piece p = grid[r][c];
				if (p != null && p.isWhite() == white) {
					if (!getLegalMoves(p).isEmpty())
						return true;
				}
			}
		}
		return false;
	}

	/** Draw the board to console */
	public void draw() {
		System.out.println();
		System.out.println("    a   b   c   d   e   f   g   h");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int r = 0; r < 8; r++) {
			System.out.print((8 - r) + " |");
			for (int c = 0; c < 8; c++) {
				Piece p = grid[r][c];
				if (p == null) {
					System.out.print((r + c) % 2 == 0 ? "   |" : " . |");
				} else {
					String sym = p.isWhite() ? p.getSymbol().toUpperCase() : p.getSymbol().toLowerCase();
					System.out.print(" " + sym + " |");
				}
			}
			System.out.println(" " + (8 - r));
			System.out.println("  +---+---+---+---+---+---+---+---+");
		}
		System.out.println("    a   b   c   d   e   f   g   h");
		System.out.println();
	}

	/** Setup standard starting position */
	public void setupStandardPosition() {
		// Black pieces (row 0-1)
		setPiece(new Rook(new Position(0, 0), false), new Position(0, 0));
		setPiece(new Knight(new Position(0, 1), false), new Position(0, 1));
		setPiece(new Bishop(new Position(0, 2), false), new Position(0, 2));
		setPiece(new Queen(new Position(0, 3), false), new Position(0, 3));
		setPiece(new King(new Position(0, 4), false), new Position(0, 4));
		setPiece(new Bishop(new Position(0, 5), false), new Position(0, 5));
		setPiece(new Knight(new Position(0, 6), false), new Position(0, 6));
		setPiece(new Rook(new Position(0, 7), false), new Position(0, 7));
		for (int c = 0; c < 8; c++)
			setPiece(new Pawn(new Position(1, c), false), new Position(1, c));

		// White pieces (row 6-7)
		for (int c = 0; c < 8; c++)
			setPiece(new Pawn(new Position(6, c), true), new Position(6, c));
		setPiece(new Rook(new Position(7, 0), true), new Position(7, 0));
		setPiece(new Knight(new Position(7, 1), true), new Position(7, 1));
		setPiece(new Bishop(new Position(7, 2), true), new Position(7, 2));
		setPiece(new Queen(new Position(7, 3), true), new Position(7, 3));
		setPiece(new King(new Position(7, 4), true), new Position(7, 4));
		setPiece(new Bishop(new Position(7, 5), true), new Position(7, 5));
		setPiece(new Knight(new Position(7, 6), true), new Position(7, 6));
		setPiece(new Rook(new Position(7, 7), true), new Position(7, 7));
	}
}
