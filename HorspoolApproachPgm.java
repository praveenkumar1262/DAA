import java.util.*;
class HorspoolApproach {
   public int charToIndex(char c) {
       if (c == ' ') return 26;
       else return c - 'a';
   }
   public int[] buildShiftTable(char[] pattern) {
      int m = pattern.length;
      int[] shift = new int[27];
      Arrays.fill(shift, m);
      for (int i = 0; i < m - 1; i++) {
         int ch = charToIndex(pattern[i]);
         if (ch >= 0 && ch < 27) {
            shift[ch] = m - 1 - i;
         }
      }
      for (int i = 0; i < 27; i++) {
         char c = (i == 26) ? ' ' : (char) ('a' + i);
         System.out.print("|'"+ c + "' : "+ shift[i]+"| ");
      }
      System.out.println();
      return shift;
   }
   public int horspoolMatching(String ptn, String txt) {
   char[] pcr;

   int m = ptn.length();
   int n = txt.length();
   pcr=new char[n];
   int i = m - 1;
   int com=0;
   int ali=0;
   int shift[] = new int[27];
   System.out.print("      ");
   for(int k=0;k<n;k++) {
      System.out.print(k+" ");
   }
   System.out.println();
   System.out.print("text: ");
   for (int j=0;j<n;j++) {
      System.out.print(txt.charAt(j)+" ");
      pcr[j]=txt.charAt(j);
   }
   shift = buildShiftTable(pcr);
   System.out.println();
   while (i <= n - 1) {
      int k = 0;
      com=com+1;

      while (k < m && ptn.charAt(m - 1 - k) == txt.charAt(i - k)) {
         k = k + 1;
      }
      com=com+k;

      if (k == m) {
//       System.out.println("aligmnet count:"+ali);
         System.out.println("comparison count:"+com);
         return i - m + 1;
      } else {
         i = i + shift[charToIndex(txt.charAt(i))];
         ali=ali+1;
      }
   }
  // System.out.println("aligmnet count:"+ali);
   System.out.println("comparison count:"+com);
   return -1;
   }
}
public class HorspoolApproachPgm {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the Text :");
      String txt=sc.nextLine();
      System.out.println("Enter the pattern to search :");
      String ptn=sc.nextLine();
      HorspoolApproach ha=new HorspoolApproach();
      int res=ha.horspoolMatching(ptn,txt);
      if (res!=-1){
         System.out.println("Pattern Found at Index "+ res);
      }
      else{
         System.out.println("Pattern not found");
      }
   }
}