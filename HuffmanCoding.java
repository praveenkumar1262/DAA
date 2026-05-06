import java.util.*;
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
}
class FrequencyComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class HuffmanCoding {
    public static void generateCodes(Node root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " -> " + code);
        }
        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters:");
        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }

        System.out.println("Enter frequencies:");
        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new FrequencyComparator());
        for (int i = 0; i < n; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }
        Node root = pq.poll();
        System.out.println("\nHuffman Codes:");
        generateCodes(root, "");
        sc.close();
    }
}
