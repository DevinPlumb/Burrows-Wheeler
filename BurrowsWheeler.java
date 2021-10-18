/* *****************************************************************************
 *  Name:    Devin Plumb
 *  NetID:   dplumb
 *  Precept: P06
 *
 *  Description:  Implements the Burrows-Wheeler algorithm (transform and
 *                inverse transform) for a given string read from BinaryStdIn,
 *                writing to BinaryStdOut.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {

    private static final int EXTENDED_ASCII = 256; // alphabet of characters

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String s = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(s);
        char[] letters = s.toCharArray();
        int n = letters.length;
        char[] transform = new char[n];
        for (int i = 0; i < n; i++) {
            int num = csa.index(i);
            if (num == 0) {
                BinaryStdOut.write(i);
            }
            transform[i] = letters[(num + n - 1) % n];
        }
        BinaryStdOut.write(new String(transform));
        BinaryStdOut.flush();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        char[] t = s.toCharArray();
        int n = t.length;
        char[] sortedT = new char[n];
        int[] count = new int[EXTENDED_ASCII + 1];
        int[] next = new int[n];

        // modified version of the key-index counting algorithm provided to us
        for (int i = 0; i < n; i++)
            count[t[i] + 1]++;
        for (int r = 0; r < EXTENDED_ASCII; r++)
            count[r + 1] += count[r];
        for (int i = 0; i < n; i++) {
            next[count[t[i]]] = i;
            sortedT[count[t[i]]] = t[i];
            count[t[i]] = count[t[i]] + 1;
        }

        char[] inverseTransform = new char[n];
        int j = first;
        for (int i = 0; i < n; i++) {
            inverseTransform[i] = sortedT[j];
            j = next[j];
        }
        BinaryStdOut.write(new String(inverseTransform));
        BinaryStdOut.flush();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-"))
            transform();
        if (args[0].equals("+"))
            inverseTransform();
    }

}
