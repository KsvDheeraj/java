import java.util.ArrayList;
import java.util.Stack;

public class dfs {

    static ArrayList<Node> nodes = new ArrayList<>();

    static class Node {
        int data; // to store data
        boolean visited; // to store whether the node is visited or not

        Node(int data) {
            this.data = data;

        }
    }

    // to find neighbours of the node
    public ArrayList<Node> findNeighbours(int adjacency_matrix[][], Node x) {
        int nodeIndex = -1;

        ArrayList<Node> neighbours = new ArrayList<>(); // neighbours arraylist is used to store neighbours
        for (int i = 0; i < nodes.size(); i++) { // to get the index of the node
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) { // if index is found
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if (adjacency_matrix[nodeIndex][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    // Iterative DFS using stack
    public void dfsUsingStack(int adjacency_matrix[][], Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            Node element = stack.pop();
            if (!element.visited) {
                System.out.print(element.data + " ");
                element.visited = true;
            }

            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                }
            }
        }
    }

    public static void main(String arg[]) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        int adjacency_matrix[][] = {
                { 0, 1, 1, 0, 0 },
                { 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 1 },
                { 0, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 1 },
        };

        dfs ob = new dfs();

        System.out.println("The DFS traversal of the graph using stack ");
        ob.dfsUsingStack(adjacency_matrix, node1);

        System.out.println();

    }

    public static void clearVisitedFlags() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited = false;
        }
    }
}