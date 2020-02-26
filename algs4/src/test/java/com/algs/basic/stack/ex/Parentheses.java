package com.algs.basic.stack.ex;

import com.algs.basic.stack.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;


/**
 * @author cntlb
 * @since 2020/2/26 15:19
 */
public class Parentheses {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        char[] chars = StdIn.readString().toCharArray();
        for (char c : chars){
            switch (c){
                case '{':
                case '[':
                case '(':
                    s.push(c);
                    break;
                case '}':
                    if(s.peek() == '{')
                        s.pop();
                    break;
                case ']':
                    if(s.peek() == '[')
                        s.pop();
                    break;
                case ')':
                    if(s.peek() == '(')
                        s.pop();
                    break;
            }
        }
        StdOut.println(s.isEmpty());
    }

    @Test
    public void test1(){
        char[] cs = "{}[]()".toCharArray();
        for(char c : cs){
            System.out.printf("%c -- %d\n", c, (int)c);
        }
    }

}
