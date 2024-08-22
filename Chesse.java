import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ruzicka
 * @since 2024-08-22
 */
public class Chesse {

    //--------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------

    static int size_board = 6;

    public static void init() {
        int final_moves = ((size_board * size_board) - 1);

        System.out.println("final_moves: " + final_moves);

        Map<String, int[]> board = new HashMap<>();

        for (int i = 0; i < size_board; i++) {
            for (int j = 0; j < size_board; j++) {
                String key = "(" + i + "," + j + ")";
                board.put(key, new int[]{i, j});
            }
        }
       /* for (Map.Entry<String, int[]> entry : board.entrySet()) {
            System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
        }
        */
        int[] start_horse = board.get("(0,0)");
        Moves.printAllPossibleMoves(start_horse);
    }


    //--------------------------------------------------------------------------------

    public static void main(String[] args) {
        init();

    }
}
