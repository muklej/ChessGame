package pl.muklejski.chessgame.model.cordinates;

import static java.lang.String.format;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_COORDINATES_FROM_AND_TO_NOT_DIFFERENT;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_COORDINATE_OUT_OF_RANGE;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_LENGTH_OF_COORDINATES;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Coordinates {

	private final Coordinate from;
	private final Coordinate to;

	public Coordinates(int[] coordinates) throws InvalidCoordinateException {
		validateCoordinates(coordinates);
		File fileFrom = File.getFileFromColumn(coordinates[0]);
		Rank rankFrom = Rank.getRankFromRow(coordinates[1]);
		File fileTo = File.getFileFromColumn(coordinates[2]);
		Rank rankTo = Rank.getRankFromRow(coordinates[3]);
		this.from = new Coordinate(fileFrom, rankFrom);
		this.to = new Coordinate(fileTo, rankTo);
	}

	private void validateCoordinates(int[] coordinates) throws InvalidCoordinateException {
		int coordinatesArrayLength = coordinates.length;
		if (coordinatesArrayLength != 4) {
			throw new InvalidCoordinateException(format(INVALID_LENGTH_OF_COORDINATES, coordinatesArrayLength));
		}

		for (int i = 0; i < coordinatesArrayLength; i++) {
			if (coordinates[i] < 0 || coordinates[i] > 7) {
				throw new InvalidCoordinateException(format(INVALID_COORDINATE_OUT_OF_RANGE, i + 1, coordinates[i]));
			}

		}

		if (8 * coordinates[0] + coordinates[1] == 8 * coordinates[2] + coordinates[3]) {
			throw new InvalidCoordinateException(INVALID_COORDINATES_FROM_AND_TO_NOT_DIFFERENT);
		}
	}
}
