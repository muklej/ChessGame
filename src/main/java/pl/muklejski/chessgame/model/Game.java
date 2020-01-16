package pl.muklejski.chessgame.model;

import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.Coordinates;
import pl.muklejski.chessgame.model.exceptions.CheckException;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;
import pl.muklejski.chessgame.model.screen.BoardDisplay;
import pl.muklejski.chessgame.model.validators.CheckValidator;
import pl.muklejski.chessgame.model.validators.MoveValidator;

public class Game {

	private final GameBoard gameBoard = new GameBoard();
	private Player currentPlayer = Player.PLAYER1;


	public void move(Coordinates coordinates) throws InvalidMoveException, InvalidCoordinateException, CheckException {
		BoardDisplay.displayCoordinates(coordinates);
		new MoveValidator(coordinates, gameBoard, currentPlayer).validate();
		gameBoard.moveChessman(coordinates);
		boolean inCheck = new CheckValidator(gameBoard, currentPlayer).validate();
		switchCurrentPlayer();
		BoardDisplay.displayBoard(gameBoard, inCheck);
	}

	private void switchCurrentPlayer() {
		this.currentPlayer = Player.getOpponent(currentPlayer);
	}
}
