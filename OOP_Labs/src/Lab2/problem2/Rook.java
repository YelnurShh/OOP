package Lab2.problem2;

public class Rook extends Piece {
	public Rook(Position position, boolean isWhite) {
		super(position, isWhite);
	}

	@Override
	public boolean isLegalMove(Position target, Board board) {
		if (target.equals(position))
			return false;
		if (!target.isValid())
			return false;
		int dr = target.getRow() - position.getRow();
		int dc = target.getCol() - position.getCol();

		if (dr != 0 && dc != 0)
			return false;

		Piece atTarget = board.getPiece(target);
		if (atTarget != null && atTarget.isWhite() == isWhite)
			return false;
		return board.isPathClear(position, target);
	}

	@Override
	public String getSymbol() {
		return "R";
	}
}
