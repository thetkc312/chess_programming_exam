package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    private ChessPiece[][] boardArray;

    public ChessBoard() {
        boardArray = new ChessPiece[8][8];
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        boardArray[position.getRow()-1][position.getColumn()-1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return boardArray[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        String defaultBoardKey =
                "rnbqkbnr\n"+
                "pppppppp\n"+
                "--------\n"+
                "--------\n"+
                "--------\n"+
                "--------\n"+
                "PPPPPPPP\n"+
                "RNBQKBNR\n";
        int boardKeyPos = 0;
        for (int rowPos = 7; rowPos >=0; rowPos--, boardKeyPos++) {
            for (int colPos = 0; colPos <=7; colPos++, boardKeyPos++) {
                char keyChar = defaultBoardKey.charAt(boardKeyPos);
                boardArray[rowPos][colPos] = ChessPiece.getFromChar(keyChar);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int rowPos = 7; rowPos >=0; rowPos--) {
            for (int colPos = 0; colPos <=7; colPos++) {
                ChessPiece currentPiece = boardArray[rowPos][colPos];
                boardString.append(ChessPiece.toChar(currentPiece));
            }
            boardString.append('\n');
        }
        return boardString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(boardArray, that.boardArray);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(boardArray);
    }
}
