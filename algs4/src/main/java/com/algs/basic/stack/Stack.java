package com.algs.basic.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author cntlb
 * @since 2020/2/26 10:55
 */
public class Stack<Item> implements IStack<Item>, Iterable<Item> {
    private static class Node<T>{
        T item;
        Node<T> next;
    }

    private Node<Item> first;
    private int N;

    @Override
    public void push(Item item) {
        Node<Item> old = first;
        first = new Node<>();
        first.item = item;
        first.next = old;
        N++;
    }

    @Override
    public Item pop() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> node = first;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public Item next() {
                Item item = node.item;
                node = node.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.printf("(%d left on stack)\n", s.size());
        for (String item : s)
            StdOut.print(item + " ");
        StdOut.println();
    }
}
