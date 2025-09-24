package chess;

import java.util.HashSet;

public class PawnRules extends MoveRules {

    PawnRules() {
        // "true" if this piece has unlimited movement
        super(false);
    }

    @Override
    HashSet<Movement> getPotentialMovements(ChessBoard boardState, ChessPosition activePosition) {
        HashSet<Movement> potentialMovements = new HashSet<>();
        // Determine forward direction based on color
        int verticalDirection;
        if (boardState.getPiece(activePosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            verticalDirection = 1;
        } else {
            verticalDirection = -1;
        }
        // Check if moving forward one is possible (must be an on-board empty space)
        Movement oneForward = new Movement(verticalDirection, 0);
        ChessPosition targetPosition = activePosition.getMovedPosition(oneForward);
        if (targetPosition.isOnBoard() && boardState.getPiece(targetPosition) == null) {
            potentialMovements.add(oneForward);
            // If it is, check if moving forward two is possible (must be in starting row, going to an on-board empty space)
            if (activePosition.getRow() == 2 || activePosition.getRow() == 7) {
                Movement twoForward = new Movement(2*verticalDirection, 0);
                targetPosition = activePosition.getMovedPosition(twoForward);
                if (targetPosition.isOnBoard() && boardState.getPiece(targetPosition) == null) {
                    potentialMovements.add(twoForward);
                }
            }

        }
        // Also check if moving diagonal is possible (must be an on-board enemy piece)
        for (int leftRight : new int[]{-1,1}) {
            Movement diagonalForward = new Movement(verticalDirection, leftRight);
            targetPosition = activePosition.getMovedPosition(diagonalForward);
            if (targetPosition.isOnBoard() && isEnemyInPosition(boardState, activePosition, targetPosition)) {
                potentialMovements.add(diagonalForward);
            }
        }
        return potentialMovements;
    }
}
