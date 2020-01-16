package pl.muklejski.chessgame;

import java.io.IOException;
import static pl.muklejski.chessgame.model.constants.Messages.LACK_OF_FILE_NAME;
import pl.muklejski.chessgame.model.controller.ChessGameController;
import pl.muklejski.chessgame.model.exceptions.CheckException;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class ChessGame {

	public static void main(String[] args) throws IOException {
		if (args.length > 0 && args[0] != null && !args[0].isEmpty()) {
			ChessGameController cgc= new ChessGameController();
			try {
				cgc.startGame(args[0]);
			} catch (InvalidCoordinateException | InvalidMoveException | CheckException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println(LACK_OF_FILE_NAME);
		}

	}

}
