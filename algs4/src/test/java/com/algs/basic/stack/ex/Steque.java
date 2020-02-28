package com.algs.basic.stack.ex;

/**
 * 以栈为目标的队列, 支持push,pop和enqueue操作.
 * push和pop对队列同一端操作, enqueue则对另一端操作
 *
 * @author cntlb
 * @since 2020/2/26 17:45
 */
public class Steque<Item> {
    private Node first;
    private Node last;
    private int n;

    private class Node {
        Item item;
        Node next;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        if (isEmpty()) {
            last = first;
        }
        n++;
    }

    public Item pop() {
        if(isEmpty()) throw new UnsupportedOperationException();
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty()) last = null;
        return item;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) {
            first = last;
        } else{
            oldLast.next = last;
        }
        n++;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        Steque<Integer> s = new Steque<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.pop();
        s.enqueue(4);
        s.pop();
        s.pop();
    }
}
