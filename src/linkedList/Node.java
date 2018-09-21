package linkedList;
/* A class representing a node in a custom singly linked list.
 * Do not modify this class.
 */
public class Node {
    private int elem; // element stored in the node
    private Node next; // reference to the next node

    /**
     * Constructor for class Node
     * @param elem integer element
     * @param next reference to the next node
     */
    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    /**
     * Constructor for class Node that takes only the element
     * and sets next to null.
     * @param elem integer element
     */
    public Node(int elem) {
        this.elem = elem;
        next = null;
    }

    /**
     * Getter for the element
     * @return element stored in the node
     */
    public int elem() {
        return elem;
    }

    /**
     * Setter for the element
     * @param elem new element to store at the node
     */
    public void setElem(int elem) {
        this.elem = elem;
    }

    /** Getter for next
     *
     * @return reference to the next node
     */
    public Node next() {
        return next;
    }

    /**
     * Setter for next
     * @param other node that should be as the next node
     */
    public void setNext(Node other) {
        next = other;
    }
}

