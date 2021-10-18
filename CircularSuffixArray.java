/* *****************************************************************************
 *  Name:    Devin Plumb
 *  NetID:   dplumb
 *  Precept: P06
 *
 *  Description:  Description
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {

    private static final int EXTENDED_ASCII = 256; // alphabet of characters

    private final char[] letters; // holds the letters in the string
    private final int n; // holds the number of letters
    private final CircularSuffix[] indices; // holds the references to suffixes

    // represents a suffix via an index in the original array of letters
    private class CircularSuffix implements Comparable<CircularSuffix> {

        private final int index; // index of the first letter in the suffix
        private int charIndex; // comment

        // constructs the suffix object
        public CircularSuffix(int i) {
            index = i;
            charIndex = index;
        }

        // compares suffixes (implements comparable)
        public int compareTo(CircularSuffix that) {
            return letters[this.charIndex] - letters[that.charIndex];
        }
    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null argument to constructor");
        }
        letters = s.toCharArray();
        n = letters.length;
        indices = new CircularSuffix[n];
        for (int i = 0; i < n; i++) { // create a suffix for each letter
            indices[i] = new CircularSuffix(i);
        }
        sort(0, n);
    }

    // comment
    private void sort(int start, int end) {
        int[] count = new int[EXTENDED_ASCII + 1];
        int[] count2 = new int[EXTENDED_ASCII + 1];
        CircularSuffix[] aux = new CircularSuffix[end - start];
        for (int i = start; i < end; i++)
            count[letters[indices[i].charIndex] + 1]++;
        for (int r = 0; r < EXTENDED_ASCII; r++) {
            count[r + 1] += count[r];
            count2[r + 1] = count[r + 1];
        }
        for (int i = start; i < end; i++)
            aux[count[letters[indices[i].charIndex]]++] = indices[i];
        for (int i = start; i < end; i++) {
            indices[i] = aux[i - start];
            indices[i].charIndex = (indices[i].charIndex + 1) % n;
        }
        for (int r = 0; r < EXTENDED_ASCII; r++) {
            if (count2[r] < count2[r + 1] - 1)
                sort(start + count2[r], start + count2[r + 1]);
        }
    }

    // length of s
    public int length() {
        return n;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > n - 1) {
            throw new IllegalArgumentException("index out of range");
        }
        return indices[i].index;
    }

    // unit testing (required)
    public static void main(String[] args) {
        CircularSuffixArray csa = new CircularSuffixArray(args[0]);
        if (csa.length() != args[0].length())
            StdOut.println("length error");
        for (int i = 0; i < csa.length(); i++) {
            StdOut.println(csa.index(i));
        }
    }
}

