import java.util.*;
public class MergeSort
{
    public void Merge(int[] left,int L,int[] right,int R,int[] arr)
    {
        int i=0,j=0,k=0;
        while(i<L && j<R)
        {
            if(left[i]<=right[j])
            {
                arr[k]=left[i];
                i++;
            }
            else 
            {
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<L)
        {
            arr[k]=left[i];
            k++;
            i++;
        }
        while(j<R)
        {
            arr[k]=right[j];
            k++;
            j++;
        }
    }

    public void MergeSort(int[] arr,int N)
    {
        if(N<2)
            return;
        int mid=N/2;
        int[] left=new int[mid];
        int[] right=new int[N-mid];
        for(int i=0;i<mid;i++)
            left[i]=arr[i];
        for(int i=mid;i<N;i++)
            right[i-mid]=arr[i];
        MergeSort(left,left.length);
        MergeSort(right,right.length);
        Merge(left,left.length,right,right.length,arr);
    }

    public void print(int[] arr)
    {
        System.out.println("----SORTED ARRAY ELEMENTS----");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    public static void main(String args[])
    {
        MergeSort MS=new MergeSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF ELEMENTS: ");
        int N=sc.nextInt();
        int[] arr=new int[N];
        System.out.println("ENTER THE ARRAY ELEMENTS TO BE SORTED: ");
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        MS.MergeSort(arr,N);
        MS.print(arr);
    }
}