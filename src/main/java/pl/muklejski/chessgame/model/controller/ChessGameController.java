package pl.muklejski.chessgame.model.controller;


import com.whitehatgaming.UserInput;
import com.whitehatgaming.UserInputFile;
import java.io.IOException;
import pl.muklejski.chessgame.model.Game;
import pl.muklejski.chessgame.model.cordinates.Coordinates;
import pl.muklejski.chessgame.model.exceptions.CheckException;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class ChessGameController {

	public void startGame(String fileName) throws IOException, InvalidCoordinateException, InvalidMoveException, CheckException {
		Game game = new Game();
		UserInput userInput = new UserInputFile(fileName);
		int[] coordinates = userInput.nextMove();
		while (coordinates != null) {
			game.move(new Coordinates(coordinates));
			coordinates = userInput.nextMove();
		}
	}
}
