/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stacksandbooleans;

/**
 *
 * @author Owner
 */
import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;

public class Stacks {
    public static final Pattern Character = Pattern.compile("\\S.*?");
    public static final Pattern UNSIGNED_INT = Pattern.compile("\\d+.*?");
    /*
     * pre-condition: expression has to have correct number of parenthisis, 
     * and correct boolean syntax
     * post-condition: returns evaluated boolean expression
     *
     */
    public static boolean boolEval(int op1, int op2, char boo){
        switch(boo){
            case '>':
                return (op1>op2);
            case '<':
                return (op1<op2);
            case 'G':
                return (op1>=op2);
            case 'L':
                return (op1<=op2);
            case 'E':
                return (op1==op2);
            case 'N':
                return (op1 != op2);
            default:
                throw new IllegalArgumentException("Illegal Operation there buddy");
        }
    }
    public static boolean evaluate(String In)
    {
        //replaces each of the boolean expressions with letters 
        In = In.replace(">=","G");
        In = In.replace("<=","L");
        In = In.replace("==","E");
        In = In.replace("!=","N");
        In = In.replace("||","O");
        In = In.replace("&&","A");
        
        Scanner in = new Scanner(In);
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operations = new Stack();
        Stack<Boolean> booleans = new Stack();
        
        String next = "";
        
        while(in.hasNext())
        {
            if(in.hasNext(UNSIGNED_INT))
            {
                next = in.findInLine(UNSIGNED_INT);
                numbers.push(Integer.parseInt(next));
            }
            else
            {
             //   System.out.println(next);
                next = in.findInLine(Character);
                switch(next.charAt(0))
                {
                    case '>': //less than
                    case 'G': 
                    case '<':
                    case 'L':
                    case 'E':
                    case 'N':
                    case 'O':
                    case 'A':
                    case '!':
                        operations.push(next.charAt(0));
                        break;
                    case ')':
                        evaluateStackTops(numbers, operations, booleans);
                        break;
                    case '(':
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal Character");
                }
            }
        }
        if(booleans.size()!=1)
            throw new IllegalArgumentException("Illegal Input Expression");
            return booleans.pop(); 
        
    }
    /**
     * pre-condition: 
     * 
     * post-condition:
     * @param numbers
     * @param operations
     * @param booleans 
     */
    public static void evaluateStackTops(Stack<Integer> numbers, Stack<Character>operations, Stack<Boolean>booleans)
    {
        int operand1, operand2;
        boolean boo1, boo2;
        //checks the stack if it has enough items within and gets the two operands
        if(operations.size()<1)
            throw new IllegalArgumentException("Illegal Expression");
        char ops = operations.pop();
        
        //System.out.println(ops);
        //System.out.println(numbers);
        switch(ops){
            case '>': //great
            case '<': // less
            case 'G': //greater or equal
            case 'L': //less than or equal
            case 'E': //equal to 
            case 'N': //not equal
                if (numbers.size()<1)
                        throw new IllegalArgumentException("Illegal Expression");
                operand2 = numbers.pop();
                operand1 = numbers.pop();
                booleans.push(boolEval(operand1, operand2, ops));
                break;
            case '!':
                if(booleans.size()<1)
                     throw new IllegalArgumentException("Illegal Expression");
                booleans.push(!(booleans.pop()));
                break;
            case 'A':
            case 'O':
                if(booleans.size()<2)
                     throw new IllegalArgumentException("Illegal Expression");
                boo2=booleans.pop();
                boo1=booleans.pop();
                if(ops=='A')
                    booleans.push((boo1&&boo2));
                else
                    booleans.push((boo1||boo2));
                break;
            default:
                 throw new IllegalArgumentException("Illegal Expression");
        }
        class Stack<E>
        {
            private E[] data;
            private int manyItems;
            
            public Stack()
            {
                final int INITIAL_CAPACITY =10;
                manyItems =0;
                data = (E[]) new Object[INITIAL_CAPACITY];
            }
            public boolean isEmpty(){
                return(manyItems==0);
            }
            public E peek(){
                if(isEmpty())
                    throw new NoSuchElementException("Nothing in Stack.");
                return data[manyItems-1];
            }
            public E pop(){
                if(isEmpty())
                    throw new NoSuchElementException("Nothing in Stack.");
                return data[--manyItems];
            }
            public void push (E item){
                if(isEmpty()==true)
                    throw new NoSuchElementException("Nothing in Stack.");
                data[manyItems]=item;
                manyItems++;
            }
            
        }

    }
    
    
}
