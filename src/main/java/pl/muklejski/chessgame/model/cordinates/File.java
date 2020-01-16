package pl.muklejski.chessgame.model.cordinates;

import static java.lang.String.format;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_FILE_COORDINATE;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

@AllArgsConstructor
public enum File {
	A(0),
	B(1),
	C(2),
	D(3),
	E(4),
	F(5),
	G(6),
	H(7);

	@Getter
	private int column;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

	public static File getFileFromColumn(int column) throws InvalidCoordinateException {
		for (File file : values()) {
			if (file.getColumn() == column) {
				return file;
			}
		}
		throw new InvalidCoordinateException(format(INVALID_FILE_COORDINATE, column));
	}
}
