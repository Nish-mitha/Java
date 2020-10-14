import java.util.*;
public class QueueList
{
    Node front,rear;
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

    // Method to insert elements into queue
    public void enqueue(int value)
    {
        Node new_node=new Node(value);
        Node temp=front;
        if(temp==null)
        {
            front=new_node;
            rear=new_node;
            return;
        }
        while(temp.link!=null)
            temp=temp.link;
        temp.link=new_node;
        rear=new_node;
    }

    // Method to delete elements from the queue
    public int dequeue()
    {
        Node temp=front;
        front=temp.link;
        temp.link=null;
        return temp.data;
    }

    // Method to reverse queue elements
    public void reverse()
    {
        Node current=front,next,prev=null;
        while(current!=rear)
        {
            next=current.link;
            current.link=prev;
            prev=current;
            current=next;
        }
        rear=front;
        front=prev;
        System.out.print(current.data+" ");
        print();
    }

    // Method to print queue elements
    public void print()
    {
        Node temp=front;
        if(temp==null)
            System.out.println("QUEUE IS EMPTY");
        while(temp!=rear)
        {
            System.out.print(temp.data+" ");
            temp=temp.link;
        }
        System.out.println(temp.data+" ");
    }

    public static void main(String args[])
    {
        QueueList QL=new QueueList();
        QL.enqueue(10);
        QL.enqueue(20);
        QL.enqueue(30);
        System.out.println("-----QUEUE ELEMENTS-----");
        QL.print();
        QL.enqueue(40);
        QL.enqueue(50);
        QL.enqueue(60);
        System.out.println("-----QUEUE ELEMENTS-----");
        QL.print();
        System.out.println("ELEMENT  DELETED: "+QL.dequeue());
        System.out.println("ELEMENT  DELETED: "+QL.dequeue());
        System.out.println("-----QUEUE ELEMENTS-----");
        QL.reverse();

    }
}