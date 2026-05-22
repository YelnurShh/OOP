package Lab2.problem2;

public class Queen extends Piece {
	public Queen(Position position, boolean isWhite) {
		super(position, isWhite);
	}

	@Override
	public boolean isLegalMove(Position target, Board board) {
		if (target.equals(position))
			return false;
		if (!target.isValid())
			return false;
		int dr = Math.abs(target.getRow() - position.getRow());
		int dc = Math.abs(target.getCol() - position.getCol());

		boolean straight = (dr == 0 || dc == 0);
		boolean diagonal = (dr == dc);
		if (!straight && !diagonal)
			return false;
		Piece atTarget = board.getPiece(target);
		if (atTarget != null && atTarget.isWhite() == isWhite)
			return false;
		return board.isPathClear(position, target);
	}

	@Override
	public String getSymbol() {
		return "Q";
	}
}
