import java.util.*;

class Item {
    int weight, value;
    double ratio;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

class Node {
    int level, profit, weight;
    double bound;
    boolean[] taken;

    Node(int level, int profit, int weight, boolean[] taken) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
        this.taken = taken.clone();
    }
}

public class KnapsackBB {
    public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    static int n, W;
    static Item[] items;

    static double bound(Node u) {
        if (u.weight >= W)
            return 0;

        double profitBound = u.profit;
        int j = u.level + 1;
        int totalWeight = u.weight;

        while (j < n && totalWeight + items[j].weight <= W) {
            totalWeight += items[j].weight;
            profitBound += items[j].value;
            j++;
        }

        if (j < n) {
            profitBound += (W - totalWeight) * items[j].ratio;
        }

        return profitBound;
    }

    static void knapsack() {
        Queue<Node> queue = new LinkedList<>();

        Node u = new Node(-1, 0, 0, new boolean[n]);
        queue.add(u);

        int maxProfit = 0;
        boolean[] bestSet = new boolean[n];

        while (!queue.isEmpty()) {
            u = queue.poll();

            if (u.level == n - 1)
                continue;

            int nextLevel = u.level + 1;

            boolean[] includeTaken = u.taken.clone();
            includeTaken[nextLevel] = true;

            Node v = new Node(nextLevel,
                    u.profit + items[nextLevel].value,
                    u.weight + items[nextLevel].weight,
                    includeTaken);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("With item " + (nextLevel + 1));
            System.out.println("Weight: " + v.weight + ", Profit: " + v.profit);

            if (v.weight <= W && v.profit > maxProfit) {
                maxProfit = v.profit;
                bestSet = v.taken.clone();
                System.out.println("Updated Max Profit!");
            }

            v.bound = bound(v);
            System.out.println("Bound: " + v.bound);

            if (v.bound > maxProfit) {
                queue.add(v);
                System.out.println(GREEN+"Added to queue\n"+RESET);
            } else {
                System.out.println(RED+"Pruned\n"+RESET);
            }

            boolean[] excludeTaken = u.taken.clone();

            v = new Node(nextLevel, u.profit, u.weight, excludeTaken);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Without item " + (nextLevel + 1));
            System.out.println("Weight: " + v.weight + ", Profit: " + v.profit);

            v.bound = bound(v);
            System.out.println("Bound: " + v.bound);

            if (v.bound > maxProfit) {
                queue.add(v);
                System.out.println(GREEN+"Added to queue\n"+RESET);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            } else {
                System.out.println(RED+"Pruned\n"+RESET);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
        System.out.println("=====================================================");
        System.out.println("Maximum Profit = " + maxProfit);
        System.out.println(" Items included in knapsack:");

        for (int i = 0; i < n; i++) {
            if (bestSet[i]) {
                System.out.println("Item " + (i + 1) +
                        " -> Weight: " + items[i].weight +
                        ", Value: " + items[i].value +
                        ", Ratio: " + items[i].ratio);
            }
        }
        System.out.println("======================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        n = sc.nextInt();

        items = new Item[n];

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            items[i] = new Item(sc.nextInt(), 0);
        }

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            items[i].value = sc.nextInt();
            items[i].ratio = (double) items[i].value / items[i].weight;
        }

        System.out.print("Enter capacity: ");
        W = sc.nextInt();
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        System.out.println("\n Items after sorting (by value/weight ratio):");
        System.out.println("-------------------------------------------------");
        System.out.println("Item\tWeight\tValue\tRatio");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" +
                    items[i].weight + "\t" +
                    items[i].value + "\t" +
                    items[i].ratio);
        }

        knapsack();
    }
}