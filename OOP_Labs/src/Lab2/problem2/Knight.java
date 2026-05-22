package Lab2.problem2;

public class Knight extends Piece {
	public Knight(Position position, boolean isWhite) {
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
		// L-shape: (2,1) or (1,2)
		if (!((dr == 2 && dc == 1) || (dr == 1 && dc == 2)))
			return false;
		Piece atTarget = board.getPiece(target);
		if (atTarget != null && atTarget.isWhite() == isWhite)
			return false;
		return true;
	}

	@Override
	public String getSymbol() {
		return "N";
	}
}
