import java.util.*;
public class BinarySearch
{
    public int Search(int[] arr,int K)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==K)
            {
                return mid+1;
            }
            else if(arr[mid]>K)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    public static void main(String args[])
    {
        BinarySearch BS=new BinarySearch();
        int[] arr={100,200,300,400,500,600,700,800,900,1000};
        int key=100;
        int position=BS.Search(arr,key);
        if(position>-1)
            System.out.println("ELEMENT FOUND AT POSITION :"+position);
        else
            System.out.println("ELEMENT NOT FOUND");
    }
}