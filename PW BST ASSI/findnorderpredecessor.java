class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    Node findInorderPredecessor(Node root, int key) {
        Node predecessor = null;
        Node current = root;

        while (current != null) {
            if (key > current.key) {
                predecessor = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (predecessor != null && predecessor.key == key) {
            if (predecessor.left != null) {
                predecessor = findMax(predecessor.left);
            }
        }

        return predecessor;
    }

    Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(25);

        int key = 15;
        Node predecessor = tree.findInorderPredecessor(tree.root, key);
        if (predecessor != null) {
            System.out.println("The inorder predecessor of " + key + " is " + predecessor.key);
        } else {
            System.out.println("The inorder predecessor does not exist for " + key);
        }
    }
}

