package pl.muklejski.chessgame.model;

import static java.lang.String.format;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import pl.muklejski.chessgame.model.chesspieces.Bishop;
import pl.muklejski.chessgame.model.chesspieces.Chessman;
import pl.muklejski.chessgame.model.chesspieces.King;
import pl.muklejski.chessgame.model.chesspieces.Knight;
import pl.muklejski.chessgame.model.chesspieces.Pawn;
import pl.muklejski.chessgame.model.chesspieces.Queen;
import pl.muklejski.chessgame.model.chesspieces.Rook;
import pl.muklejski.chessgame.model.constants.ChessmanType;
import static pl.muklejski.chessgame.model.constants.GameConstants.BOARD_LENGTH;
import pl.muklejski.chessgame.model.constants.Messages;
import static pl.muklejski.chessgame.model.constants.Messages.INVALID_MOVE_EMPTY_FIELD;
import static pl.muklejski.chessgame.model.constants.Messages.ITS_NOT_YOUR_CHESSMAN;
import pl.muklejski.chessgame.model.constants.Player;
import pl.muklejski.chessgame.model.cordinates.Coordinate;
import pl.muklejski.chessgame.model.cordinates.Coordinates;
import static pl.muklejski.chessgame.model.constants.Player.*;
import static pl.muklejski.chessgame.model.cordinates.File.*;
import static pl.muklejski.chessgame.model.cordinates.Rank.*;
import pl.muklejski.chessgame.model.exceptions.InvalidCoordinateException;
import pl.muklejski.chessgame.model.exceptions.InvalidGameStateException;
import pl.muklejski.chessgame.model.exceptions.InvalidMoveException;

public class GameBoard {

	private final Chessman[][] board;


	public GameBoard() {
		this.board = new Chessman[BOARD_LENGTH][BOARD_LENGTH];

		//player white
		this.board[RANK_1.getRow()][A.getColumn()] = new Rook(PLAYER1);
		this.board[RANK_1.getRow()][B.getColumn()] = new Knight(PLAYER1);
		this.board[RANK_1.getRow()][C.getColumn()] = new Bishop(PLAYER1);
		this.board[RANK_1.getRow()][D.getColumn()] = new Queen(PLAYER1);
		this.board[RANK_1.getRow()][E.getColumn()] = new King(PLAYER1);
		this.board[RANK_1.getRow()][F.getColumn()] = new Bishop(PLAYER1);
		this.board[RANK_1.getRow()][G.getColumn()] = new Knight(PLAYER1);
		this.board[RANK_1.getRow()][H.getColumn()] = new Rook(PLAYER1);
		this.board[RANK_2.getRow()][A.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][B.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][C.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][D.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][E.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][F.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][G.getColumn()] = new Pawn(PLAYER1);
		this.board[RANK_2.getRow()][H.getColumn()] = new Pawn(PLAYER1);

		//player black
		this.board[RANK_8.getRow()][A.getColumn()] = new Rook(PLAYER2);
		this.board[RANK_8.getRow()][B.getColumn()] = new Knight(PLAYER2);
		this.board[RANK_8.getRow()][C.getColumn()] = new Bishop(PLAYER2);
		this.board[RANK_8.getRow()][D.getColumn()] = new Queen(PLAYER2);
		this.board[RANK_8.getRow()][E.getColumn()] = new King(PLAYER2);
		this.board[RANK_8.getRow()][F.getColumn()] = new Bishop(PLAYER2);
		this.board[RANK_8.getRow()][G.getColumn()] = new Knight(PLAYER2);
		this.board[RANK_8.getRow()][H.getColumn()] = new Rook(PLAYER2);
		this.board[RANK_7.getRow()][A.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][B.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][C.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][D.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][E.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][F.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][G.getColumn()] = new Pawn(PLAYER2);
		this.board[RANK_7.getRow()][H.getColumn()] = new Pawn(PLAYER2);
	}

	void moveChessman(Coordinates coordinates) {
		Coordinate from = coordinates.getFrom();
		Coordinate to = coordinates.getTo();

		setChessman(to, getChessman(from));
		setChessman(from, null);

		getChessman(to).setNotFirstMove();
	}

	private void setChessman(Coordinate coordinate, Chessman chessman) {
		int file = coordinate.getFile().getColumn();
		int rank = coordinate.getRank().getRow();
		this.board[rank][file] = chessman;
	}

	public Chessman getChessman(Coordinate coordinate) {
		int file = coordinate.getFile().getColumn();
		int rank = coordinate.getRank().getRow();
		return this.board[rank][file];
	}

	public Chessman getPlayerChessman(Coordinate coordinate, Player player) throws InvalidMoveException {
		Chessman chessman = Optional.ofNullable(getChessman(coordinate))
			.orElseThrow(() -> new InvalidMoveException(format(INVALID_MOVE_EMPTY_FIELD, coordinate)));
		if (chessman.getPlayer().equals(player)) {
			return chessman;
		}
		throw new InvalidMoveException(ITS_NOT_YOUR_CHESSMAN);
	}

	public Coordinate getPlayerChessmanKingCoordinate(Player player) throws InvalidCoordinateException {
		for (int row = 0; row < BOARD_LENGTH; row++) {
			for (int col = 0; col < BOARD_LENGTH; col++) {
				boolean found = Optional.ofNullable(this.board[row][col])
					.map(chessman -> chessman.getChessmanType().equals(ChessmanType.KING) && chessman.getPlayer().equals(player))
					.orElse(false);
				if (found) {
					return new Coordinate(row, col);
				}
			}
		}
		throw new InvalidGameStateException(Messages.CANT_FIND_KING);
	}

	public Set<Coordinate> getPlayerChessmanOtherThanKingCoordinates(Player player) throws InvalidCoordinateException {
		Set<Coordinate> result = new HashSet<>();
		for (int row = 0; row < BOARD_LENGTH; row++) {
			for (int col = 0; col < BOARD_LENGTH; col++) {
				boolean found = Optional.ofNullable(this.board[row][col])
					.map(chessman -> !chessman.getChessmanType().equals(ChessmanType.KING) && chessman.getPlayer().equals(player))
					.orElse(false);
				if (found) {
					result.add(new Coordinate(row, col));
				}
			}
		}
		return result;
	}
}