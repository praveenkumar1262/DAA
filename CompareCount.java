import java.util.*;
class Comparis {
    public int[] ComCoun(int[] arr,int n) {
        int[] c = new int[n];
        int[] a = new int[n];
        for(int i=0;i<n;i++)
                c[i]=0;
        System.out.println("the initial count array is");
        for(int i=0;i<n;i++)
                System.out.print(c[i]+"  ");
        System.out.println();
        int i;
        for(i=0;i<n-1;i++) {
                for(int j=i+1;j<n;j++) {
                        if(arr[i]>=arr[j])
                                c[i]++;
                        else
                                c[j]++;
                }
                a[c[i]]=arr[i];
                System.out.println("Insert the element at index "+i+" in the new array's index "+c[i]);
                System.out.println("at i="+i);
                for(int k=0;k<n;k++)
                        System.out.print(c[k]+"  ");
                System.out.println();
        }
        a[c[i]]=arr[i];
        System.out.println("Insert the element at index "+i+" in the new array's index "+c[i]);
        return a;
    }
}
public class CompareCount {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("enter the size of the array:");
                int n1 =sc.nextInt();
                int[] arr =new int[n1];
                for(int i=0;i<n1;i++){
                        System.out.println("Enter element  "+(i+1));
                        arr[i]=sc.nextInt();
                }
                Comparis cs = new Comparis();
                int[] arw = new int[n1];
                arw = cs.ComCoun(arr,n1);
                System.out.println("Array before Sorting");
                for(int i=0;i<n1;i++) {
                        System.out.print(arr[i]+" ");
                }
                System.out.println();
                System.out.println("Array after Sorting");
                for(int i=0;i<n1;i++)
                        System.out.print(arw[i]+" ");
                System.out.println();
        }
}
