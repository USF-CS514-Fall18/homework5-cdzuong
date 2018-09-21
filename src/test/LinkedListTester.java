package test;

import linkedList.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class LinkedListTester {
    private LinkedList list;

    /** Method that will be executed before every test */
    @Before
    public void setup() {
        list = new LinkedList();
        list.append(17);
        list.append(30);
        list.append(2);
        list.append(45);
        list.append(1);
        list.append(25);
        //System.out.println(list);
    }

    /**
     * Test toString method
     */
    @Test
    public void testToString() {
       String studentRes =  list.toString().trim(); // removes whitespace after the last element, if it exists
       // System.out.println(studentRes);
       String expectedRes = "17 30 2 45 1 25";
       assertTrue("The result of toString method does not match the expected output.", studentRes.equals(expectedRes));
    }

    /**
     * Test getElement method
     */
    @Test
    public void testGetElement() {
        int elem1 = list.getElement(0);
        int elem2 = list.getElement(3);
        int elem3 = list.getElement(5);
        int elem4 = list.getElement(10);

        assertTrue("getElement(0) did not return the element at the head, 17.", elem1 == 17);
        assertTrue("getElement(3) did not return 45.", elem2 == 45);
        assertTrue("getElement(5) did not return the element at the tail, 10.", elem3 == 25);
        assertTrue("getElement(10) should have returned Integer.MIN_VALUE since such there is no node at such index.", elem4 == Integer.MIN_VALUE);

    }

    /** Test sumElementsAtEvenIndices */
    @Test
    public void testSumElementsAtEvenIndices() {
        int studentRes = list.sumElementsAtEvenIndices();
        assertTrue("sumElementsAtEvenIndices does not return the expected result.", studentRes == 20);
        list.append(90);
        studentRes = list.sumElementsAtEvenIndices();
        assertTrue("sumElementsAtEvenIndices does not return the expected result.", studentRes == 110);
    }

    /** Test reverse method */
    @Test
    public void testReverse() {
        list.reverse();
        String studentRes =  list.toString().trim(); // removes whitespace after the last element, if it exists
        // System.out.println(studentRes);
        String expectedRes = "25 1 45 2 30 17";
        assertTrue("reverse did not correctly reverse the list.", studentRes.equals(expectedRes));
    }

    /** Test removeLastOccurrence method */
    @Test
    public void testRemoveLastOccurrence() {
        list.append(30);
        list.append(6);
        list.append(30);
        list.append(28);
        list.append(99);
        list.removeLastOccurrence(30);
        String studentRes = list.toString().trim();
        System.out.println(studentRes);
        String expectedRes = "17 30 2 45 1 25 30 6 28 99";
        assertTrue("removeLastOccurrence does not remove correctly. ", studentRes.equals(expectedRes));
    }

    /** Test removeLastOccurrence method; the case when the only occurrence is at the head */
    @Test
    public void testRemoveLastOccurrenceAtHead() {
        list.append(30);
        list.append(6);
        list.append(30);
        list.append(28);
        list.append(99);
        list.removeLastOccurrence(17);
        String studentRes = list.toString().trim();
        //System.out.println(studentRes);
        String expectedRes = "30 2 45 1 25 30 6 30 28 99";
        assertTrue("removeLastOccurrence does not remove correctly. ", studentRes.equals(expectedRes));
    }

    /** Test removeLastOccurrence method, the case when that last occurrence is at the tail. */
    @Test
    public void testRemoveLastOccurrenceAtTail() {
        list.append(30);
        list.append(6);
        list.append(30);
        list.append(28);
        list.append(99);
        list.removeLastOccurrence(99);
        String studentRes = list.toString().trim();
        //System.out.println(studentRes);
        String expectedRes = "17 30 2 45 1 25 30 6 30 28";
        assertTrue("removeLastOccurrence does not remove correctly. ", studentRes.equals(expectedRes));
        //System.out.println(list.tail().elem());
        assertTrue("removeLastOccurrence does not update tail correctly when the last occurrence of the element is at the tail", list.tail().elem() == 28);
    }

    /** Test addNumber - simple case without carry over */
    @Test
    public void testAddNumberSimpleTest() {
        list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.addNumber(7);
        String studentRes = list.toString().trim();
        System.out.println(studentRes);
        String expectedRes = "8 2 3 4";
        assertTrue("addNumber does not add a value correctly", studentRes.equals(expectedRes));
    }

    /** Test addNumber; some carry over */
    @Test
    public void testAddNumberMediumTest() {
        list = new LinkedList();
        list.append(3);
        list.append(9);
        list.append(8);
        list.append(1);
        list.addNumber(7);
        String studentRes = list.toString().trim();
        System.out.println(studentRes);
        String expectedRes = "0 0 9 1";
        assertTrue("addNumber does not add a value correctly", studentRes.equals(expectedRes));
    }

    /** Test addNumber;  harder case: carry over for all digits  */
    @Test
    public void testAddNumberHarderTest() {
        list = new LinkedList();
        list.append(3);
        list.append(9);
        list.append(9);
        list.append(9);
        list.addNumber(7);
        String studentRes = list.toString().trim();
        System.out.println(studentRes);
        String expectedRes = "0 0 0 0 1";
        assertTrue("addNumber does not add a value correctly", studentRes.equals(expectedRes));
    }

}
