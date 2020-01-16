package pl.muklejski.chessgame.model.validators;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import pl.muklejski.chessgame.model.GameBoard;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_MOVE_ENDED_IN_CHECK;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.Coordinate;
import pl.muklejski.chessgame.model.cordinates.Coordinates;
import pl.muklejski.chessgame.model.exceptions.CheckException;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

@RequiredArgsConstructor
public class CheckValidator {

	private final GameBoard gameBoard;
	private final Player player;


	public boolean validate() throws InvalidCoordinateException, CheckException {
		if (validate(this.player)) {
			throw new CheckException(INVALID_MOVE_ENDED_IN_CHECK);
		}
		return validate(Player.getOpponent(player));
	}

	private boolean validate(Player player) throws InvalidCoordinateException {
		Coordinate myKingCoordinate = gameBoard.getPlayerChessmanKingCoordinate(player);
		Player opponent = Player.getOpponent(player);
		Set<Coordinate> opponentChessmanCoordinates = gameBoard.getPlayerChessmanOtherThanKingCoordinates(opponent);
		for (Coordinate coordinate : opponentChessmanCoordinates) {
			Coordinates coordinates = new Coordinates(coordinate, myKingCoordinate);
			try {
				if (new MoveValidator(coordinates, gameBoard, opponent).validate()) {
					return true;
				}
			} catch (InvalidMoveException | InvalidCoordinateException ignored) {
			}
		}
		return false;
	}
}
