import java.util.*;
public class MergeSort {
        public static void copyArr(int[] A) {
                int num=A.length;
                if(num>1) {
                        int n=num/2;
                        int[] B = new int[n];
                        int m=num-n;
                        int[] C = new int[m];
                        for (int i =0;i<n;i++) {
                                B[i]=A[i];
                                                                }
                        for(int i=0;i<m;i++) {
                                C[i]=A[i+n];
                        }
                        copyArr(B);
                        copyArr(C);
                        mergeDo(B,C,A);
                }
        }

        public static void mergeDo(int[] B,int[] C,int[] A) {
                int i=0;
                int j=0;
                int k=0;
                int p=B.length;
                int q=C.length;
                while(i<p && j<q) {
                        if(B[i]<=C[j]) {
                                A[k]=B[i];
                                i++;
                                k++;
                        }
                        else {
                                A[k]=C[j];
                                j++;
                                k++;
                        }
                }
                if (i==p) {
                        for(int a=j;a<q;a++) {
                                A[k]=C[a];
                                k++;
                        }
                }
                else {
                        for( int a=i;a<p;a++) {
                                A[k]=B[a];
                                k++;
                        }
                }
        }
        public static void main(String[] args) {
                int[] Ar= {4,3,5,7,8,9,10,1};
                                         Scanner sc = new Scanner(System.in);
                                         System.out.println("no of elements:");
                int n=sc.nextInt();
                int[] Ar1=new int[n];
                for(int i=0;i<n;i++) {
                   System.out.println("element "+(i+1));
                        int n1=sc.nextInt();
                        Ar1[i]=n1;
                }
                System.out.println("Array before MergeSort");
                System.out.println(Arrays.toString(Ar1));

                copyArr(Ar1);
                System.out.println("Array after MergeSort");
                System.out.println(Arrays.toString(Ar1));
        }
}