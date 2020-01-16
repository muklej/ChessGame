package pl.muklejski.chessgame.model.cordinates;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Coordinate {

	private final File file;
	private final Rank rank;

	@Override
	public String toString() {
		return file.toString() + rank.toString();
	}


	public Coordinate(int row, int column) throws InvalidCoordinateException {
		this(File.getFileFromColumn(column), Rank.getRankFromRow(row));
	}
}
