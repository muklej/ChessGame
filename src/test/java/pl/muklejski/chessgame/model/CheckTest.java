package pl.muklejski.chessgame.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_MOVE_ENDED_IN_CHECK;
import pl.muklejski.chessgame.model.controller.ChessGameController;
import pl.muklejski.chessgame.model.exceptions.CheckException;

public class CheckTest extends Base {

	@Test
	public void invalidCheckMoveTest() {
		//given
		ChessGameController gameController = new ChessGameController();

		//when
		CheckException checkException = assertThrows(CheckException.class,
							     () -> gameController.startGame("src/test/resources/check-invalid-moves.txt"));

		//then
		assertEquals(INVALID_MOVE_ENDED_IN_CHECK, checkException.getMessage());
	}

	@Test
	public void validCheckMoveTest() {
		//given
		ChessGameController gameController = new ChessGameController();

		//then
		assertAll(() -> gameController.startGame("src/test/resources/check-valid-moves.txt"));
	}

}