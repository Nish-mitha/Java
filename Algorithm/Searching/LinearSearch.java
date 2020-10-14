import java.util.*;
public class LinearSearch
{
    public int Search(int[] arr,int K) 
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==K)
            {
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String args[])
    {
        LinearSearch LS=new LinearSearch();
        int[] arr={50,10,80,60,40,20,90,30,100,70};
        int Key=70;
        int position=LS.Search(arr,Key);
        if(position>-1)
            System.out.println("Element found at position :"+position);
        else
            System.out.println("Element not found");
    }
}