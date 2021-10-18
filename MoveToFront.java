/* *****************************************************************************
 *  Name:    Devin Plumb
 *  NetID:   dplumb
 *  Precept: P06
 *
 *  Description:  Implements the move-to-front algorithm (encoding and decoding)
 *                for a given string read from BinaryStdIn, writing to
 *                BinaryStdOut.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int EXTENDED_ASCII = 256; // alphabet of characters

    // apply move-to-front encoding,
    // reading from standard input and writing to standard output
    public static void encode() {
        char[] alphabet = new char[EXTENDED_ASCII];
        for (int r = 0; r < EXTENDED_ASCII; r++)
            alphabet[r] = (char) r;
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        int n = input.length;
        int output = 0;
        for (int i = 0; i < n; i++) {
            for (int r = 0; r < EXTENDED_ASCII; r++) {
                if (input[i] == alphabet[r]) {
                    output = r;
                    BinaryStdOut.write((char) output);
                    break;
                }
            }
            char temp = alphabet[output];
            for (int r = output; r > 0; r--)
                alphabet[r] = alphabet[r - 1];
            alphabet[0] = temp;
        }
        BinaryStdOut.flush();
    }

    // apply move-to-front decoding,
    // reading from standard input and writing to standard output
    public static void decode() {
        char[] alphabet = new char[EXTENDED_ASCII];
        for (int r = 0; r < EXTENDED_ASCII; r++)
            alphabet[r] = (char) r;
        String s = BinaryStdIn.readString();
        char[] input = s.toCharArray();
        int n = input.length;
        for (int i = 0; i < n; i++) {
            char temp = alphabet[(int) input[i]];
            BinaryStdOut.write(temp);
            for (int r = (int) input[i]; r > 0; r--)
                alphabet[r] = alphabet[r - 1];
            alphabet[0] = temp;
        }
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-"))
            encode();
        if (args[0].equals("+"))
            decode();
    }

}
