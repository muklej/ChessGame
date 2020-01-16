package pl.muklejski.chessgame.model.cordinates;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_COORDINATES_FROM_AND_TO_NOT_DIFFERENT;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_COORDINATE_OUT_OF_RANGE;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_LENGTH_OF_COORDINATES;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

public class CoordinatesTest {

	@Test
	public void tooLongCoordinatesArrayTest() {
		//given
		int[] coordinates = new int[] {1, 2, 5, 4, 9};

		//when
		InvalidCoordinateException invalidCoordinateException = assertThrows(InvalidCoordinateException.class, () -> new Coordinates(coordinates));

		//then
		assertEquals(format(INVALID_LENGTH_OF_COORDINATES, 5), invalidCoordinateException.getMessage());
	}

	@Test
	public void coordinateOutOfRangeTest() {
		//given
		int[] coordinates = new int[] {1, 2, 15, 4};

		//when
		InvalidCoordinateException invalidCoordinateException = assertThrows(InvalidCoordinateException.class, () -> new Coordinates(coordinates));

		//then
		assertEquals(format(INVALID_COORDINATE_OUT_OF_RANGE, 3, 15), invalidCoordinateException.getMessage());
	}

	@Test
	public void coordinatesNotDifferentTest() {
		//given
		int[] coordinates = new int[] {1, 2, 1, 2};

		//when
		InvalidCoordinateException invalidCoordinateException = assertThrows(InvalidCoordinateException.class, () -> new Coordinates(coordinates));

		//then
		assertEquals(INVALID_COORDINATES_FROM_AND_TO_NOT_DIFFERENT, invalidCoordinateException.getMessage());
	}


}