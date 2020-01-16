package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.CANT_ATTACK_YOUR_CHESSMAN;
import static pl.muklejski.chessgame.model.constants.Messages.MOVE_NOT_VALID_WITH_RULES;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

class KnightTest extends Base {

	@Test
	public void validKnightWhiteMoveTest() {
		notThrowingExceptionTest("src/test/resources/knight-white-valid-moves.txt");
	}

	@Test
	public void validKnightBlackMoveTest() {
		notThrowingExceptionTest("src/test/resources/knight-black-valid-moves.txt");
	}

	@Test
	public void invalidKnightWhiteMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/knight-white-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.KNIGHT), invalidMoveException.getMessage());
	}

	@Test
	public void invalidKnightBlackMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/knight-black-invalid-moves.txt");

		//then
		assertEquals(CANT_ATTACK_YOUR_CHESSMAN, invalidMoveException.getMessage());
	}
}