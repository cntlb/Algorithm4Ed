package com.algs.basic.stack.ex;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * {@link Deque}的动态数组版本, 真tm麻烦
 *
 * @author cntlb
 * @since 2020/2/27 09:35
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private int n;
    private int first;
    private int last;
    private Item[] a = (Item[]) new Object[1];

    public void pushLeft(Item item) {
        if (isEmpty()) {
            first = a.length / 3;//调整指标
            a[first] = item;
            last = first;
        } else {
            a[--first] = item;
        }
        n++;
        if (first == 0) resize(3 * n);
    }

    public void pushRight(Item item) {
        if (isEmpty()) {
            last = a.length * 2 / 3;
            a[last] = item;
            first = last;
        } else {
            a[++last] = item;
        }
        n++;
        if (last == a.length - 1) resize(3 * n);
    }

    public Item popLeft() {
        if (isEmpty()) throw new UnsupportedOperationException();
        Item item = a[first];
        a[first] = null;//避免对象游离
        first++;
        n--;
        if (n > 0 && n <= a.length / 6) resize(a.length / 3);
        return item;
    }

    public Item popRight() {
        if (isEmpty()) throw new UnsupportedOperationException();
        Item item = a[last];
        a[last] = null;
        last--;
        n--;
        if (n > 0 && n <= a.length / 6) resize(a.length / 3);
        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // 扩容, 容量大小为3n, 数据存储在中间长n的区域
    private void resize(int cap) {
        Item[] b = (Item[]) new Object[cap];
        int oldFirst = first;
        int oldLast = last;
        first = cap / 3;
        last = first + n - 1;
        for (int i = oldFirst, j = 0; i <= oldLast; i++, j++) {
            b[first + j] = a[i];
        }
        a = b;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int lo = first;

            @Override
            public boolean hasNext() {
                return lo <= last;
            }

            @Override
            public Item next() {
                return a[lo++];
            }
        };
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> q = new ResizingArrayDeque<>();
        q.pushLeft(1);//1
        q.pushLeft(2);//2 1
        q.pushLeft(3);//3 2 1
        q.pushLeft(4);//3 2 1
        q.pushLeft(5);//3 2 1
        q.pushLeft(6);//3 2 1
        for (int i : q)
            StdOut.println(i);
        q.popRight();
        q.popRight();
        q.popRight();
        q.popRight();
        q.popRight();
        q.popRight();
        q.pushRight(4);// 3214
        q.popRight();
        q.pushRight(4);// 3214
        q.popRight();

//        for(int i : q){
//            StdOut.print(i+" ");
//        }
//        StdOut.println();
//        Iterator<Integer> it = q.reverseIterator();
//        while(it.hasNext()){
//            StdOut.print(it.next()+" ");
//        }
//        StdOut.println();

        q.popLeft();//214
        q.popRight();//21
        q.popLeft();//1
        q.popRight();
        //q.popLeft();//exception
    }

}
