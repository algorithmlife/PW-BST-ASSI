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

    void findKthLargest(int k) {
        int[] count = {0};  
        Node result = findKthLargestUtil(root, k, count);
        if (result != null) {
            System.out.println("The " + k + "'th largest element is " + result.key);
        } else {
            System.out.println("There are less than " + k + " nodes in the BST");
        }
    }

    Node findKthLargestUtil(Node node, int k, int[] count) {
        if (node == null) {
            return null;
        }

        Node right = findKthLargestUtil(node.right, k, count);
        if (right != null) {
            return right;
        }


        count[0]++;

        if (count[0] == k) {
            return node;
        }


        return findKthLargestUtil(node.left, k, count);
    }
}

public class findKthLargest {
    public static void main(String[] args) {
        BST tree = new BST();


        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(25);


        int k = 2;
        tree.findKthLargest(k);  
    }
}
