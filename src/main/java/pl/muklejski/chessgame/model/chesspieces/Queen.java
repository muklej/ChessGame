package pl.muklejski.chessgame.model.chesspieces;

import pl.muklejski.chessgame.model.constants.ChessmanType;
import pl.muklejski.chessgame.model.constants.MoveDirection;
import static pl.muklejski.chessgame.model.constants.MoveDirection.DIAGONAL;
import static pl.muklejski.chessgame.model.constants.MoveDirection.HORIZONTAL;
import static pl.muklejski.chessgame.model.constants.MoveDirection.VERTICAL;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;

public class Queen extends Chessman {

	public Queen(Player player) {
		super(player, ChessmanType.QUEEN);
	}

	boolean isValidMove(MoveCharacteristic moveCharacteristic) {
		boolean occupiedFieldsBetween = moveCharacteristic.isOccupiedFieldsBetween();
		return checkValidDirection(moveCharacteristic) && !occupiedFieldsBetween;
	}

	private boolean checkValidDirection(MoveCharacteristic moveCharacteristic) {
		MoveDirection moveDirection = moveCharacteristic.getMoveDirection();
		return moveDirection.equals(DIAGONAL) || moveDirection.equals(HORIZONTAL) || moveDirection.equals(VERTICAL);
	}
}
