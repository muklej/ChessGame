package pl.muklejski.chessgame.model.chesspieces;

import pl.muklejski.chessgame.model.constants.ChessmanType;
import pl.muklejski.chessgame.model.constants.MoveDirection;
import static pl.muklejski.chessgame.model.constants.MoveDirection.*;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;

public class Bishop extends Chessman {

	public Bishop(Player player) {
		super(player, ChessmanType.BISHOP);
	}

	boolean isValidMove(MoveCharacteristic moveCharacteristic) {
		MoveDirection moveDirection = moveCharacteristic.getMoveDirection();
		boolean occupiedFieldsBetween = moveCharacteristic.isOccupiedFieldsBetween();
		return moveDirection.equals(DIAGONAL) && !occupiedFieldsBetween;
	}
}
