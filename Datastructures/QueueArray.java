import java.util.*;
public class QueueArray
{
    int MAX_LEN=20,front=-1,rear=-1;
    int[] queue=new int[MAX_LEN];

    // Method to check whether the queue is full or not
    public boolean isFull()
    {
        if(rear<MAX_LEN-1)
            return false;
        else 
            return true;
    }

    // Method to check whether the queue is empty or not
    public boolean isEmpty()
    {
        if(front==-1 && rear==-1)
            return true;
        else
            return false;
    }

    // Method to insert elements into queue
    public void enqueue(int value)
    {
        if(isFull())
            System.out.println("QUEUE OVERFLOW");
        else if(isEmpty())
        {
            front=0;
            rear=0;
        }
        else
            rear++;
        queue[rear]=value;
        System.out.println("");
    }

    // Method to delete elements from the queue
    public void dequeue()
    {
        if(isEmpty())
            System.out.println("QUEUE UNDERFLOW");
        else if(front==rear)
        {
            System.out.println("DELETED ELEMENT IS : "+queue[front]);
            front=-1;
            rear=-1;
        }
        else
            System.out.println("DELETED ELEMENT IS : "+queue[front++]);
        System.out.println("");
    }

    // Method to print values in the queue
    public void print()
    {
        if(isEmpty())
            System.out.println("QUEUE IS EMPTY");
        else
        {
            System.out.println("-----QUEUE ELEMENTS-----");
            for(int i=front;i<=rear;i++)
            {
                System.out.print(queue[i]+" ");
            }
        }
        System.out.println("");
    }

    // Method to reverse values in the queue
    public void reverse()
    {
        if(isEmpty())
            System.out.println("QUEUE IS EMPTY");
        else
        {
            System.out.println("-----REVERSED QUEUE ELEMENTS-----");
            for(int i=rear;i>=front;i--)
            {
                System.out.print(queue[i]+" ");
            }
        }
        System.out.println("");
    }

    public static void main(String args[])
    {
        QueueArray QA=new QueueArray();
        QA.enqueue(10);
        QA.enqueue(20);
        QA.print();
        QA.enqueue(30);
        QA.enqueue(40);
        QA.print();
        QA.reverse();
        QA.dequeue();
        QA.print();
        QA.dequeue();
        QA.print();
        QA.dequeue();
        QA.dequeue();
    }
}