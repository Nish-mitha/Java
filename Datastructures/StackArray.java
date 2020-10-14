import java.util.*;
public class StackArray
{
    int MAX_LEN=20,top=-1;
    int[] stack=new int[MAX_LEN];

    // Method to insert element into the stack
    public void push(int value)
    {
        if(top<MAX_LEN-1)
            stack[++top]=value;
        else
            System.out.println("STACK OVERFLOW");
    }

    // Method to delete element from the stack
    public void pop()
    {
        if(top==-1)
            System.out.println("STACK UNDERFLOW");
        else
            top--;
    }
    
    // Method to print stack elements
    public void print()
    {
        if(top==-1)
        {
            System.out.println("STACK IS EMPTY");
            return;
        }
        System.out.println("-----STACK ELEMENTS-----");
        for(int i=0;i<=top;i++)
            System.out.print(stack[i]+" ");
    }

    // Method to print reverse of stack elements
    public void reverse()
    {
        if(top==-1)
        {
            System.out.println("STACK IS EMPTY");
            return;
        }
        System.out.println("-----STACK ELEMENTS-----");
        for(int i=top;i>=0;i--)
            System.out.print(stack[i]+" ");
    }

    public static void main(String args[])
    {
        StackArray SA=new StackArray();
        SA.push(10);
        SA.push(20);
        SA.push(30);
        SA.push(40);
        SA.push(50);
        SA.print();
        System.out.println(" ");
        SA.pop();
        SA.print();
        System.out.println(" ");
        SA.pop();
        SA.print();
        System.out.println(" ");
        SA.push(100);
        SA.push(200);
        SA.print();
        System.out.println(" ");
        SA.reverse();
    }
}