package pl.muklejski.chessgame.model.chesspieces;

import pl.muklejski.chessgame.model.constants.ChessmanType;
import pl.muklejski.chessgame.model.constants.MoveDirection;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;

public class Pawn extends Chessman {

	public Pawn(Player player) {
		super(player, ChessmanType.PAWN);
	}

	boolean isValidMove(MoveCharacteristic moveCharacteristic) {
		return isAttackMove(moveCharacteristic) ||
		       isOneSqForwardMove(moveCharacteristic) ||
		       isTwoSqForwardMove(moveCharacteristic);
	}

	private boolean isAttackMove(MoveCharacteristic moveCharacteristic) {
		MoveDirection moveDirection = moveCharacteristic.getMoveDirection();
		int length = moveCharacteristic.getLength();
		boolean occupiedToField = moveCharacteristic.isOccupiedToField();
		boolean forwardMove = moveCharacteristic.isForwardMove();
		return moveDirection.equals(MoveDirection.DIAGONAL) && length == 1 && occupiedToField && forwardMove;
	}

	private boolean isTwoSqForwardMove(MoveCharacteristic moveCharacteristic) {
		int length = moveCharacteristic.getLength();
		return isForwardMove(moveCharacteristic) && length == 2 && this.isFirstMove;
	}

	private boolean isOneSqForwardMove(MoveCharacteristic moveCharacteristic) {
		int length = moveCharacteristic.getLength();
		return isForwardMove(moveCharacteristic) && length == 1;
	}

	private boolean isForwardMove(MoveCharacteristic moveCharacteristic) {
		MoveDirection moveDirection = moveCharacteristic.getMoveDirection();
		boolean occupiedToField = moveCharacteristic.isOccupiedToField();
		boolean occupiedFieldsBetween = moveCharacteristic.isOccupiedFieldsBetween();
		boolean forwardMove = moveCharacteristic.isForwardMove();
		return moveDirection.equals(MoveDirection.VERTICAL) && !occupiedToField && !occupiedFieldsBetween && forwardMove;
	}
}
