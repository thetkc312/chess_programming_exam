package chess;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    public ChessPiece getFromChar(char c) {
        ChessPiece.PieceType checkPieceType = switch (c) {
            case 'r' -> PieceType.ROOK;
            case 'R' -> PieceType.ROOK;
            case 'n' -> PieceType.KNIGHT;
            case 'N' -> PieceType.KNIGHT;
            case 'b' -> PieceType.BISHOP;
            case 'B' -> PieceType.BISHOP;
            case 'q' -> PieceType.QUEEN;
            case 'Q' -> PieceType.QUEEN;
            case 'k' -> PieceType.KING;
            case 'K' -> PieceType.KING;
            case 'p' -> PieceType.PAWN;
            case 'P' -> PieceType.PAWN;
            default -> null;
        };
        if (checkPieceType == null) {
            return null;
        } else {
            ChessGame.TeamColor checkPieceColor;
            if (Character.isLowerCase(c)) {
                checkPieceColor = ChessGame.TeamColor.BLACK;
            } else {
                checkPieceColor = ChessGame.TeamColor.WHITE;
            }
            return new ChessPiece(checkPieceColor, checkPieceType);
        }
    }

    // Factory method to take a ChessPiece object as a parameter and determine the appropriate character to represent it
    // (importantly, it is static and called on the class, with an instance of the class passed to it).
    public static char toChar(ChessPiece myPiece) {
        if (myPiece == null) {
            return '-';
        }
        char c = switch (myPiece.getPieceType()) {
            case PieceType.ROOK -> 'r';
            case PieceType.KNIGHT -> 'n';
            case PieceType.BISHOP -> 'b';
            case PieceType.QUEEN -> 'q';
            case PieceType.KING -> 'k';
            case PieceType.PAWN -> 'p';
        };
        if (myPiece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            c = Character.toUpperCase(c);
        }
        return c;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", type, pieceColor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }
}
