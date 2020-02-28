package com.algs.basic.stack.ex;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author cntlb
 * @since 2020/2/27 11:29
 */
public class RandomBag<T>  implements Iterable<T>{
    private int n;
    private Node first;

    private class Node{
        T item;
        Node next;
    }

    public void add(T item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        T[] a = (T[]) new Object[n];
        int i=0;
        for(Node node= first; node!=null; node=node.next, i++)
            a[i] = node.item;
        StdRandom.shuffle(a);

        return new Iterator<T>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i<a.length;
            }

            @Override
            public T next() {
                return a[i++];
            }
        };
    }

    public static void main(String[] args) {
        RandomBag<Integer> b = new RandomBag<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);

        for (int i = 0; i < 24; i++) {
            b.forEach(k -> StdOut.print(k+" "));
            StdOut.println();
        }
    }
}
