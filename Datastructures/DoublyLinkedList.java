import java.util.*;
public class DoublyLinkedList
{
    Node head;
    public class Node
    {
        int data;
        Node prevLink;
        Node nextLink;
        Node(int d)
        {
            data=d;
            prevLink=null;
            nextLink=null;
        }
    }

    // Method to insert node at the beginning of the doubly linked list
    public void insertBegin(int value)
    {
        Node new_node= new Node(value);
        if(head==null)
        {
            head=new_node;
            return;
        }
        new_node.prevLink=null;
        new_node.nextLink=head;
        new_node.nextLink.prevLink=new_node;
        head=new_node;
    }

    // Method to insert node at the end of the doubly linked list
    public void insertEnd(int value)
    {
        Node new_node=new Node(value);
        Node temp=head;
        while(temp.nextLink != null)
            temp=temp.nextLink;
        temp.nextLink=new_node;
        new_node.prevLink=temp;
        new_node.nextLink=null;
    }

    // Method to insert node at particular position in the Doubly linked list
    public void insertPos(int value,int pos)
    {
        Node temp=head;
        Node new_node=new Node(value);
        if(pos==1)
        {
            new_node.prevLink=null;
            new_node.nextLink=head;
            head=new_node;
        }
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.nextLink;
        }
        new_node.prevLink=temp;
        new_node.nextLink=temp.nextLink;
        temp.nextLink=new_node;
        new_node.nextLink.prevLink=new_node;
    }

    // Method to delete a node when position is given in Doubly Linked List
    public void deletePos(int pos)
    {
        Node temp=head,next;
        if(pos==1)
        {
            head=temp.nextLink;
            temp.nextLink=null;
            return;
        }
        for(int i=0;i<pos-2;i++)
        {
            temp=temp.nextLink;
        }
        next=temp.nextLink;
        if(next.nextLink !=null)
        {
            temp.nextLink=next.nextLink;
            next.nextLink.prevLink=temp;
        }
        else
        {
            temp.nextLink=null;
        }
    }

    // Method to delete a particular element from the Doubly Linked list
    public void deleteValue(int value)
    {
        Node temp=head,prev,current;
        if(temp.data==value)
        {
            head=temp.nextLink;
            temp.nextLink=null;
            return;
        }
        prev=temp;
        temp=temp.nextLink;
        current=temp;
        while(temp.nextLink!=null)
        {
            if(temp.data==value)
            {
                prev.nextLink=temp.nextLink;
                prev.nextLink.prevLink=prev;
                return;
            }
            prev=temp;
            temp=temp.nextLink;
            current=temp;
        }
        if(temp.data==value)
        {
            prev.nextLink=null;
            current.prevLink=null;
        }
    }

    // Method to print reverse of the linked list
    public void reverse()
    {
        Node temp=head;
        while(temp.nextLink!=null)
        {
            temp=temp.nextLink;
        }
        while(temp.prevLink!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.prevLink;
        }
        System.out.print(temp.data+" ");
        
    }

    // Method to print data of the doubly linked list
    public void print()
    {
        Node temp=head;
        System.out.print("ELEMENTS: ");
        while(temp.nextLink!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.nextLink;
        }
        System.out.println(temp.data+" ");
    }
    
    public static void main(String args[])
    {
        DoublyLinkedList DLL= new DoublyLinkedList();
        System.out.println("-----INSERTING NODES FROM THE FRONT-----");
        DLL.insertBegin(10);
        DLL.insertBegin(20);
        DLL.insertBegin(30);
        DLL.print();
        System.out.println(" ");
        System.out.println("-----INSERTING NODES FROM THE END-----");
        DLL.insertEnd(40);
        DLL.insertEnd(50);
        DLL.insertEnd(60);
        DLL.print();
        System.out.println(" ");
        System.out.println("-----INSERTING NODE AT A SPECIFIED POSITION-----");
        DLL.insertPos(100,4);
        DLL.print();
        System.out.println(" ");
        System.out.println("-----DELETE NODE FROM A SPECIFIED POSITION-----");
        DLL.deletePos(5);
        DLL.print();
        System.out.println(" ");
        System.out.println("-----DELETE NODE FOR A SPECIFIED VALUE-----");
        DLL.deleteValue(10);
        DLL.print();
        System.out.println(" ");
        System.out.println("-----REVERSE THE DOUBLY LINKED LIST-----");
        DLL.reverse();
    }
}