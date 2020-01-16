package pl.muklejski.chessgame.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ChessmanType {
	ROOK('r'),
	KNIGHT('n'),
	BISHOP('b'),
	KING('k'),
	QUEEN('q'),
	PAWN('p');

	@Getter
	private char abbreviation;
}
