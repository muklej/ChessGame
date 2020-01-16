package pl.muklejski.chessgame.model;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.muklejski.chessgame.model.baseTest.Base;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_MOVE_EMPTY_FIELD;
import static pl.muklejski.chessgame.model.constants.Messages.ITS_NOT_YOUR_CHESSMAN;
import pl.muklejski.chessgame.model.cordinates.Coordinate;
import pl.muklejski.chessgame.model.cordinates.File;
import pl.muklejski.chessgame.model.cordinates.Rank;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class MoveTest extends Base {

	@Test
	public void invalidEmptyFieldMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/empty-field-invalid-moves.txt");

		//then
		assertEquals(format(INVALID_MOVE_EMPTY_FIELD, new Coordinate(File.D, Rank.RANK_6)), invalidMoveException.getMessage());
	}

	@Test
	public void invalidChessmanPlayerMoveTest() {
		InvalidMoveException invalidMoveException = throwsExceptionTest("src/test/resources/not-your-chessman-invalid-moves.txt");

		//then
		assertEquals(ITS_NOT_YOUR_CHESSMAN, invalidMoveException.getMessage());
	}

}