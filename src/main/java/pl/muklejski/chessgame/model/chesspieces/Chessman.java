package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import pl.muklejski.chessgame.model.constants.Messages;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;


@RequiredArgsConstructor
public abstract class Chessman {

	@Getter
	private final Player player;

	@Getter
	private final ChessmanType chessmanType;
	boolean isFirstMove = true;

	public char getName() {
		return player.getPlayerConfig().getNameChanger(chessmanType.getAbbreviation());
	}

	abstract boolean isValidMove(MoveCharacteristic moveCharacteristic);

	public boolean validateMove(MoveCharacteristic moveCharacteristic) throws InvalidMoveException {
		if (isValidMove(moveCharacteristic)) {
			return true;
		} else {
			throw new InvalidMoveException(format(Messages.MOVE_NOT_VALID_WITH_RULES, this.chessmanType));
		}
	}

	public void setNotFirstMove() {
		this.isFirstMove = false;
	}
}
