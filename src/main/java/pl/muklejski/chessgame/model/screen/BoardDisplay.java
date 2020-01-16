package pl.muklejski.chessgame.model.screen;

import java.util.Optional;
import java.util.stream.Stream;
import pl.muklejski.chessgame.model.GameBoard;
import pl.muklejski.chessgame.model.chesspieces.Chessman;
import static pl.muklejski.chessgame.model.constants.GameConstants.BOARD_LENGTH;
import static pl.muklejski.chessgame.model.constants.Messages.IN_CHECK;
import pl.muklejski.chessgame.model.cordinates.Coordinate;
import pl.muklejski.chessgame.model.cordinates.Coordinates;
import pl.muklejski.chessgame.model.cordinates.File;
import pl.muklejski.chessgame.model.cordinates.Rank;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;

public class BoardDisplay {

	public static void displayBoard(GameBoard gameBoard, boolean inCheck) throws InvalidCoordinateException {
		System.out.println(prepareBoardVisualisation(gameBoard));
		if (inCheck) {
			System.out.println(IN_CHECK);
		}
	}

	public static void displayCoordinates(Coordinates coordinates) {
		System.out.println(coordinates);
	}

	private static String prepareBoardVisualisation(GameBoard gameBoard) throws InvalidCoordinateException {
		StringBuilder stringBuilder = new StringBuilder();
		addFilesColumnsToBoardDisplay(stringBuilder);
		for (int row = 0; row < BOARD_LENGTH; row++) {
			addRankRowsToBoardDisplay(stringBuilder, row);
			for (int col = 0; col < BOARD_LENGTH; col++) {
				addChessmanNameOrAsterisk(gameBoard, stringBuilder, row, col);
			}
			addRankRowsToBoardDisplay(stringBuilder, row);
			stringBuilder.append("\n");
		}
		addFilesColumnsToBoardDisplay(stringBuilder);
		return stringBuilder.toString();
	}

	private static void addChessmanNameOrAsterisk(GameBoard gameBoard, StringBuilder stringBuilder, int row, int col) throws InvalidCoordinateException {
		char name = Optional.ofNullable(gameBoard.getChessman(new Coordinate(row, col)))
			.map(Chessman::getName)
			.orElse('*');
		stringBuilder.append(name).append(" ");
	}

	private static void addRankRowsToBoardDisplay(StringBuilder stringBuilder, int row) throws InvalidCoordinateException {
		stringBuilder.append(Rank.getRankFromRow(row).toString()).append(" ");
	}

	private static void addFilesColumnsToBoardDisplay(StringBuilder stringBuilder) {
		stringBuilder.append("  ");
		Stream.of(File.values()).forEachOrdered(file -> stringBuilder.append(file.toString()).append(" "));
		stringBuilder.append("\n");
	}

}
