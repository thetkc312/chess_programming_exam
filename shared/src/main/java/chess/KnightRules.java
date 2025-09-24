package chess;

import java.util.HashSet;

public class KnightRules extends MoveRules {

    KnightRules() {
        // "true" if this piece has unlimited movement
        super(false);
    }

    @Override
    HashSet<Movement> getPotentialMovements(ChessBoard boardState, ChessPosition activePosition) {
        HashSet<Movement> potentialMovements = new HashSet<>(8);
        potentialMovements.add(new Movement(-2, -1));
        potentialMovements.add(new Movement(-2, 1));
        potentialMovements.add(new Movement(-1, -2));
        potentialMovements.add(new Movement(-1, 2));
        potentialMovements.add(new Movement(1, -2));
        potentialMovements.add(new Movement(1, 2));
        potentialMovements.add(new Movement(2, -1));
        potentialMovements.add(new Movement(2, 1));
        return potentialMovements;
    }
}
