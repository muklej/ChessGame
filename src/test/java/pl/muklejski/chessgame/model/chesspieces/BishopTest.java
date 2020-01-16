package pl.muklejski.chessgame.model.chesspieces;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.Messages.*;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

class BishopTest extends Base {

	@Test
	public void validBishopWhiteMoveTest() {
		notThrowingExceptionTest("src/test/resources/bishop-white-valid-moves.txt");
	}

	@Test
	public void validBishopBlackMoveTest() {
		notThrowingExceptionTest("src/test/resources/bishop-black-valid-moves.txt");
	}

	@Test
	public void invalidBishopWhiteMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/bishop-white-invalid-moves.txt");

		//then
		assertEquals(format(MOVE_NOT_VALID_WITH_RULES, ChessmanType.BISHOP), invalidMoveException.getMessage());
	}

	@Test
	public void invalidBishopBlackMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/bishop-black-invalid-moves.txt");

		//then
		assertEquals(CANT_ATTACK_YOUR_CHESSMAN, invalidMoveException.getMessage());
	}
}