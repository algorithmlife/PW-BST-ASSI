class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;


    BST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void searchIterative(int key) {
        Node current = root;
        Node parent = null; 

        while (current != null) {
            if (key == current.key) {
                if (parent != null) {
                    if (key > parent.key) {
                        System.out.println("The given key is the right node of the node with key " + parent.key);
                    } else if (key < parent.key) {
                        System.out.println("The given key is the left node of the node with key " + parent.key);
                    }
                } else {
                    System.out.println("The given key is the root of the BST");
                }
                return;
            } else if (key < current.key) {
                parent = current; 
                current = current.left; 
            } else {
                parent = current; 
                current = current.right; 
            }
        }
        System.out.println("The given key is not present in the BST");
    }
}

public class Search {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(25);

        tree.searchIterative(25);  
    }
}
