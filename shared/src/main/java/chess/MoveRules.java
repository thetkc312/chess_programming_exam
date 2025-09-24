package chess;

import java.util.HashSet;

abstract class MoveRules {

    final private boolean unlimitedMovement;

    abstract HashSet<Movement> getPotentialMovements(ChessBoard boardState, ChessPosition activePosition);

    MoveRules(boolean unlimitedMovement) {
        this.unlimitedMovement = unlimitedMovement;
    }

    public boolean hasUnlimitedMovement() {
        return unlimitedMovement;
    }

    public boolean isValidMove(ChessBoard board, ChessPosition activePosition, ChessPosition targetPosition) {
        if (!targetPosition.isOnBoard()) {
            return false;
        }
        if (board.getPiece(targetPosition) == null) {
            return true;
        }
        if (isEnemyInPosition(board, activePosition, targetPosition)) {
            return true;
        }
        return false;
    }

    public boolean isEnemyInPosition(ChessBoard board, ChessPosition activePosition, ChessPosition targetPosition) {
        ChessPiece activePiece = board.getPiece(activePosition);
        ChessPiece targetPiece = board.getPiece(targetPosition);
        if (targetPiece == null) {
            return false;
        }
        return activePiece.getTeamColor() != targetPiece.getTeamColor();
    }
}
