package com.algs.basic.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author cntlb
 * @since 2020/2/26 11:18
 */
public class Queue<Item> implements IQueue<Item> , Iterable<Item>{
    private class Node {
        Item item;
        Node next;
    }

    Node first;
    Node last;
    int N;

    @Override
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node node = first;
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
        Queue<String> s = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item))
                s.enqueue(item);
            else if (!s.isEmpty())
                StdOut.print(s.dequeue() + " ");
        }
        StdOut.printf("(%d left on stack)\n", s.size());
        for (String item : s)
            StdOut.print(item + " ");
        StdOut.println();
    }
}
