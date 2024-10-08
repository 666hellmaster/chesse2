import java.util.ArrayList;
import java.util.List;

/**
 * @author ruzicka
 * @since 2024-08-22
 */
public class Moves {
    //---Field------------------------------------------------------------------------

    public static class Field { // field on the board
        private final int x;
        private final int y;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    //---Move-------------------------------------------------------------------------

    public static class Move { // move from source to destination
        private final Field sourceField;
        private final Field destField;

        public Move(Field sourceField, Field destField) {
            this.sourceField = sourceField;
            this.destField = destField;
        }

        public Field getSourceField() {
            return sourceField;
        }

        public Field getDestField() {
            return destField;
        }

        @Override
        public String toString() {
            return "Move{" +
                    "sourceField=" + sourceField +
                    ", destField=" + destField +
                    '}';
        }
    }

    //---Directions-------------------------------------------------------------------

    public enum Direction { // all possible moves for the horse (without constraints)
        UP_LEFT {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() - 1, field.getY() + 2);
            }
        },
        UP_RIGHT {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() + 1, field.getY() + 2);
            }
        },
        RIGHT_UP {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() + 2, field.getY() + 1);
            }
        },
        RIGHT_DOWN {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() + 2, field.getY() - 1);
            }
        },
        DOWN_LEFT {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() - 1, field.getY() - 2);
            }
        },
        DOWN_RIGHT {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() + 1, field.getY() - 2);
            }
        },
        LEFT_UP {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() - 2, field.getY() + 1);
            }
        },
        LEFT_DOWN {
            @Override
            public Field apply(Field field) {
                return new Field(field.getX() - 2, field.getY() - 1);
            }
        };

        public abstract Field apply(Field field);
    }

    //---AllPossibleMoves-------------------------------------------------------------

    public static List<Move> AllPossibleMoves(Field startHorse) { // checking all possible moves for the horse (with constraints (board size and visited positions))
        List<Move> validMoves = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Field destination = direction.apply(startHorse);
            if (destination.getX() < 0 || destination.getY() < 0 || destination.getX() >= Chesse.size_board || destination.getY() >= Chesse.size_board) {
                continue;
            }
            String destPosition = "(" + destination.getX() + "," + destination.getY() + ")";
            if (Chesse.visitedPositions.contains(destPosition)) {
                continue;
            }
            Move move = new Move(startHorse, destination);
            validMoves.add(move);
        }
        return validMoves;
    }
}
