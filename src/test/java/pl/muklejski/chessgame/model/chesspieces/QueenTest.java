package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_MOVE;
import static pl.muklejski.chessgame.model.constants.Messages.MOVE_NOT_VALID_WITH_RULES;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class QueenTest extends Base {

	@Test
	public void validQueenWhiteMoveTest() {
		notThrowingExceptionTest("src/test/resources/queen-white-valid-moves.txt");
	}

	@Test
	public void validQueenBlackMoveTest() {
		notThrowingExceptionTest("src/test/resources/queen-black-valid-moves.txt");
	}

	@Test
	public void invalidQueenWhiteMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/queen-white-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.QUEEN), invalidMoveException.getMessage());
	}

	@Test
	public void invalidQueenBlackMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/queen-black-invalid-moves.txt");

		//then
		assertEquals(INVALID_MOVE, invalidMoveException.getMessage());
	}
}