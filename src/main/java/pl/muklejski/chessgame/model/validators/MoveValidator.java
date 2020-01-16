package pl.muklejski.chessgame.model.validators;

import lombok.RequiredArgsConstructor;
import pl.muklejski.chessgame.model.GameBoard;
import pl.muklejski.chessgame.model.chesspieces.Chessman;
import static pl.muklejski.chessgame.model.constants.Messages.CANT_ATTACK_YOUR_CHESSMAN;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_MOVE;
import pl.muklejski.chessgame.model.constants.MoveDirection;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.Coordinate;
import pl.muklejski.chessgame.model.cordinates.Coordinates;
import pl.muklejski.chessgame.model.cordinates.MoveCharacteristic;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

@RequiredArgsConstructor
public class MoveValidator {

	private final Coordinates coordinates;
	private final GameBoard gameBoard;
	private final Player player;


	public boolean validate() throws InvalidMoveException, InvalidCoordinateException {
		return gameBoard
			.getPlayerChessman(this.coordinates.getFrom(), this.player)
			.validateMove(prepareMoveCharacteristic());
	}

	private MoveCharacteristic prepareMoveCharacteristic() throws InvalidMoveException, InvalidCoordinateException {
		return MoveCharacteristic.builder()
			.moveDirection(determineDirection())
			.length(calcLength())
			.occupiedFieldsBetween(isGoingThroughOtherChessman())
			.occupiedToField(isFieldToOccupiedByOpponent())
			.forwardMove(isForwardMove())
			.build();
	}

	private int getColumnFrom() {
		return this.coordinates.getFrom().getFile().getColumn();
	}

	private int getRowFrom() {
		return this.coordinates.getFrom().getRank().getRow();
	}

	private int getColumnTo() {
		return this.coordinates.getTo().getFile().getColumn();
	}

	private int getRowTo() {
		return this.coordinates.getTo().getRank().getRow();
	}

	private int calcColumnLength() {
		return getColumnTo() - getColumnFrom();
	}

	private int calcRowLength() {
		return getRowTo() - getRowFrom();
	}

	private MoveDirection determineDirection() throws InvalidMoveException {
		boolean columnEquality = getColumnFrom() == getColumnTo();
		boolean rowEquality = getRowFrom() == getRowTo();
		if (columnEquality && not(rowEquality)) {
			return MoveDirection.VERTICAL;
		}
		if (not(columnEquality) && rowEquality) {
			return MoveDirection.HORIZONTAL;
		}

		int columnLength = Math.abs(calcColumnLength());
		int rowLength = Math.abs(calcRowLength());
		if (columnLength == rowLength && columnLength > 0) {
			return MoveDirection.DIAGONAL;
		}
		if ((columnLength == 1 && rowLength == 2) || (columnLength == 2 && rowLength == 1)) {
			return MoveDirection.KNIGHT;
		}
		throw new InvalidMoveException(INVALID_MOVE);
	}

	private int calcLength() {
		int columnLength = Math.abs(calcColumnLength());
		int rowLength = Math.abs(calcRowLength());

		return Math.max(columnLength, rowLength);
	}

	private boolean isFieldToOccupiedByOpponent() throws InvalidMoveException {
		Chessman chessman = gameBoard.getChessman(this.coordinates.getTo());
		if (chessman == null) {
			return false;
		}
		if (chessman.getPlayer().equals(this.player)) {
			throw new InvalidMoveException(CANT_ATTACK_YOUR_CHESSMAN);
		}
		return true;
	}

	private boolean isGoingThroughOtherChessman() throws InvalidCoordinateException {
		if (calcColumnLength() == 1 || calcRowLength() == 1) {
			return false;
		}

		int columnDirectionSign = calcDirectionSign(calcColumnLength());
		int rowDirectionSign = calcDirectionSign(calcRowLength());

		for (int i = 1; i < calcLength(); i++) {
			int row = getRowFrom() + i * rowDirectionSign;
			int column = getColumnFrom() + i * columnDirectionSign;
			if (gameBoard.getChessman(new Coordinate(row, column)) != null) {
				return true;
			}
		}
		return false;
	}

	private boolean isForwardMove() {
		int rowDirectionSign = calcDirectionSign(calcRowLength());
		return this.player.getPlayerConfig().isForwardSign(rowDirectionSign);
	}

	private int calcDirectionSign(int length) {
		return length / Math.max(Math.abs(length), 1);
	}

	private boolean not(boolean bool) {
		return !bool;
	}

}
