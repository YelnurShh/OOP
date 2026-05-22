package Lab2.problem2;

import java.util.List;
import java.util.Scanner;

public class ChessGame {
	private Board board;
	private boolean whiteTurn;
	private Scanner scanner;

	public ChessGame() {
		board = new Board();
		board.setupStandardPosition();
		whiteTurn = true;
		scanner = new Scanner(System.in);
	}

	/** Parse algebraic notation like "e2" → Position */
	private Position parsePosition(String s) {
		s = s.trim().toLowerCase();
		if (s.length() != 2)
			return null;
		int col = s.charAt(0) - 'a';
		int row = 8 - (s.charAt(1) - '0');
		Position pos = new Position(row, col);
		return pos.isValid() ? pos : null;
	}

	/** Print whose turn it is and check status */
	private void printStatus() {
		String color = whiteTurn ? "WHITE" : "BLACK";
		System.out.println("=== " + color + "'s turn ===");
		if (board.isInCheck(whiteTurn)) {
			System.out.println("  *** CHECK! ***");
		}
	}

	/** Handle pawn promotion: auto-promote to Queen */
	private void handlePromotion() {
		for (int c = 0; c < 8; c++) {
			Piece p = board.getPiece(new Position(0, c));
			if (p instanceof Pawn && p.isWhite()) {
				board.setPiece(new Queen(new Position(0, c), true), new Position(0, c));
				System.out.println("  Pawn promoted to Queen!");
			}
			p = board.getPiece(new Position(7, c));
			if (p instanceof Pawn && !p.isWhite()) {
				board.setPiece(new Queen(new Position(7, c), false), new Position(7, c));
				System.out.println("  Pawn promoted to Queen!");
			}
		}
	}

	/** Show available moves for a given piece */
	private void showAvailableMoves(Piece piece) {
		List<Position> moves = board.getLegalMoves(piece);
		if (moves.isEmpty()) {
			System.out.println("  No legal moves for this piece.");
		} else {
			System.out.print("  Legal moves: ");
			for (Position m : moves)
				System.out.print(m + " ");
			System.out.println();
		}
	}

	/** Main game loop */
	public void play() {
		System.out.println("╔══════════════════════════════╗");
		System.out.println("║    WELCOME TO CHESS GAME     ║");
		System.out.println("╠══════════════════════════════╣");
		System.out.println("║ Commands:                    ║");
		System.out.println("║  <from> <to>  e.g. 'e2 e4'  ║");
		System.out.println("║  'hint <sq>'  e.g. 'hint e2' ║");
		System.out.println("║  'resign'  to resign         ║");
		System.out.println("╚══════════════════════════════╝");

		board.draw();

		while (true) {
			printStatus();
			System.out.print("Enter move: ");
			String input = scanner.nextLine().trim();

			if (input.equalsIgnoreCase("resign")) {
				String winner = whiteTurn ? "BLACK" : "WHITE";
				System.out.println(winner + " wins by resignation!");
				break;
			}

			// Hint command
			if (input.toLowerCase().startsWith("hint")) {
				String[] parts = input.split("\\s+");
				if (parts.length == 2) {
					Position pos = parsePosition(parts[1]);
					if (pos != null) {
						Piece p = board.getPiece(pos);
						if (p != null && p.isWhite() == whiteTurn) {
							showAvailableMoves(p);
						} else {
							System.out.println("  No friendly piece at " + parts[1]);
						}
					} else {
						System.out.println("  Invalid square.");
					}
				}
				continue;
			}

			// Parse move
			String[] parts = input.split("\\s+");
			if (parts.length != 2) {
				System.out.println("  Invalid input. Use format: e2 e4");
				continue;
			}

			Position from = parsePosition(parts[0]);
			Position to = parsePosition(parts[1]);

			if (from == null || to == null) {
				System.out.println("  Invalid square. Use a-h and 1-8, e.g. e2 e4");
				continue;
			}

			Piece piece = board.getPiece(from);

			if (piece == null) {
				System.out.println("  No piece at " + parts[0]);
				continue;
			}

			if (piece.isWhite() != whiteTurn) {
				System.out.println("  That's not your piece!");
				continue;
			}

			// Check if move is in legal moves (including king safety)
			List<Position> legal = board.getLegalMoves(piece);
			if (!legal.contains(to)) {
				System.out.println("  Illegal move! (use 'hint " + parts[0] + "' to see legal moves)");
				continue;
			}

			// Execute move
			Piece captured = board.movePiece(from, to);
			if (captured != null) {
				System.out.println("  Captured: " + captured);
			}

			handlePromotion();

			whiteTurn = !whiteTurn;

			board.draw();

			if (!board.hasLegalMoves(whiteTurn)) {
				board.draw();
				if (board.isInCheck(whiteTurn)) {
					String winner = whiteTurn ? "BLACK" : "WHITE";
					System.out.println("╔══════════════════════╗");
					System.out.println("║    CHECKMATE!        ║");
					System.out.println("║  " + winner + " wins!          ║");
					System.out.println("╚══════════════════════╝");
				} else {
					System.out.println("╔══════════════════════╗");
					System.out.println("║    STALEMATE!        ║");
					System.out.println("║    Draw!             ║");
					System.out.println("╚══════════════════════╝");
				}
				break;
			}
		}

		scanner.close();
	}

	public static void main(String[] args) {
		new ChessGame().play();
	}
}

//f2 f3
//e7 e5
//g2 g4
//d8 h4 
