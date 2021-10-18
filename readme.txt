/* *****************************************************************************
 *  Name:      Devin Plumb
 *  NetID:     dplumb
 *  Precept:   P06
 *
 *  Hours to complete assignment (optional):    ~8
 *
 **************************************************************************** */

Programming Assignment 8: Burrows-Wheeler



/* *****************************************************************************
 *  List in table format which input files you used to test your program.
 *  Fill in columns for how long your program takes to compress and
 *  decompress these instances (by applying BurrowsWheeler, MoveToFront,
 *  and Huffman in succession). Also, fill in the third column for
 *  the compression ratio (number of bytes in compressed message
 *  divided by the number of bytes in the message).
 *
 *  Use three significant digits for the compression ratio.
 **************************************************************************** */

File            Encoding Time    Decoding time      Compression ratio
------------------------------------------------------------------------
mobydick.txt    3.304s           0.615s             0.347
aesop.txt       1.034s           0.472s             0.344
us.gif          0.502s           0.419s             1.03

/* *****************************************************************************
 *  Compare the results of your program (compression ratio and running
 *  time) on mobydick.txt to that of the most popular Linux/OS X compression
 *  program (gzip).
 **************************************************************************** */

 Program        Encoding Time    Decoding time      Compression ratio
 ------------------------------------------------------------------------
 mine           3.304s           0.615s             0.347
 gzip           0.130s           0.014s             0.408

/* *****************************************************************************
 *  Give the order of growth of the running time of each of the 6
 *  methods as a function of the input size n and the alphabet size R
 *  both in practice (on typical English text inputs) and in theory
 *  (in the worst case), e.g., n, n + R, n log n, n^2, or R n.
 *
 *  Include the time for sorting circular suffixes in Burrows-Wheeler
 *  transform().
 **************************************************************************** */

                                      typical            worst
---------------------------------------------------------------------
BurrowsWheeler transform()            n log n            n^2
BurrowsWheeler inverseTransform()     n + R              n + R
MoveToFront encode()                  n + R              R n
MoveToFront decode()                  n + R              R n
Huffman compress()                    n + R log R        n + R log R
Huffman expand()                      n                  n


/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */

    None.

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */

    None.

/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */

    None.

/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it. Additionally, you may include any suggestions
 *  for what to change or what to keep (assignments or otherwise) in future
 *  semesters.
 **************************************************************************** */

    None.
