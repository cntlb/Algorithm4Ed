package com.algs.basic.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author cntlb
 * @since 2020/2/25 11:08
 */
public class FixCapacityStack<Item> implements IStack<Item>, Iterable<Item> {
    private Item[] a;
    private int N;

    public FixCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    @Override
    public void push(Item item) {
        if (N == a.length) resize(2 * N);
        a[N++] = item;
    }

    @Override
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N < a.length / 4) resize(a.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new FixCapacityStackIterator();
    }

    private void resize(int size) {
        Object[] b = new Object[size];
        for (int i = 0; i < N; i++) {
            b[i] = a[i];
        }
        a = (Item[]) b;
    }

    private class FixCapacityStackIterator implements Iterator<Item> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            return a[i++];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        FixCapacityStack<String> s = new FixCapacityStack<>(100);
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
