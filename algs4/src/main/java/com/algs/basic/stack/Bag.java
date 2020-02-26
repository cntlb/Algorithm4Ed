package com.algs.basic.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author cntlb
 * @since 2020/2/26 11:39
 */
public class Bag<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
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
        Bag<String> s = new Bag<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            s.add(item);
        }
        StdOut.printf("(%d left on bag)\n", s.size());
        for (String item : s)
            StdOut.print(item + " ");
        StdOut.println();
    }

}
