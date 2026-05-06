import java.util.*;

class QuickSortPgm {
        public void quickSort(int[] A,int l, int r) {
                if (l<r) {
                        int s=partition(A,l,r);
                        quickSort(A,l,s-1);
                        quickSort(A,s+1,r);
                }

        }
        public void swap(int[] A,int i,int j) {
                int t=A[i];
                A[i]=A[j];
                A[j]=t;
        }
        public int partition(int[] A,int l,int r) {
                int p=A[l];
                int i = l;
                int j = r+1;
                do {
                        i=i+1;
                        while(i<r && A[i]<p)
                                i=i+1;
                        j=j-1;
                        while(A[j]>p)
                                j=j-1;
                        swap(A,i,j);
                }while(i<j);
                swap(A,i,j);
                swap(A,l,j);

                return j;

        }
}

public class QuickSort {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                QuickSortPgm qsp = new QuickSortPgm();


                System.out.println("no of elements:");
                int n=sc.nextInt();
                int[] Ar1=new int[n];
                for(int i=0;i<n;i++) {
                   System.out.println("element "+(i+1));
                        int n1=sc.nextInt();
                        Ar1[i]=n1;
                }
                System.out.println("Array before Quick sort:");
                System.out.println(Arrays.toString(Ar1));
                qsp.quickSort(Ar1,0,Ar1.length-1);
                System.out.println("Array after Quick sort:");
                System.out.println(Arrays.toString(Ar1));


        }
}