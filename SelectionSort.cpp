#include<iostream>
using namespace std;
int main() {
   int n,min,t;
   int *a;
   string red = "\033[31m";
   string reset = "\033[0m";
   cout<<"Enter the array size:"<<endl;
   cin>>n;
   a = new int[n];
   for(int i=0;i<n;i++) {
      cout<<"Enter the Element no."<<i+1<<"\n";
      cin>>a[i];
   }
   cout<<"Elements before sorting:\n";
   for(int i=0;i<n;i++)
      cout<<a[i]<<"  ";
   cout<<endl;
   for(int i=0;i<=n-2;i++) {
      min = i;
      cout<<"pass "<<i+1<<endl;
      for(int j=i+1;j<=n-1;j++) {
         if(a[min]>a[j])
            min=j;
      }
      t=a[min];
      a[min]=a[i];
      a[i]=t;
      for(int k=0;k<n;k++) {
         if(k==min || k==i)
            cout<<red<<a[k]<<reset<<"  ";
         else
            cout<<a[k]<<"  ";
      }
      cout<<endl;
   }
   cout<<"Elements after sorting:\n";
   for(int i =0;i<n;i++)
      cout<<a[i]<<"  ";
   cout<<endl;
   return 0;
}