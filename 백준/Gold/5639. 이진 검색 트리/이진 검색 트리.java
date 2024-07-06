import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = Integer.parseInt(br.readLine());
        Node root = new Node(temp);
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            insert(root, Integer.parseInt(input));
        }
        select(root);
        bw.flush();
    }

    private static void select(Node node) throws IOException {
        if (node == null) {
            return;
        }
        select(node.left);
        select(node.right);
        bw.write(node.value + "\n");
    }

    private static void insert(Node node, int input) {
        if (node.value > input) {
            if(node.left == null){
                node.left = new Node(input);
            } else {
                insert(node.left, input);
            }
        } else {
            if(node.right == null){
                node.right = new Node(input);
            } else {
                insert(node.right, input);
            }
        }
    }

    private static class Node {
        public int value;
        public Node left = null;
        public Node right = null;

        public Node(int value) {
            this.value = value;
        }
    }
}