import java.util.*;
public class BalancedParantheses
{
    int MAX_LEN=20,top=-1;
    char[] stack=new char[MAX_LEN];
    // Method to insert element into the stack
    public void push(char value)
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

    // Method to check whether paratheses are balanced or not
    public boolean checkBalance(char[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='{' || arr[i]=='[' || arr[i]=='(')
            {
                push(arr[i]);
            }
            else if(arr[i]=='}' || arr[i]==']' || arr[i]==')')
            {
                if(top!=-1 && pair(stack[top],arr[i]))
                {
                    pop();
                }
                else
                    return false;
            }
        }
        if(top==-1)
            return true;
        else
            return false;
    }

    // Method to check wether the paranthese pair or not
    public boolean pair(char open,char close)
    {
        switch(open)
        {
            case '{': if(close=='}')
                        return true;
                    break;
            case '(': if(close==')')
                        return true;
                    break;
            case '[': if(close==']')
                        return true;
                    break;
        }
        return false;
    }

    public static void main(String args[])
    {
        BalancedParantheses BP=new BalancedParantheses();
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER THE EXPRESSION: ");
        String str=sc.next();
        char[] arr=str.toCharArray();
        if(BP.checkBalance(arr))
            System.out.println("EXPRESSION IS BALANCED");
        else
            System.out.println("EXPRESSION IS NOT BALANCED");
    }
}