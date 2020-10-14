import java.util.*;
public class JumpSearch
{
    public int Search(int[] arr,int K)
    {
        int N=arr.length,prev=0;
        int count=(int)Math.sqrt(N);
        while(arr[count-1]<K)
        {
            prev=count;
            count=count+(int)Math.sqrt(N);
            if(prev>N)
        }
        System.out.println(count-1+" "+prev);
        while(prev<=count-1)
        {
            if(arr[prev]==K)
                return prev+1;
            prev++;
        }
        return -1;

    }
    public static void main(String args[])
    {
        JumpSearch JS=new JumpSearch();
        int[] arr={0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,900,1000};
        int key=901;
        int position=JS.Search(arr,key);
        if(position>-1)
            System.out.println("ELEMENT FOUND AT POSITION :"+position);
        else
            System.out.println("ELEMENT NOT FOUND");
    }
}