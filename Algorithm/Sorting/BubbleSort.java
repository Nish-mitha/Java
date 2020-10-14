import java.util.*;
public class BubbleSort
{
    public int[] Bubble(int[] arr,int N)
    {
        int temp=0;
        for(int i=0;i<N-1;i++)
        {
            for(int j=0;j<N-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String args[])
    {
        BubbleSort BS=new BubbleSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF ELEMENTS: ");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("ENTER THE ARRAY ELEMENTS TO BE SORTED: ");
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        int[] sorted=BS.Bubble(arr,N);
        System.out.println("----SORTED ARRAY ELEMENTS----");
        for(int i=0;i<N;i++)
            System.out.print(sorted[i]+" ");
    }
}