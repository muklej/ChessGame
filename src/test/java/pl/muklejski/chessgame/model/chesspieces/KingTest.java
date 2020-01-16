package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.CANT_ATTACK_YOUR_CHESSMAN;
import static pl.muklejski.chessgame.model.constants.Messages.MOVE_NOT_VALID_WITH_RULES;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

class KingTest extends Base {

	@Test
	public void validKingWhiteMoveTest() {
		notThrowingExceptionTest("src/test/resources/king-white-valid-moves.txt");
	}

	@Test
	public void validKingBlackMoveTest() {
		notThrowingExceptionTest("src/test/resources/king-black-valid-moves.txt");
	}

	@Test
	public void invalidKingWhiteMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/king-white-invalid-moves.txt");

		//then
		assertEquals(CANT_ATTACK_YOUR_CHESSMAN, invalidMoveException.getMessage());
	}

	@Test
	public void invalidKingBlackMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/king-black-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.KING), invalidMoveException.getMessage());
	}
}