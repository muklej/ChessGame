package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.MOVE_NOT_VALID_WITH_RULES;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class PawnTest extends Base {

	@Test
	public void validPawnWhiteMoveTest() {
		notThrowingExceptionTest("src/test/resources/pawn-white-valid-moves.txt");
	}

	@Test
	public void validPawnBlackMoveTest() {
		notThrowingExceptionTest("src/test/resources/pawn-black-valid-moves.txt");
	}

	@Test
	public void invalidPawnWhiteTwoSqForwardNotFirstMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/pawn-white-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.PAWN), invalidMoveException.getMessage());
	}

	@Test
	public void invalidPawnBlackAttackVerticalMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/pawn-black-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.PAWN), invalidMoveException.getMessage());
	}

	@Test
	public void invalidPawnWhiteBackwardMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/pawn-white-invalid-backward-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.PAWN), invalidMoveException.getMessage());
	}

	@Test
	public void invalidPawnBlackMoveThroughTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/pawn-black-invalid-through-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.PAWN), invalidMoveException.getMessage());
	}
}