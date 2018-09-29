package linkedList;

import java.io.IOException;

/**
 * A class representing a custom singly-linked list.
 * FILL IN CODE in methods toString, getElement, sumElementsAtEvenIndices(),
 * removeNodes, reverse, removeLastOccurrence and addNumber.
 * Note: you are not allowed to use Java's built in class LinkedList
 * from java.util. Also, you are not allowed to use arrays, ArrayLists,
 * any maps or sets for this homework.
 */
public class LinkedList {
    private Node head, tail;

    /**
     * Constructor of class LinkedList
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Returns the head of the linked list
     *
     * @return head of the linked list
     */
    public Node head() {
        return head;
    }

    /**
     * Getter for the tail.
     *
     * @return tail of the linked list
     */
    public Node tail() {
        return tail;
    }

    /**
     * Inserts a new node at the front of the list
     *
     * @param elem element to insert
     */
    public void insertAtFront(int elem) {
        Node newNode = new Node(elem);
        if (head != null) {
            newNode.setNext(head);
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    /**
     * Creates a new node with the given element and
     * adds it to the back of the list
     *
     * @param elem element to append at the end of the list
     */
    public void append(int elem) {
        Node newNode = new Node(elem);
        if (tail != null) {
            tail.setNext(newNode);
            tail = newNode;
        } else {
            head = tail = newNode;
        }
    }

    /**
     * Remove the node after previousNode
     *
     * @param previousNode the node before the one we want to delete
     * @return integer element at the deleted node
     * or Integer.MAX_VALUE if nothing to delete
     */
    public int remove(Node previousNode) {
        if ((previousNode == null) || (previousNode.next() == null)) {
            System.out.println("Nothing to remove");
            return Integer.MAX_VALUE;
            // Note: it would be best to throw an exception here,
            // we will discuss exceptions in class soon

        }

        int elem = previousNode.next().elem(); //save the element before deleting the node

        // if removing the tail
        if (previousNode.next() == tail) {
            tail = previousNode;
            tail.setNext(null);

        } else {
            // delete node
            previousNode.setNext(previousNode.next().next());
        }
        return elem;
    }

    /**
     * Returns a string that contains elements from
     * all the nodes separated by whitespace
     *
     * @return string representation of the linked list
     */
    public String toString() {
        // FILL IN CODE
        Node current = head;
        String result = "";
        while (current != null) {
            result += Integer.toString(current.elem()) + " ";
            current = current.next();
        }

        return result; // change as needed
    }

    /**
     * Returns the element at the node with given index
     * Assume the head corresponds to index 0
     *
     * @param index index of the element in the linked list
     * @return element at the node at that index or INTEGER.MIN_VALUE
     * if there is no node at that index
     */
    public int getElement(int index) {
        //FILL IN CODE

        Node current = head;
        int elem = head.elem();
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.next();
            } else {
                return Integer.MIN_VALUE;
            }
        }

        return current.elem(); // change as needed


    }

    /**
     * Returns the sum of elements at even indices (0, 2, 4, ...)
     *
     * @return sum of elements at even indices
     * Note: you may not use an additional list or array etc.
     */
    public int sumElementsAtEvenIndices() {
        // FILL IN CODE
        Node current = head;
        int sum = 0;
        while (current.next().next() != null && current.next() != null) {
            sum += current.elem();
            current = current.next().next();
        }
        return sum; // change as needed
    }

    /**
     * Remove all nodes from the linked list from startIndex to endIndex
     * Example: if list is [5, 10, 24, 1, 12, 7, 9, 3] and we invoke this method
     * with startIndex = 2 and endIndex = 5, then the list should become:
     * 5, 10, 9, 3
     * Note: you are not allowed to use an extra LinkedList or array, ArrayList etc.
     *
     * @param startIndex index from which we should start removing nodes
     * @param endIndex   index of last node to remove
     */
    public void removeNodes(int startIndex, int endIndex) {
        // FILL IN CODE
        Node current = head;
        int i = 0;


        if (startIndex > 0) {
            while (current != null) {

                while (i != 0 && i >= startIndex - 1 && i < endIndex) {


                    remove(current);

                    i++;
                }
                current = current.next();
                i++;

            }
        }
        if (startIndex <= 0) {
            i = 0;
            while (current != null) {
                current = current.next();
                i++;
                if (i == endIndex + 1) {
                    head = current;
                    head.setNext(current.next());
                }
            }
        }
    }


    /**
     * Reverse the linked list.
     * Do not change the signature of the method.
     * You may not use any extra memory apart from a couple of integers
     * and a variable of type Node.
     * Example: If the list is 4, 5, 1, 7, 2, after invoking reverse(), it
     * should become 2, 7, 1, 5, 4
     */
    public void reverse() {
        // FILL IN CODE
        Node current = head;
        Node temp;
        while (current.next() != null) {
            temp = head;
            insertAtFront(tail.elem());
            if (current.next() == tail) {
                remove(current);
            }
            tail = temp;
            current = current.next();
        }


    }

    /**
     * Given a linked list that has duplicates,
     * remove the last occurrence of a given element
     * in the list
     *
     * @param elem integer element
     */
    public void removeLastOccurrence(int elem) {

        Node current = head;
        Node penult = tail;
        int i = 0;
        int dupIndex = 0;
        while (current.next() != null) {
            if (current.elem() == elem) {
                dupIndex = i;
            }
            i++;
            current = current.next();
            if (current.next() == tail) {
                penult = current;
            }

        }

        if (tail.elem() == elem) {
            tail = penult;
            tail.setNext(null);
        } else if (dupIndex == 0) {
            head = head.next();
        } else {
            current = head;
            int j = 0;
            while (current != null) {
                if (j == dupIndex - 1) {
                    current.setNext(current.next().next());
                }
                current = current.next();
                j++;
            }
        }


    }

    /**
     * Assume this linked list represents a decimal number,
     * where each node represents one digit, but the order of digits is reversed,
     * so that the ones appear in position 0, the tens in position 1, and so on.
     * The most significant digit will be in the last position.
     * For instance, the list 3 9 8 1 represents the number 1893. The method should add a given
     * value to the number represented by this linked list.
     * Example: if the list is 3 9 8 1 and value is 7, then the resulting
     * list will be 0 0 9 1 representing the number 1900 (because 1893 + 7 = 1900)
     *
     * @param value integer value to add to the number represented by this linked list
     */
    public void addNumber(int value) {
        // FILL IN CODE
        Node current = head;

        int total = value + current.elem();
        int stay = 0;
        int carry = 0;
        if (total >= 10) {
            total = 10;
        }


        current.setElem(stay);
        while (current.next() != null) {
            // Make sure you deal with the situation when
            // the sum is 10 or more and you need to carry over to the next digit,
            // potentially all the way to the significant digit, and might need to add another node after it
            if (current == head) {
                current.setElem(total % 10);
            }

            //ten's place
            carry = total / 10;
            total = carry + current.next().elem();

            current.next().setElem(total % 10);
            current = current.next();

        }
        if (total == 10) {
            Node addThis = new Node(1);
            current.setNext(addThis);
        }
    }
}


