import java.util.ArrayList;

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

    // Constructor
    BinaryTree() {
        root = null;
    }

    // Inorder traversal of the tree
    void inorderTraversal(Node node, ArrayList<Integer> arr) {
        if (node == null)
            return;

        inorderTraversal(node.left, arr);
        arr.add(node.key);
        inorderTraversal(node.right, arr);
    }

    // Function to check if there exists a pair with given sum
    boolean findPairWithSum(Node node, int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorderTraversal(node, arr);

        int start = 0;
        int end = arr.size() - 1;

        while (start < end) {
            int currentSum = arr.get(start) + arr.get(end);

            if (currentSum == sum) {
                System.out.println("Pair found (" + arr.get(start) + ", " + arr.get(end) + ")");
                return true;
            }
            if (currentSum < sum)
                start++;
            else
                end--;
        }
        System.out.println("No pair found");
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.right = new Node(22);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(9);

        int sum = 14;
        tree.findPairWithSum(tree.root, sum);
    }
}
