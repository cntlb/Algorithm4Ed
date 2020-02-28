package com.algs.basic.stack.ex;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 1.3.40 <b>前移编码</b>。从标准输入读取一串字符，使用链表保存这些字符并删除重复字符。
 * 当你读取了一个从未见过的字符时，将它插入表头。当你读取了一个重复的字符时，
 * 将它从链表中删去并再次插入表头。将你的程序命名为 MoveToFront：它实现了著名的前移编码策略，
 * 这种策略假设最近访问过的元素很可能会再次访问，因此可以用于缓存、数据压缩等许多场景。
 *
 * @author cntlb
 * @since 2020/2/27 15:53
 */
public class MoveToFront<E> implements Iterable<E> {
    private int n;
    private Node first;

    class Node {
        E e;
        Node next;
    }

    public void push(E e) {
        Node oldFirst = first;
        first = new Node();
        first.e = e;
        first.next = oldFirst;
        n++;
    }

    public void insert(E e) {
        delete(e);
        push(e);
    }

    public void delete(E e) {
        if (isEmpty()) return;
        Node current = first;
        while (current != null) {
            Node next = current.next;
            if (next != null && next.e.equals(e)) {
                current.next = next.next;
                next.next = null;
                n--;
                return;
            }
            current = next;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E e = node.e;
                node = node.next;
                return e;
            }
        };
    }

    public static void main(String[] args) {
        char[] cs = "move it to front of this queue".toCharArray();
        MoveToFront<Character> q = new MoveToFront<>();
        for (char c : cs)
            q.insert(c);

        for (char c : q)
            StdOut.println(c);
    }
}
