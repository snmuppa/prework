package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for KthSmallestElement in an Array.
 * Unlocks level-4
 */
public class KthSmallestElement extends TestCase {

    private static int heapSize;

    private int leftNode(int nodeCount) {
        return 2 * nodeCount + 1;
    }

    private int rightNode(int nodeCount) {
        return 2 * nodeCount + 2;
    }

    private void buildMinHeap(int inputArray[]) {
        heapSize = inputArray.length;

        for (int i = (heapSize / 2 - 1); i >= 0; i--) {
            minHeapify(inputArray, i);
        }
    }

    private void minHeapify(int[] inputArray, int i) {
        int leftNode = leftNode(i);
        int rightNode = rightNode(i);

        int smallestElementIndex = i;

        if (leftNode < heapSize && inputArray[leftNode] < inputArray[i]) {
            smallestElementIndex = leftNode;
        }

        if (rightNode < heapSize && inputArray[rightNode] < inputArray[smallestElementIndex]) {
            smallestElementIndex = rightNode;
        }

        if (smallestElementIndex != i) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[smallestElementIndex];
            inputArray[smallestElementIndex] = temp;
            minHeapify(inputArray, smallestElementIndex);
        }
    }

    /**
     * Sorts the array in descending order
     * @param inputArray
     */
    private void heapSort(int[] inputArray) { // side implementation
        buildMinHeap(inputArray);
        int arrayLength = inputArray.length;
        for (int i = arrayLength - 1; i >= 0; i--) {
            // Move current root to end
            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            heapSize = heapSize - 1;
            minHeapify(inputArray, 0);
        }
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KthSmallestElement(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(KthSmallestElement.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        int inputArray[] = { 3, 5, 12, 6, 8, 4, 10, 9, 2 };

        int kthElement = 4;
        int kthSmallestNumber = getKthSmallestElement(inputArray, kthElement);
        System.out.println(kthSmallestNumber);
    }

    private int getKthSmallestElement(int[] inputArray, int kthElement) {
        buildMinHeap(inputArray);
        int kthIndex = kthElement - 1;
        int arrayLength = inputArray.length;
        int maxIndex = arrayLength - 1;
        if (kthIndex > maxIndex || kthIndex < 0) {
            System.out.println("Out of bound exception");
            return -1;
        }

        for (int i = arrayLength - 1; i >= 0; i--) {
            if (kthIndex == 0) {
                return inputArray[0];
            }
            // Move current root to end
            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            heapSize = heapSize - 1;
            minHeapify(inputArray, 0);
            kthIndex--;
        }

        return -1;
    }
}
