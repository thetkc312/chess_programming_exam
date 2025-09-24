package chess;

import java.util.HashSet;

public class BishopRules extends MoveRules {

    BishopRules() {
        // "true" if this piece has unlimited movement
        super(true);
    }

    @Override
    HashSet<Movement> getPotentialMovements(ChessBoard boardState, ChessPosition activePosition) {
        HashSet<Movement> potentialMovements = new HashSet<>(4);
        potentialMovements.add(new Movement(-1, -1));
        potentialMovements.add(new Movement(-1, 1));
        potentialMovements.add(new Movement(1, -1));
        potentialMovements.add(new Movement(1, 1));
        return potentialMovements;
    }
}
