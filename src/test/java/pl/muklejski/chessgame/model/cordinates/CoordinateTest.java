package pl.muklejski.chessgame.model.cordinates;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_FILE_COORDINATE;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_RANK_COORDINATE;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

public class CoordinateTest {

	@Test
	public void coordinateCreationOkTest() throws InvalidCoordinateException {
		Coordinate coordinate = new Coordinate(0, 7);

		assertEquals(File.H, coordinate.getFile());
		assertEquals(Rank.RANK_8, coordinate.getRank());
	}

	@Test
	public void coordinateCreationFailRankTest() {
		InvalidCoordinateException invalidCoordinateException = assertThrows(InvalidCoordinateException.class, () -> new Coordinate(-5, 7));
		assertEquals(format(INVALID_RANK_COORDINATE, -5), invalidCoordinateException.getMessage());
	}

	@Test
	public void coordinateCreationFailFileTest() {
		InvalidCoordinateException invalidCoordinateException = assertThrows(InvalidCoordinateException.class, () -> new Coordinate(-5, 15));
		assertEquals(format(INVALID_FILE_COORDINATE, 15), invalidCoordinateException.getMessage());
	}

}