package Lab2.problem2;

public class King extends Piece {
	public King(Position position, boolean isWhite) {
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
		if (dr > 1 || dc > 1)
			return false;
		Piece atTarget = board.getPiece(target);
		if (atTarget != null && atTarget.isWhite() == isWhite)
			return false;
		return true;
	}

	@Override
	public String getSymbol() {
		return "K";
	}
}
