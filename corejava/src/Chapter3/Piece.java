

import java.util.Arrays;

/**
 * An enumeration representing the seven pieces in the IQStars game.
 * <p>
 * You may want to look at the 'Planet' example in the Oracle enum tutorial for
 * an example of an enumeration.
 * <p>
 * http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 */
public enum Piece {
    A(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(2, 0)} ), // purple
    B(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(1, 1)}), // orange
    C(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(1, 1), new Hex(1, 2)}), // pink
    D(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(0, 1), new Hex(1, 1)}), // red
    E(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(1, 1), new Hex(2, 2)}), // green
    F(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(2, 0), new Hex(0, 1)}), // yellow
    G(new Hex[]{new Hex(0, 0), new Hex(1, 0), new Hex(0, 1), new Hex(1, 2)}); // blue

    public static final double MAX_PIECE_WIDTH = 3;
    public static final char INVALID_SPACE = '!';

    /**
     * A list of spaces covered by this piece in its default rotation.
     * Each space in the list is given as an offset from the origin (0,0).
     */
    public final Hex[] shape;

    Piece(Hex[] shape) {
        this.shape = shape;
    }

    public char getId() {
        return this.name().charAt(0);
    }

    /**
     * Return indices corresponding to which board spaces would be covered
     * by this piece, given a correct provided placement.
     * If a part of the piece would lie off the board in a given orientation,
     * return '!' for that part of the piece.
     * The order of the indices in the array does not matter.
     * <p>
     * Examples:
     * Given the piece placement string 'AAB' would return the indices: {'A', 'H', 'O'}.
     * Given the piece placement string 'CPD' would return the indices: {'B', 'H', 'O', 'P'}.
     * Given the piece placement string 'DAB' would return the indices: {'!', 'A', 'H', 'N'}.
     * <p>
     * Hint: You can associate values with each entry in the enum using a constructor,
     * so you could use that to somehow encode the properties of each of the twelve pieces.
     * Then in this method you could use the value to calculate the required indices.
     * <p>
     * See the 'Grade' enum given in the O2 lecture as part of the lecture code (live coding),
     * for an example of an enum with associated state and constructors.
     * <p>
     * The tutorial here: http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
     * has an example of a Planet enum, which includes two doubles in each planet's
     * constructor representing the mass and radius.   Those values are used in the
     * surfaceGravity() method, for example.
     *
     * @param hex         the index of the hex in which the origin of the piece is placed ('A' to 'Z')
     * @param orientation which orientation the tile is in ('A' to 'F')
     * @return A set of indices corresponding to the board positions that would be covered by this piece
     */
    char[] getCovered(char hex, char orientation) {
        // FIXME Task 6: implement code that correctly creates an array of chars specifying the indices of the covered spaces

        Hex[] currentLocations = Arrays.copyOf(shape, shape.length); // current locations after placement

        for (int i = 0; i < currentLocations.length; i++) {
            int flag = (int) orientation - 'A';
            while (flag > 0) {
                currentLocations[i] = currentLocations[i].rotate60Degrees();
                flag--;
            }
        }

        for (int i = 0; i < currentLocations.length; i++) {
            currentLocations[i] = currentLocations[i].translate(new Hex(hex));
        }

        char[] output = new char[currentLocations.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = currentLocations[i].getIndex();
        }
        return output;

    }

    public static void main(String[] args) {
        // char[] pieceCovering = Piece.valueOf(String.valueOf('A')).getCovered('H','A');
        // for (char c : pieceCovering) {
        //     System.out.println(c);
        // }
        System.out.println(String.valueOf(Piece.valueOf(String.valueOf('A')).getCovered('H', 'D')).contains("!"));
    }

}
