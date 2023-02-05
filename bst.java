public class bst {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root = null;

    Node addroot(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = addroot(root.left, data);
        }
        if (data > root.data) {
            root.right = addroot(root.right, data);
        }
        return root;
    }

    Node deleteroot(Node root, int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteroot(root.left, data);
        }
        if (data > root.data) {
            root.right = deleteroot(root.right, data);
        }
        // If the node is with only one child or no child
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;
        return root;
    }

    void insert(int data) {
        root = addroot(root, data);
    }

    void del(int data) {
        root = deleteroot(root, data);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ->");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        bst ob = new bst();
        ob.insert(8);
        ob.insert(3);
        ob.insert(1);
        ob.insert(6);
        ob.insert(7);
        ob.insert(10);
        ob.insert(14);
        ob.insert(4);
        System.out.print("Inorder traversal: ");
        ob.inorder(ob.root);
        System.out.println("\n\nAfter deleting 10");
        ob.del(10);
        System.out.print("Inorder traversal: ");
        ob.inorder(ob.root);

    }

}