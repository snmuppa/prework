package algorthims.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for the Next Greatest Element Array.
 * Unlocks level-5
 */
public class NextGreatestElementTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public NextGreatestElementTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(NextGreatestElementTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        ArrayList<Integer> inputlist = new ArrayList<>(Arrays.asList(3, 2, 6, 4, 12, 11, 20, 21, 22, 1));
        // Other test inputs
        // ArrayList<Integer> inputlist = new ArrayList<>(Arrays.asList(5, 3, 3, 2, 1));
        // ArrayList<Integer> inputlist = new ArrayList<>(Arrays.asList(2, 2, 2, 3, 3));
        // ArrayList<Integer> inputlist = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));

        ArrayList<Integer> nextGreatestArray = getNextGreatestArray(inputlist);

        System.out.println(nextGreatestArray.toString());
    }

    private ArrayList<Integer> getNextGreatestArray(ArrayList<Integer> inputlist) {
        LinkedStack<StackStorage<Integer>> stack = new LinkedStack<>();

        ArrayList<Integer> nextGreatestList = new ArrayList<>(inputlist.size());
        for (@SuppressWarnings("unused") Integer integer : inputlist) {
            nextGreatestList.add(null);
        }

        for (int index = 0; index < inputlist.size(); index++) {
            if (stack.length == 0 || stack.peek().getData() > inputlist.get(index)) {
                stack.push(new StackStorage<Integer>(index, inputlist.get(index)));
                continue;
            }

            while(stack.length > 0 && stack.peek().getData() < inputlist.get(index)) {
                StackStorage<Integer> storage = stack.pop();
                nextGreatestList.set(storage.getIndex(), inputlist.get(index));
            }

            stack.push(new StackStorage<Integer>(index, inputlist.get(index)));
        }

        while(stack.length > 0) {
            StackStorage<Integer> storage = stack.pop();
            nextGreatestList.set(storage.getIndex(), -1); // set -1 for elements that are left out.
        }

        return nextGreatestList;
    }

    /**
     * A class that stores the index of the array list and the corresponding data at that location
     * @author Sai Muppa
     *
     * @param <T>
     */
    public class StackStorage<T> {
        private int index;

        private T data;

        public StackStorage(int index, T data) {
            this.index = index;
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public T getData() {
            return data;
        }
    }

    /**
     * Class the represents the node of a linked list
     * @author Sai Muppa
     *
     */
    public class ListNode<T> {
        private T nodeData;

        private ListNode<T> nextNode;

        public ListNode(T nodeData) {
            this.nodeData = nodeData;
        }

        public void setData(T nodeData) {
            this.nodeData = nodeData;
        }

        public T getData() {
            return nodeData;
        }

        public void setNext(ListNode<T> nextNode) {
            this.nextNode = nextNode;
        }

        public ListNode<T> getNext() {
            return nextNode;
        }
    }

    /**
     * Implementation of the Linked List version of the Stack
     * @author Sai Muppa
     *
     * @param <T>
     */
    public class LinkedStack<T> {
        private int length;

        private ListNode<T> top;

        public LinkedStack() {
            length = 0;
            top = null;
        }

        public void push(T nodeData) {
            ListNode<T> temp = new ListNode<T>(nodeData);

            temp.setNext(top);
            top = temp;
            length++;
        }

        public T pop() throws EmptyStackException {
            if (isStackEmpty()) {
                throw new EmptyStackException();
            }
            T result = top.getData();
            top = top.getNext();
            length--;
            return result;
        }

        public T peek() throws EmptyStackException {
            if (isStackEmpty()) {
                throw new EmptyStackException();
            }
            T result = top.getData();
            return result;
        }

        public boolean isStackEmpty() {
            return (length == 0);
        }
    }
}
