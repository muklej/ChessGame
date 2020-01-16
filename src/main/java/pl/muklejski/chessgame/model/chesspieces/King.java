package pl.muklejski.chessgame.model.chesspieces;

import pl.muklejski.chessgame.model.constants.ChessmanType;
import pl.muklejski.chessgame.model.constants.MoveDirection;
import static pl.muklejski.chessgame.model.constants.MoveDirection.DIAGONAL;
import static pl.muklejski.chessgame.model.constants.MoveDirection.HORIZONTAL;
import static pl.muklejski.chessgame.model.constants.MoveDirection.VERTICAL;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;

public class King extends Chessman {

	public King(Player player) {
		super(player, ChessmanType.KING);
	}

	boolean isValidMove(MoveCharacteristic moveCharacteristic) {

		int length = moveCharacteristic.getLength();
		return checkValidDirection(moveCharacteristic) && length == 1;
	}

	private boolean checkValidDirection(MoveCharacteristic moveCharacteristic) {
		MoveDirection moveDirection = moveCharacteristic.getMoveDirection();
		return moveDirection.equals(DIAGONAL) || moveDirection.equals(HORIZONTAL) || moveDirection.equals(VERTICAL);
	}
}
