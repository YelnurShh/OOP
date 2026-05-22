package Lab2.problem2;

public class Pawn extends Piece {
	public Pawn(Position position, boolean isWhite) {
		super(position, isWhite);
	}

	@Override
	public boolean isLegalMove(Position target, Board board) {
		if (target.equals(position))
			return false;
		if (!target.isValid())
			return false;

		int direction = isWhite ? -1 : 1; // white moves up (row decreases), black moves down
		int startRow = isWhite ? 6 : 1;

		int dr = target.getRow() - position.getRow();
		int dc = target.getCol() - position.getCol();

		// One step forward
		if (dc == 0 && dr == direction) {
			return !board.isOccupied(target);
		}

		// Two steps from starting row
		if (dc == 0 && dr == 2 * direction && position.getRow() == startRow) {
			Position middle = new Position(position.getRow() + direction, position.getCol());
			return !board.isOccupied(middle) && !board.isOccupied(target);
		}

		// Diagonal capture
		if (Math.abs(dc) == 1 && dr == direction) {
			return board.isOccupiedByEnemy(target, isWhite);
		}

		return false;
	}

	@Override
	public String getSymbol() {
		return "P";
	}
}
