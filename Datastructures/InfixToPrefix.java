import java.util.*;
public class InfixToPrefix
{
    int MAX_LEN=20,top=-1;
    char[] stack=new char[MAX_LEN];
    int[] stackValue=new int[MAX_LEN];

    // Method to insert elements into the stack
    public void push(char value)
    {
        if(top<MAX_LEN-1)
            stack[++top]=value;
        else 
            System.out.println("STACK OVERFLOW");
    }

    // Method to delete elements from the stack
    public char pop()
    {
        if(top==-1)
        {
            System.out.println("STACK UNDERFLOW");
            return '0';
        }
        else
            return stack[top--];
    }

    // Method to insert VALUES into the stack
    public void pushValue(int value)
    {
        if(top<MAX_LEN-1)
            stackValue[++top]=value;
        else 
            System.out.println("STACK OVERFLOW");
    }

    // Method to delete VALUES from the stack
    public int popValue()
    {
        if(top==-1)
        {
            System.out.println("STACK UNDERFLOW");
            return '0';
        }
        else
            return stackValue[top--];
    }

    // Method to check whether the character passed is a operand
    public boolean operand(char op)
    {
        if((op>='a'&& op<='z') || (op>='A'&& op<='Z') || (op>='0'&& op<='9'))
            return true;
        else
            return false;
    }

    // Method to check whether the character passed is a operator
    public boolean operator(char op)
    {
        if(op=='+' || op=='-' || op=='*' || op=='/' || op=='%' || op=='^')
            return true;
        else
            return false;
    }

    // Method to check priority of operators
    public int priorityCheck(char op)
    {
        if(op=='-' || op=='+')
            return 1;
        else if(op=='*' || op=='/' || op=='%')
            return 2;
        else if(op=='^')
            return 3;
        else
            return 0;
    }

    // Method to check whether the character passed is  open bracket
    public boolean openBracket(char op)
    {
        if(op =='(' || op =='{' || op =='[')
            return true;
        else
            return false;
    }

    // Method to check whether the character passed is  clos bracket
    public boolean closeBracket(char op)
    {
        if(op ==')' || op =='}' || op ==']')
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

    // Method to convert INFIX to PREFIX expression
    public String convert(char[] arr)
    {
        String prefix="";
        for(int i=arr.length-1;i>=0;i--)
        {
            if(operand(arr[i]))
                prefix=arr[i]+""+prefix;
            else if(operator(arr[i]))
            {
                while(top!=-1 && priorityCheck(arr[i])<=priorityCheck(stack[top]))
                {
                    prefix=pop()+""+prefix;
                }
                push(arr[i]);
            }
            else if(closeBracket(arr[i]))
                push(arr[i]);
            else if(openBracket(arr[i]))
            {
                while(!pair(arr[i],stack[top]))
                {
                    prefix=pop()+""+prefix;
                }
                pop();
            }
        }
        while(top!=-1)
            prefix=pop()+""+prefix;
        return prefix;
    }

    // Method to calculate the values 
    public int calculate(int value1,int value2,char ch)
    {
        switch(ch)
        {
            case '+': return value1+value2;
            case '-': return value1-value2;
            case '*': return value1*value2;
            case '%': return value1%value2;
            case '/': return value1/value2;    
            case '^': return (int)Math.pow(value1,value2);       
        }
        return 0;
    }

    // Method to evaluate postfix expression
    public int evaluate(String strPrefix)
    {
        String[] value=strPrefix.split(" ",0);
        int answer=0;
        for(int i=value.length-1;i>=0;i--)
        {
            char ch=value[i].charAt(0);
            if(operator(ch))
            {
                int value1=popValue();
                int value2=popValue();
                answer=calculate(value1,value2,ch);
                pushValue(answer);
            }
            else
            {
                Integer num=Integer.valueOf(value[i]);  
                pushValue(num);
            }
        }
        return popValue();
    }

    public static void main(String args[])
    {
        InfixToPrefix IP=new InfixToPrefix();
        Scanner sc=new Scanner(System.in);
        System.out.println("\n");
        System.out.println("-----CONVERSION OF INFIX EXPRESSION TO PREFIX AND EVALUATION OF PREFIX EXPRESSION-----\n\n");
        System.out.print("ENTER THE INFIX EXPRESSION: ");
        String expression=sc.next();
        char[] arr=expression.toCharArray();
        String str=IP.convert(arr); // CONVERSION OF INFIX TO PREFIX 
        System.out.println("\n");
        System.out.println("PREFIX EXPRESSION :  "+str);

        // Reading values for variables in the expression 
        String strPrefix="";
        System.out.println("Enter ");
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isLetter(ch))
            {
                System.out.print("Value of "+ch+" :");
                String N=sc.next();
                strPrefix=strPrefix+N+" ";
            }
            else
                strPrefix=strPrefix+ch+" ";
        }
        System.out.println("\n");
        System.out.println("EXPRESSION TO BE EVALUATED : \n"+strPrefix);
        int result=IP.evaluate(strPrefix);
        System.out.println("RESULT : "+result);
    }
}