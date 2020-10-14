import java.util.*;
public class LinkedList
{
    Node head;
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

    // Method to insert node at the beginning of the linked list
    public void insertBegin(int value)
    {
        Node new_node=new Node(value);
        new_node.link=head;                     //address of previous node stored in head
        head=new_node;                          //link address of new node with head
    }

    // Method to insert node at the end of the linked list
    public void insertEnd(int value)
    {
        Node new_node=new Node(value);
        Node temp=head;
        while(temp.link!=null)
        {
            temp=temp.link;
        }
        temp.link=new_node;
        
    }

    // Method to insert node at particular position in the linked list
    public void insertPos(int value,int pos)
    {
        Node new_node=new Node(value);
        if(pos==1)
        {
            new_node.link=head;
            head=new_node;
            return;
        }
        Node temp=head;
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.link;
        }
        new_node.link=temp.link;
        temp.link=new_node;
    }

    // Method to delete a node when position is given of a linked list
    public void deletePos(int pos)
    {
        Node temp=head;
        if(pos==1)
        {
            head=temp.link;
            temp.link=null;
            return;
        }
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.link;
        }
        Node prev=temp.link;
        temp.link=prev.link;
        prev.link=null;
    }

    // Method to delete a particular element from the list
    public void deleteValue(int value)
    {
        Node temp=head;
        if(temp.data==value)
        {
            temp=head;
            head=temp.link;
            temp.link=null;
            return;
        }
        Node prev,last=temp;
        temp=temp.link;
        while(temp.link!= null)
        {
            if(temp.data==value)
            {
                last.link=temp.link;
                prev=temp;
                prev.link=null;
                return;
            }
            last=temp;
            temp=temp.link;
        }
        if(temp.data==value)
        {
            last.link=null;
            return;
        }

    }

    // Method to print reverse of the linked list
    public void reverse()
    {
        Node current=head,next,prev=null;
        while(current!=null)
        {
            next=current.link;
            current.link=prev;
            prev=current;
            current=next;
        }
        head=prev;
        print();
    }

    // Method to print data of the linked list
    public void print()
    {
        Node temp=head;
        System.out.print("ELEMENTS: ");
        while(temp.link!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.link;
        }
        System.out.println(temp.data);
    }

    public static void main(String args[])
    {
        LinkedList list=new LinkedList();
        System.out.println("-----INSERTING NODES FROM THE FRONT-----");
        list.insertBegin(30);
        list.insertBegin(20);
        list.insertBegin(10);
        list.print();
        System.out.println(" ");
        System.out.println("-----INSERTING NODES FROM THE END-----");
        list.insertEnd(40);
        list.insertEnd(60);
        list.insertEnd(70);
        list.print();
        System.out.println(" ");
        System.out.println("-----INSERTING NODE AT A SPECIFIED POSITION-----");
        list.insertPos(50,5);
        list.print();
        System.out.println(" ");
        System.out.println("-----DELETE NODE FROM A SPECIFIED POSITION-----");
        list.deletePos(7);
        list.print();
        System.out.println(" ");
        System.out.println("-----DELETE NODE FOR A SPECIFIED VALUE-----");
        list.deleteValue(70);
        list.print();
        System.out.println(" ");
        System.out.println("-----REVERSE THE LINKED LIST-----");
        list.reverse();
        System.out.println(" ");
    }
}