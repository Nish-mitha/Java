import java.util.*;
public class CircularLinkedList
{
    Node tail,head;
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

    // Method to insert node at the beginning of the Circular linked list
    public void insertBegin(int value)
    {
        Node new_node=new Node(value);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
        }
        new_node.link=head;
        head=new_node;
        tail.link=head;
    }

    // Method to insert node at the end of the Circular linked list
    public void insertEnd(int value)
    {
        Node new_node=new Node(value);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
        }
        tail.link=new_node;
        tail=new_node;
        new_node.link=head;
    }

    // Method to insert node at particular position in the Circular linked list
    public void insertPos(int value,int pos)
    {
        Node temp=head;
        Node new_node=new Node(value);
        if(pos==1)
        {
            new_node.link=head;
            head=new_node;
            tail.link=head;
        }
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.link;
        }
        new_node.link=temp.link;
        temp.link=new_node;
    }
    
    // Method to delete a node when position is given of a Circular linked list
    public void deletePos(int pos)
    {
        Node temp=head;
        if(pos==1)
        {
            head=temp.link;
            temp.link=null;
            tail.link=head;
            return;
        }
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.link;
        }
        Node current=temp.link;
        temp.link=current.link;
        if(current==tail)
            tail=temp;
        current=null;
    }

    // Method to delete a particular element from the Circular Linked list
    public void deleteValue(int value)
    {
        Node temp=head,prev,current;
        if(temp.data==value)
        {
            head=temp.link;
            temp.link=null;
            tail.link=head;
            return;
        }
        prev=temp;
        temp=temp.link;
        while(temp!=tail)
        {
            if(temp.data==value)
            {
                current=temp;
                prev.link=current.link;
                current.link=null;
                return;
            }
            prev=temp;
            temp=temp.link;
        }
        if(temp.data==value)
        {
            current=temp;
            prev.link=current.link;
            tail=prev;
            current.link=null;
        }
    }

    // Method to print reverse of the linked list
    public void reverse()
    {
        Node current=head,next,prev=tail;
        prev.link=null;
        while(current!=tail)
        {
            next=current.link;
            current.link=prev;
            prev=current;
            current=next;
        }
        tail=head;
        head=prev;
        System.out.print(current.data+" ");
        print();
    }

    // Method to print data of the Circular linked list
    public void print()
    {
        Node temp=head;
        System.out.print(temp.data+" ");
        temp=temp.link;
        while(temp!=tail.link)
        {
            System.out.print(temp.data+" ");
            temp=temp.link;
        }
    }

    public static void main(String args[])
    {
        CircularLinkedList CLL=new CircularLinkedList();
        System.out.println("-----INSERTING NODES FROM THE FRONT-----");
        CLL.insertBegin(10);
        CLL.insertBegin(20);
        CLL.insertBegin(30);
        CLL.print();
        System.out.println("\n");
        System.out.println("-----INSERTING NODES FROM THE END-----");
        CLL.insertEnd(40);
        CLL.insertEnd(60);
        CLL.insertEnd(70);
        CLL.print();
        System.out.println("\n");
        System.out.println("-----INSERTING NODE AT A SPECIFIED POSITION-----");
        CLL.insertPos(100,6);
        CLL.print();
        System.out.println("\n");
        System.out.println("-----DELETE NODE FROM A SPECIFIED POSITION-----");
        CLL.deletePos(5);
        CLL.print();
        System.out.println("\n");
        System.out.println("-----DELETE NODE FOR A SPECIFIED VALUE-----");
        CLL.deleteValue(10);
        CLL.print();
        System.out.println("\n");
        System.out.println("-----REVERSE THE CIRCULAR LINKED LIST-----");
        CLL.reverse();
    }

}