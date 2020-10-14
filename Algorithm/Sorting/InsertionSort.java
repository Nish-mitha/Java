import java.util.*;
public class InsertionSort
{
    public int[] Insertion(int[] arr,int N)
    {
        int value,pos;
        for(int i=1;i<N;i++)
        {
            value=arr[i];
            pos=i;
            while(pos>0 && arr[pos-1]>value)
            {
                arr[pos]=arr[pos-1];
                pos--;
            }
            arr[pos]=value;
        }
        return arr;
    }
    
    public static void main(String args[])
    {
        InsertionSort IS=new InsertionSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF ELEMENTS: ");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("ENTER THE ARRAY ELEMENTS TO BE SORTED: ");
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        int[] sorted=IS.Insertion(arr,N);
        System.out.println("----SORTED ARRAY ELEMENTS----");
        for(int i=0;i<N;i++)
            System.out.print(sorted[i]+" ");
    }
}