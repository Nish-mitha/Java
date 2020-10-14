import java.util.*;
public class StackList
{
    Node top;
    public class Node
    {
        int data;
        Node link;
        Node(int d)
        {
            data=d;
            link=null;
        }
    }

    // Method to insert node into the stack
    public void push(int value)
    {
        Node new_node=new Node(value);
        new_node.link=top;
        top=new_node;
    }

    // Method to delete node from the stack
    public void pop()
    {
        Node temp=top,newTop;
        if(temp==null)
        {
            System.out.println("STACK UNDERFLOW");
            return;
        }
        newTop=temp;
        top=newTop.link;
        newTop.link=null;   
    }

    // Method to reverse the stack
    public void reverse()
    {
        Node current=top,next,prev=null;
        if(top==null)
        {
            System.out.println("STACK IS EMPTY");
            return;
        }
        while(current!=null)
        {
            next=current.link;
            current.link=prev;
            prev=current;
            current=next;
        }
        top=prev;
        print();
    }

    // Method to print the stack
    public void print()
    {
        Node temp=top;
        if(temp==null)
        {
            System.out.println("STACK IS EMPTY");
            return;
        }
        System.out.println("-----STACK ELEMENTS-----");
        while(temp.link!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.link;
        }
        System.out.println(temp.data+" ");
    }

    public static void main(String args[])
    {
        StackList SL=new StackList();
        SL.print();
        System.out.println(" ");
        SL.push(30);
        SL.push(20);
        SL.push(10);
        SL.print();
        SL.reverse();
        System.out.println(" ");
        SL.pop();
        SL.print();
        SL.pop();
        SL.print();
        SL.pop();
        SL.print();
        SL.pop();
        SL.print();
        System.out.println(" ");
    }
}