package pl.muklejski.chessgame.model.cordinates;

import static java.lang.String.format;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_RANK_COORDINATE;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

@AllArgsConstructor
public enum Rank {
	RANK_1(7),
	RANK_2(6),
	RANK_3(5),
	RANK_4(4),
	RANK_5(3),
	RANK_6(2),
	RANK_7(1),
	RANK_8(0);

	@Getter
	private int row;

	@Override
	public String toString() {
		return name().substring(5);
	}

	public static Rank getRankFromRow(int row) throws InvalidCoordinateException {
		for (Rank rank : values()) {
			if (rank.getRow() == row) {
				return rank;
			}
		}
		throw new InvalidCoordinateException(format(INVALID_RANK_COORDINATE, row));
	}
}
