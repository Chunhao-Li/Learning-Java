// package comp1110.ass1;

/**
 * This class represents a single hexagonal space on the board.
 * A Hex can be identified by index ('A'-Z'), or by odd-r offset coordinates (col, row), or by cube coordinates (x,y,z).
 * Each of these is useful for different reasons, but we will mostly operate in offset coordinates.
 * <p>
 * See <a href="https://www.redblobgames.com/grids/hexagons/">Hexagonal Grids</a> by Red Blob Games for an
 * explanation of the offset and cube coordinate systems.
 */
public class Hex {
    /* constants describing the shape of the board */
    public static final int NUM_ROWS = 4;
    public static final int NUM_COLS = 7;
    public static final int NUM_SPACES = 26; // number of spaces on board
    public final int col;
    public final int row;

    /**
     * Create a new Hex with the given column and row coordinates.
     *
     * @param col the column index
     * @param row the row index
     */
    public Hex(int col, int row) {
        this.col = col;
        this.row = row;
    }

    /**
     * Create a new Hex with the given index 'A'-'Z'.
     *
     * @param index the hex index character
     */
    public Hex(char index) {
        int hexNum = index - 'A';
        if (hexNum >= 20) {
            row = 3;
            col = hexNum - 20;
        } else if (hexNum >= 13) {
            row = 2;
            col = hexNum - 13;
        } else if (hexNum >= 7) {
            row = 1;
            col = hexNum - 7;
        } else {
            row = 0;
            col = hexNum;
        }
    }

    /**
     * Create a new Hex from the given cube coordinates.
     *
     * @param x
     * @param y
     * @param z
     */
    public Hex(int x, int y, int z) {
        col = x + (z - (z & 1)) / 2;
        row = z;
    }

    /**
     * @return get the index character 'A'-'Z' for this Hex
     */
    public char getIndex() {
        int hex;
        switch (row) {
            case 0:
                if (col >= 0 && col < NUM_COLS) hex = col;
                else return '!';
                break;
            case 1:
                if (col >= 0 && col < NUM_COLS - 1) hex = col + 7;
                else return '!';
                break;
            case 2:
                if (col >= 0 && col < NUM_COLS) hex = col + 13;
                else return '!';
                break;
            case 3:
                if (col >= 0 && col < NUM_COLS - 1) hex = col + 20;
                else return '!';
                break;
            default:
                return '!';
        }
        return (char) ('A' + hex);
    }

    public int[] getCubeCoordinates() {
        int x = col - (row - (row & 1)) / 2;
        int z = row;
        int y = -x - z;
        return new int[]{x, y, z};
    }

    /**
     * Translate this hex by the vector from the origin to the given hex.
     *
     * @param vector the hex by which this vector should be translated
     * @return the new hex after translation
     */
    public Hex translate(Hex vector) {
        int[] thisCube = getCubeCoordinates();
        int[] vectorCube = vector.getCubeCoordinates();
        for (int i = 0; i < 3; i++) {
            thisCube[i] += vectorCube[i];
        }
        return new Hex(thisCube[0], thisCube[1], thisCube[2]);
    }

    /**
     * Rotate this hex clockwise around the origin by 60 degrees.
     * A rotation 60° right shoves each coordinate one slot to the right:
     * [ x,  y,  z]
     * to    [-z, -x, -y]
     * See <a href="https://www.redblobgames.com/grids/hexagons/">Hexagonal Grids</a> by Red Blob Games
     *
     * @return the new hex after rotation by 60 degrees clockwise
     */
    public Hex rotate60Degrees() {
        int[] cube = getCubeCoordinates();
        return new Hex(-cube[2], -cube[0], -cube[1]);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hex) {
            Hex s = (Hex) obj;
            return s.col == this.col && s.row == this.row;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return col * 37 + row;
    }

    public String toString() {
        return col + "," + row;
    }

    public static void main(String[] args) {
        Hex test = new Hex('A');
        int[] cubeCoord = test.getCubeCoordinates();
        for (int i : cubeCoord) {
            System.out.println(i);
        }
        System.out.println(test.toString());
        // System.out.println(test.getCubeCoordinates());
        // test = test.translate(new Hex('Z'));
        // System.out.println(test);
    }
}
