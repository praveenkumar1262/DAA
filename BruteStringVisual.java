import java.util.Scanner;

class BruteStringVisual {
        public static final String RESET = "\u001B[0m";
            public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
                  public static void prF(int n,String s) {
                          int l=s.length();
                          for (int i =n;i<l;i++) {
                                  System.out.print(s.charAt(i)+ "  ");
                          }
                  }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int alignmentCount = 0;
        int comparisonCount = 0;
        int foundIndex = -1;

        System.out.print("Enter the Text    : ");
        String T = sc.nextLine();

        System.out.print("Enter the Pattern : ");
        String P = sc.nextLine();

        int n = T.length();
        int m = P.length();

        System.out.println();


        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        System.out.print("T : ");
        for (int i = 0; i < n; i++) {
            System.out.print(T.charAt(i) + "  ");
        }
        System.out.println("\n");

        for (int i = 0; i <= n - m; i++) {
            alignmentCount++;

            System.out.print("P : ");
            for (int s = 0; s < i; s++) {
                System.out.print("   ");
            }

            int j;
            for (j = 0; j < m; j++) {
                comparisonCount++;
                if (T.charAt(i + j) == P.charAt(j)) {
                                        System.out.print(GREEN+P.charAt(j) +RESET+ "  ");
                                }
                                else {
                                        System.out.print(RED +P.charAt(j)+RESET + "  ");
                                                                                                         prF(j+1,P);
                                        break;
                                }
                        }

            if (j == m) {
                System.out.print("  <-- MATCH");
                foundIndex = i;
                                break;
            }
            System.out.println();
        }

                System.out.println();
        System.out.println("Total alignments attempted: " + alignmentCount);
        System.out.println("Total character comparisons made: " + comparisonCount);
        if (foundIndex != -1) {
            System.out.println("Pattern found at starting index: " + foundIndex);
        } else {
            System.out.println("Pattern was not found in the text.");
        }

        sc.close();
    }
}