package chess;

import java.util.HashSet;

public class QueenRules extends MoveRules {

    QueenRules() {
        // "true" if this piece has unlimited movement
        super(true);
    }

    @Override
    HashSet<Movement> getPotentialMovements(ChessBoard boardState, ChessPosition activePosition) {
        HashSet<Movement> potentialMovements = new HashSet<>(8);
        potentialMovements.add(new Movement(-1, -1));
        potentialMovements.add(new Movement(-1, 0));
        potentialMovements.add(new Movement(-1, 1));
        potentialMovements.add(new Movement(0, -1));
        potentialMovements.add(new Movement(0, 1));
        potentialMovements.add(new Movement(1, -1));
        potentialMovements.add(new Movement(1, 0));
        potentialMovements.add(new Movement(1, 1));
        return potentialMovements;
    }
}
