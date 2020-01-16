package pl.muklejski.chessgame.model.chesspieces;

import pl.muklejski.chessgame.model.constants.ChessmanType;
import pl.muklejski.chessgame.model.constants.MoveDirection;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;

public class Knight extends Chessman {

	public Knight(Player player) {
		super(player, ChessmanType.KNIGHT);
	}

	boolean isValidMove(MoveCharacteristic moveCharacteristic) {
		MoveDirection moveDirection = moveCharacteristic.getMoveDirection();
		return moveDirection.equals(MoveDirection.KNIGHT);
	}
}
