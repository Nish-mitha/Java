import java.util.*;
public class QuickSort
{

    public int partition(int[] arr,int start,int end)
    {
        int pivot=arr[end];
        int i=start;
        int temp;
        for(int j=start;j<end;j++)
        {
            if(arr[j]<pivot)
            {
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
        }
        temp=arr[i];
        arr[i]=arr[end];
        arr[end]=temp;
        return i;
    }

    public void QuickSort(int[] arr,int start,int end)
    {
        if(start<end)
        {
            int index=partition(arr,start,end);
            QuickSort(arr,start,index-1);
            QuickSort(arr,index+1,end);
        }
    }

    public void print(int[] arr)
    {
        System.out.println("----SORTED ARRAY ELEMENTS----");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String args[])
    {
        QuickSort QS=new QuickSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF ELEMENTS: ");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("ENTER THE ARRAY ELEMENTS TO BE SORTED: ");
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        QS.QuickSort(arr,0,N-1);
        QS.print(arr);
    }
}