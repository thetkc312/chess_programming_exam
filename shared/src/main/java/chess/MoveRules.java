package chess;

import java.util.HashSet;

abstract class MoveRules {

    final boolean unlimitedMovement;

    abstract HashSet<int[]> getPotentialMoves(ChessBoard boardState, ChessPosition activePosition);

    MoveRules(boolean unlimitedMovement) {
        this.unlimitedMovement = unlimitedMovement;
    }
}
