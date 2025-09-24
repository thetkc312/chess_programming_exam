package chess;

import java.util.HashSet;

public class QueenRules extends MoveRules {

    QueenRules() {
        // "true" if this piece has unlimited movement
        super(true);
    }

    @Override
    HashSet<int[]> getPotentialMoves(ChessBoard boardState, ChessPosition activePosition) {
        throw new RuntimeException("Not implemented");
    }
}
