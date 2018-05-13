package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple ConcentricCircularMatrix.
 * Unlocks Level-3
 */
public class ConcentricCircularMatrixTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConcentricCircularMatrixTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConcentricCircularMatrixTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
        int count = 9;
        getConcentricMatrix(count);
    }

    /**
     * Print the concentric matrix
     * @param count
     * output:
     * 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9
     * 9 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9
     * 9 8 7 7 7 7 7 7 7 7 7 7 7 7 7 8 9
     * 9 8 7 6 6 6 6 6 6 6 6 6 6 6 7 8 9
     * 9 8 7 6 5 5 5 5 5 5 5 5 5 6 7 8 9
     * 9 8 7 6 5 4 4 4 4 4 4 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 3 3 3 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 2 2 2 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 2 2 2 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 3 3 3 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 4 4 4 4 4 4 5 6 7 8 9
     * 9 8 7 6 5 5 5 5 5 5 5 5 5 6 7 8 9
     * 9 8 7 6 6 6 6 6 6 6 6 6 6 6 7 8 9
     * 9 8 7 7 7 7 7 7 7 7 7 7 7 7 7 8 9
     * 9 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9
     * 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9
     */
    private void getConcentricMatrix(int count) {
        if (count == 1) {
            System.out.println(count);
            return;
        }

        int matrixCount = 2 * count - 1;
        int[][] matrix = new int[matrixCount][matrixCount];
        try {
            for (int i = 0; i < count; i++) {
                for (int j = i; j < matrixCount - i; j++) {
                    if (j == count - 1) {
                        matrix[j][j] = 1;
                    }
                    int number = count - i;
                    matrix[i][j] = number;
                    matrix[matrixCount - i - 1][j] = number;
                    matrix[j][i] = number;
                    matrix[j][matrixCount - i - 1] = number;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < matrixCount; i++) {
            for (int j = 0; j < matrixCount; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
