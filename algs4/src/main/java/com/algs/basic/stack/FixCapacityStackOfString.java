package com.algs.basic.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author cntlb
 * @since 2020/2/25 11:24
 */
public class FixCapacityStackOfString implements IStack<String> {
    int N;
    String[] arr;

    public FixCapacityStackOfString(int cap) {
        arr = new String[cap];
        N = 0;
    }

    @Override
    public void push(String s) {
        arr[N++] = s;
    }

    @Override
    public String pop() {
        return arr[--N];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixCapacityStackOfString s = new FixCapacityStackOfString(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.printf("(%d left on stack)\n", s.size());
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext())
//            System.out.println(scanner.next());
    }
}
