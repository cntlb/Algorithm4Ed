package com.algs.basic.stack.ex;

/**
 * 删除第k个元素的队列(链表实现)
 *
 * @author cntlb
 * @since 2020/2/27 15:14
 */
public class GeneralizedQueue<E> {
    private int n;
    private Node first;
    private Node last;

    private class Node {
        E e;
        Node next;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(E e) {
        Node node = new Node();
        node.e = e;
        if (isEmpty()) {
            last = node;
            first = last;
        } else {
            Node oldLast = last;
            last = node;
            oldLast.next = last;
        }
        n++;
    }

    public E delete(int k) {
        if (k < 0 || k >= n) throw new IndexOutOfBoundsException();
        if (k == 0) {
            E e = first.e;
            first = first.next;
            n--;
            return e;
        }

        Node previous = null;
        Node current = first;
        for (int i = 0; i < k; i++) {
            previous = current;
            current = current.next;
        }
        E e = current.e;
        previous.next = current.next;
        n--;
        return e;
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> q = new GeneralizedQueue<>();
        for (int i = 0; i < 5; i++) {
            q.insert(i);
        }

        q.delete(0);
        q.delete(2);
        q.delete(1);
        q.delete(0);
        q.delete(0);
        assert q.isEmpty();
    }

}
