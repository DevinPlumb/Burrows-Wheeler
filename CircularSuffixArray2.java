/* *****************************************************************************
 *  Name:    Devin Plumb
 *  NetID:   dplumb
 *  Precept: P06
 *
 *  Description:  A fundamental data structure which describes the abstraction
 *                of a sorted array of the circular suffixes of a given String
 *                (a String of length n will have n circular suffixes).
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class CircularSuffixArray2 {

    private final char[] letters; // holds the letters in the string
    private final int n; // holds the number of letters
    private final CircularSuffix[] indices; // holds the references to suffixes

    // represents a suffix via an index in the original array of letters
    private class CircularSuffix implements Comparable<CircularSuffix> {

        private final int index; // index of the first letter in the suffix

        // constructs the suffix object
        public CircularSuffix(int i) {
            index = i;
        }

        // compares suffixes (implements comparable)
        public int compareTo(CircularSuffix that) {
            // if it is not resolved after running through all letters, equal
            for (int i = 0; i < n; i++) {
                // compare letters, if equal move to next pair of letters
                if (letters[(this.index + i) % n]
                        < letters[(that.index + i) % n]) return -1;
                if (letters[(this.index + i) % n]
                        > letters[(that.index + i) % n]) return +1;
            }
            return 0;
        }
    }

    // circular suffix array of s
    public CircularSuffixArray2(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null argument to constructor");
        }
        letters = s.toCharArray();
        n = letters.length;
        indices = new CircularSuffix[n];
        for (int i = 0; i < n; i++) { // create a suffix for each letter
            indices[i] = new CircularSuffix(i);
        }
        Arrays.sort(indices);
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
