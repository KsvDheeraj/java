
// Java program for sparse matrix representation.
// Using Link list
import java.util.*;

public class sm_ll {
    // Creating head/first node of list as NULL
    static Node first = null;

    // Node class to represent link list
    public static class Node {
        int row;
        int col;
        int data;
        Node next;
    };

    // Driver Code
    public static void main(String[] args) {
        // 4x5 sparse matrix
        int[][] sparseMatrix = { { 0, 0, 3, 0, 4 },
                { 0, 0, 5, 7, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 2, 6, 0, 0 } };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                // Pass only those values which
                // are non - zero
                if (sparseMatrix[i][j] != 0) {
                    create_new_node(i, j,
                            sparseMatrix[i][j]);
                }
            }
        }
        printList(first);
    }

    // Function to create new node
    private static void create_new_node(int row_index, int col_index, int x) {
        Node temp = first;
        Node r;

        // If link list is empty then
        // create first node and assign value.
        if (temp == null) {
            temp = new Node();
            temp.row = row_index;
            temp.col = col_index;
            temp.data = x;
            temp.next = null;
            first = temp;
        }

        // If link list is already created
        // then append newly created node
        else {
            while (temp.next != null)
                temp = temp.next;

            r = new Node();
            r.row = row_index;
            r.col = col_index;
            r.data = x;
            r.next = null;
            temp.next = r;
        }
    }

    // Function prints contents of linked list
    // starting from start
    public static void printList(Node start) {
        Node ptr = start;
        System.out.print("row_position:");
        while (ptr != null) {
            System.out.print(ptr.row + " ");
            ptr = ptr.next;
        }
        System.out.println("");
        System.out.print("column_position:");

        ptr = start;
        while (ptr != null) {
            System.out.print(ptr.col + " ");
            ptr = ptr.next;
        }
        System.out.println("");
        System.out.print("Value:");
        ptr = start;

        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }
}
