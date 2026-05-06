import java.util.*;
public class HeapSortAlgorithm {
    public static void heapBottomUp(int[] H) {
        int n = H.length;



        for (int i = n / 2 - 1; i >= 0; i--) {
            int k = i;
            int v = H[k];
            boolean isHeap = false;


            while (!isHeap && 2 * k + 1 < n) {
                int j = 2 * k + 1;

                if (j < n - 1) {
                    if (H[j] < H[j + 1]) {
                        j = j + 1;
                    }
                }

                if (v >= H[j]) {
                    isHeap = true;
                } else {
                    H[k] = H[j];
                    k = j;
                }
            }
            H[k] = v;
        }
    }


    public static void heapSort(int[] H) {
        int n = H.length;


        heapBottomUp(H);


        for (int i = n - 1; i > 0; i--) {

            int temp = H[0];
            H[0] = H[i];
            H[i] = temp;


            siftDown(H, 0, i);
        }
    }


    private static void siftDown(int[] H, int k, int n) {
        int v = H[k];
        boolean isHeap = false;
        while (!isHeap && 2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j < n - 1 && H[j] < H[j + 1]) j = j + 1;
            if (v >= H[j]) isHeap = true;
            else {
                H[k] = H[j];
                k = j;
            }
        }
        H[k] = v;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The the no. of elements:");
        int num = sc.nextInt();
        int[] arr = new int[num];
        int num1;
        for(int i=0;i<num;i++) {
           System.out.println("Enter element"+(i+1));
           num1 = sc.nextInt();
           arr[i]=num1;
        }
        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }
}