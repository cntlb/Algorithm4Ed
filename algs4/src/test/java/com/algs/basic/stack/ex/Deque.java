package com.algs.basic.stack.ex;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 双向队列
 *
 * @author cntlb
 * @since 2020/2/27 09:08
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Node left;
        Item item;
        Node right;
    }

    public void pushLeft(Item item) {
        Node node = new Node();
        node.item = item;
        if(isEmpty()){
            first = node;
            last = node;
        }else{
            Node oldFirst = first;
            first = node;
            first.right = oldFirst;
            oldFirst.left = first;
        }
        n++;
    }

    public void pushRight(Item item) {
        Node node = new Node();
        node.item = item;
        if(isEmpty()){
            first = node;
            last = node;
        }else{
            Node oldLast = last;
            last = node;
            last.left = oldLast;
            oldLast.right = last;
        }
        n++;
    }

    public Item popLeft() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Item item = first.item;
        first = first.right;
        n--;
        if(isEmpty()) last = first;
        else first.left = null;
        return item;
    }

    public Item popRight() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Item item = last.item;
        last = last.left;
        n--;
        if(isEmpty()) first = last;
        else last.right = null;
        return item;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n==0;
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
                node = node.right;
                return item;
            }
        };
    }

    public Iterator<Item> reverseIterator() {
        return new Iterator<Item>() {
            Node node = last;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public Item next() {
                Item item = node.item;
                node = node.left;
                return item;
            }
        };
    }


    public static void main(String[] args) {
        Deque<Integer> q = new Deque<>();
        q.pushLeft(1);//1
        q.pushLeft(2);//2 1
        q.pushLeft(3);//3 2 1
        q.pushRight(4);// 3214

        for(int i : q){
            StdOut.print(i+" ");
        }
        StdOut.println();
        Iterator<Integer> it = q.reverseIterator();
        while(it.hasNext()){
            StdOut.print(it.next()+" ");
        }
        StdOut.println();

        q.popLeft();//214
        q.popRight();//21
        q.popLeft();//1
        q.popRight();
        //q.popLeft();//exception
    }
}
