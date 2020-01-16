package pl.muklejski.chessgame.model;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.MOVE_NOT_VALID_WITH_RULES;
import pl.muklejski.chessgame.model.controller.ChessGameController;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class SampleTest extends Base {

	@Test
	public void sampleCheckMateMovesTest() {
		//given
		ChessGameController gameController = new ChessGameController();

		//then
		assertAll(() -> gameController.startGame("data/checkmate.txt"));
	}

	@Test
	public void sampleMovesTest() {
		//given
		ChessGameController gameController = new ChessGameController();

		//then
		assertAll(() -> gameController.startGame("data/sample-moves.txt"));
	}

	@Test
	public void invalidChessmanPlayerMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("data/sample-moves-invalid.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.KNIGHT), invalidMoveException.getMessage());
	}

}
