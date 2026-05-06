import java.util.Scanner;
import java.util.ArrayList;

public class NQueensCombined {
    static int N;
    static int[][] board;
    static int solutionCount;
    static ArrayList<ArrayList<Integer>> allSolutions;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queens (N): ");
        N = sc.nextInt();

        board = new int[N][N];
        allSolutions = new ArrayList<>();
        solutionCount = 0;


        System.out.println("Solving N-Queens for N = " + N);


        solve(0);


        System.out.println("SUMMARY");

        System.out.println("Total Solutions Found: " + solutionCount);

        if (solutionCount > 0) {

            for (int i = 0; i < allSolutions.size(); i++) {
                System.out.print("Solution " + (i + 1) + ": [");
                ArrayList<Integer> sol = allSolutions.get(i);
                for (int j = 0; j < sol.size(); j++) {
                    System.out.print(sol.get(j));
                    if (j < sol.size() - 1) System.out.print(", ");
                }
                System.out.println("]");
            }
        } else {
            System.out.println("No solution exists for N = " + N);
        }

        sc.close();
    }

    static void solve(int row) {
        if (row == N) {
            solutionCount++;
            saveAndPrintSolution();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                solve(row + 1);
                board[row][col] = 0;
            }
        }
    }

    static boolean isSafe(int row, int col) {

        for (int i = 0; i < row; i++)
            if (board[i][col] == 1) return false;


        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;


        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1) return false;

        return true;
    }

    static void saveAndPrintSolution() {
        ArrayList<Integer> solution = new ArrayList<>();

        System.out.println("----------------------------------------");
        System.out.println("Solution #" + solutionCount);
        System.out.println("----------------------------------------");


        System.out.println("Matrix Format:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                    solution.add(j + 1);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }


        System.out.print("Array Format: [");
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(solution.get(i));
            if (i < solution.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("\n");

        allSolutions.add(solution);
    }
}