import java.util.*;
public class SelectionSort
{
    public int[] Selection(int[] arr,int N)
    {
        int min=0;
        for(int i=0;i<N-1;i++)
        {
            min=i;
            for(int j=i+1;j<N;j++)
            {
                if(arr[j]<arr[min])
                    min=j;
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
        return arr;
    }

    public static void main(String args[])
    {
        SelectionSort SS=new SelectionSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF ELEMENTS: ");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("ENTER THE ARRAY ELEMENTS TO BE SORTED: ");
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        int[] sorted=SS.Selection(arr,N);
        System.out.println("----SORTED ARRAY ELEMENTS----");
        for(int i=0;i<N;i++)
            System.out.print(sorted[i]+" ");
    }
}