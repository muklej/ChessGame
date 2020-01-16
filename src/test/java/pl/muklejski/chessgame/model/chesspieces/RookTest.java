package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.MOVE_NOT_VALID_WITH_RULES;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class RookTest extends Base {

	@Test
	public void validRookWhiteMoveTest() {
		notThrowingExceptionTest("src/test/resources/rook-white-valid-moves.txt");
	}

	@Test
	public void validRookBlackMoveTest() {
		notThrowingExceptionTest("src/test/resources/rook-black-valid-moves.txt");
	}

	@Test
	public void invalidRookWhiteMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/rook-white-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.ROOK), invalidMoveException.getMessage());
	}

	@Test
	public void invalidRookBlackMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/rook-black-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.ROOK), invalidMoveException.getMessage());
	}
}