package pl.muklejski.chessgame.model.baseTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import pl.muklejski.chessgame.model.controller.ChessGameController;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class Base {

	protected InvalidMoveException throwsExceptionTest(String fileName) {
		//given
		ChessGameController gameController = new ChessGameController();

		//when
		InvalidMoveException invalidMoveException = assertThrows(InvalidMoveException.class,
									 () -> gameController.startGame(fileName));
		System.out.println(invalidMoveException.getMessage());
		return invalidMoveException;
	}

	protected void notThrowingExceptionTest(String fileName) {
		//given
		ChessGameController gameController = new ChessGameController();

		//then
		assertAll(() -> gameController.startGame(fileName));
	}


}
