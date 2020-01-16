package pl.muklejski.chessgame.model.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.muklejski.chessgame.model.config.Player1Config;
import pl.muklejski.chessgame.model.config.Player2Config;
import pl.muklejski.chessgame.model.config.PlayerConfig;
import static pl.muklejski.chessgame.model.constants.ChessmanColor.BLACK;
import static pl.muklejski.chessgame.model.constants.ChessmanColor.WHITE;

@Getter
@AllArgsConstructor
public enum Player {
	PLAYER1(WHITE, new Player1Config()),
	PLAYER2(BLACK, new Player2Config());

	private ChessmanColor color;
	private PlayerConfig playerConfig;


	public static Player getOpponent(Player player) {
		return player.equals(PLAYER1) ? PLAYER2 : PLAYER1;
	}
}
